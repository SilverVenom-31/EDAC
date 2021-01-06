//Created by @AkhilD on 15/12/2020.
package com.app.tester;

import java.util.Scanner;

import com.app.org.Employee;
import com.app.org.FixedStack;
import com.app.org.GrowableStack;
import com.app.org.Stack;

public class TestStack {

	// TODO: Exception handling in process.
	/* Note: Application is not user friendly, strictly binded with protocols. */
	// Warning: Do not try to run this application in absence of its creator.
	// Help: Incase stuck immediately contact its creator.

	static {
		Employee.id = 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack reStack = null;
		boolean status = false;
		while (true) {
			System.out.println(
					"\n1.Choose Fixed Stack\n2.Choose Growable Stack\n3.Push Data\n4.Pop Data\n5.Exit\n\nChoose any one option: ");

			switch (sc.nextInt()) {
			case 1:
				if (!status) {
					reStack = new FixedStack();
					System.out.println("Fixed Stack choosen");
					status = true;
					continue;
				} else {
					System.out.println("Growable Stack already choosen");
				}
				continue;

			case 2:
				if (!status) {
					reStack = new GrowableStack();
					System.out.println("Growable Stack choosen");
					status = true;
					continue;
				} else {
					System.out.println("Fixed Stack already choosen");
				}

				continue;
			case 3:
				if (reStack != null) {
					System.out.println("Enter Employee Name and Salary");
					String empName = sc.next();
					double empSal = sc.nextDouble();

					if (empName != null && empSal != 0.0) {
						reStack.push(new Employee(empName, empSal));
					} else {
						System.out.println("Input data is null");
					}
				} else {
					System.out.println("Choose anyone stack");
				}
				continue;
			case 4:
				if (reStack != null) {
					System.out.println(reStack.pop().toString());
				} else {
					System.out.println("Choose anyone stack");
				}
				continue;
			case 5:
				System.out.println("Good Bye!!!");
				sc.close();
				System.exit(0);

				break;
			default:
				System.out.println("Invalid option: Please choose again");
				continue;
			}

		}

	}

}
