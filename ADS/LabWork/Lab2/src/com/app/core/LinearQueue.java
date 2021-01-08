//Created by @AkhilD on 07/01/2021.
package com.app.core;

import com.app.utils.Queue;

public class LinearQueue implements Queue {
	private int[] arr;
	private int rear;
	private int front;

	public LinearQueue(int s) {
		rear = -1;
		front = -1;

		arr = new int[s];
	}

	@Override
	public void push(int i) {
		if (isFull()) {

			System.out.println("Queue is full");
		}

		arr[++rear] = i;
	}

	@Override
	public int pop() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		return arr[++front];
	}

	@Override
	public boolean isEmpty() {
		if (front == rear) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if (rear == arr.length - 1) {
			return true;
		}
		return false;
	}
	@Override
	public void displayQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			if (front == -1) {
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i]);
				}
			} else {
				for (int i = front + 1; i < arr.length; i++) {
					System.out.println(arr[i]);
				}
			}
		}

	}

}
