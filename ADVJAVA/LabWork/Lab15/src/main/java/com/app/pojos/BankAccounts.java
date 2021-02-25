//Created by @AkhilD on 07/02/2021
package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="bank_accounts")
public class BankAccounts extends BaseEntity {
	@Enumerated( EnumType.STRING)
	private AccountType type;
	private double balance;
	@ManyToOne
	@JoinColumn(name = "v_id", nullable = false)
	private Vendors accountOwner;

	public BankAccounts(AccountType type, double balance) {
		super();
		this.type = type;
		this.balance = balance;
		
	}

	public BankAccounts() {
		System.out.println("In bankAccount constr");
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Vendors getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(Vendors accountOwner) {
		this.accountOwner = accountOwner;
	}

	@Override
	public String toString() {
		return "BankAccounts [type=" + type + ", balance=" + balance + "]";
	}

}
