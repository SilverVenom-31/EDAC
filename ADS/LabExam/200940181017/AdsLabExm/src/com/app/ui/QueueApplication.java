//Created by @AkhilD on 24/02/2021
package com.app.ui;

import java.util.Scanner;

import com.app.core.QueueImpLinkedList;

public class QueueApplication {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the size of queue : ");
			QueueImpLinkedList queue = new QueueImpLinkedList(sc.nextInt());
			boolean flag = false;
			while (!flag) {
				System.out.println(
						"\n1. Enqueue Element(PUSH) \n2. Dequeue Element(POP) \n3. IsEmpty : to check whether Queue is empty or not "
								+ "\n4. IsFull: to check whether Queue is full or not"
								+ "\n5. Front Function: to return front element of queue \n6. Exit");
				System.out.println("Enter your choice");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter element to add data to queue");
					queue.push(sc.nextInt());
					break;
				case 2:
					System.out.println("The removed element is : " + queue.pop());
					break;
				case 3:
					System.out.println("Is Queue EMPTY ?? " + queue.isEmpty());
					break;
				case 4:
					System.out.println("Is Queue FULL ?? " + queue.isFull());
					break;

				case 5:
					int f = queue.top();
					System.out.println(" Queue Front element: " + f);
					break;

				case 6:
					flag = true;
					System.out.println("Exited successfully ..!!");
					break;
				default:
					System.out.println("Wrong Choice!! please enter correct choice");
					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
