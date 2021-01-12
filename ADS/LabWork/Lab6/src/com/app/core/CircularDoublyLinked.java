//Created by @AkhilD on 12/01/2021.
package com.app.core;

public class CircularDoublyLinked {
	private CirDList head;

	public class CirDList {
		int data;
		CirDList next;
		CirDList prev;
	}

	public CircularDoublyLinked() {
		head = new CirDList();
		head.next = head;
		head.prev = head;
	}

	public void printList() {
		// forward traversal
		CirDList curr = head.next;
		while (curr != head) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}

	public void insert(int num) {
		CirDList n = new CirDList();
		n.data = num;
		CirDList curr = head.next;
		while ((curr != head) && (curr.data < n.data)) {
			curr = curr.next;
		}
		n.next = curr;
		n.prev = curr.prev;
		curr.prev.next = n;
		curr.prev = n;

	}

	public void delete(int num) {
		CirDList curr = head.next;
		while ((curr != head) && (curr.data != num)) {
			curr = curr.next;
		}

		if (curr == head) {
			return;
		}
		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;
	}

}
