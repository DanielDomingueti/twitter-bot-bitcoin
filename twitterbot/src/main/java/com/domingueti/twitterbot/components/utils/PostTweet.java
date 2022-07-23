package com.domingueti.twitterbot.components.utils;

import java.text.DateFormatSymbols;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import com.domingueti.twitterbot.module.crypto.dtos.response.CryptoDTO;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class PostTweet {

	public static void execute(CryptoDTO dto) {
	    
	    try {
	    	
	    	TwitterFactory tf = new TwitterFactory();
		    Twitter twitter = tf.getInstance();	

		    //Calculate current UTC
			String instantStr = Instant.now().truncatedTo(ChronoUnit.MILLIS).toString().replaceAll("[TZ]", " ");
			String date = instantStr.substring(0, 10);
			String hour = instantStr.substring(11, 19);
			String month = new DateFormatSymbols(Locale.US).getMonths()[Integer.valueOf(date.substring(5, 7))-1];
			String day = date.substring(8, 10);
			String finalStr = "\uD83D\uDD50[" + month + " " + day + "] " + hour;
		    
		    String changeIcon = "\uD83D\uDD3B"; //decrease standard code;
		    if (dto.getHasIncreased()) {
		    	changeIcon = "\u2B06"; //increase code 
		    }
		    
		    String response = 
		    		" $" + dto.getSymbol() + " " +
		    		dto.getName() +
		    		"\n\uD83D\uDCB5 Price $" + dto.getPriceUsd() +
		    		"\n" + changeIcon + dto.getStatus() + ": " +
		    		dto.getChangeValue() + "% in the last 24h" +
		    		"\n" + finalStr +
		    		"\n\n#" + dto.getSymbol() + " #crypto #java #code";
		    
		    twitter.updateStatus(response);
	
	    } 
	    catch (TwitterException e) {
			e.printStackTrace();
		}
	    
	}
}
