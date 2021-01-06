//Created by @AkhilD on 23/12/2020.
package com.app.org;

/* Modification:
1.Date Time handling by java 8 features.
 */
import java.time.LocalDate;

public class Customer {
// email , password , name , registration amount , city
	private String email;
	private String password;
	private String name;
	private double regAmt;
	
	private Address addr;
	private LocalDate dOBDate;
	private CustomerType cType;

	public Customer(String name, String password, LocalDate doBDate, String email, CustomerType cType, double regAmt) {

		this.email = email;
		this.password = password;
		this.name = name;
		this.regAmt = regAmt;

		this.dOBDate = doBDate;
		this.cType = cType;
	}

	public Customer(String email, LocalDate date) {
		this.email = email;
		this.dOBDate = date;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	private class Address {
		// city ,state ,country , phoneNo
		private String city;
		private String state;
		private String country;
		private String phoneNo;

		private Address(String city, String state, String country, String phoneNo) {
			this.city = city;
			this.country = country;
			this.phoneNo = phoneNo;
			this.state = state;
		}

		private Address(String phoneNo) {

			this.phoneNo = phoneNo;

		}

	}

	public void setPhoneNo(String num) {
		addr.phoneNo = num;
	}

	public void linkAddress(String city, String state, String country, String phoneNo) {
		addr = new Address(city, state, country, phoneNo);
	}

	public void linkAddress(String phoneNo) {
		addr = new Address(phoneNo);
	}
	public double getRegAmt() {
		return regAmt;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNo() {
		return addr.phoneNo;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Customer) {

			if (email.equals(((Customer) obj).email) && dOBDate.equals(((Customer) obj).dOBDate)) {

				return true;
			}
		}
		return false;

	}

	@Override
	public String toString() {

		return "\nCustomer Name: " + name + "\nCustomer Email: " + email + "\nCustomer Registration Amount: " + regAmt
				+ "\nDate of Birth: " + dOBDate + "\nCustomer type: " + cType + "\nPhone number: " + addr.phoneNo;

		/*
		 * + "\nCity: " + addr.city + "\nState: " + addr.state + "\nCountry: " +
		 * addr.country + "\nCustomer PhoneNo.: " + addr.phoneNo;
		 */
	}

	public String getCity() {
		return addr.city;
	}

	public LocalDate getdOBDate() {
		return dOBDate;
	}

}