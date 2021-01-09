//Created by @AkhilD on 09/01/2021.
package com.app.tester;

import com.app.core.SinglyLinkedList;

public class SinglyTester {

	public static void main(String[] args) {
		
		SinglyLinkedList s = new SinglyLinkedList();
		
		s.addToEnd(5);
		s.addToEnd(3);
		s.addToEnd(2);
		s.addAtFront(1);
		s.printList();
		System.out.println();
		SinglyLinkedList x = new SinglyLinkedList();
		
		x.insert(4);
		x.insert(3);
		x.insert(5);
		x.insert(6);
		x.printList();

	}

}
