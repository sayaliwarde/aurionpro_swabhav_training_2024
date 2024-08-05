package com.aurionpro.model;

public class BankAccount {
	private int account_number;
	private String user_name;
	private double user_balance;
	private double deposit;
	private double withdrawal;
	
	public void setAccount_number(int accountNumber) { //set acc no
		account_number=accountNumber;
	}
	public int getAccount_number() { //get acc no
		return account_number;
	}
	public void setUser_name(String name) { //set name
		user_name=name;
	}
	public String getUser_name() { //get name
		return user_name;
	}
	public void setUser_balance(double balance) { //set balance
		user_balance=balance;
	}
	public double getUser_balance() { //get balance
		return user_balance;
	}
	public void setDeposit(double credit) { //set deposit
		deposit=credit;
	}
	public double getDeposit() { //get balance
		return deposit;
	}
	public void setWithdrawl(double debit) { //set withdrawal
		withdrawal=debit;
	}
	public double getWithdrawal() { //get withdrawal
		return withdrawal;
	}

}
