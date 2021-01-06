//Created by @AkhilD on 15/12/2020.
package com.app.org;

public class Employee {
	private int empId;
	public static int id;
	private String empName;
	private double empSal;

	public Employee(String name, double sal) {
		empId = id++;
		empName = name;
		empSal = sal;

	}

	@Override
	public String toString() {
		
		return "\nEmployee ID: " + empId + "\nEmployee Name: " + empName + "\nEmployee Salary: " + empSal;
	}

}
