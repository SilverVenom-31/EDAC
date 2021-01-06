//Created by @AkhilD on 28/12/2021.
package com.app.org;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class TestEmp {

	public static void main(String[] args) {
		ArrayList<Employee> arr = new ArrayList<>(Arrays.asList(new Employee(),new Employee(),new Employee()));

		Vector<SalesManager> sm = new Vector<>(
				Arrays.asList(new SalesManager(), new SalesManager(), new SalesManager()));

		Collections.copy(arr, sm);
		
		System.out.println(arr);

	}

}
