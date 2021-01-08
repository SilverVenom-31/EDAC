//Created by @AkhilD on 07/01/2021.
package com.app.tester;

import java.util.Scanner;

import com.app.core.LinearQueue;
import com.app.utils.Queue;

public class LinearTester {

	public static void main(String[] args) {

		Queue que = new LinearQueue(5);

		Scanner sc = new Scanner(System.in);

		// System.out.println(que.pop());
		System.out.println("Enter numbers: ");
		while (!que.isFull()) {
			que.push(sc.nextInt());
		}

		while (!que.isEmpty()) {
			System.out.println(que.pop());
		}

		sc.close();

	}

}
