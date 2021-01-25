//Created by @AkhilD on 23/01/2021.
package com.app.tester;

import com.app.core.BinSearTree;

public class Tester {

	public static void main(String[] args) {

		BinSearTree b = new BinSearTree();

		b.insert(2);
		b.insert(1);
		b.insert(3);
		b.insert(4);
		b.insert(5);

		System.out.println("inorder recursion");
		b.inOrder();
		System.out.println();
		System.out.println("Inorder iterator");
		b.inOrderItr();
		System.out.println();
		System.out.println("height of tree: " + b.heightBtree());

	}

}
