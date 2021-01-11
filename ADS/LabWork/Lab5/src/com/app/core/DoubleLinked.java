//Created by @AkhilD on 11/01/2021.
package com.app.core;

public class DoubleLinked {

	public class Dnode {
		int data;
		Dnode prev;
		Dnode next;

	}

	private Dnode head;
	private Dnode last;

	public DoubleLinked() {
		head = null;
		last = null;
	}

	public void addFront(int num) {
		Dnode n = new Dnode();
		n.data = num;
		n.next = head;
		if (head != null) {
			head.prev = n;
		}
		head = n;
		n.prev = null;

	}

	public void addEnd(int num) {
		Dnode n = new Dnode();
		n.data = num;
		n.next = null;
		if (head == null) {
			head = n;
			last = n;
			n.prev = null;
			return;
		}

		last.next = n;
		n.prev = last;
		last = n;

	}

	public void printList() {
		Dnode curr = head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;

		}
	}

}
