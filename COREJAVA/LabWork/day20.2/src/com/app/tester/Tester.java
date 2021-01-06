//Created by @AkhilD on 30/12/2021.
package com.app.tester;

import static utils.CollectionUtils.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.app.core.Product;

public class Tester {

	public static void main(String[] args) {

		
		
		List<Product> populData = populateData();
		
		populData.forEach(i->System.out.print(i+" "));
		
		populData.removeIf(i-> i.getPrice()<400 );
		Collections.sort(populData,(p1,p2)-> p1.getManufactureDate().compareTo(p2.getManufactureDate()));
	populData.forEach(i-> System.out.print(i+" "));

	}

}
