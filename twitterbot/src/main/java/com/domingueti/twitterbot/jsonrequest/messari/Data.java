package com.domingueti.twitterbot.jsonrequest.messari;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)

public class Data implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String symbol;
	private MarketData market_data;
	//ignore roi_data for instance
	private RoiData roi_data;
	
}
