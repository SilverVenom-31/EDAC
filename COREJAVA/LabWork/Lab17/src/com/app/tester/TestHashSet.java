//Created by @AkhilD on 26/12/2020.
package com.app.tester;

import java.util.HashSet;
import static java.time.LocalDate.parse;
import com.app.core.Student;

public class TestHashSet {

	public static void main(String[] args) {

		HashSet<Student> students = new HashSet<>();

		System.out.println("Added: " + students.add(new Student(17, "java", "alpha", 80, parse("2020-03-21"))));
		System.out.println("Added: " + students.add(new Student(33, "wt", "bravo", 85, parse("2020-04-21"))));
		System.out.println("Added: " + students.add(new Student(49, "dbt", "charlie", 87, parse("2020-05-22"))));
		System.out.println("Added: " + students.add(new Student(65, "os", "delta", 90, parse("2020-03-23"))));
		System.out.println("Added: " + students.add(new Student(100, "java", "echo", 20, parse("2020-03-26"))));
		System.out.println("Size: " + students.size());
		
		for(Student s: students) {
			System.out.println(s);
		}
		
		
	}

}
