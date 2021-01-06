//Created by @AkhilD on 18/12/2020.
package com.app.org;

import static com.app.tester.CustomerRegistration.sdf;
import java.util.Date;

public class Customer {
// email , password , name , registration amount , city
	private String email;
	private String password;
	private String name;
	private double regAmt;
	private String city;
	private Date dOBDate;
	private CustomerType cType;

	public Customer(String name, String password, Date doBDate, String email, CustomerType cType, double regAmt,
			String city) {

		this.email = email;
		this.password = password;
		this.name = name;
		this.regAmt = regAmt;
		this.city = city;
		this.dOBDate = doBDate;
		this.cType = cType;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getCity() {
		return city;
	}

	@Override
	public boolean equals(Object obj) {

		/*
		 * if(obj instanceof Customer){
		 * 
		 * return email == ((Customer)obj).email; }
		 */

		return (this == obj);
	}

	@Override
	public String toString() {

		return "\nCustomer Name: " + name + "\nCustomer Email: " + email + "\nCustomer city: " + city
				+ "\nCustomer Registration Amount: " + regAmt + "\nDate of Birth: " + sdf.format(dOBDate)
				+ "\nCustomer type: " + cType;
	}

	public Date getdOBDate() {
		return dOBDate;
	}

}