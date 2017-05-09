package com.fexco.source;

import java.io.*;
import java.math.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

import com.fexco.common.*;

public class FileDataSource implements DataSource{

	private Properties prop = new Properties();
	
	
	/**
	 * 
	 */
	public FileDataSource() {
		super();
		prop = new Properties();
		 InputStream input = null;
		 try {
			input = new FileInputStream("configuration.properties");
			prop.load(input);

		} catch (IOException e) {
			e.printStackTrace();
		}
		 finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	}

	@Override
	public List<CustomerCharges> loadCustomerCharges() {
		String fileName = prop.getProperty("files.customer.charges.path");
		List<CustomerCharges> mcustomerCharges = new ArrayList<CustomerCharges>();
		try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
			List<List<String>> valuesCC = lines.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
			valuesCC.forEach(s ->{
				isInList(mcustomerCharges,s);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mcustomerCharges;
	}

	 /**
	  * Asking if the occurrence is into the List
	  * @param mcustomerCharges22
	  * @param s
	  * @return
	  */
	private void isInList(List<CustomerCharges> mcustomerCharges22,
			List<String> s) {
		List<CustomerCharges> lCurrent = mcustomerCharges22.stream()
				.filter(p ->p.getID().equals(s.get(0)))
				.collect(Collectors.toList());
		
		if(lCurrent.size()==0){
			List<CustomerChargesData> listCustomerC = new ArrayList<CustomerChargesData>();
			listCustomerC.add(new CustomerChargesData(s.get(1), new BigDecimal(s.get(2))));
			mcustomerCharges22.add(new CustomerCharges(s.get(0), listCustomerC));
		}else{
			List<CustomerChargesData> listCustomerC = lCurrent.get(0).getListCustomerCharges();
			listCustomerC.add(new CustomerChargesData(s.get(1).toUpperCase(), new BigDecimal(s.get(2))));
			
		}
	}
	@Override
	public List<CurrencyMinorUnit> loadCurrency() {
		String filePath = prop.getProperty("files.currency.path");
		List<List<String>> values = new ArrayList<List<String>>();
		List<CurrencyMinorUnit> currency = new ArrayList<CurrencyMinorUnit>();
		 if(isInvalidFilePath(filePath) ) {
	            System.out.println(prop.getProperty("erro.message.path"));
	            System.exit(1);
	        }
		try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
			values = lines.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
			values.forEach(value -> currency.add(new CurrencyMinorUnit(value.get(0), Integer.parseInt(value.get(1)))));
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return currency;
		
	}
	/**
	 * 
	 * @param filePath
	 * @return
	 */
	private static boolean isInvalidFilePath(String filePath) {
        try {
            Path path = Paths.get(filePath);

            if(!Files.exists(path) || Files.notExists(path)) { //either does not exist or status is unknown
                return true;
            }

            if(!Files.isRegularFile(path)) { //an executable or directory
                return true;
            }

            if(!Files.isReadable(path)) { //not allowed to read (at least at this moment)
                return true;
            }
        } catch (InvalidPathException | NullPointerException exception) {
            return true; //raised an exception
        }

        return false;
    }
 


}
