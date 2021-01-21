//Created by @AkhilD on 17/01/2021.
package com.app.core;

import java.time.LocalDate;

public class MyBuddies {

	private String email;
	private String name;
	private String phoneNo;
	private LocalDate dobDate;
	private String city;

	public MyBuddies(String email, String name, String phoneNo, LocalDate dobDate, String city) {

		this.email = email;
		this.name = name;
		this.phoneNo = phoneNo;
		this.dobDate = dobDate;
		this.city = city;
	}

	@Override
	public String toString() {

		return "\nEmail ID: " + email + "\nName: " + name + "\nPhone Number: " + phoneNo + "\nDate of Birth: " + dobDate
				+ "\nCity: " + city;
	}
	public LocalDate getDobDate() {
		return dobDate;
	}

}
