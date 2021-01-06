//Created by @AkhilD on 14/12/2020.
package com.app.bank;

public class LoanAccount extends BankAccount {
	private int noOfInstallments;
	private double emi;

	public LoanAccount(String name, double balance, int installments, double emi) {
		super(name, "Loan", balance);
		this.noOfInstallments = installments;
		this.emi = emi;
		
	}

	@Override
	public double computeIncomeTax() {

		return (((5 * super.balance) / 100) - ((1 * emi) / 100));
	}

	

	public String displayLoanDetails() {
		return ("Number of installments: " + noOfInstallments + " EMI: " + emi);
	}

	@Override
	public String toString() {
		return (super.toString() + " " + displayLoanDetails() + " Income Tax: " + this.computeIncomeTax());
	}
}
