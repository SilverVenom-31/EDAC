//Created by @AkhilD on 24/12/2020.
package com.app.utils;

import java.util.ArrayList;
import static java.time.LocalDate.parse;
import com.app.org.Customer;
import com.app.org.CustomerType;

public class CollectionUtils {

	public static ArrayList<Customer> generateRecord() {

		ArrayList<Customer> arrayList = new ArrayList<>();

		arrayList.add(new Customer("Alpha", "@Alpha1", parse("2019-03-21"), "alpha@gmail.com",
				CustomerType.valueOf("GOLD"), 500, "9284425897", "Mumbai", "Maharashtra", "INDIA"));
		arrayList.add(new Customer("Bravo", "@Bravo2", parse("2019-05-22"), "bravo@gmail.com",
				CustomerType.valueOf("SILVER"), 5000, "9284425295", "Pune", "Maharashtra", "INDIA"));
		arrayList.add(new Customer("Charlie", "@Charlie3", parse("2019-03-21"), "charlie@gmail.com",
				CustomerType.valueOf("PLATINUM"), 500, "9284425793", "Ujjai", "MadhyaPradesh", "INDIA"));
		arrayList.add(new Customer("Delta", "@Delta4", parse("2019-03-24"), "delta@gmail.com",
				CustomerType.valueOf("GOLD"), 2500, "9284425692", "Noida", "Delhi", "INDIA"));
		arrayList.add(new Customer("Echo", "@Echo5", parse("2019-04-25"), "echo@gmail.com",
				CustomerType.valueOf("PLATINUM"), 4500, "9284425591", "Mysore", "Banglore", "INDIA"));

		return arrayList;
	}

}
