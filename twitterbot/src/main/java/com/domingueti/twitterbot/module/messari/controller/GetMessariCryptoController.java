package com.domingueti.twitterbot.module.messari.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domingueti.twitterbot.module.data.dtos.CryptoDataDTO;
import com.domingueti.twitterbot.module.data.services.GetCryptoDataBySymbolService;
import com.domingueti.twitterbot.module.tweet.services.InsertTweetService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/messari")
public class GetMessariCryptoController {

	private GetCryptoDataBySymbolService getCryptoDataBySymbolService;
	
	private InsertTweetService insertTweetService;
	
	@GetMapping(value = "get/{crypto}")
	public ResponseEntity<CryptoDataDTO> getMessariCrypto(@PathVariable("crypto") String crypto) {
		
		CryptoDataDTO dto = getCryptoDataBySymbolService.execute(crypto);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping(value = "post")
	public ResponseEntity<List<CryptoDataDTO>> postTweet() {
		
		List<CryptoDataDTO> listDTO = insertTweetService.execute();
		
		return ResponseEntity.ok().body(listDTO);
	}
	
}