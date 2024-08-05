package com.aurionpro.creational.factory.model;

public class CurrentAccount implements IAccount{
	
	private long accountNumber;
	private String name;
	private double balance;
	
	

	public CurrentAccount(long accountNumber, String name, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}

	
	public long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	@Override
	public void credit(int amount) {
		if(amount<=0)
			System.out.println("Amount should be greater than 0");
		if(amount>=0)
			balance=+amount;
		System.out.println("Your balance is: " +balance);
		
	}

	@Override
	public void debit(int amount) {
		double overDraftLimit = 500;
		if(amount<=0)
			System.out.println("Amount should be greater than 0");
		if(amount>overDraftLimit)
		System.out.println("Your over draft limit is exceeded");
		else 
			balance=-amount;
		System.out.println("Your balance is" +balance);

		
	}

}
