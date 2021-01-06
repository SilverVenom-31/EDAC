//Created by @AkhilD on 28/12/2021.
package com.app.core;

import java.time.LocalDate;
import java.util.Map;

public class Students  {

	private String prnString;
	private Course course;

	private String nameString;
	private double marks;

	private LocalDate bDate;

	public Students(String prnString, Course course, String nameString, double marks, LocalDate bDate) {

		this.prnString = prnString;
		this.course = course;
		this.nameString = nameString;
		this.marks = marks;
		this.bDate = bDate;
	}

	@Override
	public String toString() {
		return "\n\nStudentF PRN: " + prnString + "\ncourse: " + course + "\nStudent Name: " + nameString + "\nMarks: "
				+ marks + "\nBirthDate: " + bDate;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public Course getCourse() {
		return course;
	}
	
	

}
