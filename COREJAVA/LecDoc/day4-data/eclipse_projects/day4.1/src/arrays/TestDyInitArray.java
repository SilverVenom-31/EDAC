package arrays;

import java.util.Arrays;

public class TestDyInitArray {

	public static void main(String[] args) {
		//dynamic init of array : excellent for testing : setting up some sample data
		char[] chars = /* new char[] */ {'a','s','d','f'};
		//what will be mem pic
		//display contents : toString
		System.out.println("Array contents ");
		System.out.println(Arrays.toString(chars));
		System.out.println("Loaded class name for char[] "+chars);//[C

	}

}
