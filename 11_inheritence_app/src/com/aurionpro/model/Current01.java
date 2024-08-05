package com.aurionpro.model;

public class Current01 extends Account01 {
	public double overDraftLimit;
	
	public Current01(double initialBalance) {
		this.balance=initialBalance;
		this.overDraftLimit=balance+500;
	}
	
	public void credit(double amount) {
		if (amount <= 0) {
            System.out.println("Credit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Credited: " + amount + ". New balance: " + balance);
	}
	
	public void debit(double amount) {
		if (amount <= 0 || amount >balance+overDraftLimit) {
            System.out.println("Check your debit amount or over draft limit");
            return;
        }
        balance -= amount;
        System.out.println("Debited: " + amount + ". New balance: " + balance);
		
	}
	

}
