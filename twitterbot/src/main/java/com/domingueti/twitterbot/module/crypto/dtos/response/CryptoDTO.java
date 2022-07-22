package com.domingueti.twitterbot.module.crypto.dtos.response;

import java.io.Serializable;

import com.domingueti.twitterbot.components.messari.Data;
import com.domingueti.twitterbot.module.crypto.models.Crypto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class CryptoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter Long id;
		
	private @Getter @Setter String name;
	
	private @Getter @Setter String symbol;
	
	private @Getter @Setter Double priceUsd;
	
	private @Getter @Setter Boolean hasIncreased;
	
	private @Getter @Setter Double changeValue;
	
	public CryptoDTO(Crypto model) {
		id = model.getId();
		name = model.getCryptoData().getName();
		symbol = model.getCryptoData().getSymbol();
		priceUsd = model.getCryptoData().getPriceUsd();
		hasIncreased = model.getCryptoData().getHasIncreased();
		changeValue = model.getCryptoData().getChangePercentage();
	}
	
	public CryptoDTO(Data data) {
		
	}
}
