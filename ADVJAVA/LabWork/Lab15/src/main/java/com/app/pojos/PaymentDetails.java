package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
//annotations that are not acceptable: entity,id,table,generated value
public class PaymentDetails {
	@Enumerated(EnumType.STRING)
	@Column(length = 20, name = "payment_mode")
	private PaymentMode mode;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "payment_date")
	private LocalDate paymentDate;
	
	@Min(value=100)
	@Max(value=10000)
	private double amount;

	public PaymentDetails() {
		System.out.println("in payment details constr");
	}

	public PaymentDetails(PaymentMode mode, LocalDate paymentDate, double amount) {
		super();
		this.mode = mode;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	public PaymentMode getMode() {
		return mode;
	}

	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PaymentDetails [mode=" + mode + ", paymentDate=" + paymentDate + ", amount=" + amount + "]";
	}
}
