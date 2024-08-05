package com.aurionpro.creational.factory.test;

import com.aurionpro.creational.factory.model.AccountFactory;
import com.aurionpro.creational.factory.model.AccountType;
import com.aurionpro.creational.factory.model.IAccount;

public class AccountTest {
	public static void main(String[] args) {
		
		IAccount account;
		account=AccountFactory.makeAccount(AccountType.SAVINGSACCOUNT);
		account.credit(100);
		account.debit(2000);
		
		
	}
	
	
	

}
