/**
 * 
 */
package com.fexco.common;

/**
 * @author Ariel
 *
 */
public class CurrencyMinorUnit {
	private String currency;
	private int charge;
	/**
	 * @param currency
	 * @param charge
	 */
	public CurrencyMinorUnit(String currency, int charge) {
		super();
		this.currency = currency;
		this.charge = charge;
	}
	/**
	 * @return the currency
	 */
	public synchronized String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public synchronized void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the charge
	 */
	public synchronized int getCharge() {
		return charge;
	}
	/**
	 * @param charge the charge to set
	 */
	public synchronized void setCharge(int charge) {
		this.charge = charge;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + charge;
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurrencyMinorUnit other = (CurrencyMinorUnit) obj;
		if (charge != other.charge)
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		return true;
	}
	
	
	
}
