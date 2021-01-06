package notes;

/* Recursion : a process where a method calls itself continuously
 * Method which calls itself is called recursive method [sayHello()]
 * It must have a terminating/halt condition
 * Used for code optimization
 */

//#1----------------------------------------------------------
//public class Recursion {
//
//	public static void main(String[] args) {
//		System.out.println("Main starts");
//		sayHello();
//		System.out.println("Main ends");
//
//	}
//
//	public static void sayHello() {
//		System.out.println("Hello");
//		sayHello();// calls itself
//		// it will print hello till stack gets full and will give CE
//		//Exception in thread "main" java.lang.StackOverflowError
//		//so it must have terminating condition
//		
//	}
//}


//#2----------------------------------------------------------
public class Recursion {

	static int count = 1;

	public static void main(String[] args) {
		System.out.println("Main starts");
		sayHello();
		System.out.println("Main ends");

	}

	public static void sayHello() {
		System.out.println("Hello");
		count++;
		if (count <= 5)// terminating condition
			sayHello();// calls itself
		// it will print hello 5 times

	}
}
