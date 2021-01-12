
package com.app.core;

public class DList {
	public class DListNode {
		int data;
		DListNode prev;
		DListNode next;
	};

	private DListNode head;
	private DListNode last;

	public DList() {
		head = null;
		last = null;
	}

	public void printList() {
		DListNode curr = head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}

	public void insert(int elem) {
		// 1. Create a new node.
		DListNode n = new DListNode();
		// 2. Initialize new node.
		n.data = elem;
		n.prev = null;
		n.next = null;
		// 3. if list is empty
		if (head == null) {
			// 3.1 Make new node as first node
			head = n;
			// 3.2 Make new node as last node
			last = n;
			// 3.3 Stop
			return;
		}
		// 4. Traverse the list
		DListNode curr = head;
		// 5. While curr is pointing to a node and its data is less
		while ((curr != null) && (curr.data < n.data)) {
			// 5.1 Move curr to next node.
			curr = curr.next;
		}
		// 6. We are adding smallest value => Add new node before curr/head.
		if (curr == head) {
			// 6.1 Make new node a curr's prev node
			curr.prev = n;
			// 6.2 Make curr as new node's next node.
			n.next = curr;
			// 6.3 Make new node as new first node.
			head = n;
			// 6.4 Stop
			return;
		}
		// 7. We are adding largest value => Add new node after last, as curr will be
		// null.
		if (curr == null) {
			// 7.1 Make new node as next to current last node.
			last.next = n;
			// 7.2 Make current last node as new node's prev node.
			n.prev = last;
			// 7.3 Make new node as last node.
			last = n;
			// 7.4 Stop
			return;
		}
		// 8. Make curr as new node's next node.
		n.next = curr;
		// 9. Make curr's prev node as new node's prev.
		n.prev = curr.prev;
		// 10. Make new node as next of curr's prev node.
		curr.prev.next = n;
		// 11. Make new node as curr's prev node
		curr.prev = n;
	}

	public void delete(int elem) {
		DListNode curr = head;
		while ((curr != null) && (curr.data != elem)) {
			curr = curr.next;
		}
		if (curr == null) {
			return;
		}
		if (curr == head) {
			if (curr == last) {
				head = null;
				last = null;
				return;
			}
			curr.next.prev = null;
			head = curr.next;
			return;

		}
		if (curr == last) {
			curr.prev.next = null;
			last = curr.prev;
			return;
		}

		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;

	}
}