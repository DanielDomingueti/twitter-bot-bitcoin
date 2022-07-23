package com.domingueti.twitterbot.components.utils;

import java.math.BigDecimal;
import java.math.MathContext;

public class RoundDouble {

	public static BigDecimal executeValueUsd(BigDecimal value) {
		return value.round(new MathContext(6));
	}
	
	public static BigDecimal executePercentage(BigDecimal value) {
		return value.round(new MathContext(3));
	}

}
