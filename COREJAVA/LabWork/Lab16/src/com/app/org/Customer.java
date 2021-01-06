//Created by @AkhilD on 24/12/2020.
package com.app.org;

/* Modification:
1.Date Time handling by java 8 features.
 */
import java.time.LocalDate;

public class Customer implements Comparable<Customer> {
// email , password , name , registration amount , city
	private String email;
	private String password;
	private String name;
	private double regAmt;
	private Address addr;
	private LocalDate dOBDate;
	private CustomerType cType;

	

	public Customer(String name, String password, LocalDate doBDate, String email, CustomerType cType, double regAmt,
			String phoneNo) {
		this(email, doBDate);
		this.password = password;
		this.name = name;
		this.regAmt = regAmt;
		this.addr = new Address(phoneNo);
		this.cType = cType;
	}

	public Customer(String name, String password, LocalDate doBDate, String email, CustomerType cType, double regAmt,
			String phoneNo, String city, String state, String country) {
		this(name, password, doBDate, email, cType, regAmt, phoneNo);
		this.addr = new Address(city, state, country, phoneNo);

	}

	public Customer(String email, LocalDate doBDate) {
		this.email = email;
		this.dOBDate = doBDate;
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

		private Address(String city, String state, String country) {
			this.city = city;
			this.country = country;
			this.state = state;
		}

		private Address(String city, String state, String country, String phoneNo) {
			this(city, state, country);
			this.phoneNo = phoneNo;

		}

		private Address(String phoneNo) {
			this.phoneNo = phoneNo;

		}

	}

	public void setPhoneNo(String num) {
		addr.phoneNo = num;
	}

	public void linkAddress(String city, String state, String country) {
		addr = new Address(city, state, country);
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

		
	}

	public String getDetails() {
		return "\nCustomer Name: " + name + "\nCustomer Email: " + email + "\nCustomer Registration Amount: " + regAmt
				+ "\nDate of Birth: " + dOBDate + "\nCustomer type: " + cType + "\nPhone number: " + addr.phoneNo

				+ "\nCity: " + addr.city + "\nState: " + addr.state + "\nCountry: " + addr.country;

	}

	public String getCity() {
		return addr.city;
	}

	public String getState() {
		return addr.state;
	}

	public LocalDate getdOBDate() {
		return dOBDate;
	}
	public CustomerType getcType() {
		return cType;
	}
	@Override
	public int compareTo(Customer o) {
		if (this.dOBDate.compareTo(o.dOBDate) == 0) {
			return this.getEmail().compareTo(o.getEmail());
		}

		return this.dOBDate.compareTo(o.dOBDate);
	}

}