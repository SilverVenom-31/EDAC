package com.app.core;

import java.time.LocalDate;

import custom_exception.AccountHandlingException;

import static utils.BankValidationRules.*;

public class BankAccount {
	private int acctNo;
	private String customerName;
	private AcType acctType;
	private double balance;
	private LocalDate createdOn;
	private String status; 
	
	private LocalDate tDate;
	
	public BankAccount(int acctNo, String customerName, AcType acctType, double balance, LocalDate createdOn) {
		super();
		this.acctNo = acctNo;
		this.customerName = customerName;
		this.acctType = acctType;
		this.balance = balance;
		this.createdOn = createdOn;
		this.tDate = createdOn;
	}
	@Override
	public String toString() {
		return "BankAccount [acctNo=" + acctNo + ", customerName=" + customerName + ", acctType=" + acctType
				+ ", balance=" + balance + ", createdOn=" + createdOn + "]";
	}
	//B.L methods
	public void deposit(double amount) throws AccountHandlingException
	{
		if (!status.equals("ACTIVE")) 
			throw new AccountHandlingException("Account is Disabled\nStatus: "+ getStatus());
		
			balance += amount;
			tDate = LocalDate.now();
	}
	public void withdraw(double amount) throws AccountHandlingException
	{
		if (!status.equals("ACTIVE")) 
			throw new AccountHandlingException("Account is Disabled\nStatus: "+ getStatus());
		
		validateBalance(balance-amount);
		balance -= amount;
		tDate = LocalDate.now();
	}
	public void transferFunds(BankAccount dest,double amt)  throws AccountHandlingException
	{
		if (!status.equals("ACTIVE")) 
			throw new AccountHandlingException("Account is Disabled\nStatus: "+ getStatus());
		
		this.withdraw(amt);
		dest.deposit(amt);
		tDate = LocalDate.now();
	}
	//apply interest
	public void applyInterest(double rate) throws AccountHandlingException
	{
		//period = 1yr
		double simpleInt=(balance*rate)/100;
		deposit(simpleInt);
	}
	//getters
	public int getAcctNo() {
		return acctNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public AcType getAcctType() {
		return acctType;
	}
	public double getBalance() {
		return balance;
	}
	public LocalDate getCreatedOn() {
		return createdOn;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate gettDate() {
		return tDate;
	}
	

}
