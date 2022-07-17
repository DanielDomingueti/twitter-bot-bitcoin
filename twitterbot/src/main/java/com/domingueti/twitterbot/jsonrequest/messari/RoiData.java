package com.domingueti.twitterbot.jsonrequest.messari;

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
public class RoiData {

	//ignore it for instance
	private String percent_change_last_1_week;
	private String percent_change_last_1_month;
	private String percent_change_last_3_months;
	private String percent_change_last_1_year;

}