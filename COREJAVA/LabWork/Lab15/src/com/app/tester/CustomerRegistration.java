//Created by @AkhilD on 23/12/2020.
package com.app.tester;

import static com.app.utils.CustomerValidations.chckDup;
import static com.app.utils.CustomerValidations.dobValidate;
import static com.app.utils.CustomerValidations.numValidate;
import static com.app.utils.CustomerValidations.passChck;
import static com.app.utils.CustomerValidations.regAmtChck;
import static com.app.utils.CustomerValidations.typeValidate;
import static com.app.utils.CustomerValidations.validateEmail;
import static java.time.LocalDate.parse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.app.exception.CustomerHandlingException;
import com.app.org.Customer;
import com.app.org.CustomerType;

public class CustomerRegistration {
	/* Note: Application is not user friendly, strictly binded with protocols. */
	/* Free to carry all testCases on the application. */
	/* Help: In case lost immediately contact its creator. */

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			ArrayList<Customer> arrayList = new ArrayList<>();

			while (true) {

				System.out.println(
						"\n1.Register new Customer\n2.Fetch Customer Details\n3.Customer Login\n4.UnSubcribe Customer\n5.Display all customer details\n6.Change Phone Number\n7.Display phone Numbers\n10.Exit\n\nChoose any one option");

				switch (sc.nextInt()) {
				case 1:
//name, password, doBDate, email, cType, regAmt
//Alpha @1Alpha 2019-03-21 alpha@gmail.com SILVER 500
					// 9284425250
//Bravo @1Bravo 2019-03-22 bravo@gmail.com GOLD 5000
					try {
						System.out.println("Enter Customer name, password, doBDate, email, cType, regAmt");

						Customer testCustomer = new Customer(sc.next(), passChck(sc.next()),
								dobValidate(parse(sc.next())), validateEmail(sc.next()),
								typeValidate(CustomerType.valueOf(sc.next().toUpperCase())),
								regAmtChck(sc.nextDouble()));

						chckDup(arrayList, testCustomer);
						System.out.println("Add Phone Number: ");
						testCustomer.linkAddress(numValidate(sc.next()));
						arrayList.add(testCustomer);
						System.out.println("Customer Registered successfully");

					} catch (Exception e) {
						e.printStackTrace();
					}
					continue;
				case 2:
//alpha@gmail.com 2019-03-21	
//bravo@gmail.com 2019-03-22
					try {
						System.out.println("Enter Customer email and date of birth");

						Customer testCustomer = new Customer(validateEmail(sc.next()), dobValidate(parse(sc.next())));
						if (arrayList.indexOf(testCustomer) < 0)
							throw new CustomerHandlingException("Customer Details not found");

						System.out.println(arrayList.get(arrayList.indexOf(testCustomer)));
					} catch (Exception e) {
						e.printStackTrace();
					}

					continue;

				case 3:
//Alpha @1Alpha 2019-03-21 alpha@gmail.com SILVER 500	
//alpha@gmail.com 2019-03-21 @1Alpha
					try {
						System.out.println("Enter Email , DoB, Password");
						Customer testCustomer = new Customer(validateEmail(sc.next()), dobValidate(parse(sc.next())));
						if (arrayList.indexOf(testCustomer) < 0)
							throw new CustomerHandlingException("Customer Details not found");

						if (!arrayList.get(arrayList.indexOf(testCustomer)).getPassword().equals(sc.next()))
							throw new CustomerHandlingException("Password is incorrect");

						System.out.println("Login successfull");

					} catch (Exception e) {
						e.printStackTrace();
					}
					continue;

				case 4:
////Alpha @1Alpha 2019-03-21 alpha@gmail.com SILVER 500	9284425250
//Bravo @1Bravo 2019-03-22 bravo@gmail.com GOLD 5000 9284425350
//alpha@gmail.com 2019-03-21 
					try {
						System.out.println("Enter Email , DoB");
						Customer testCustomer = new Customer(validateEmail(sc.next()), dobValidate(parse(sc.next())));
						if (arrayList.indexOf(testCustomer) < 0)
							throw new CustomerHandlingException("Customer Details not found");

						System.out.println(arrayList.remove(arrayList.indexOf(testCustomer)));

						/* arrayList.remove(testCustomer); //not checked with TestCases */

					} catch (Exception e) {
						e.printStackTrace();
					}
					continue;
				case 5:
					Iterator<Customer> itrIterator1 = arrayList.iterator();
					while (itrIterator1.hasNext())
						System.out.println(itrIterator1.next());

					/*
					 * for (Customer i : arrayList) System.out.println(i);
					 * 
					 */

					continue;
				case 10:
					System.out.println("GOODBYE !!!");
					System.exit(0);
					break;

// alpha@gmail.com 2019-03-21 @1Alpha 9284425444
				case 6:
					try {
						System.out.println("Enter  email, dob , password , new phone no.");
						Customer testCustomer = new Customer(validateEmail(sc.next()), dobValidate(parse(sc.next())));

						if (arrayList.indexOf(testCustomer) < 0)
							throw new CustomerHandlingException("Customer Details not found");

						if (!arrayList.get(arrayList.indexOf(testCustomer)).getPassword().equals(sc.next()))
							throw new CustomerHandlingException("Password is incorrect");

						arrayList.get(arrayList.indexOf(testCustomer)).setPhoneNo(numValidate(sc.next()));
						System.out.println("Number Changed successfully");

					} catch (Exception e) {
						e.printStackTrace();
					}
					continue;

				case 7:
//Alpha @1Alpha 2019-03-21 alpha@gmail.com SILVER 500
		// 9284425250
//Bravo @1Bravo 2019-04-22 bravo@gmail.com GOLD 5000
//2019-03-22 2019-05-02  800
					System.out.println("Enter Start date , end date and registration amount: ");
					LocalDate aft = parse(sc.next());
					LocalDate bef = parse(sc.next());
					double regAmt = sc.nextDouble();
					for (Customer i : arrayList) {
						if (i.getdOBDate().isAfter(aft) && i.getdOBDate().isBefore(bef) && i.getRegAmt() > regAmt) {
							System.out.println(i.getName() + " " + i.getEmail() + " " + i.getPhoneNo());
						}
					}
					continue;
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