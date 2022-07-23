package com.domingueti.twitterbot.components.utils;

import com.domingueti.twitterbot.module.crypto.dtos.response.CryptoDTO;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class PostTweet {

	public static void execute(CryptoDTO dto) {
	    
	    try {
	    	
	    	TwitterFactory tf = new TwitterFactory();
		    Twitter twitter = tf.getInstance();	
		    
		    String changeIcon = "\uD83D\uDD3B"; //decrease standard code;

		    if (dto.getHasIncreased()) {
		    	changeIcon = "\u2B06"; //increase code 
		    }
		    
		    //add time UTC twice a day 
		    
		    String response = 
		    		" $" + dto.getSymbol() + " " +
		    		dto.getName() +
		    		"\n\uD83D\uDCB5 Price $" + dto.getPriceUsd() +
		    		"\n" + changeIcon + dto.getStatus() + ": " +
		    		dto.getChangeValue() + "% in the last 24h" +
		    		"\n\n#" + dto.getSymbol() + " #crypto #java #code";
		    
		    twitter.updateStatus(response);
	
	    } 
	    catch (TwitterException e) {
			e.printStackTrace();
		}
	    
	}
}
