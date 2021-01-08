//Created by @AkhilD on 07/01/2021.
package com.app.core;

import com.app.utils.Stack;

public class Stacks implements Stack {

	private int[] arr;
	private int top;

	public Stacks(int s) {
		top = -1;
		arr = new int[s];
	}

	@Override
	public void push(int i) {
		if (isFull()) {
			System.out.println("Stack is full");
		}
		arr[++top] = i;
	}

	@Override
	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		return arr[top--];
	}

	@Override
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if (top == arr.length - 1) {
			return true;
		}
		return false;
	}

	@Override
	public void reverse() {
		int[] arr2 = new int[arr.length];
		int j = 0;
		for (int i = arr.length - 1; i >= 0; i--) {

			arr2[i] = arr[j];
			j++;
		}
		arr = arr2;
	}

}
