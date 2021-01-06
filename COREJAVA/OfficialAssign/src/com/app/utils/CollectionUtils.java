//Created by @AkhilD on 04/01/2021.
package com.app.utils;

import static java.time.LocalDate.parse;

import java.util.HashMap;
import java.util.Map;

import com.app.book.Book;
import com.app.book.Category;
import com.app.users.Type;
import com.app.users.Users;

public class CollectionUtils {

	public static Map<String, Book> populateMapData() {

		HashMap<String, Book> map = new HashMap<>();

		Book b1 = new Book("Lethal White", Category.FICTION, 900, parse("2018-09-18"), 4);
		b1.addAuthor("Robert Galbraith", "robert@gmail.com");
		map.put(b1.getTitle(), b1);
		Book b2 = new Book("Troubled Blood", Category.FICTION, 500, parse("2020-09-15"), 3);
		b2.addAuthor("Robert Galbraith", "robert@gmail.com");
		b2.addAuthor("J.K. Rowling", "jk@gmail.com");
		map.put(b2.getTitle(), b2);

		Book b3 = new Book("Theory of Everything", Category.SCIENCE, 800, parse("2002-05-21"), 4);
		b3.addAuthor("Stephan Hawking", "stephan@gmail.com");
		map.put(b3.getTitle(), b3);
		Book b4 = new Book("Relativity: General Theory", Category.SCIENCE, 700, parse("1916-02-02"), 3);
		b4.addAuthor("Albert Einstein", "einsteinfan@gmail.com");
		map.put(b4.getTitle(), b4);

		Book b5 = new Book("Financial Management", Category.FINANCE, 1000, parse("1977-04-22"), 2);
		b5.addAuthor(" Eugene F. Brigham", "eugene@gmail.com");
		map.put(b5.getTitle(), b5);
		Book b6 = new Book("Business Ethics", Category.FINANCE, 1200, parse("2000-03-21"), 4);
		b6.addAuthor("O. C. Ferrel", "ferrel@gmail.com");
		map.put(b6.getTitle(), b4);

		Book b7 = new Book("Enlightenment For Idiots", Category.YOGA, 1500, parse("2005-07-23"), 2);
		b7.addAuthor("Anne Cushman", "annecushman@gmail.com");
		map.put(b7.getTitle(), b7);
		Book b8 = new Book("Yoga School Dropout", Category.YOGA, 200, parse("2005-09-28"), 5);
		b8.addAuthor("Lucy Edge", "lucyedge@gmail.com");
		map.put(b8.getTitle(), b8);

		Book b9 = new Book("Zen Mind", Category.MEDITATION, 1800, parse("2005-07-23"), 2);
		b9.addAuthor(" Shunryū Suzuki", " shunryūsuzuki@gmail.com");
		b9.addAuthor("Thich Nhat Hanh", "thichnhathanh@gmail.com");
		map.put(b9.getTitle(), b9);
		Book b10 = new Book("Moving into Meditation", Category.MEDITATION, 1400, parse("2013-02-21"), 5);
		b10.addAuthor("Anne Cushman", "annecushman@gmail.com");
		map.put(b10.getTitle(), b10);

		return map;
	}

	public static Map<Integer, Users> populateUsers() {
		HashMap<Integer, Users> userMap = new HashMap<>();
		Users u1 = new Users(Type.ADMIN, "initialadmin@gmail.com", "@InitialAdmin1");
		userMap.put(u1.getUserId(), u1);
		Users c1 = new Users(Type.CUSTOMER, "alpha@gmail.com", "@Alpha1");
		userMap.put(c1.getUserId(), c1);
		Users c2 = new Users(Type.CUSTOMER, "bravo@gmail.com", "@Bravo2");
		userMap.put(c2.getUserId(), c2);
		Users c3 = new Users(Type.CUSTOMER, "charlie@gmail.com", "@Charlie3");
		userMap.put(c3.getUserId(), c3);
		Users c4 = new Users(Type.CUSTOMER, "delta@gmail.com", "@Delta4");
		userMap.put(c4.getUserId(), c4);
		Users c5 = new Users(Type.CUSTOMER, "echo@gmail.com", "@Echo5");
		userMap.put(c5.getUserId(), c5);

		return userMap;
	}

}//ciphered(K-10): @KursvN
