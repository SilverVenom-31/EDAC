//Created by @AkhilD on 11/01/2021.
package com.app.core;

import com.app.utils.Stack;

public class Stacks implements Stack {

	public class Snode {
		int data;
		Snode next;
	}

	Snode head;
	Snode last;

	public Stacks() {
		head = null;
		last = null;
	}

	@Override
	public void push(int num) {
		Snode n = new Snode();
		n.data = num;
		n.next = head;
		head = n;

	}

	@Override
	public int pop() {

		if (head != null) {

			Snode ret = head;
			head = head.next;
			return ret.data;
		} else {
			System.out.println("List is empty");
			return -1;
		}

	}

	@Override
	public void printList() {
		Snode curr = head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}

}
