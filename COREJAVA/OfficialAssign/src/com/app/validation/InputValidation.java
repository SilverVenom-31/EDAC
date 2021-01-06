//Created by @AkhilD on 04/01/2021.
package com.app.validation;

import java.util.Map;

import com.app.book.Book;
import com.app.exception.BookShopException;
import com.app.users.Type;
import com.app.users.Users;

public class InputValidation {

	public static void validateLoginDets(Map<Integer, Users> populUsers, String email, String pass)
			throws BookShopException {

		boolean status = false;
		for (Users u : populUsers.values()) {
			if (u.getEmail().equals(email) && u.getPassword().equals(pass)) {

				status = true;
			}
		}

		if (!status)
			throw new BookShopException("Invalid Login Credentials");
	}

	public static void validateAdmin(Map<Integer, Users> populUsers, String email, String pass)
			throws BookShopException {

		boolean status = false;
		for (Users u : populUsers.values()) {
			if (u.getEmail().equals(email) && u.getPassword().equals(pass) && u.getUser().equals(Type.ADMIN)) {

				status = true;
			}
		}

		if (!status)
			throw new BookShopException("You are not ADMIN");
	}

	public static int validateRating(int rat) throws BookShopException {
		if (rat < 1 || rat > 5) {
			throw new BookShopException("Rating should be between 1 to 5 only");
		}
		return rat;
	}

	public static String validateTitle(Map<String, Book> hMap, String title) throws BookShopException {

		for (Book u : hMap.values()) {
			if (title.equals(u.getTitle())) {
				return title;
			}
		}

		throw new BookShopException("Invalid Book Title");

	}

}// ciphered(K-10): @KursvN
