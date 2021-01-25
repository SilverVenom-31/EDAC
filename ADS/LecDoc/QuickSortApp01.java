
public class QuickSortApp01 {
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; ++i)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}
	public static void quickSort(int[] arr, int startPos, int endPos) {
		// 1. Array to sort is of size 1 or less, STOP.
		if ((endPos - startPos + 1) <= 1) return;
		// 2. Use first element as pivote.
		int pivote = startPos;
		// 3. Left will be set to element after pivote.
		int left = startPos + 1;
		// 4. Set Right to last element.
		int right = endPos;
		// 5. While left and right don't cross over.
		while (left <= right) {
			// 5.1 While left and right hasn't crossed over and left is pointing to element less than pivote, move ahead.
			while ((left <= right) && (arr[left] < arr[pivote])) ++left;
			// 5.2 While left and right hasn't crossed over and right is pointing to element greater than pivote, move back.
			while ((left <= right) && (arr[pivote] < arr[right])) --right;
			// 5.3 If left and right hasn't crossed over, swap left and right elements.
			if (left < right) {
				int t = arr[left];
				arr[left] = arr[right];
				arr[right] = t;
			}
		}
		// 6. Swap pivote with right element. Now, right will point to pivote element.
		int t = arr[pivote];
		arr[pivote] = arr[right];
		arr[right] = t;
		// 7. Perform quick sort on array part that is on left side of right . 
		quickSort(arr, startPos, right - 1);
		// 8. Perform quick sort on array part that is on right side of right . 
		quickSort(arr, right + 1, endPos);
	}
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] arr2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] arr3 = {9, 1, 7, 3, 10, 4, 6, 5, 8, 2};

		System.out.println("Before sorting ...");
		printArray(arr1);
		quickSort(arr1, 0, arr1.length - 1);
		System.out.println("After sorting ...");
		printArray(arr1);

		System.out.println("Before sorting ...");
		printArray(arr2);
		quickSort(arr2, 0, arr2.length - 1);
		System.out.println("After sorting ...");
		printArray(arr2);

		System.out.println("Before sorting ...");
		printArray(arr3);
		quickSort(arr3, 0, arr3.length - 1);
		System.out.println("After sorting ...");
		printArray(arr3);
	}
}
