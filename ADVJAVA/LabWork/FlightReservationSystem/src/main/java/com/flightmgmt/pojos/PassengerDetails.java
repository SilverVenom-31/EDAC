//Created by @AkhilD on 17/02/2021
package com.flightmgmt.pojos;

import java.time.LocalDate;
import java.time.LocalTime;

public class PassengerDetails {

	//name,email,phoneNo, cardNo,card validity, airline, depCity,arrCity,Depdate,Deptime,price

private String name;
private String email;
private String phoneNo;


private String airline;
private String depCity;
private String arrCity;
private String depDate;
private LocalTime depTime;
private double price;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}


public String getAirline() {
	return airline;
}
public void setAirline(String airline) {
	this.airline = airline;
}
public String getDepCity() {
	return depCity;
}
public void setDepCity(String depCity) {
	this.depCity = depCity;
}
public String getArrCity() {
	return arrCity;
}
public void setArrCity(String arrCity) {
	this.arrCity = arrCity;
}
public String getDepDate() {
	return depDate;
}
public void setDepDate(String depDate) {
	this.depDate = depDate;
}
public LocalTime getDepTime() {
	return depTime;
}
public void setDepTime(LocalTime depTime) {
	this.depTime = depTime;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
@Override
public String toString() {
	return "PassengerDetails [name=" + name + ", email=" + email + ", phoneNo=" + phoneNo  
			 + ", airline=" + airline + ", depCity=" + depCity + ", arrCity=" + arrCity
			+ ", depDate=" + depDate + ", depTime=" + depTime + ", price=" + price + "]";
}


}
