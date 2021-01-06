//Created by @AkhilD on 30/12/2021.
package com.app.tester;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static com.app.utils.CollectionUtils.populateList;

import com.app.core.StudAddress;
import com.app.core.Student;
import com.app.core.Subject;

public class StudentTester {

	public static void main(String[] args) {

		List<Student> list = populateList();

		double avg = list.stream().filter(i -> i.getSubject() == Subject.JAVA).mapToDouble(i -> i.getGpa()).average()
				.orElse(-99);

		System.out.println("Average of JAVA students: " + avg);

		double max = list.stream().filter(i -> i.getSubject() == Subject.JAVA).mapToDouble(i -> i.getGpa()).max()
				.orElse(-99);

		list.stream().filter(i -> i.getGpa() == max).forEach(i -> System.out.println(i.getName()));
		;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Subject: ");
		Subject sub = Subject.valueOf(sc.next().toUpperCase());

		list.stream().filter(i -> i.getSubject() == sub).filter(i -> i.getGpa() < 5)
				.forEach(i -> System.out.println(i.getName()));

		double count = list.stream().filter(i -> i.getGpa() > 7.5).count(); // forEach(i->
																			// System.out.println(i.getName()));
		System.out.println(count);
		
		
		
	Set<String> set =	list.stream().map(i->i.getCity()).collect(Collectors.toSet());
		
		set.stream().distinct().forEach(i->System.out.println(i));
	}

}
