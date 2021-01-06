//Created by @AkhilD on 26/12/2020.
package com.app.core;

import java.time.LocalDate;

public class Student {
//studentId(int),course(string),name,marks,birthDate(LocalDate)

	private int studId;
	private String course;
	private String name;
	private double marks;
	private LocalDate birthDate;

	public Student(int studId, String course, String name, double marks, LocalDate birthDate) {

		this.studId = studId;
		this.course = course;
		this.name = name;
		this.marks = marks;
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {

		return "\nStudent Id: " + studId + "\nCourse Name:  " + course + "\nStudent Name: " + name + "\nMarks: " + marks
				+ "\nBirth Date: " + birthDate;
	}

	@Override
	public boolean equals(Object obj) {

		System.out.println("In equals...");
		if (obj instanceof Student) {
			Student s = (Student) obj;
			return this.studId == s.studId;
		}
		return false;
	}

	@Override
	public int hashCode() {
		System.out.println("in hashcode...");
		return studId;
	}

}
