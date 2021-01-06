//Created by @AkhilD on 02/01/2021.
package threads;

import static java.lang.Thread.currentThread;

import utils.JointAccount;

public class UpdaterTask implements Runnable {
	JointAccount jc;

	public UpdaterTask(JointAccount jc) {
		this.jc = jc;
	}

	@Override
	public void run() {
		try {

			while (true) {

				jc.updateBalance(1000);
			//	System.out.println(jc);
			//	Thread.sleep(500);

			}

		} catch (Exception e) {
			System.out.println("Exception caught in thread: " + currentThread().getName() + " " + e);
		}
	}
}
