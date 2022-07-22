package com.domingueti.twitterbot.components.utils;

import org.springframework.stereotype.Component;

import com.domingueti.twitterbot.components.messari.Data;
import com.domingueti.twitterbot.module.data.models.CryptoData;

@Component
public class CalculateHasIncreased {

	public static CryptoData execute(Data data) {
		Double oneHour = 0.0;
		Double twentyFourHours = 0.0;
		Boolean hasIncreased = false;
		Double changePercentage = 0.0;
		
		String oneHourString = data.getMarket_data().getPercent_change_usd_last_1_hour();
		String twentyFourHoursString = data.getMarket_data().getPercent_change_usd_last_24_hours();

		
		if (oneHourString != null) {
			oneHour = Double.valueOf(oneHourString);
		}
		
		if (twentyFourHoursString != null) {
			twentyFourHours = Double.valueOf(twentyFourHoursString);
		}
		
		changePercentage = oneHour + twentyFourHours;
		
		//check if percentage has increased
		if (changePercentage > 0) {
			hasIncreased = true;
		}
		
		return new CryptoData(null, null, data.getName(), data.getSymbol(), Double.parseDouble(data.getMarket_data().getPrice_usd())
				, hasIncreased, changePercentage, null, null, null, null);
		
	}
	
}
