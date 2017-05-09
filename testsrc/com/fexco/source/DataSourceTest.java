package com.fexco.source;

import static org.junit.Assert.*;

import org.junit.*;
public class DataSourceTest {
	
	@Test
	public void testDataSourceFileFound(){
		DataSource ds = new FileDataSource();
		
		assertNotNull(ds.loadCurrency());
	}
	
	@Test
	public void testBDDataSourceFileFound(){
		DataSource ds = new BDDataSource();
		
		assertNull(ds.loadCurrency());
	}

}
