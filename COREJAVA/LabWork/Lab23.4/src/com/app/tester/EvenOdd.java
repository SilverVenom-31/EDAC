//Created by @AkhilD on 02/01/2021.
package com.app.tester;

import java.util.Scanner;

import com.app.core.EvenPrinterTask;
import com.app.core.OddPrinterTask;

public class EvenOdd {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter start and end numbers: ");
			int start = sc.nextInt();
			int end = sc.nextInt();

			Thread t1 = new Thread(new EvenPrinterTask(start, end), "Even");
			Thread t2 = new Thread(new OddPrinterTask(start, end), "Odd");

			t1.start();
			t2.start();
			System.out.println("Charlie Mike");
			t1.join();
			t2.join();
			System.out.println("Jackpot");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
