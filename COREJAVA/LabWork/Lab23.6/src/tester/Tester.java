//Created by @AkhilD on 02/01/2021.
package tester;

import threads.CheckerTask;
import threads.UpdaterTask;
import utils.JointAccount;

public class Tester {
	public static void main(String [] args) {
		
		
		try {
			JointAccount jc = new JointAccount(5000);
			
			Thread t1 = new Thread(new UpdaterTask(jc),"Update");
			Thread t2 = new Thread(new CheckerTask(jc),"Checker");
			
			
			t1.start();
			t2.start();
			
			System.out.println("Charlie Mike");
			
			

			
			t1.join();
			t2.join();
		
			System.out.println("JackPot");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
