//Created by @AkhilD on 24/02/2021
package com.app.core;

public class StackImpLinkedList implements StackInterface {
	private SinglyLinkedList struct;
	private int size;
	private int count = 0;

	public StackImpLinkedList(int size) {
		
		struct = new SinglyLinkedList();
		this.size = size;
	}

	@Override
	public void push(int data) {
	
		if (!isFull()) {
			struct.addAtFront(data);
			count++;
		} else {
			System.out.println("Stack is full");
		}

	}

	@Override
	public int pop() {

		if (!isEmpty()) {
			int data = struct.getFront();
			struct.removeFront();
			count--;
			return data;
		} else {
			System.out.println("Stack is empty");
			return -1;
		}
	}

	@Override
	public int top() {

		if (!isEmpty()) {
			return struct.getFront();
		} else {
			System.out.println("Stack is empty");
			return -1;
		}
	}

	@Override
	public boolean isEmpty() {

		return struct.isEmpty();
	}

	@Override
	public boolean isFull() {
		
		if (count == size)
			return true;
		return false;
	}

}
