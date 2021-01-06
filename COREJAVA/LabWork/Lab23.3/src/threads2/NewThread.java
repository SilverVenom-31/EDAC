//Created by @AkhilD on 02/01/2021.
package threads2;
import static java.lang.Thread.currentThread;
public class NewThread extends Thread {
//add parameterized constructor to set name of the thread
	public NewThread(String name) {
		super(name); // STATE: NEW: thread class instance is created on heap but separate flow of
						// exec has not yet started
		start();// STATE: Runnable (ready pool or running)
		//if start() is commented and run() method is called than we get sequential execcution
		//Only main thread is running on system excluding gc
		
		
		System.out.println("In constr "+ currentThread().getName()); //main	
		//run();
		
	}

	@Override
	public void run() {
		System.out.println(currentThread().getName() + " Started");
		try {

			// B.L:simple dummy loop
			for (int i = 0; i < 10; i++) {
				System.out.println(currentThread().getName() + " exec# " + i);
				Thread.sleep(1000);  //ms: STATE: Blocked on sleep
			}
System.out.println("End of try....	");
		} catch (Exception e) {

			System.out.println("Error Occurred in " + getName() + " exc " + e);
		}

		System.out.println(getName() + " Over");
	}

}
