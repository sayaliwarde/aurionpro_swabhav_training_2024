package com.aurionpro.creational.factory.model;

public class AccountFactory {
	public static IAccount makeAccount(AccountType accountType) {
		IAccount account=null;
		if(accountType==AccountType.SAVINGSACCOUNT)
			account = new SavingsAccount(1234, "sayali", 200);
		if(accountType==AccountType.CURRENTACCOUNT)
			account = new CurrentAccount(9876, "aagya", 500);
			return account;
	}

}
