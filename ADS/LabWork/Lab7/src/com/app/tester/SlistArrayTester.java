//Created by @AkhilD on 13/01/2021.
package com.app.tester;

import com.app.core.SlistArray;

public class SlistArrayTester {

	public static void main(String[] args) {

		SlistArray s = new SlistArray(5);

		s.insert(5);
		s.insert(2);
		s.insert(3);
		s.insert(1);
		s.printList();

		System.out.println();
		s.delete(3);
		s.printList();

	}

}
