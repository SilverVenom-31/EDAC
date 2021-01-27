package com.app.tester;

import java.sql.Date;
import java.util.Scanner;

import com.app.dao.CustomerImpl;

public class CustomerTester {

	public static void main(String[] args) {

		try (CustomerImpl dao = new CustomerImpl(); Scanner sc = new Scanner(System.in)) {

			while (true) {

				try {
					System.out.println(
							"\n1.User Login\n2.New User Registration\n3.Change Password\n4.Unsubscribe Customer\n5.Exit");
					switch (sc.nextInt()) {
					case 1:// user login
							// rama@gmail.com 1234
						System.out.println("Enter email and password");

						System.out.println(dao.authenticatUser(sc.next(), sc.next()));
						System.out.println("Login successfull");
						break;

					case 2:
						// 4000 bravo@gmail.com Bravo 12 2021-02-01 customer
						System.out.println("Enter deposit_amt,email,name,password,reg_date,role");

						System.out.println(dao.registerCustomer(sc.nextDouble(), sc.next(), sc.next(), sc.next(),
								Date.valueOf(sc.next()), sc.next()));
						break;

					case 3:// change password
							// bravo@gmail.com 12 123456
						System.out.println("Enter email,old password, new password");

						System.out.println(dao.updatePassword(sc.next(), sc.next(), sc.next()));

						break;
					case 4:// unsubscribe

						System.out.println("Enter customer ID: ");

						System.out.println(dao.unsubscribeCustomer(sc.nextInt()));
						break;

					case 5: // terminating
						dao.cleanUp();
						System.out.println("GoodBye!!!");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid Option: Please choose again");
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
