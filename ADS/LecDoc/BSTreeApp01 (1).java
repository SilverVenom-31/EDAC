
public class BSTreeApp01 {
	public static void main(String[] args) {
		BSTree bst = new BSTree();

		System.out.println("Print elements - empty tree.");
		bst.print();
		if (bst.find(10)) {
			System.out.println("Search 10 - Found.");
		} else {
			System.out.println("Search 10 - Not Found.");
		}
		bst.insert(10);
		bst.insert(5);
		bst.insert(1);
		bst.insert(20);
		bst.insert(15);
		System.out.println("Print elements - 1 5 10 15 20.");
		bst.print();
		if (bst.find(10)) {
			System.out.println("Search 10 - Found.");
		} else {
			System.out.println("Search 10 - Not Found.");
		}
		if (bst.find(100)) {
			System.out.println("Search 100 - Found.");
		} else {
			System.out.println("Search 100 - Not Found.");
		}
		System.out.println("Delete 100");
		bst.delete(100); // Remove element not preset.
		System.out.println("Print elements - 1 5 10 15 20.");
		bst.print();
		System.out.println("Delete 10");
		bst.delete(10);
		System.out.println("Print elements - 1 5 15 20.");
		bst.print();
		System.out.println("Delete 1");
		bst.delete(1);
		System.out.println("Print elements - 5 15 20.");
		bst.print();
		System.out.println("Delete 5");
		bst.delete(5);
		System.out.println("Print elements - 15 20.");
		bst.print();
		System.out.println("Delete 15");
		bst.delete(15);
		System.out.println("Print elements - 20.");
		bst.print();
		System.out.println("Delete 20");
		bst.delete(20);
		System.out.println("Print elements - Empty.");
		bst.print();
	}
}
