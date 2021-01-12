//Created by @AkhilD on 12/01/2021.
package com.app.tester;

import com.app.core.CircularDoublyLinked;

public class CirDoub {

	public static void main(String[] args) {

		CircularDoublyLinked cd = new CircularDoublyLinked();

		cd.insert(5);
		cd.insert(3);
		cd.insert(10);

		cd.printList();
		System.out.println();
		cd.delete(3);
		cd.printList();

	}

}
