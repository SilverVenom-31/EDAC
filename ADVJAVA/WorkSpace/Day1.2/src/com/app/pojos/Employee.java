package com.app.pojos;

import java.sql.Date;

public class Employee {
//empid | name    | addr    | salary | deptid | join_date 

	private int empId;
	private String name;
	private String address;
	private double salary;
	private String dept;
	private Date jDate;

	public Employee() {
//hibernate framework uses default constructor
	}

	public Employee(int empId, String name, String address, double salary, String dept, Date jDate) {

		this.empId = empId;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.dept = dept;
		this.jDate = jDate;
	}
public Employee(int empId, String name, double salary, Date jDate) {
		
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.jDate = jDate;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", address=" + address + ", salary=" + salary
				+ ", dept	=" + dept + ", jDate=" + jDate + "]";
	}

	

}
