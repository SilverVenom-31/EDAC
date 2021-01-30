package com.app.pojo;

import java.sql.Date;

public class Customer {
//id | deposit_amt | email          | name    | password | reg_date   | role  
	private int id;
	private double depositAmt;
	private String email;
	private String name;
	private String password;
	private Date date;
	private String role;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, double depositAmt, String email, String name, String password, Date date, String role) {
		super();
		this.id = id;
		this.depositAmt = depositAmt;
		this.email = email;
		this.name = name;
		this.password = password;
		this.date = date;
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Customer[id=" + id + ",depositAmt=" + depositAmt + ",email=" + email + ",name=" + name
				 + ",date=" + date + ",role=" + role + "]";
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDepositAmt() {
		return depositAmt;
	}

	public void setDepositAmt(double depositAmt) {
		this.depositAmt = depositAmt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}
