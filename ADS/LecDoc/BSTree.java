
public class BSTree {
	public class BTNode {
		int data;
		BTNode lChild;
		BTNode rChild;
	}
	private BTNode root;
	public BSTree() {
		root = null;
	}
	public void insert(int elem) {
		// 1. Set curr to root and prev to null.
		BTNode curr = root;
		BTNode prev = null;
		// 2. while curr is still node of a tree.
		while (curr != null) {
			prev = curr;
			// Move curr to its child.
			if (elem < curr.data) {
				curr = curr.lChild;
			} else {
				curr = curr.rChild;
			}
		}
		// Create new node.
		BTNode newNode = new BTNode();
		newNode.data = elem;
		newNode.lChild = null;
		newNode.rChild = null;
		// Tree is initially empty.
		if (prev == null) {
			// Make new node as root node and stop.
			root = newNode;
			return;
		}
		// Add new node as child of prev.
		if (newNode.data < prev.data) {
			prev.lChild = newNode;
		} else {
			prev.rChild = newNode;
		}
	}
	public boolean find(int elem) {
		BTNode curr = root;
		while ((curr != null) && (curr.data != elem)) {
			if (elem < curr.data) {
				curr = curr.lChild;
			} else {
				curr = curr.rChild;
			}
		}
		if (curr == null) {
			return false;
		}
		return true;
	}
	private void inorder(BTNode node) {
		if (node == null) {
			return;
		}
		if (node.lChild != null) {
			inorder(node.lChild);
		}
		System.out.println(node.data);
		if (node.rChild != null) {
			inorder(node.rChild);
		}
	}
	public void print() {
		inorder(root);
	}
	public void delete(int elem) {
		// 1. Set curr to root and prev to null.
		BTNode curr = root;
		BTNode prev = null;
		// 2. Find the node containing the elem to be deleted.
		while ((curr != null) && (curr.data != elem)) {
			// 2.1 Set prev to curr.
			prev = curr;
			// 2.2
			if (elem < curr.data) {
				// 2.2.1
				curr = curr.lChild;
			} else {
				// 2.2.2
				curr = curr.rChild;
			}
		}
		// 3. If curr is null then elem is not present in the tree.
		if (curr == null) {
			return;
		}

		// 4. While we are not removing a leaf node => curr is not a leaf node.
		// ((curr.lChild != null) || (curr.rChild != null))
		while (!((curr.lChild == null) && (curr.rChild == null))) {
			// 4.1 If curr is having one child.
			/* This code/algo does not work for all cases.
			if ((curr.lChild == null) || (curr.rChild == null)) {
				// 4.1.1 Swap data of curr with its child.
				if (curr.lChild != null) {
					int t = curr.data;
					curr.data = curr.lChild.data;
					curr.lChild.data = t;
				} else {
					int t = curr.data;
					curr.data = curr.rChild.data;
					curr.rChild.data = t;
				}
				// 4.1.2 Set prev to curr
				prev = curr;
				// 4.1.3 Set curr to its child.
				if (curr.lChild != null) {
					curr = curr.lChild;
				} else {
					curr = curr.rChild;
				}
				// 4.1.4 Continue
				continue;
			}
			 */
			if ((curr.lChild == null) || (curr.rChild == null)) {
				// Before Step #4.1. If curr is the only node in the tree to be remove
				if (curr == root) {
					if (curr.lChild != null) {
						root = curr.lChild;
					} else {
						root = curr.rChild;
					}
					return;
				}

				// 4.1 Replace prev's child from curr to curr's child.
				if (prev.lChild == curr) {
					if (curr.lChild != null) {
						prev.lChild = curr.lChild;
					} else {
						prev.lChild = curr.rChild;
					}
				} else {
					if (curr.lChild != null) {
						prev.rChild = curr.lChild;
					} else {
						prev.rChild = curr.rChild;
					}
				}
				//4.2 Stop
				return;
			}
			// Curr is having two child's.
			// 4.2 Find inorder successor of curr.
			BTNode isNodeParent = curr;
			BTNode isNode = curr.rChild;
			// While isNode has left child
			while (isNode.lChild != null) {
				isNodeParent = isNode;
				isNode = isNode.lChild;
			}
			// 4.3 Swap curr and inorder successor node's data
			int t = curr.data;
			curr.data = isNode.data;
			isNode.data = t;
			// 4.4 Set curr to inorder successor node.
			curr = isNode;
			// 4.5 Set prev to inorder successor parent.
			prev = isNodeParent;
			// 4.6 Continue
			continue;
		}
		// Before Step #5. If curr is the only node in the tree to be remove
		if (curr == root) {
			root = null;
			return;
		}
		// 5. curr is a leaf node.
		// Remove curr node.
		// 5.1
		if (curr == prev.lChild) {
			// 5.1.1
			prev.lChild = null;
		} else {
			// 5.1.2
			prev.rChild = null;
		}
	}
}
