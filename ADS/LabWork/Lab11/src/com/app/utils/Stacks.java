//Created by @AkhilD on 11/01/2021.
package com.app.utils;

public class Stacks<Temp> implements Stack<Temp> {

	public class Snode {
		Temp data;
		Snode next;
	}

	Snode head;
	Snode last;

	public Stacks() {
		head = null;
		last = null;
	}

	@Override
	public void push(Temp num) {
		Snode n = new Snode();
		n.data = num;
		n.next = head;
		head = n;

	}

	@Override
	public Temp pop() {

		if (head != null) {

			Snode ret = head;
			head = head.next;
			return ret.data;
		} else {
			System.out.println("List is empty");
			return null;
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

	@Override
	public boolean isEmpty() {

		if (head == null) {
			return true;
		}

		return false;
	}

}
