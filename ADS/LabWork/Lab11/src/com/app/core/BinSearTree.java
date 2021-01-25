//Created by @AkhilD on 23/01/2021.
package com.app.core;

import com.app.utils.Stacks;

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

	public void inOrder() {
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

	public void inOrderItr() {
		inOrderItr(root);
	}

	private void inOrderItr(BTSNode node) {
		BTSNode curr = node;
		Stacks<BTSNode> s = new Stacks<>();
		while (curr != null) {
			s.push(curr);
			curr = curr.lChild;
		}

		while ((curr == null) && (!s.isEmpty())) {
			BTSNode pNode = s.pop();
			System.out.print(pNode.data + " ");
			curr = pNode.rChild;
			while (curr != null) {
				s.push(curr);
				curr = curr.lChild;
			}
		}

	}

	public int heightBtree() {
		return heightBtree(root);
	}

	private int heightBtree(BTSNode node) {

		if (node == null) {
			return 0;
		}

		if ((node.lChild == null) && (node.rChild == null)) {
			return 1;
		}

		int lHeight = heightBtree(node.lChild);
		int rHeight = heightBtree(node.rChild);
		return 1 + Math.max(lHeight, rHeight);

	}

}
