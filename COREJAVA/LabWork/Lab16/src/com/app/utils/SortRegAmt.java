//Created by @AkhilD on 24/12/2020.
package com.app.utils;

import java.util.Comparator;

import com.app.org.Customer;

public class SortRegAmt implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {

		return ((Double) o1.getRegAmt()).compareTo(((Double) o2.getRegAmt()));
	}

}
