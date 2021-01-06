//Created by @AkhilD on 28/12/2021.
package com.app.core;

import java.util.Collections;
import java.util.LinkedList;

public class Shuffle {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		
		for(int i =1 ; i<=100; i++) {
			list.add(i);
		}
		
		System.out.println("Before: "+list);

		Collections.shuffle(list);
		
		System.out.println("After: "+list);
		
	}

}
