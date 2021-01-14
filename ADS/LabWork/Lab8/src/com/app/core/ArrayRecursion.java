//Created by @AkhilD on 14/01/2021.
package com.app.core;

public class ArrayRecursion {

	private int sum = 0;

	public int totalSum(int[] arr, int i) {

		if (i == arr.length) {
			return 0;
		}
		sum = arr[i] + totalSum(arr, i + 1);

		return sum;

	}
}
