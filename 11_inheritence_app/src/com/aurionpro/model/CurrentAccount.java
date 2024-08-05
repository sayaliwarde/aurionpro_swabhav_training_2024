package com.aurionpro.model;

public class CurrentAccount extends Account{
	private int overDraftLimit;

	public CurrentAccount(int accountNumber, String name, double balance, int overDraftLimit) {
		super(accountNumber, name, balance);
		this.overDraftLimit = overDraftLimit;
	}

	public int getOverDraftLimit() {
		return overDraftLimit;
	}

	public void setOverDraftLimit(int overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}

	@Override
	public String toString() {
		return "CurrentAccount [overDraftLimit="  + getOverDraftLimit()
				+ ", AccountNumber=" + getAccountNumber() + ", Name=" + getName() + ", Balance="
				+ getBalance() +  "]";
	}
	
	

}
