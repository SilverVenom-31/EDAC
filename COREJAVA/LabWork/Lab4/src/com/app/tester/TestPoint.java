//Created by @AkhilD on 10/12/20.

package com.app.tester;

import java.util.Scanner;

import com.app.geometry.Point2D;

class TestPoint {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		System.out.println("How many points to plot: ");
		Point2D[] arr = new Point2D[sc.nextInt()]; // 5
		int index;
		while (true) {
//Menu for user
			System.out.println(
					"1.Plot a new point\n2.Display all points\n3.Calculate distance\n4.Exit\n\nChoose any one option:");
//segregation of options
			switch (sc.nextInt()) {
			case 1:
				System.out.println("Enter index ,x ,y: "); // 2
				index = sc.nextInt();

				if (index < arr.length) {

					arr[index] = new Point2D(sc.nextInt(), sc.nextInt());

					if (arr[index] == null) {
						System.out.println("Invalid Index: No point plotted here");
					}
				} else {
					System.out.println("Invalid index: out of range");
				}
				break;

			case 2:

				for (Point2D pd : arr) {
					if (pd != null) {
						System.out.println(pd.getDetails());
					} else {
						System.out.println("index is null,Please choose again");
					}
				}

				break;
			case 3:
				System.out.println("Enter start point index and end point index: ");
				int strt = sc.nextInt();
				int end = sc.nextInt();
				if (arr[strt] != null && arr[end] != null) {
					System.out.println(arr[strt].calculateDistance(arr[end]));
				} else {
					System.out.println("Index is null, Please choose again");
				}
				break;
			case 4:
				System.out.println("GoodBye!!!");
				sc.close();
				System.exit(0);

				break;
			default:
				System.out.println("Please choose again ");
				break;

			}

		}

	}

}
