//Created by @AkhilD on 23/01/2021.
package com.app.tester;

import com.app.core.BinSearTree;

public class Tester {

	public static void main(String[] args) {

		BinSearTree b = new BinSearTree();


		b.root = b.insert(b.root, 10);
		b.root = b.insert(b.root, 20);
		b.root = b.insert(b.root, 30);
		b.root = b.insert(b.root, 40);
		b.root = b.insert(b.root, 50);
		b.root = b.insert(b.root, 25);
		
		
		System.out.println("inorder recursion");
		b.inOrder();
		System.out.println();
		System.out.println("Inorder iterator");
		b.inOrderItr();
		System.out.println();
		System.out.println("height of tree: " + b.heightBtree());

	}

}
