package com.domingueti.twitterbot.module.tweet.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.domingueti.twitterbot.components.utils.PostTweet;
import com.domingueti.twitterbot.module.data.dtos.CryptoDataDTO;
import com.domingueti.twitterbot.module.data.services.GetCryptoDataBySymbolService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InsertTweetService  {

	private GetCryptoDataBySymbolService getCryptoDataBySymbolService;

	public List<CryptoDataDTO> execute() {
		List<CryptoDataDTO> listDTO = new ArrayList<>();
		List<String> list = new ArrayList<>();
		list.add("BTC");
		list.add("ETH");
		list.add("SOL");
		
		for (String cryptoSymbol : list) {
			CryptoDataDTO dto = getCryptoDataBySymbolService.execute(cryptoSymbol);
			
			PostTweet.execute(dto);
			
			listDTO.add(dto);
		}
		
		return listDTO;
	}
	
}
