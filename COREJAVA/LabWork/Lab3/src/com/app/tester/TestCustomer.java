package com.app.tester;

import java.util.Scanner;
import com.app.core.*;

public class TestCustomer {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Customer name,email,age,credlimit: ");
		Customer c1 = new Customer(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextDouble());

		
		sc.nextLine();
		System.out.print("Enter Customer name,email,age: \n");

	
		Customer c2 = new Customer(sc.nextLine(),sc.nextLine(),sc.nextInt() );

		Customer c3 = new Customer();

		System.out.println(c1.getDetails());
		System.out.println(c2.getDetails());
		System.out.println(c3.getDetails());

		System.out.println("Change the credit limit of " + c3.getDetails() + " to: ");
		c3.setCreditLimit(sc.nextDouble());

		System.out.println("New credit limit is: " + c3.getCreditLimit());
		
		sc.close();

	}

}
