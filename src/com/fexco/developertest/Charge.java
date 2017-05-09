package com.fexco.developertest;

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

import com.fexco.common.*;
import com.fexco.source.*;

public class Charge implements ChargeCalculator{
	

	private Properties prop;
	
	List<CurrencyMinorUnit> currency; 
	List<CustomerCharges> mcustomerCharges;
	DataSource ds;
	

	 /**
	 * @param connection
	 */
	public Charge() {
		super();
		initialize();
	}


	
	@Override
	public String determineProcessingCharge(String customerId, String c,
			BigDecimal charge) {
		BigDecimal result = new BigDecimal(0);
		try{		
	        List<CurrencyMinorUnit> lCurrent = this.currency.stream()
	        									.filter(p ->p.getCurrency().equals(c))
	        									.collect(Collectors.toList());
	        
	        mcustomerCharges = this.ds.loadCustomerCharges();
	        List<CustomerCharges> lCC = this.mcustomerCharges.stream()
					.filter(cc -> cc.getID().equals(customerId) )
					.collect(Collectors.toList());
	        
	        
	        List<CustomerChargesData> ccd = lCC.get(0).getListCustomerCharges().stream()
	        		.filter(p -> p.getCurrency().equals(c.toUpperCase()))
	        		.collect(Collectors.toList());
	        CurrencyMinorUnit current = lCurrent.get(0);
	        result = ccd.get(0).getCharge().multiply(charge);
	        
			result = result.setScale(current.getCharge(), RoundingMode.valueOf(prop.getProperty("rounding.mode")));
		}catch(NullPointerException npe){
			prop.getProperty("error.message.noData");
		}
		return result.toString();
	}
	
	
	/**
	 * Methods which initializes the environment
	 */
	private void initialize(){
	 prop = new Properties();
	 InputStream input = null;

		try {

			input = new FileInputStream("configuration.properties");
			prop.load(input);
			this.ds = (prop.getProperty("connection.type").equals(ConnectionType.FILE.toString()))?new FileDataSource(): new BDDataSource();
			this.currency = this.ds.loadCurrency();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		
	 }



		

}
