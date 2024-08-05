package com.aurionpro.model;

public class Savings01 extends Account01{
	public double minimumBalance;
//	public double credit;
//	public double debit;
	public Savings01(double initialBalance) {
		
		this.balance=initialBalance;
		this.minimumBalance=5000;
		
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
		if (amount <= 0 || amount >balance - minimumBalance) {
            System.out.println("Check your debit amount");
            return;
        }
        balance -= amount;
        System.out.println("Debited: " + amount + ". New balance: " + balance);
		
	}
	
}
