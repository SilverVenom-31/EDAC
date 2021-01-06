package com.app.core;

public class Customer {

	// name(String),email(String),age(int), creditLimit(double)
	private String name;
	private String email;
	private int age;
	private double creditLimit;
	
	public Customer(String name,String email,int age,double creditLimit) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.creditLimit = creditLimit;
		
	}
	
	public Customer() {
		//name to "Riya" , email to "riya@gmail.com",age=25,creditLimit=10000
		this("Riya","riya@gmail.com",25,10000);
		
	}
	
	public Customer(String name,String email,int age) {
		this(name,email,age,10000);
	}
	
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	public String getDetails() {
		return (this.name+" "+this.creditLimit);
	}
	

}
