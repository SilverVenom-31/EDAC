//Created by @AkhilD on 14/12/2020.
package com.app.bank;

public class SavingAccount extends BankAccount {
	private double simpleInterest;

	public SavingAccount(String name, double balance) {
		super(name, "Savings", balance);
		

	}

	

	public void applyInterest(int years) {

		this.simpleInterest = (super.balance * years * 5) / 100;
		super.balance = super.balance + this.simpleInterest;

	}

	@Override
	public double computeIncomeTax() {
		this.simpleInterest = (super.balance * 1 * 5) / 100;
		return ((10 * simpleInterest) / 100);

	}

	@Override
	public String toString() {

		return super.toString() + " " + " Income Tax: " + this.computeIncomeTax();
	}
	
	public String toString(String str) {

		return super.toString() + " " + " Simple Interest: " + this.simpleInterest;
	}
	

}
