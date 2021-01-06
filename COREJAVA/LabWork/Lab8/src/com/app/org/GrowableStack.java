//Created by @AkhilD on 15/12/2020.
package com.app.org;


public class GrowableStack implements Stack {

	private Employee[] emp;
	private Employee[] emp2;
	private int top;

	public GrowableStack() {
		emp = new Employee[STACK_SIZE];

		top = -1;

	}

	@Override
	public void push(Employee e) {
		int count = 0;
		emp2 = new Employee[STACK_SIZE * 2];
		for (Employee er : emp) {
			if (er != null) {
				count++;
			}
		}
		System.out.println(count);
		System.out.println("tp: " + top);
		if (count < emp.length) {
			emp[++top] = e;
			
		} else {
			System.out.println("Stack is full, reassigning the stack");

			for (int i = 0; i < emp.length; i++) {
				emp2[i] = emp[i];
			}

			
			emp2[++top] = e;
			//copying the reference of new array to previous array so the reference is pointing to new array
		}
	}

	@Override
	public Employee pop() {
		int count = 0;
		for (Employee er : emp) {
			if (er != null) {
				count++;
			}
		}
		System.out.println("tp: " + top);
		if (top > emp.length - 1) {
			if (count != 0 && top >= 0) {
				count--;
				return emp2[top--];

			} else {
				return null; // stack is empty
			}
		} else {
			if (count != 0 && top >= 0) {
				count--;
				return emp[top--];

			} else {
				return null; // stack is empty
			}
		}

	}
}
