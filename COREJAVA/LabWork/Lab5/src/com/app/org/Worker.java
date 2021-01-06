//Created by @AkhilD on 11/12/2020.
package com.app.org;

public class Worker extends Employee {

	// --id,name,basic,deptId,hoursWorked,hourlyRate

	private double hoursWorked;
	private double hourlyRate;

	public Worker(int id, String name, int deptId, double basic, double hoursWorked, double hourlyRate) {
		super(id, name, deptId, basic);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;

	}

	public String toString() {
		return ("Worker Details: \n" + super.toString() + " Hours Worked: " + hoursWorked + " Hourly Rate: "
				+ hourlyRate);
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public double computeNetSalary() {
		return super.getBasic() + (hoursWorked * hourlyRate);
	}
}
