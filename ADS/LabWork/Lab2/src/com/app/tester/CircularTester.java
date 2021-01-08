//Created by @AkhilD on 07/01/2021.
package com.app.tester;

import java.util.Scanner;

import com.app.core.CircularQueue;
import com.app.utils.Queue;

public class CircularTester {

	public static void main(String[] args) {
		
		Queue cir = new CircularQueue(3);
		Scanner sc = new Scanner(System.in);

		//System.out.println(que.pop());
	//	System.out.println("Enter numbers: ");
		cir.push(1);
		cir.push(2);
		cir.push(3);
		cir.push(4);
		cir.push(5);
	System.out.println(cir.pop());
	System.out.println(cir.pop());
	System.out.println(cir.pop());
	System.out.println(cir.pop());
	
	
	
	
		sc.close();
	}

}
