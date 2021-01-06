//Created by @AkhilD on 18/12/2020.
package com.app.tester;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.app.org.Customer;
import com.app.org.CustomerType;

import static com.app.utils.CustomerValidations.*;

public class CustomerRegistration {

	// Note: Free to carry all testCases on the application.
	// If stuck then immediately contact the creator.

	public static SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("yyyy-MM-dd");
	}

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			Customer[] arr = new Customer[10];
			int index = 0;

			while (true) {

				System.out
						.println("\n1.Register new Customer\n2.Display all Customer\n3.Exit\n\nChoose any one option");

				switch (sc.nextInt()) {
				case 1:
//alpha 1@alpha 2020-3-21  alp@g.com SILVER 500 mumbai
//bravo 2@bravo 2020-3-21  bravo@g.com SILVER 500 mumbai
					System.out.println("Enter Customer name,password,dob,email, type ,registration Amount, city");

					String name = sc.next();
					String password = passChck(sc.next());
					Date doB = dobValidate(sdf.parse(sc.next()));
					String email = validateEmail(sc.next());
			
					CustomerType typeString = typeValidate(CustomerType.valueOf(sc.next().toUpperCase()));
					double regAmt = regAmtChck(sc.nextDouble());
					String city = sc.next();

					chckDup(arr, email, doB);
					arr[index] = new Customer(name, password, doB, email, typeString, regAmt, city);
					index++;

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
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Null Pointer");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println(" Exception caught: " + e);
			e.printStackTrace();

		}

	}

}