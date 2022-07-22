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
		    
		    StringBuilder response = new StringBuilder();
			response.append("ID: ");
			response.append(dto.getId());
			response.append("\nName: ");
			response.append(dto.getName());
			response.append("\nSymbol: ");
			response.append(dto.getSymbol());
			response.append("\nPrice $");
			response.append(dto.getPriceUsd());
			response.append("\nIncreased: ");
			response.append(dto.getHasIncreased());
			response.append("\nPercentage changed: ");
			response.append(dto.getChangeValue());
		    
		    twitter.updateStatus(response.toString());
	
	    } 
	    catch (TwitterException e) {
			e.printStackTrace();
		}
	    
	}
}
