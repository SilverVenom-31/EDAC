
public class SinglyLinkedList {

	public static void main(String[] args) {
		SinglyList sl = new SinglyList();

		System.out.println("Printing list");
		sl.printList();

		sl.addAtFront(10);
		System.out.println("Printing list");
		sl.printList();

		sl.addAtFront(5);
		sl.addAtFront(1);
		System.out.println("Printing list");
		sl.printList();
	}
}
