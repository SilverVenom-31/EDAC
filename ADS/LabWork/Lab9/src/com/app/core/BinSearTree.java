//Created by @AkhilD on 15/01/2021.
package com.app.core;

public class BinSearTree {

	public class BTSNode {
		int data;
		BTSNode lChild;
		BTSNode rChild;

	}

	private BTSNode root;

	public BinSearTree() {
		root = null;
	}

	public void insert(int elem) {
		BTSNode curr = root;
		BTSNode prev = null;
		while (curr != null) {
			prev = curr;
			if (elem < curr.data) {
				curr = curr.lChild;
			} else {
				curr = curr.rChild;
			}
		}

		if (prev == null) {
			root = new BTSNode();
			root.data = elem;
			return;
		}

		if (elem < prev.data) {
			prev.lChild = new BTSNode();
			prev.lChild.data = elem;
		} else {
			prev.rChild = new BTSNode();
			prev.rChild.data = elem;

		}

	}

	public boolean find(int elem) {

		return find(root, elem);

	}

	private boolean find(BTSNode node, int elem) {
		if (node == null) {
			return false;

		}
		if (node.data == elem) {
			return true;

		}

		if (elem < node.data) {
			if (node.lChild != null) {
				return find(node.lChild, elem);

			} else {
				return false;

			}
		}
		if (node.rChild != null) {
			return find(node.rChild, elem);
		}
		return false;
	}

	public void printTree() {
		inOrder(root);

	}

	private void inOrder(BTSNode node) {
		if (node == null) {
			return;
		}
		if (node.lChild != null) {
			inOrder(node.lChild);
			// if want to display left side then root then right side then call preorder()

		}
		System.out.print(node.data + " ");

		if (node.rChild != null) {
			inOrder(node.rChild);
		}
	}

}
