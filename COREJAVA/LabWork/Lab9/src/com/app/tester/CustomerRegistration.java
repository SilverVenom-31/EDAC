//Created by @AkhilD on 16/12/2020.
package com.app.tester;

import java.util.Scanner;

import com.app.org.Customer;

public class CustomerRegistration {
	// Note: Free to carry all testCases on the application.
	// If stuck then immediately contact the creator.

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			Customer[] arr = new Customer[10];
			int index = 0;

			while (true) {
				System.out
						.println("\n1.Register new Customer\n2.Display all Customer\n3.Exit\n\nChoose any one option");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter Customer name,password,email, registration Amount, city");

					String name = sc.next();
					String password = sc.next();
					String email = sc.next();
					double regAmt = sc.nextDouble();
					String city = sc.next();

					int count = 0;
					for (Customer i : arr) {
						if (i != null) {
							if (i.getEmail().equals(email)) {

								count++;
							}
						}
					}
					if (count == 0) {
						arr[index] = new Customer(name, password, email, regAmt, city);
						index++;
					} else {
						System.out.println("Duplicate Email: Please try again");
					}

					continue;
				case 2:
					System.out.println("Enter Customer city name: ");
					String cityx = sc.next();
					for (Customer c : arr) {
						if (c != null) {
							if (c.getCity().equals(cityx)) {
								System.out.println(c);
							} else {
								System.out.println("No city match found " + c.getCity() + " " + cityx);
							}
						}
					}
					continue;

				case 3:
					System.exit(0);
					break;

				default:
					System.out.println("Invalid Option: Please choose again");
					continue;
				}

			}
		} catch (java.util.InputMismatchException e) {
			System.err.println("Input mismatch");

		} catch (NullPointerException e) {
			System.out.println("Null Pointer");

		} catch (Exception e) {
			System.err.println("Unknown Exception caught: ");
			e.printStackTrace();
		}

	}

}
