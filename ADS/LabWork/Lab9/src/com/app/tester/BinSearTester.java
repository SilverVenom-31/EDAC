//Created by @AkhilD on 15/01/2021.
package com.app.tester;

import com.app.core.BinSearTree;

public class BinSearTester {

	public static void main(String[] args) {
	
		BinSearTree bt = new BinSearTree();
		
		
		bt.insert(20);
		bt.insert(10);
		bt.insert(40);
		bt.insert(5);
		bt.printTree();
		System.out.println();
System.out.println(bt.find(5));
System.out.println(bt.find(100));
	}

}
