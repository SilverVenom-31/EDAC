//Created by @AkhilD on 14/01/2021.
package com.app.core;
public class TreeNode {

	public class BTnode {
		int data;
		BTnode lChild;
		BTnode rChild;

	}

	private BTnode root;

	public TreeNode() {
		root = null;
	}

	public void create() {
		root = new BTnode();
		root.data = 7;
		root.lChild = new BTnode();
		root.lChild.data = 9;
		root.lChild.lChild = new BTnode();
		root.lChild.lChild.data = 1;
		root.lChild.rChild = new BTnode();
		root.lChild.rChild.data = 5;
		root.lChild.rChild.lChild = new BTnode();
		root.lChild.rChild.lChild.data = 3;

		root.rChild = new BTnode();
		root.rChild.data = 4;
		root.rChild.rChild = new BTnode();
		root.rChild.rChild.data = 2;
		root.rChild.rChild.lChild = new BTnode();
		root.rChild.rChild.lChild.data = 6;
	}

	public void preOrder(BTnode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		if (node.lChild != null) {
			preOrder(node.lChild);
		}
		if (node.rChild != null) {
			preOrder(node.rChild);
		}

	}

	public void postOrder(BTnode node) {
		if (node == null) {
			return;
		}

		if (node.lChild != null) {
			preOrder(node.lChild);
		}
		if (node.rChild != null) {
			preOrder(node.rChild);
		}
		System.out.print(node.data + " ");
	}

	public void InOrder(BTnode node) {
		if (node == null) {
			return;
		}

		if (node.lChild != null) {
			InOrder(node.lChild);
			
		}
		System.out.print(node.data + " ");
		if (node.rChild != null) {
			InOrder(node.rChild);
		}

	}

	public void printList() {
		System.out.println("PreOrder: ");
		preOrder(root);
		System.out.println();

		System.out.println("PostOrder: ");
		postOrder(root);
		System.out.println();
		System.out.println("InOrder: ");
		InOrder(root);
	}
}
