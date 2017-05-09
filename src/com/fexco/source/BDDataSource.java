package com.fexco.source;

import java.io.*;
import java.util.*;

import com.fexco.common.*;

public class BDDataSource implements DataSource{
	private Properties prop = new Properties();
	

	/**
	 * @param prop
	 */
	public BDDataSource() {
		super();
		prop = new Properties();
		 InputStream input = null;
		 try {
			input = new FileInputStream("configuration.properties");
			prop.load(input);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CustomerCharges> loadCustomerCharges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CurrencyMinorUnit> loadCurrency() {
		return null;
		
	}



}
