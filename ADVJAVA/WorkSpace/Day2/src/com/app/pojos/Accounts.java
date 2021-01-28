package com.app.pojos;

public class Accounts {

	private int accNo;
	private String name, accType;
	private double balance;
	public Accounts(int accNo, String name, String accType, double balance) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.accType = accType;
		this.balance = balance;
	}
	
 public Accounts() {
	 	
 }

public int getAccNo() {
	return accNo;
}

public void setAccNo(int accNo) {
	this.accNo = accNo;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAccType() {
	return accType;
}

public void setAccType(String accType) {
	this.accType = accType;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

@Override
public String toString() {
	return "Accounts [accNo=" + accNo + ", name=" + name + ", accType=" + accType + ", balance=" + balance + "]";
}
	
	
	
}
