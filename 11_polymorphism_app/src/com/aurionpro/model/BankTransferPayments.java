package com.aurionpro.model;

public class BankTransferPayments extends Payments{

	@Override
	public void processPayment() {
		System.out.println("Payment Through bank transfer");
		
	}

	@Override
	public void refund() {
		System.out.println("Refund through bank transfer");
		
	}

}
