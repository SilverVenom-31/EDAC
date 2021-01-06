//Created by @AkhilD on 13/12/2020.
package com.app.tester;

import com.app.utils.*;

import com.app.fruits.*;
import java.util.Scanner;

public class FruitTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("How many fruits to store in basket: ");
		Fruits[] basket = new Fruits[sc.nextInt()];
		int index = 0;
		while (true) {
			System.out.println(
					"\n1.Add Apple\n2.Add Orange\n3.Add Cherry\n4.Display taste of all fruits in basket\n5.Exit\n\nChoose any one option: ");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("Enter name of Apple: ");
				if (index < basket.length) {
					FruitUtils.addFruit(new Apple(sc.next()), basket, index);
					index++;
				} else {
					System.out.println("Basket is full.\nPlease choose display basket or exit");

				}

				continue;
			case 2:
				System.out.println("Enter name of Orange: ");
				if (index < basket.length) {
					FruitUtils.addFruit(new Orange(sc.next()), basket, index);
					index++;
				} else {
					System.out.println("Basket is full.\\nPlease choose display basket or exit");
				}
				continue;
			case 3:
				System.out.println("Enter name of Cherry: ");
				if (index < basket.length) {
					FruitUtils.addFruit(new Cherry(sc.next()), basket, index);
					index++;
				} else {
					System.out.println("Basket is full.\\nPlease choose display basket or exit");
				}
				continue;
			case 4:
				for (Fruits f : basket) {
					if (f != null) {
						f.taste();
					}
				}
				continue;
			case 5:
				System.out.println("Good Bye!!!");
				sc.close();
				System.exit(0);
				break;

			default:
				System.out.println("Please choose again");
				continue;
			}

		}
	}

}
