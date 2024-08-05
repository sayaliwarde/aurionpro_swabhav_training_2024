package com.aurionpro.model;

public class PayPalPayment extends Payments{

	@Override
	public void processPayment() {
	System.out.println("Payment through Pay Pal");
		
	}

	@Override
	public void refund() {
System.out.println("Refund through Pay Pal");
		
	}

}
