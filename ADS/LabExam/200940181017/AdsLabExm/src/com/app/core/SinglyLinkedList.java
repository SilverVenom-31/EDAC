//Created by @AkhilD on 24/02/2021
package com.app.core;
public class SinglyLinkedList {
	private Node head;
	private Node last;

	public class Node {
		private int data;
		private Node next;

		public Node(int data) {

			this.data = data;
			next = null;
		}
	}

	public SinglyLinkedList() {

		head = null;
		last = null;
	}

//// Add the number at the end of list.
	public void addAtEnd(int num) {
		Node n = new Node(num);
		if (head == null) {
			head = n;
			last = n;
		}
		last.next = n;
		last = n;

	}
	public void addAtFront(int num) {
		Node n = new Node(num);
		n.next = head;
		head = n;
	}

	// Return the first element in the list.
	public int getFront() {
		if (isEmpty()) {
			System.out.println("List is empty!!");
			return -1;
		}
		else {
			return head.data;
		}

	}

	//// Remove the first element from the list.
	public void removeFront() {
		if (isEmpty()) {
			System.out.println("List is empty!!");
			return;
		}
		else {
			head = head.next;
		}
		
	}

	// Return true if list is empty else false.
	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}

	}

}
