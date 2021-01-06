//Created by @AkhilD on 04/01/2021.

package com.app.ui;

import static com.app.utils.CollectionUtils.populateMapData;
import static com.app.utils.CollectionUtils.populateUsers;
import static com.app.utils.MiscOpt.adLogIn;
import static com.app.utils.MiscOpt.addBooks;
import static com.app.utils.MiscOpt.addToCart;
import static com.app.utils.MiscOpt.cusLogIn;
import static com.app.utils.MiscOpt.dispAmt;
import static com.app.utils.MiscOpt.removeBook;
import static com.app.validation.InputValidation.validateTitle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import com.app.book.Book;
import com.app.users.Users;

public class BookShopApp {

	public static void main(String[] args) {
		/*
		 * Note: Please refer com.app.utils.CollectionUtils for login details of users or else choose option 3 from menu.
		 */
		/* If crashed immediately contact the creator: @AkhilD */
		try (Scanner sc = new Scanner(System.in);
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			Map<String, Book> mapData = populateMapData();
			HashMap<String, Book> adCart = new HashMap<>();
			Map<Integer, Users> populateUsers = populateUsers();

			while (true) {
				System.out.println("\n============MAIN MENU============");
				System.out.println("1.Admin\n2.Customer\n3.Show Users\n4.Exit\nChoose any one option: ");
				switch (sc.nextInt()) {
				case 1:
					try {

						adLogIn(sc, populateUsers);
						boolean status = false;
						while (!status) {
							System.out.println("==================================");
							System.out.println("\n1.Show available Books\n2.Add Books\n3.Exit");
							System.out.println("==================================");
							switch (sc.nextInt()) {
							case 1:

								mapData.values().stream().forEach(System.out::println);
								break;

							case 2:

								addBooks(mapData, sc, br);
								break;
							case 3:
								System.out.println("Back to Main Menu");
								status = true;
								break;
							default:
								System.out.println("Invalid Option: Please choose again");
								break;
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Exception Caught: " + e.getMessage());
					}
					continue;
				case 2:
					try {

						cusLogIn(sc, populateUsers);
						boolean stat = false;
						while (!stat) {
							System.out.println("==================================");
							System.out.println(
									"\n1.Show Available books\n2.Add to Cart\n3.Show the Cart\n4.Remove from cart\n5.Checkout");
							System.out.println("==================================");
							switch (sc.nextInt()) {
							case 1:
								mapData.values().stream().forEach(System.out::println);
								break;
							case 2:
								try {

									System.out.println("\nEnter title of book:");
									String title = validateTitle(mapData, br.readLine());
									addToCart(mapData, adCart, title, sc);

								} catch (Exception e) {
									System.out.println("Exception Caught: " + e.getMessage());
								}
								break;
							case 3:
								if (!adCart.isEmpty()) {

									adCart.values().stream()
											.forEach(c -> System.out.println(c + "\nQuantity:" + c.getQuantity()));
								} else {
									System.out.println("Your Cart is Empty");
								}
								break;
							case 4:
								try {
									adCart.values().stream().forEach(
											c -> System.out.println(c.getTitle() + "--> Quantity:" + c.getQuantity()));
									System.out.println("\nEnter title of book");
									String titleString = validateTitle(mapData, br.readLine());
									removeBook(adCart, titleString);
								} catch (Exception e) {
									System.out.println("Exception Caught: " + e.getMessage());
								}
								break;
							case 5:
								System.out.println("Your Total Cart Value: ");

								dispAmt(adCart);
								stat = true;
								break;
							default:
								System.out.println("Invalid Option: Please choose again");
								break;
							}

						}
					} catch (Exception e) {
						System.out.println("Exception Caught: " + e.getMessage());
					}
					continue;

				case 3:

					populateUsers.values().stream().forEach(System.out::println);
					continue;

				case 4:
					System.out.println("GoodBye!!!");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid Option: Please choose again");
					break;
				}

			}
		} catch (InputMismatchException e) {
			e.printStackTrace();
			System.out.println("Exception Caught: " + e.getMessage());

		} catch (Exception e) {
			System.out.println("Exception Caught: " + e.getMessage());
		}
	}

}// ciphered(K-10): @KursvN
