package com.fexco.developertest;

import static org.junit.Assert.*;

import java.io.*;
import java.math.*;

import org.junit.*;

public class ChargeCalculatorTest {

	@Test
	public void testdetermineProcessingCharge() {
		
		//You should setup your solution here
		ChargeCalculator lookup = new Charge();
				
		
		assertNotNull(lookup);
		// Checks to make sure files are found on working directory
		assertTrue(new File("customer_charges.csv").exists());
		assertTrue(new File("currency_minor_units.csv").exists());

		assertEquals("2.74", lookup.determineProcessingCharge("100000000", "USD", new BigDecimal("100.00")));
		assertEquals("22.151", lookup.determineProcessingCharge("100000000", "BHD", new BigDecimal("1234.567")));
		assertEquals("14980", lookup.determineProcessingCharge("788710417", "JPY", new BigDecimal("1290118")));
	}
	

}
