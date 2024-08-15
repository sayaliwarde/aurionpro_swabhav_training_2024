package com.aurionpro.test;

import com.aurionpro.model.TransactionManaging;

public class TransactionManagementTest {
	public static void main(String[] args) {
		
		TransactionManaging transactionManaging=new TransactionManaging();
		
		transactionManaging.connectTo();
		transactionManaging.debit();
		transactionManaging.credit();
		transactionManaging.getTransactionDetails();
		
	}
	

	

}
