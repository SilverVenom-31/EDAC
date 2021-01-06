//Created by @AkhilD on 11/12/2020.
package com.app.tester;

import java.util.Scanner;

import com.app.org.Employee;
import com.app.org.Manager;
import com.app.org.Worker;

public class TestOrganization {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Employee[] array = new Employee[100];
		int i = 0;

		while (true) {
			System.out
					.println("\n1.Hire Manager\n2.Hire Worker\n3.Display Employees\n4.Exit\n\nChoose any one option: ");

			switch (sc.nextInt()) {

			case 1:
				System.out.println("Enter Manager Details: id,  name, basic, deptId, perfBonus:");
				array[i] = new Manager(sc.nextInt(), sc.next(), sc.nextDouble(), sc.nextInt(), sc.nextDouble());
				i++;
				continue;

			case 2:
				System.out.println("Enter Worker Details: id, name, deptId, basic,hours Worked, hourly Rate: ");
				array[i] = new Worker(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextDouble(),
						sc.nextDouble());
				i++;
				continue;
			case 3:
				for (Employee d : array) {
					if (d != null) {
						System.out.println(d);
					}
				}

				continue;
			case 4:
				System.out.println("Good Bye!!!");
				System.exit(0);
				sc.close();

				break;
			default:
				System.out.println("Please choose again");
				break;
			}
		}

	}

}
