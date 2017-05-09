package com.fexco.source;

import java.util.*;

import com.fexco.common.*;

public interface DataSource {
	
	
	public List<CustomerCharges> loadCustomerCharges();
	
	public List<CurrencyMinorUnit> loadCurrency();

}
