package com.fexco.developertest;

import java.math.*;

public interface ChargeCalculator {
	/**
	 * 
	 * @param customerId
	 * @param currency
	 * @param charge
	 * @return
	 */
	public String determineProcessingCharge(String customerId, String currency, BigDecimal charge);
}

