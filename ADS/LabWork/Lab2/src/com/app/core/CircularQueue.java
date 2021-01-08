//Created by @AkhilD on 07/01/2021.
package com.app.core;

import com.app.utils.Queue;

public class CircularQueue implements Queue {

	private int front;
	private int rear;
	private int[] arr;

	public CircularQueue(int s) {
		front = 0;
		rear = 0;
		arr = new int[s];

	}

	@Override
	public void push(int i) {

		if (isFull()) {
			System.out.println("Queue is full");
			return;
		}

		rear = (rear + 1) % arr.length;
		arr[rear] = i;
	}

	@Override
	public int pop() {

		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}

		front = (front + 1) % arr.length;
		int n = arr[front];
		arr[front] = 0;
		return n;
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
		if ((rear + 1) % arr.length == front) {
			return true;
		}
		return false;
	}
	@Override
	public void displayQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			if (front == 0) {
				for (int i = 1; i < arr.length; i++) {
					System.out.println(arr[i]);
				}
			} else {
				for (int i = 0; i < arr.length; i++) {
					if (i != front) {
						System.out.println(arr[i]);
					}
				}
			}

		}

	}

}
