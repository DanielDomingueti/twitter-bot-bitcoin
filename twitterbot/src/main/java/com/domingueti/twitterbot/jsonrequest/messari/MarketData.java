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
public class MarketData implements Serializable {
	private static final long serialVersionUID = 1L;

	private String price_usd;
	private String percent_change_usd_last_1_hour;
	private String percent_change_usd_last_24_hours;
	
//	private Long price_btc;
//	private Long percent_change_btc_last_1_hour;
//	private Long percent_change_btc_last_24_hours;
	
}