//Created by @AkhilD on 02/01/2021.
package com.app.core;

import static java.lang.Thread.currentThread;

public class EvenPrinterTask implements Runnable {

	private int start;
	private int end;

	public EvenPrinterTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		try {
			for (int i = start; i <= end; i++) {

				if (i % 2 == 0) {
					System.out.println("Even Number: " + i);
					Thread.sleep(1000);
				}
				
			}
		} catch (Exception e) {
			System.out.println("Exception caught in thread: " + currentThread().getName());
		}

	}

}
