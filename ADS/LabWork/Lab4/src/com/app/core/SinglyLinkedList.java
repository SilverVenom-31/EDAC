//Created by @AkhilD on 08/01/2021.
package com.app.core;

public class SinglyLinkedList {
	Node head;
	Node last;

	public class Node {
		int data;
		boolean flag;
		Node next;
	}

	public SinglyLinkedList() {
		head = null;
		last = null;
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
		n.next = null;
		if (head == null) {
			head = n;
			last = n;
			return;
		}
		last.next = n;
		last = n;

	}

	public void addBefore(int num, int no) {
		Node n = new Node();
		n.data = no;
		Node var = head;

		while (var != null) {

			if (var.data == num) {
				n.next = var.next;
				var.next = n;
				return;
			}

			var = var.next;
		}

	}

	public void addAfter(int num, int no) {
		Node n = new Node();
		n.data = no;
		Node var = head;

		while (var != null) {

			if (var.next.data == num) {
				n.next = var.next;
				var.next = n;
				return;
			}

			var = var.next;
		}

	}

	public void insert(int num) {

		Node n = new Node();
		n.data = num;
		n.next = null;
		Node prev = null;
		Node var = head;
		if (head == null) {
			head = n;
			return;
		}
		while ((var != null) && (var.data < n.data)) {
			prev = var;
			var = var.next;
		}

		if (prev == null) {
			n.next = head;
			head = n;

			return;
		}

		if (var == null) {
			prev.next = n;
			last = prev;
			return;
		}
		prev.next = n;
		n.next = var;

	}

	public void reverse() {
		Node var = head;
		Node temp = null;
		Node prev = temp;
		while (var != null) {
			temp = var.next;
			var.next = prev;
			prev = var;
			var = temp;
		}
		head = prev;

	}

	public boolean isLoop() {
		Node var = head;

		while (var != null) {
			var.flag = true;
			if (var.next.flag) {
				return true;
			}

			var = var.next;
		}

		return false;
	}

}
