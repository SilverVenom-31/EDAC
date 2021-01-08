//Created by @AkhilD on 07/01/2021.
package com.app.tester;

import java.util.Scanner;

import com.app.core.Stacks;
import com.app.utils.Stack;

public class StackTester {

	public static void main(String[] args) {

		Stack st = new Stacks(5);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter numbers: ");
		while (!st.isFull()) {
			st.push(sc.nextInt());
		}
st.reverse();
		while (!st.isEmpty()) {
			System.out.println(st.pop());
		}

		sc.close();
	}

}
