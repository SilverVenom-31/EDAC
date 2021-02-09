package dependent;

import dependency.TestTransport;
import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport ;
private double cash;

	
//constr based DI
	public ATMImpl(double c123) {
		cash=c123;
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport+" "+cash);
	}

	

	public void setMyTransport(Transport myTransport) {
		this.myTransport = myTransport;
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
}
