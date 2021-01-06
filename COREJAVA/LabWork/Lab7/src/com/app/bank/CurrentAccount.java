//Created by @AkhilD on 14/12/2020.
package com.app.bank;

public class CurrentAccount extends BankAccount {

	public CurrentAccount(String name, double balance) {
		super(name, "Current", balance);
		
	}

	

	@Override
	public double computeIncomeTax() {

		return ((1 * super.balance) / 100);
	}

	@Override
	public String toString() {

		return super.toString() + " Income Tax: " + this.computeIncomeTax();
	}

}
