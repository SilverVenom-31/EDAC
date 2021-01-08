//Created by @AkhilD on 08/01/2021.
package com.app.core;

public class SinglyLinkedList {
	Node head;

	public class Node {
		int data;
		Node next;
	}

	public SinglyLinkedList() {
		head = null;
	}

	public void addAtFront(int num) {
		Node n = new Node();
		n.data = num;
		n.next = head;
		head = n;
	}

	public void printList() {
		Node var = head;
		while (var != null) {
			System.out.println(var.data);
			var = var.next;
		}
	}

	public int count() {
		int count = 0;
		if (head == null) {
			count = 0;
		} else {
			Node var = head;
			while (var != null) {
				count++;
				var = var.next;
			}
		}
		return count;
	}

	public boolean find(int n) {

		Node var = head;
		while (var != null) {
			if (var.data == n) {
				return true;
			}
			var = var.next;
		}

		return false;
	}

	public int countFreq(int n) {
		Node var = head;
		int count = 0;
		if (find(n)) {
			while (var != null) {

				if (var.data == n) {
					count++;
				}

				var = var.next;
			}

		}
		return count;
	}

	public void addToEnd(int num) {
		Node n = new Node();
		n.data = num;
		Node var = head;
		if (var == null) {
			addAtFront(num);
		} else {
			while (var != null) {
				if (var.next == null) {
					var.next = n;
					n.next = null;
				}
				var = var.next;
			}
		}

	}

}
