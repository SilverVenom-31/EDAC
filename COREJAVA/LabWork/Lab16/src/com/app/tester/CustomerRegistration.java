//Created by @AkhilD on 24/12/2020.
package com.app.tester;

import static com.app.utils.CollectionUtils.generateRecord;
import static com.app.utils.CustomerValidations.chckDup;
import static com.app.utils.CustomerValidations.dobValidate;
import static com.app.utils.CustomerValidations.numValidate;
import static com.app.utils.CustomerValidations.passChck;
import static com.app.utils.CustomerValidations.regAmtChck;
import static com.app.utils.CustomerValidations.typeValidate;
import static com.app.utils.CustomerValidations.validateEmail;
import static com.app.utils.CustomerValidations.counValidate;
import static java.time.LocalDate.parse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import com.app.exception.CustomerHandlingException;
import com.app.org.Customer;
import com.app.org.CustomerType;
import com.app.utils.SortRegAmt;

public class CustomerRegistration {
	/* Note: Application is not user friendly, strictly binded with protocols. */
	/* Warning: Do not try to run this application in absence of its creator. */
	/* Help: Incase stuck immediately contact its creator. */

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			ArrayList<Customer> arrayList = generateRecord();

			while (true) {

				System.out.println(
						"\n1.Register new Customer\n2.Fetch Customer Details\n3.Customer Login\n4.UnSubcribe Customer\n5.Display all customer details\n6.Change Phone Number\n7.Display phone Numbers\n8.Sort Customers in email and dob\n9.Sort customers in registration amount\n10.Sort customers in city & registration amount\n11.Link Address to Customers\n12.Sort customers in customer type & state\n13.Exit\n\nChoose any one option");

				switch (sc.nextInt()) {
				case 1:

//Foxtrot @1foxtrot 2019-03-22 foxtrot@gmail.com SILVER 500 9284425250 
// foxtrot@gmail.com 2019-03-22
					try {
						System.out
								.println("Enter Customer name, password, doBDate, email, cType, regAmt,Phone Number:");

						Customer testCustomer = new Customer(sc.next(), passChck(sc.next()),
								dobValidate(parse(sc.next())), validateEmail(sc.next()),
								typeValidate(CustomerType.valueOf(sc.next().toUpperCase())),
								regAmtChck(sc.nextDouble()), numValidate(sc.next()));

						chckDup(arrayList, testCustomer);

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

						System.out.println(arrayList.get(arrayList.indexOf(testCustomer)).getDetails());
					} catch (Exception e) {
						e.printStackTrace();
					}

					continue;

				case 3:

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

				case 8:
					// Sort customers as per email & dob (using Natural ordering)
					Collections.sort(arrayList);

					continue;
				case 9:
					// Sort customers as per registration amount
					Collections.sort(arrayList, new SortRegAmt());
					continue;

				case 10:
					// Sort customers as per city & registration amount
					Collections.sort(arrayList, new Comparator<Customer>() {
						@Override
						public int compare(Customer o1, Customer o2) {
							if (((Double) o1.getRegAmt()).compareTo(((Double) o2.getRegAmt())) == 0) {
								return o1.getCity().compareTo(o2.getCity());
							}

							return ((Double) o1.getRegAmt()).compareTo(((Double) o2.getRegAmt()));
						}
					});
					continue;
				case 11:
					// alpha@gmail.com 2019-03-21
					// bravo@gmail.com 2019-05-22
					try {
						System.out.println("Enter Customer email and date of birth");

						Customer testCustomer = new Customer(validateEmail(sc.next()), dobValidate(parse(sc.next())));
						if (arrayList.indexOf(testCustomer) < 0)
							throw new CustomerHandlingException("Customer Details not found");
						System.out.println("Enter Customer city,state,country:");
						arrayList.get(arrayList.indexOf(testCustomer)).linkAddress(sc.next(), sc.next(),
								counValidate(sc.next().toUpperCase()));
						;
					} catch (Exception e) {
						e.printStackTrace();
					}

					continue;

				case 12:
					// Sort customers as per customer type & state
					Collections.sort(arrayList, new Comparator<Customer>() {
						@Override
						public int compare(Customer o1, Customer o2) {
							if (o1.getcType().compareTo(o2.getcType()) == 0) {
								return o1.getState().compareTo(o2.getState());
							}

							return o1.getcType().compareTo(o2.getcType());
						}
					});
					continue;
				case 13:
					System.out.println("GOODBYE !!!");
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