//Created by @AkhilD on 15/12/2020.
package com.app.org;


public class FixedStack implements Stack {
	private Employee[] emp;
	private int top;

	public FixedStack() {
		emp = new Employee[STACK_SIZE];
		top = -1;

	}

	@Override
	public void push(Employee e) {
		int count = 0;
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
			System.out.println("Stack is full");
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
		if (count != 0 && top >= 0) {
			count--;
			return emp[top--];

		} else {
			return null; // stack is empty
		}
	}

}
