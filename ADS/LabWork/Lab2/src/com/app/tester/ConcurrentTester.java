//Created by @AkhilD on 07/01/2021.
package com.app.tester;

import java.util.Scanner;

import com.app.core.CircularQueue;
import com.app.core.LinearQueue;
import com.app.utils.Queue;

public class ConcurrentTester {

	public static void main(String[] args) {
		Queue que = new LinearQueue(3);
		Queue cir = new CircularQueue(3);
		Scanner sc = new Scanner(System.in);
		que.push(1);
		que.push(2);
		que.push(3);
		que.displayQueue();
		System.out.println(que.pop());
		System.out.println(que.pop());
		System.out.println(que.pop());
		
		if (que.isEmpty() && que.isFull()) {
			System.out.println("Queue is empty and full at same time");
		}

		cir.push(1);
		cir.push(2);
		System.out.println(cir.pop());
		cir.push(3);
		cir.push(4);
		cir.displayQueue();
		
		System.out.println(cir.pop());
		System.out.println(cir.pop());
		
		if (cir.isEmpty() && cir.isFull()) {
			System.out.println("Circular Queue is empty and full at same time");
		}
	}

}
