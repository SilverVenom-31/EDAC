//Created by @AkhilD on 30/12/2021.
package com.app.core;

import java.time.LocalDate;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class Student {
//rollNo(string),name,dob(LocalDate),subject(enum),gpa(double) 	
	private String rollNo;
	private String name;
	private LocalDate dobDate;
	private Subject subject;
	private double gpa;

	private StudAddress address;

	public Student(String rollNo, String name, LocalDate dobDate, Subject subject, double gpa) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.dobDate = dobDate;
		this.subject = subject;
		this.gpa = gpa;
	}

	public void linkAddress(StudAddress addr) {
		address = addr;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", dobDate=" + dobDate + ", subject=" + subject
				+ ", gpa=" + gpa + ", address=" + address + "]";
	}

	public String getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return address.getCity();
	}

	public void setAddress(StudAddress address) {
		this.address = address;
	}

	public LocalDate getDobDate() {
		return dobDate;
	}

	public Subject getSubject() {
		return subject;
	}

	public double getGpa() {
		return gpa;
	}

}
