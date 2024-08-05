package com.aurionpro.model;

public class SavingsAccount extends Account{
	private double minimumBalance;

	public SavingsAccount(int accountNumber, String name, double balance, double minimumBalance) {
		super(accountNumber, name, balance);
		this.minimumBalance = minimumBalance;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	@Override
	public String toString() {
		return "SavingsAccount [MinimumBalance=" + getMinimumBalance()
				+ ", AccountNumber=" + getAccountNumber() + ", Name=" + getName() + ", Balance="
				+ getBalance() +  "]";
	}
	

}
