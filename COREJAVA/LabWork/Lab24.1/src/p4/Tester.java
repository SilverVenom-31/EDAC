//Created by @AkhilD on 04/01/2021.
package p4;

import java.util.Comparator;
import static java.lang.Thread.*;

import java.io.IOException;

public class Tester {

	public static void main(String[] args) throws InterruptedException {

		// using lambda expression
		Thread t1 = new Thread(() -> {
			try {
				
				System.out.println("Press enter to continue: ");
System.out.println("Thread on hold");
				System.in.read();

				System.out.println("Sleep started.... in thread");
				sleep(1000);
				System.out.println("Sleep over... in thread");
			} catch (Exception e) {
				System.out.println("Thread: " + currentThread().getName() + " : " + e);
				e.printStackTrace();
			}
		}, "First");

		System.out.println("Before starting thread");
		t1.start();
		// It will wait for no daemon thread (child thread) to get completed
		// t1.start(); // java.lang.IllegalThreadStateException
		System.out.println("Before sleep in main");
		sleep(1000);
		System.out.println("Sleep over in main waiting for thread to complete: Charlie Mike");
		// main is sending interrupt signal to thread to abort: Endex
		System.out.println("Sending interrupt signal: EndEx");
		
		t1.interrupt();
		System.out.println("Mission Aborted");
		t1.join();
		// t1.start(); // java.lang.IllegalThreadStateException
		System.out.println("Main over...JackPot");

	}

}
