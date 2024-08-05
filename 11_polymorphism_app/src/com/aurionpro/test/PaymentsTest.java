package com.aurionpro.test;

import com.aurionpro.model.BankTransferPayments;
import com.aurionpro.model.CreditCardPayment;
import com.aurionpro.model.PayPalPayment;

public class PaymentsTest {
	public static void main(String[] args) {
		CreditCardPayment creditcard=new CreditCardPayment();
		creditcard.processPayment();
		creditcard.refund();
		PayPalPayment paypal=new PayPalPayment();
		paypal.processPayment();
		paypal.refund();
		BankTransferPayments banktransfer=new BankTransferPayments();
		banktransfer.processPayment();
		banktransfer.refund();
		
	
	}

}
