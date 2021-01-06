//Created by @AkhilD on 14/12/2020.
package com.app.bank;

public abstract class BankAccount {
	public static int id;
	private String name;
	private String type;
	protected double balance;
	private int accNo;

	public int getAccNo() {
		return accNo;
	}

	protected BankAccount(String name, String type, double balance) {
		this.name = name;
		this.type = type;
		this.balance = balance;
		this.accNo = BankAccount.id++;
	}

	public double getBalance() {
		return balance;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return ("Account Number: " + accNo + " Customer Name: " + name + " Account Type: " + type + " Account Balance: "
				+ balance);
	}

	public void withdraw(double amount) {
		this.balance = this.balance - amount;
	}

	public void deposit(double amount) {
		this.balance = this.balance + amount;
	}

	public abstract double computeIncomeTax();

}
