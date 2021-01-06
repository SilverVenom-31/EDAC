//Created by @AkhilD on 04/01/2021.
package p1;

import java.util.Comparator;
import static java.lang.Thread.*;

public class Tester {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("Sleep started.... in thread");
					Thread.sleep(5000);
					System.out.println("Sleep over... in thread");
				} catch (InterruptedException e) {
					System.out.println("Thread: " + currentThread().getName() + " : " + e);
					e.printStackTrace();
				}

			}
		}, "first");
System.out.println("Before starting thread");
		t1.start();
		//It will wait for no daemon thread (child thread) to get completed
		//t1.start(); // java.lang.IllegalThreadStateException
		System.out.println("Before sleep in main");
		sleep(1000);
		System.out.println("Sleep over in main: Charlie Mike");
		t1.join();
		//t1.start(); // java.lang.IllegalThreadStateException
		System.out.println("Main over...JackPot");

	}

}
