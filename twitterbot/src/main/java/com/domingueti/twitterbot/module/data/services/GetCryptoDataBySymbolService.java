package com.domingueti.twitterbot.module.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.domingueti.twitterbot.components.utils.CalculateHasIncreased;
import com.domingueti.twitterbot.module.data.dtos.CryptoDataDTO;
import com.domingueti.twitterbot.module.data.models.CryptoData;
import com.domingueti.twitterbot.module.messari.models.DataResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GetCryptoDataBySymbolService {

	@Autowired
	private RestTemplate rest;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Value("${messariUrl}")
	private String url;

	@Transactional(readOnly = true)
	public CryptoDataDTO execute(String cryptoParameter) {
		
		CryptoData cryptoData = new CryptoData();
		
		try {
			
			String response = rest.getForEntity(url + cryptoParameter + "/metrics", String.class).getBody();
			System.out.println(response);
			DataResponse data = mapper.readValue(response, DataResponse.class);
			
			cryptoData = CalculateHasIncreased.execute(data.getData());
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	
		return new CryptoDataDTO(cryptoData);
		
	}
	
}
