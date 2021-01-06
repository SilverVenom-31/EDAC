//Created by @AkhilD on 16/12/2020.
package com.app.org;

public class Customer {
// email , password , name , registration amount , city
	private String email;
	private String password;
	private String name;
	private double regAmt;
	private String city;

	public Customer(String name, String password, String email, double regAmt, String city) {

		this.email = email;
		this.password = password;
		this.name = name;
		this.regAmt = regAmt;
		this.city = city;
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

		return (this == obj);
	}

	@Override
	public String toString() {

		return "\nCustomer Name: " + name + "\nCustomer Email: " + email + "\nCustomer city: " + city
				+ "\nCustomer Registration Amount: " + regAmt;
	}

}
