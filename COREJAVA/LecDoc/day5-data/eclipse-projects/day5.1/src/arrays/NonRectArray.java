//Created by @AkhilD on 11/12/20.
package arrays;

import java.util.Scanner;

public class NonRectArray {

	public static void main(String[] args) {
		int counter = 1;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter outer array length: ");
		int[][] arr = new int[sc.nextInt()][];

		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter inner array length for "+(i+1)+" array: ");
			arr[i] = new int[sc.nextInt()];
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = counter;
				counter++;
			}

		}

		for (int[] d : arr) {
			for (int c : d) {
				System.out.print(c + " ");
			}
			System.out.println(" ");
		}
		
		sc.close();

	}

}
