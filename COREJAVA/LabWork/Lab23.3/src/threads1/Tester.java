//Created by @AkhilD on 02/01/2021.
package threads1;

import static java.lang.Thread.currentThread;

public class Tester {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread()); // 1 thread running on system excluding garbage collector thread

		// create child threads and observe the concurrency
//Asynchronous execution and Sequential execution
		NewThread t1 = new NewThread("one");
		NewThread t2 = new NewThread("two");
		NewThread t3 = new NewThread("three");
		NewThread t4 = new NewThread("four"); // 5 runnable threads are there on system including main and excluding
												// garbage collector

		// main: dummy logic
		for (int i = 0; i < 10; i++) {
			System.out.println(currentThread().getName() + " exec# " + i);
			Thread.sleep(1000); // ms: STATE: Blocked on sleep
		}
		System.out.println("Main over...");

	}
}
