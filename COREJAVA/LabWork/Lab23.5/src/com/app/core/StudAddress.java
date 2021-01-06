//Created by @AkhilD on 01/01/2021.
package com.app.core;

import java.io.Serializable;

public class StudAddress implements Serializable{
//--city,state,phoneNo
	
	private String city,state,phoneNo;

public String getCity() {
		return city;
	}

public StudAddress(String city, String state, String phoneNo) {
	super();
	this.city = city;
	this.state = state;
	this.phoneNo = phoneNo;
}

@Override
public String toString() {
	return "StudAddress [city=" + city + ", state=" + state + ", phoneNo=" + phoneNo + "]";
}
	
}
