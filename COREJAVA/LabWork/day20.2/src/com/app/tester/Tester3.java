//Created by @AkhilD on 30/12/2021.
package com.app.tester;

import java.util.Arrays;

public class Tester3 {

	public static void main(String[] args) {
		int[] data = { 4, 3, 2, 6, 3, 5, 1 };
		Arrays.stream(data).forEach(i -> System.out.print(i+" "));
	}

}
