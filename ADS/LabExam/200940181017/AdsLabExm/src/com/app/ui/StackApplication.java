//Created by @AkhilD on 24/02/2021
package com.app.ui;

import java.util.Scanner;


import com.app.core.StackImpLinkedList;

public class StackApplication {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the size of stack : ");
			StackImpLinkedList stack = new StackImpLinkedList(sc.nextInt());
			boolean flag = false;
			while (!flag) {
				System.out.println(
						"\n1.  Element(PUSH) \n2.  Element(POP) \n3. IsEmpty : to check whether stack is empty or not "
								+ "\n4. IsFull: to check whether stack is full or not"
								+ "\n5. Front Function: to return front element of stack \n6. Exit");
				System.out.println("Enter your choice");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter element to add data to stack");
					stack.push(sc.nextInt());
					break;
				case 2:
					System.out.println("The removed element is : " + stack.pop());
					break;
				case 3:
					System.out.println("Is stack EMPTY ?? " + stack.isEmpty());
					break;
				case 4:
					System.out.println("Is stack FULL ?? " + stack.isFull());
					break;

				case 5:
					int f = stack.top();
					System.out.println(" stack Front element: " + f);
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
