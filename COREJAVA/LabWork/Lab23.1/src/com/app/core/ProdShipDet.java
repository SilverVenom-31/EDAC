//Created by @AkhilD on 01/01/2021.
package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;

public class ProdShipDet /* implements Serializable */ {
private String city,zipCode,phoneNo;
private LocalDate shipDate;
public ProdShipDet(String city, String zipCode, String phoneNo, LocalDate shipDate) {
	
	this.city = city;
	this.zipCode = zipCode;
	this.phoneNo = phoneNo;
	this.shipDate = shipDate;
}
@Override
public String toString() {
	return "ProdShipDet [city=" + city + ", zipCode=" + zipCode + ", phoneNo=" + phoneNo + ", shipDate=" + shipDate
			+ "]";
}

}
