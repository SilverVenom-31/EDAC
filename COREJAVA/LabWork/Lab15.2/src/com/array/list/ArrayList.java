//Created by @AkhilD on 23/12/2020.
package com.array.list;

import static java.time.LocalDate.parse;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public abstract class ArrayList implements List<Integer> {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			Integer[] a = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
			List<Integer> l1 = Arrays.asList(a);
			System.out.println(l1.get(6) + " " + l1.get(5) + " " + l1.get(0));

			boolean status = false;
			java.util.ArrayList<LocalDate> arrayList = new java.util.ArrayList<>();

			while (!status) {
				System.out.println("\n1.Registration Dates: \n2.Exit\n\nChoose any one option: ");

				if (sc.nextInt() == 2) {
					status = true;
					sort(arrayList);
					for (LocalDate lDate : arrayList) {
						System.out.println(lDate);
					}

				} else {
					System.out.print("Date:(yyyy-MM-dd): ");
					arrayList.add(parse(sc.next()));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\nGoodBye!!!");
	}

	public static void sort(java.util.ArrayList<LocalDate> arrayList) {
		Collections.sort(arrayList);
	}

}
