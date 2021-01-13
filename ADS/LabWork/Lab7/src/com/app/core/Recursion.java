//Created by @AkhilD on 13/01/2021.
package com.app.core;

public class Recursion {

	public int fibonacci(int n) {

		if ((n == 1) || (n == 2)) {

			return 1;
		}
		int i = fibonacci(n - 1);
		int j = fibonacci(n - 2);

		return i + j;
	}

	public int prod(int x, int y) {
		if (x == 0 || y == 0) {
			return 0;
		}
		if (x == 1) {
			return y;
		}
		if (y == 1) {
			return x;
		}

		int i = x + prod(x, y - 1);
		return i;

	}

	private int count = 1;

	public int div(int x, int y) {

		if (x == 0) {
			return 0;
		}

		if (x != y) {
			div(x - y, y);
			count++;
		}

		return count;

	}

}
