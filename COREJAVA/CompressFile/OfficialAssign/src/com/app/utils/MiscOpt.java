//Created by @AkhilD on 05/01/2021.
package com.app.utils;

import static com.app.validation.InputValidation.validateAdmin;
import static com.app.validation.InputValidation.validateLoginDets;
import static com.app.validation.InputValidation.validateRating;
import static java.time.LocalDate.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.app.book.Book;
import com.app.book.Category;
import com.app.exception.BookShopException;
import com.app.users.Users;

public class MiscOpt {

	public static void addBooks(Map<String, Book> mapData, Scanner sc, BufferedReader br)
			throws IOException, BookShopException {
		System.out.println("Enter Book Title,Category,price,publishing date,rating");
		Book b1 = new Book(br.readLine(), Category.valueOf(sc.next().toUpperCase()), sc.nextDouble(), parse(sc.next()),
				validateRating(sc.nextInt()));
		System.out.println("Enter Author Name, email");

		b1.addAuthor(sc.next(), sc.next());
		mapData.put(b1.getTitle(), b1);

	}

	public static void addToCart(Map<String, Book> mapData, HashMap<String, Book> adCart, String title, Scanner sc) {
		for (Book d : mapData.values()) {
			if (title.equals(d.getTitle())) {

				System.out.println("Enter Quantity: ");
				d.setQuantity(sc.nextInt());
				adCart.put(title, d);
				break;
			}

		}
	}

	public static void removeBook(HashMap<String, Book> adCart, String titleString) {
		if (!adCart.isEmpty()) {
			for (Book d : adCart.values()) {
				if (titleString.equals(d.getTitle())) {
					adCart.remove(titleString);
					System.out.println("\n"+titleString + " removed from Cart");
					break;
				}

			}
		} else {
			System.out.println("Your Cart is Empty");
		}
	}

	public static void dispAmt(HashMap<String, Book> adCart) {
		double amount = 0;
		for (Book e : adCart.values()) {
			System.out.println("Title: " + e.getTitle() +" --> Price: "+e.getPrice()+ " --> Quantity: " + e.getQuantity());
			amount = e.getPrice() * e.getQuantity() + amount;
		}

		System.out.println("\nTotal Rs. " + amount);

	}

	public static void adLogIn(Scanner sc, Map<Integer, Users> populateUsers) throws BookShopException {
		System.out.println("Login Details:\nEmail:  ");
		String email = sc.next();
		System.out.println("Password: ");
		String pass = sc.next();
		validateLoginDets(populateUsers, email, pass);
		validateAdmin(populateUsers, email, pass);
		System.out.println("Successfully Logged In...");
	}

	public static void cusLogIn(Scanner sc, Map<Integer, Users> populateUsers) throws BookShopException {
		System.out.println("Login Details:\nEmail:  ");
		String email = sc.next();
		System.out.println("Password: ");
		String pass = sc.next();
		validateLoginDets(populateUsers, email, pass);
		System.out.println("Successfully Logged In...");
	}
}
