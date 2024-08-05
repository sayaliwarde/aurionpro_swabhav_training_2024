package com.aurionpro.test;

import com.aurionpro.model.CurrentAccount;
import com.aurionpro.model.SavingsAccount;

public class AccountTest {
	public static void main(String[] args) {
		SavingsAccount savingsAccount=new SavingsAccount(123, "sayali", 100, 50);
		System.out.println(savingsAccount);
		CurrentAccount currentAccount=new CurrentAccount(456, "neha", 200, 100);
		System.out.println(currentAccount);
	}

}
