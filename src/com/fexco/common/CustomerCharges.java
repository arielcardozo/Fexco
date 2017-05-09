package com.fexco.common;

import java.util.*;



public class CustomerCharges {
	
	private String ID;
	
	private List<CustomerChargesData> listCustomerCharges;

	/**
	 * @param iD
	 * @param listCustomerCharges
	 */
	public CustomerCharges(String iD,
			List<CustomerChargesData> listCustomerCharges) {
		super();
		ID = iD;
		this.listCustomerCharges = listCustomerCharges;
	}

	/**
	 * @return the iD
	 */
	public synchronized String getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public synchronized void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the listCustomerCharges
	 */
	public synchronized List<CustomerChargesData> getListCustomerCharges() {
		return listCustomerCharges;
	}

	/**
	 * @param listCustomerCharges the listCustomerCharges to set
	 */
	public synchronized void setListCustomerCharges(
			List<CustomerChargesData> listCustomerCharges) {
		this.listCustomerCharges = listCustomerCharges;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime
				* result
				+ ((listCustomerCharges == null) ? 0 : listCustomerCharges
						.hashCode());
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
		CustomerCharges other = (CustomerCharges) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (listCustomerCharges == null) {
			if (other.listCustomerCharges != null)
				return false;
		} else if (!listCustomerCharges.equals(other.listCustomerCharges))
			return false;
		return true;
	}

	
	

}
