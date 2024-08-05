package com.aurionpro.model;

public class CreditCardPayment extends Payments {

	@Override
	public void processPayment() {
		System.out.println("Payment through credit card");
		
	}

	@Override
	public void refund() {
		System.out.println("Refund through Credit card");
		
	}
	
	

}
