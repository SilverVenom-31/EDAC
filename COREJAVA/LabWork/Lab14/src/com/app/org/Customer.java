//Created by @AkhilD on 22/12/2020.
package com.app.org;
/* Modification:
1. Added Customer constructor
2. Changed the functionality of overidded equals method
  
 */
import static com.app.tester.CustomerRegistration.sdf;
import java.util.Date;

public class Customer {
// email , password , name , registration amount , city
	private String email;
	private String password;
	private String name;
	private double regAmt;
	private Address addr;
	private Date dOBDate;
	private CustomerType cType;

	public Customer(String name, String password, Date doBDate, String email, CustomerType cType, double regAmt) {

		this.email = email;
		this.password = password;
		this.name = name;
		this.regAmt = regAmt;

		this.dOBDate = doBDate;
		this.cType = cType;
	}

	public Customer(String email, Date date ) {
		this.email = email;
		this.dOBDate= date;
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

	}

	public void setPhoneNo(String num) {
		addr.phoneNo = num;
	}

	public void linkAddress(String city, String state, String country, String phoneNo) {
		addr = new Address(city, state, country, phoneNo);
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
				+ "\nDate of Birth: " + sdf.format(dOBDate) + "\nCustomer type: " + cType;

		/*
		 * + "\nCity: " + addr.city + "\nState: " + addr.state + "\nCountry: " +
		 * addr.country + "\nCustomer PhoneNo.: " + addr.phoneNo;
		 */
	}

	public String getCity() {
		return addr.city;
	}

	public Date getdOBDate() {
		return dOBDate;
	}

}