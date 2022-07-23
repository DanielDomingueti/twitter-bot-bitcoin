package com.domingueti.twitterbot.module.tweet.services;

import org.springframework.stereotype.Service;

import com.domingueti.twitterbot.components.utils.PostTweet;
import com.domingueti.twitterbot.module.crypto.dtos.response.CryptoDTO;
import com.domingueti.twitterbot.module.crypto.services.GetCryptoBySymbolService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InsertTweetService  {

	private GetCryptoBySymbolService getCryptoBySymbolService;

	public CryptoDTO execute(String crypto) {
		CryptoDTO dto = getCryptoBySymbolService.execute(crypto);
	
		PostTweet.execute(dto);
		
		return dto;
	}
	
}
