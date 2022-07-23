package com.domingueti.twitterbot.components.utils;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.domingueti.twitterbot.components.messari.Data;
import com.domingueti.twitterbot.module.data.models.CryptoData;

@Component
public class CalculateHasIncreased {

	public static CryptoData execute(Data data) {
		BigDecimal twentyFourHours = new BigDecimal("0.0");
		Boolean hasIncreased = false;
		String status = "Decreased";
		
//		String oneHourString = data.getMarket_data().getPercent_change_usd_last_1_hour();
		String twentyFourHoursString = data.getMarket_data().getPercent_change_usd_last_24_hours();

		if (twentyFourHoursString != null) {
			twentyFourHours = BigDecimal.valueOf(Double.valueOf(twentyFourHoursString));
		}
		
		//check if percentage has increased
		// == 1 means it's greater than 0
		if (twentyFourHours.signum() == 1) {
			hasIncreased = true;
		}
		
		if (hasIncreased == true) {
			status = "Increased";
		}
		
		return new CryptoData(null, data.getName(), data.getSymbol(), BigDecimal.valueOf(Double.parseDouble(data.getMarket_data().getPrice_usd()))
				, hasIncreased, status, twentyFourHours, null, null, null, null);
		
	}
	
}
