//Created by @AkhilD on 17/01/2021.
package com.app.utils;

import java.util.HashMap;

import com.app.core.MyBuddies;
import static java.time.LocalDate.parse;

public class CollectionUtils {

	public static HashMap<String, MyBuddies> generateData() {
		HashMap<String, MyBuddies> hmap = new HashMap<>();

		hmap.put("alpha@gmail.com",
				new MyBuddies("alpha@gmail.com", "Alpha", "1234567890", parse("2020-01-01"), "mumbai"));

		hmap.put("bravo@gmail.com",
				new MyBuddies("bravo@gmail.com", "Bravo", "1234567340", parse("2020-05-01"), "pune"));
		hmap.put("charlie@gmail.com",
				new MyBuddies("charlie@gmail.com", "Charlie", "1544567890", parse("2020-03-01"), "ujjain"));
		hmap.put("delta@gmail.com",
				new MyBuddies("delta@gmail.com", "Delta", "1234512890", parse("2020-07-01"), "banglore"));
		hmap.put("echo@gmail.com", new MyBuddies("echo@gmail.com", "Echo", "1234568690", parse("2020-04-01"), "delhi"));

		return hmap;
	}

}
