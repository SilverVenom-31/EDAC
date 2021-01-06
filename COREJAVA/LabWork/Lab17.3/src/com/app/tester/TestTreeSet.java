//Created by @AkhilD on 26/12/2020.
package com.app.tester;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

import static java.time.LocalDate.parse;
import com.app.core.Student;

public class TestTreeSet {

	public static void main(String[] args) {

		HashSet<Student> students = new HashSet<>();

		System.out.println("Added: " + students.add(new Student(100, "java", "alpha", 85, parse("2020-03-21"))));
		System.out.println("Added: " + students.add(new Student(104, "java", "bravo", 85, parse("2020-03-25"))));
		System.out.println("Added: " + students.add(new Student(102, "dbt", "charlie", 80, parse("2020-03-24"))));
		System.out.println("Added: " + students.add(new Student(105, "java", "delta", 85, parse("2020-03-22"))));
		System.out.println("Added: " + students.add(new Student(103, "java", "echo", 85, parse("2020-03-20"))));
		System.out.println("Size: " + students.size());

		for (Student s : students) {
			System.out.println(s);
		}
		System.out.println("\n\nSorted Details wrt id: ");
		TreeSet<Student> tSet = new TreeSet<>(students);
		for (Student s : tSet) {
			System.out.println(s);
		}

		System.out.println("\n\nSorting details wrt marks");
		TreeSet<Student> tSet2 = new TreeSet<>(new Comparator<Student>() {

			public int compare(Student s1, Student s2) {
				return ((Double) s1.getMarks()).compareTo(s2.getMarks());
			}

		});

		tSet2.addAll(students);
		for (Student s : tSet2) {
			System.out.println(s);
		}

		System.out.println("\n\nSorting details wrt birtdate and marks");
		TreeSet<Student> tSet3 = new TreeSet<>(new Comparator<Student>() {

			public int compare(Student s1, Student s2) {

				if (((Double) s1.getMarks()).compareTo(s2.getMarks()) == 0) {

					return s1.getBirthDate().compareTo(s2.getBirthDate());
				}

				return ((Double) s1.getMarks()).compareTo(s2.getMarks());

			}
		});

		tSet3.addAll(students);

		for (Student s : tSet3) {
			System.out.println(s);
		}

	}

}
