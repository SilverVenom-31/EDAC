
public class SinglyList {
	public class SListNode {
		int data;
		SListNode next;
	};

	private SListNode head;

	public SinglyList() {
		head = null;
	}

	public void addAtFront(int no) {
		SListNode n = new SListNode(); // 1. Create a new node.
		n.data = no; // 2. Store data in new node.
		n.next = head; // 3. Make head node come after new node.
		head = n; // 4. Make new node as head.
	}

	public void printList() {
		SListNode curr = head; // 1. Set curr to head.
		while (curr != null) { // 2.
			System.out.println(curr.data); // 2.1 Process curr's data
			curr = curr.next; // 2.2 Make curr point to curr's next node.
		}
	}
}
