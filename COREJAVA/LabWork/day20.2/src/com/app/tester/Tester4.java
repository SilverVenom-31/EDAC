//Created by @AkhilD on 30/12/2021.
package com.app.tester;

import java.util.ArrayList;
import java.util.Arrays;

public class Tester4 {

	public static void main(String[] args) {

		ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 4, 3, 2, 5, 2));

		arrayList.stream().forEach(i -> System.out.print(i + " "));
		System.out.println();
		arrayList.parallelStream().forEach(i -> System.out.print(i + " "));

	}

}
