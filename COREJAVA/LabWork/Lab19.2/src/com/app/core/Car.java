//Created by @AkhilD on 29/12/2021.
package com.app.core;

import java.time.LocalDate;

public class Car {
	// regNo(int) , chasis no (string) , manufactureDate , price , modelName,
	// company

	private int regNo;

	private String chasisNo;
	private LocalDate manufacDate;
	private double price;
	private String modelName;
	private String company;

	public Car(int regNo, String chasisNo, LocalDate manufacDate, double price, String modelName, String company) {

		this.regNo = regNo;
		this.chasisNo = chasisNo;
		this.manufacDate = manufacDate;
		this.price = price;
		this.modelName = modelName;
		this.company = company;
	}

	@Override
	public boolean equals(Object o) {

		if (o instanceof Car) {
			Car c = (Car) o;
			return this.chasisNo.equals(c.chasisNo) && ((Integer) regNo).equals(c.regNo);
		}

		return false;

	}

	@Override
	public String toString() {
		return "Car [regNo=" + regNo + ", chasisNo=" + chasisNo + ", manufacDate=" + manufacDate + ", price=" + price
				+ ", modelName=" + modelName + ", company=" + company + "]";
	}

	@Override
	public int hashCode() {

		return regNo + chasisNo.hashCode();

	}

	public int getRegNo() {
		return regNo;
	}
}
