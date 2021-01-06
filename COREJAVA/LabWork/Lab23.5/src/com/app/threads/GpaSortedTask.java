//Created by @AkhilD on 02/01/2021.
package com.app.threads;

import static java.lang.Thread.currentThread;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;

import com.app.core.Student;

public class GpaSortedTask implements Runnable {

	private Map<String, Student> map;

	public GpaSortedTask(Map<String, Student> map) {
		this.map = map;
	}

	@Override
	public void run() {
		try (PrintWriter pr = new PrintWriter(new FileWriter("student_gpa.txt"))) {

			map.values().stream().sorted(Comparator.comparing(Student::getGpa)).forEach(pr::println);

		} catch (Exception e) {
			System.out.println("Exception caught in thread: " + currentThread().getName() + " " + e);
		}

	}

}
