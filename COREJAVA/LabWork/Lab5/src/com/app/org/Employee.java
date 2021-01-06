//Created by @AkhilD on 11/12/2020.
package com.app.org;

public abstract class Employee {
	// id(int), name, deptId , basic(double)
	private int id;
	private String name;
	private int deptId;
	private double basic;

	protected Employee(int id, String name, int deptId, double basic) {
		this.id = id;
		this.name = name;
		this.deptId = deptId;
		this.basic = basic;

	}

	public double getBasic() {
		return basic;
	}

	public String toString() {
		return ("Id: " + id + " Name: " + name + " Department Id: " + deptId + " Basic: " + basic);
	}

	public abstract double computeNetSalary();
	//to avoid unnecessary method definition

}
