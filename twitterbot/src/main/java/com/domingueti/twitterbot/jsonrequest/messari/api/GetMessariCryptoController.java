package com.domingueti.twitterbot.jsonrequest.messari.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domingueti.twitterbot.module.crypto.dtos.response.CryptoDTO;
import com.domingueti.twitterbot.module.crypto.services.GetCryptoBySymbolService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/messari")
public class GetMessariCryptoController {
	
	private GetCryptoBySymbolService getCryptoBySymbolService;
	
	@GetMapping(value = "get/{crypto}")
	public ResponseEntity<CryptoDTO> getMessariCrypto(@PathVariable("crypto") String crypto) {
		
		CryptoDTO dto = getCryptoBySymbolService.execute(crypto);
		
		return ResponseEntity.ok().body(dto);
	}
	
}