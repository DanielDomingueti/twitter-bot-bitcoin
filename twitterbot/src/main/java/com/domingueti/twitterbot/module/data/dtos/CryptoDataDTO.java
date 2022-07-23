package com.domingueti.twitterbot.module.data.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import com.domingueti.twitterbot.components.utils.RoundDouble;
import com.domingueti.twitterbot.module.data.models.CryptoData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class CryptoDataDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter @Setter Long id;
		
	private @Getter @Setter String name;
	
	private @Getter @Setter String symbol;
	
	private @Getter @Setter BigDecimal priceUsd;
	
	private @Getter @Setter Boolean hasIncreased;

	private @Getter @Setter String status;
	
	private @Getter @Setter BigDecimal changePercentage;
	
	public CryptoDataDTO(CryptoData cryptoData) {
		id = cryptoData.getId();
		name = cryptoData.getName();
		symbol = cryptoData.getSymbol();
		priceUsd = RoundDouble.executeValueUsd(cryptoData.getPriceUsd());
		hasIncreased = cryptoData.getHasIncreased();
		status = cryptoData.getStatus();
		changePercentage = RoundDouble.executePercentage(cryptoData.getChangePercentage());
	}
	
}
