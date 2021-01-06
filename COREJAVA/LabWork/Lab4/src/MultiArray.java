import java.util.Arrays;

public class MultiArray {

	public static void main(String[] args) {

		double[][] arr = new double[10][10];
		double counter = 101;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = counter;
				counter++;
			}

		}

		System.out.println("For each loop:");
		for (double[] arr2 : arr) {
			for (double val : arr2) {
				System.out.print(val + " ");
			}
			System.out.println(" ");
		}

		System.out.println("For loop:");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println(" ");
		}

		System.out.println("deepToString:");
		System.out.println(Arrays.deepToString(arr));

	}

}
