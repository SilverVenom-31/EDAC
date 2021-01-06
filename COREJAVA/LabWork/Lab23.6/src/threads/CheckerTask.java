//Created by @AkhilD on 02/01/2021.
package threads;

import static java.lang.Thread.currentThread;

import utils.JointAccount;

public class CheckerTask implements Runnable {

	JointAccount jc;

	public CheckerTask(JointAccount jc) {
		this.jc=jc;
	}

	@Override
	public void run() {
		try {
			
			while (true) {

				double bal = jc.checkBalance();
				//System.out.println(jc);
				if (bal != jc.getBalance()) {
					System.err.println("Error!!!");
					System.exit(1);
				}
				//Thread.sleep(500);

			}

		} catch (Exception e) {
			System.out.println("Exception caught in thread: " + currentThread().getName() + " " + e);
		}
	}

}
