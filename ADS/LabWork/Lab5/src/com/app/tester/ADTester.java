//Created by @AkhilD on 23/01/2021.
package com.app.tester;

import com.app.core.Queues;
import com.app.core.Stacks;

public class ADTester {

	public static void main(String[] args) {

		Stacks s = new Stacks();

		s.push(1);
		s.push(2);
		s.push(3);
		s.printList();

		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println();
		s.printList();
		System.out.println();
		// Queue testing
		Queues q = new Queues();

		q.push(1);
		q.push(2);
		q.push(3);
		q.printList();
		System.out.println("popping in queue");
		System.out.println(q.pop());
		System.out.println(q.pop());

		System.out.println();
		q.printList();
	}

}
