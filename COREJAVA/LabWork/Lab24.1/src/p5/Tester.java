//Created by @AkhilD on 04/01/2021.
package p5;

import java.util.Comparator;
import static java.lang.Thread.*;

import java.io.IOException;

public class Tester {

	public static void main(String[] args) throws InterruptedException {

		// using lambda expression
		Thread t1 = new Thread(() -> {
			try {

				System.out.println("Press enter to continue: ");
				System.out.println("Thread t1 on hold");
				System.in.read();

				System.out.println("Sleep started.... in thread t1");
				sleep(1000);
				System.out.println("Sleep over... in thread t1");
			} catch (Exception e) {
				System.out.println("Thread: " + currentThread().getName() + " : " + e);
				e.printStackTrace();
			}
		}, "First");
		Thread t2 = new Thread(() -> {
			try {
				System.out.println("Waiting for t1 to complete");
				t1.join();
				System.out.println("Sleep started.... in thread t2");
				sleep(1000);
				System.out.println("Sleep over... in thread t2");
			} catch (Exception e) {
				System.out.println("Thread: " + currentThread().getName() + " : " + e);
				e.printStackTrace();
			}
		}, "Second");

		System.out.println("Before starting threads");
		t1.start();
		t2.start();
		// It will wait for no daemon thread (child thread) to get completed
		// t1.start(); // java.lang.IllegalThreadStateException
		System.out.println("Before sleep in main");
		sleep(1000);
		System.out.println("Sleep over in main waiting for threads to complete: Charlie Mike");

		t1.join(4000);
		t1.join(3000); // 7secs
		// main is sending interrupt signal to thread to abort: Endex
		System.out.println("Sending interrupt signal: EndEx");

		t1.interrupt();
		t2.interrupt();
		System.out.println("Mission Aborted");

		System.out.println("waiting for threads to complete: Charlie Mike v2");
		t2.join();
		t1.join();

		// t1.start(); // java.lang.IllegalThreadStateException
		System.out.println("Main over...JackPot");

	}

}
