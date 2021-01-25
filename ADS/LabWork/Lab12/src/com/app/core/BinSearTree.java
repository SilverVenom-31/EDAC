//Created by @AkhilD on 23/01/2021.
package com.app.core;

import com.app.utils.Stacks;

public class BinSearTree {

	public class BTSNode {
		int data;
		BTSNode lChild;
		BTSNode rChild;
		int height;
		public BTSNode() {
			height =1;
		}
		public BTSNode(int data) {
			height = 1;
			this.data = data;
		}

	}

	public BTSNode root;

	public BinSearTree() {
		root = null;
	}

	public BTSNode insert(BTSNode node, int data) { 
		  
	        /* 1.  Perform the normal BST insertion */
	        if (node == null) 
	            return (new BTSNode(data)); 
	  
	        if (data < node.data) 
	            node.lChild = insert(node.lChild, data); 
	        else if (data > node.data) 
	            node.rChild = insert(node.rChild, data); 
	        else // Duplicate keys not allowed 
	            return node; 
	  
	        /* 2. Update height of this ancestor node */
	        node.height = 1 + max(height(node.lChild), 
	                              height(node.rChild)); 
	  
	        /* 3. Get the balance factor of this ancestor 
	              node to check whether this node became 
	              unbalanced */
	        int balance = getBalance(node); 
	  
	        // If this node becomes unbalanced, then there 
	        // are 4 cases Left Left Case 
	        if (balance > 1 && data < node.lChild.data) 
	            return rightRotate(node); 
	  
	        // Right Right Case 
	        if (balance < -1 && data > node.rChild.data) 
	            return leftRotate(node); 
	  
	        // Left Right Case 
	        if (balance > 1 && data > node.lChild.data) { 
	            node.lChild = leftRotate(node.lChild); 
	            return rightRotate(node); 
	        } 
	  
	        // Right Left Case 
	        if (balance < -1 && data < node.rChild.data) { 
	            node.rChild = rightRotate(node.rChild); 
	            return leftRotate(node); 
	        } 
	  
	        /* return the (unchanged) node pointer */
	        return node; 
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

	int height(BTSNode N) { 
        if (N == null) 
            return 0; 
  
        return N.height; 
    } 
  
    // A utility function to get maximum of two integers 
    int max(int a, int b) { 
        return (a > b) ? a : b; 
    } 
    
    
    BTSNode rightRotate(BTSNode y) {
    	BTSNode x = y.lChild;
    	BTSNode t2 = x.rChild;
    	
    	//performing rotation
    	x.rChild = y;
    	y.lChild = t2;
    	
    	y.height = max(height(y.lChild), height(y.rChild))+1;
    	x.height = max(height(x.lChild), height(x.rChild))+1;
    	
    	
    	return x;
    	
    }
    
    
    BTSNode leftRotate(BTSNode y) {
    	BTSNode x = y.rChild;
    	BTSNode t2 = x.lChild;
    	
    	//performing rotation
    	x.lChild = y;
    	y.rChild = t2;
    	
    	y.height = max(height(y.lChild), height(y.rChild))+1;
    	x.height = max(height(x.lChild), height(x.rChild))+1;
    	
    	return x;
    }
    
    int getBalance(BTSNode n) {
    	if(n == null) {
    		return 0;
    	}
    	
    	return height(n.lChild)-height(n.rChild);
    }
    
    public int heightBtree() {
    	return max(height(root.lChild), height(root.rChild))+1;
    }
    
    
    
    
    
    
    
    

}
