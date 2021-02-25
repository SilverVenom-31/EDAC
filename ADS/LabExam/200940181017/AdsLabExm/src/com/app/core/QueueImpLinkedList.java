//Created by @AkhilD on 24/02/2021
package com.app.core;

public class QueueImpLinkedList implements QueueInterface {

	private SinglyLinkedList struct;

	private int size; // maximum size of queue
	int count = 0; // to keep track of no of elements in Queue

	public QueueImpLinkedList(int size) {
		struct = new SinglyLinkedList();
		this.size = size;
	}

	@Override
	public void push(int data) {
		if (!isFull()) {
			struct.addAtEnd(data);
			count++;
		} else {
			System.out.println("Queue is full");
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
			System.out.println("Queue is empty");
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

	@Override
	public int top() {
		if (!isEmpty()) {
			return struct.getFront();
		} else {
			System.out.println("Queue is empty");
			return -1;
		}
	}

}
