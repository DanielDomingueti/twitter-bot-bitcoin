package com.domingueti.twitterbot.module.crypto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.domingueti.twitterbot.jsonrequest.messari.Data;
import com.domingueti.twitterbot.module.crypto.dtos.response.CryptoDTO;
import com.domingueti.twitterbot.module.crypto.models.Crypto;
import com.domingueti.twitterbot.module.crypto.repositories.CryptoRepository;
import com.domingueti.twitterbot.module.data.models.CryptoData;
import com.domingueti.twitterbot.module.data.repositories.CryptoDataRepository;
import com.domingueti.twitterbot.utils.statics.CalculateHasIncreased;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GetCryptoBySymbolService {
	
	@Autowired
	private RestTemplate rest;
	
	@Autowired
	private ObjectMapper mapper;
	
	private String url = "https://data.messari.io/api/v1/assets/";

	@Autowired
	private CryptoRepository cryptoRepository;
	
	@Autowired
	private CryptoDataRepository cryptoDataRepository;

	@Transactional(readOnly = true)
	public CryptoDTO execute(String cryptoParameter) {
		
		CryptoData cryptoData = new CryptoData();
		Crypto crypto = new Crypto();
		
		try {
			
			String response = rest.getForEntity(url + cryptoParameter + "/metrics", String.class).getBody();
			System.out.println(response);
			Data data = mapper.readValue(response, Data.class);
			
			cryptoData = CalculateHasIncreased.execute(data);
			if (cryptoData != null) {
				cryptoDataRepository.save(cryptoData);
			}
			
			crypto= new Crypto(null, cryptoData.getId(), cryptoData, null, null, null);
			if (crypto != null) {
				cryptoRepository.save(crypto);
			}
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	
		return new CryptoDTO(crypto);
		
	}
	
}
