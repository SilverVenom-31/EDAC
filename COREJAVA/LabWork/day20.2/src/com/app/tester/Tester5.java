//Created by @AkhilD on 30/12/2021.
package com.app.tester;

import java.util.stream.IntStream;

public class Tester5 {

	public static void main(String[] args) {

		IntStream.rangeClosed(1, 101).filter(i -> i % 2 == 0).forEach(i -> System.out.print(i + " "));

	}

}
