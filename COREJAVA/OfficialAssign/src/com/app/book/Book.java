//Created by @AkhilD on 04/01/2021.
package com.app.book;

import java.time.LocalDate;
import java.util.ArrayList;

public class Book {
	
	private String title;

	private ArrayList<Authors> authors;
	private Category category;
	private double price;
	private LocalDate publishDate;
	private int quantity;

	private int rating;

	public Book(String title, Category category, double price, LocalDate publishDate, int rating) {

		this.title = title;

		this.category = category;
		this.price = price;
		this.publishDate = publishDate;

		this.rating = rating;
		authors = new ArrayList<>();
	}

	public class Authors {
		// Author has name & * email address.
		private String name;
		private String email;

		public Authors(String name, String email) {

			this.name = name;
			this.email = email;
		}

		public String getName() {
			return name;
		}

		public String getEmail() {
			return email;
		}

		public String toString() {
			return "Author Name: " + name + "\nEmail ID: " + email;
		}
	}

	public String toString() {

		return "\nTitle: " + title + "\n" + authors + "\nCategory: " + category + "\nPrice: " + price
				+ "\nPublish Date: " + publishDate + "\nRating: " + rating;

	}

	public void addAuthor(String name, String email) {

		authors.add(new Authors(name, email));

	}

	public String getTitle() {
		return title;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}
}//ciphered(K-10): @KursvN
