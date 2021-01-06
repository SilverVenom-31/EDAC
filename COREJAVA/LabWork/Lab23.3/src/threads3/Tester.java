//Created by @AkhilD on 02/01/2021.
package threads3;

import static java.lang.Thread.currentThread;

public class Tester {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread()); // 1 thread running on system excluding garbage collector thread

		// create child threads and observe the concurrency

		// Create runnable class instance
		RunnableTask task = new RunnableTask(); // 1 thread running on system

		// Thread class constructor which implements runnable i/f instance
		Thread t1 = new Thread(task, "one");
		Thread t2 = new Thread(task, "two");
		Thread t3 = new Thread(task, "three");
		Thread t4 = new Thread(task, "four"); // 1 runnable thread running on system

		t1.start();
		t2.start();
		t3.start();
		t4.start(); // 5 runnable thread running on system

//garbage collector is daemon thread 

		// Java applications are terminated only when all non daemon threads are
		// terminated
		// Orphan case scenario when parent thread is terminated before child thread
		// (Not preferred)

		// No orphan scenario is recommended
		// main: dummy logic
		for (int i = 0; i < 10; i++) {
			System.out.println(currentThread().getName() + " exec# " + i);
			Thread.sleep(500); // ms: STATE: Blocked on sleep
		}

		System.out.println("main waiting for child threads to complete exec");
		System.out.println("thread status: " + t1.isAlive() + " " + t4.isAlive()); // t t
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		System.out.println("Child threads are over...");
		System.out.println("thread status: " + t1.isAlive() + " " + t4.isAlive()); // f f
		System.out.println("Main over...");

	}
}
