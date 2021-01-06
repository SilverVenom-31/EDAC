//Created by @AkhilD on 02/01/2021.
package threads3;

import static java.lang.Thread.currentThread;

public class RunnableTask implements Runnable {
	// RunnableTask is not a thread, it is a runnable

	@Override
	public void run() {
		System.out.println(currentThread().getName() + " Started");
		try {

			// B.L:simple dummy loop
			for (int i = 0; i < 10; i++) {
				System.out.println(currentThread().getName() + " exec# " + i);
				Thread.sleep(1000); // ms: STATE: Blocked on sleep
			}
			System.out.println("End of try....	");
		} catch (Exception e) {

			System.out.println("Error Occurred in " + currentThread().getName() + " exc " + e);
		}

		System.out.println(currentThread().getName() + " Over");
	}

}
