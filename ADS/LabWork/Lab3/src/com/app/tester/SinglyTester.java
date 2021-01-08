//Created by @AkhilD on 08/01/2021.
package com.app.tester;

import com.app.core.SinglyLinkedList;

public class SinglyTester {

	public static void main(String[] args) {

		SinglyLinkedList sl = new SinglyLinkedList();

		sl.addAtFront(1);
		sl.addAtFront(2);
		sl.addAtFront(4);
		sl.addAtFront(4);
		sl.addAtFront(5);
		sl.printList();
		System.out.println("Count: " + sl.count());
		System.out.println("Does Exists: " + sl.find(4));
		System.out.println("Freq: " + sl.countFreq(4));
		
		System.out.println("+++++++++++++++++==");
		
		sl.addToEnd(6);
		sl.printList();
		System.out.println("+++++++++++++++++==");
		
	}

}
