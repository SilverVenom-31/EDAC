//Created by @AkhilD on 30/12/2021.
package com.app.tester;

import static utils.CollectionUtils.populateData;
import static utils.CollectionUtils.populateMap;

import java.util.Map;

import com.app.core.Product;

public class Tester2 {
	public static void main(String[] args) {

		Map<Integer, Product> map = populateMap(populateData());

		map.forEach((i, u) -> System.out.println(u.getName()+" "+u.getPrice()));
		
		for(Map.Entry<Integer, Product> c : map.entrySet() ) {
			System.out.println(c.getKey()+" "+c.getValue().getName());
		}
	}

}
