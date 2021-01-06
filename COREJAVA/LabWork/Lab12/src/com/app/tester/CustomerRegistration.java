//Created by @AkhilD on 19/12/2020.
package com.app.tester;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.app.org.Customer;
import com.app.org.CustomerType;

import static com.app.utils.CustomerValidations.*;

public class CustomerRegistration {

	// Note: Free to carry all testCases on the application.
	/* Note: Application is not user friendly, strictly binded with protocols. */
	// Help: In case stucked immediately contact its creator.


	public static SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("yyyy-MM-dd");
	}

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			Customer[] arr = new Customer[10];
			int index = 0;

			while (true) {

				System.out.println(
						"\n1.Register new Customer\n2.Display Customer with city\n3.Change Phone Number\n4.Display all Customer Details\n5.Exit\n\nChoose any one option");

				switch (sc.nextInt()) {
				case 1:
//alpha 1@alpha 2020-3-21  alp@g.com SILVER 500 
//bravo 2@bravo 2020-3-21  bravo@g.com SILVER 500 
					try {
						System.out.println("Enter Customer name,password,dob,email, type ,registration Amount");

						String name = sc.next();
						String password = passChck(sc.next());
						Date doB = dobValidate(sdf.parse(sc.next()));
						String email = validateEmail(sc.next());

						CustomerType typeString = typeValidate(CustomerType.valueOf(sc.next().toUpperCase()));
						double regAmt = regAmtChck(sc.nextDouble());

						chckDup(arr, email, doB);
						arr[index] = new Customer(name, password, doB, email, typeString, regAmt);
//Mumbai Maharashtra India 9284425290
						System.out.println("\nAdd Customer Address: city ,state ,country , phoneNo");
						String cityString = sc.next();
						String stateString = sc.next();
						String couString = counValidate(sc.next().toUpperCase());
						String phonString = numValidate(sc.next());
						arr[index].linkAddress(cityString, stateString, couString, phonString);
						index++;
					} catch (Exception e) {
						e.printStackTrace();
					}

					continue;
				case 2:
					try {
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
					} catch (Exception e) {
						e.printStackTrace();
					}
					continue;
// alp@g.com  2020-3-21 1@alpha	9284425250
				case 3:
					try {
						System.out.println("Enter  email, dob , password , new phone no.");
						String ema = validateEmail(sc.next());
						Date dob = dobValidate(sdf.parse(sc.next()));
						String pass = passChck(sc.next());

						String numString = numValidate(sc.next());

						for (Customer c : arr) {
							if (c != null) {
								if (c.getdOBDate().equals(dob) && c.getEmail().equals(ema)
										&& c.getPassword().equals(pass)) {
									c.setPhoneNo(numString);
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					continue;

				case 4:

					for (Customer c : arr) {
						if (c != null) {
							System.out.println(c);
						}
					}
					continue;
				case 5:
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