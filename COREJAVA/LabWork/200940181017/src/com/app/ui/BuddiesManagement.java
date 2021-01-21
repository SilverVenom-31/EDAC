//Created by @AkhilD on 17/01/2021.
package com.app.ui;

import static com.app.utils.CollectionUtils.generateData;
import static com.app.validation.BuddyValidation.chckDup;
import static com.app.validation.BuddyValidation.emailChck;
import static com.app.validation.BuddyValidation.valEmail;
import static com.app.validation.BuddyValidation.valPhone;
import static java.time.LocalDate.parse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import com.app.core.MyBuddies;

public class BuddiesManagement {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			HashMap<String, MyBuddies> hMap = generateData();
			while (true) {
				try {
					System.out.println("\n**************Welcome to MyBuddies**************");
					System.out.println(
							"\n1.Add New Buddy\n2.Search Buddy by Email Id\n3.Delete Buddy by Email Id\n4.Display all my buddies\n5.Sort all buddies of given date of birth\n6.Exit");

					switch (sc.nextInt()) {
					case 1:
						// add new buddy

						System.out.println("Enter Email ID, name, phoneNo, dobDate, city");
						String emailString = valEmail(sc.next()); // validating email
						chckDup(hMap, emailString); // Checking for duplicate buddy
						hMap.put(emailString, new MyBuddies(emailString, sc.next(), valPhone(sc.next()),
								parse(sc.next()), sc.next()));
						System.out.println("Buddy registered successfully");

						break;
					case 2:
						// search by email id

						System.out.println("Enter Email ID");
						String eString = valEmail(sc.next());
						// checking if email exists
						emailChck(hMap, eString);

						System.out.println(hMap.get(eString));

						break;

					case 3:
						// delete

						System.out.println("Enter Email ID");
						String eSt = valEmail(sc.next());
						// checking if email exists
						emailChck(hMap, eSt);
						// removing
						hMap.remove(eSt);
						System.out.println("Buddy removed successfully");

						break;

					case 4:
						// display all data

						hMap.values().forEach(System.out::println);
						break;

					case 5:
						// sort all by date of birth
						ArrayList<MyBuddies> arrayList = new ArrayList<>(hMap.values());

						Collections.sort(arrayList, (b1, b2) -> b1.getDobDate().compareTo(b2.getDobDate()));
						// displaying sorted data
						arrayList.stream().forEach(System.out::println);
						break;

					case 6:
						System.out.println("GoodBye!!!");
						System.exit(0); // terminating the code
						break;

					default:
						// choose again
						System.out.println("Invalid Option: Please choose again");
						break;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				sc.nextLine();
			}
		}
	}

}
