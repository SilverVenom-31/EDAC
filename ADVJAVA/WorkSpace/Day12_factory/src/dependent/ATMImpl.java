package dependent;

import dependency.TestTransport;
import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport ;
private double cash;

	

	private ATMImpl(double c123,Transport t1) {
		cash=c123;
		myTransport = t1;
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport+" "+cash);
	}

	


	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
	}

	public void myInit() {
		System.out.println("in init: "+myTransport+" "+cash);
	}
	public void myDestroy() {
		System.out.println("in destroy: "+myTransport+" "+cash);
	}
	
	//factory method based DI
	public static ATMImpl myFactory(double c,Transport t) {
		System.out.println("in factory");
		return new ATMImpl(c, t);
	}
}
