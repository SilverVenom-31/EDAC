//Created by @AkhilD on 11/01/2021.
package com.app.tester;

import com.app.core.DoubleLinked;

public class DoubleTester {

	public static void main(String[] args) {

		DoubleLinked list = new DoubleLinked();
		
		list.addEnd(5);
		list.addEnd(4);
		list.addFront(2);
		list.addFront(1);
		list.printList();
	}

}
