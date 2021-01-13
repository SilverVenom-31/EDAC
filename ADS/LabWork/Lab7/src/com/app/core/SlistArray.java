//Created by @AkhilD on 13/01/2021.
package com.app.core;

public class SlistArray {
	private int size;
	private SlistNode[] nodes;
	private int head;

	public SlistArray(int s) {
		size = s;
		nodes = new SlistNode[size];
		head = -1;
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new SlistNode();
			nodes[i].isUsed = false;
		}

	}

	public class SlistNode {
		int data;
		int next;
		boolean isUsed;
	}

	private int getFreeNode() {
		for (int i = 0; i < size; i++) {
			if (!nodes[i].isUsed) {
				nodes[i].isUsed = true;
				return i;
			}
		}

		return -1;

	}

	public void insert(int num) {

		int n = getFreeNode();
		if (n == -1) {
			return;
		}
		nodes[n].data = num;
		nodes[n].next = -1;
		if (head == -1) {
			head = n;
			return;
		}
		int prev = -1;
		int curr = head;
		while ((curr != -1) && (nodes[curr].data < num)) {
			prev = curr;
			curr = nodes[curr].next;
		}

		if (prev == -1) {
			nodes[n].next = head;
			head = n;
			return;
		}

		if (curr == -1) {
			nodes[prev].next = n;
			return;
		}

		nodes[prev].next = n;
		nodes[n].next = curr;

	}

	public void printList() {

		int curr = head;
		while (curr != -1) {
			System.out.println(nodes[curr].data);
			curr = nodes[curr].next;
		}

	}

	public void delete(int num) {

		int curr = head;
		int prev = -1;
		while ((curr != -1) && (nodes[curr].data != num)) {
			prev = curr;
			curr = nodes[curr].next;
		}

		if (curr == -1) {
			return;
		}
		if (prev == -1) {
			head = nodes[curr].next;
			return;
		}

		nodes[prev].next = nodes[curr].next;

	}

}
