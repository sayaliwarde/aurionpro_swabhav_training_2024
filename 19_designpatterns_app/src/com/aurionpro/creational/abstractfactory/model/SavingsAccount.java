package com.aurionpro.creational.abstractfactory.model;

public class SavingsAccount implements IAccount {

    private long accountNumber;
    private String name;
    private double balance;

    public SavingsAccount(long accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public void credit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount to be credited should be greater than 0");
        } else {
            balance += amount;
            System.out.println("Your new balance is: " + balance);
        }
    }

    @Override
    public void debit(double amount) {
        double minimumBalance = 1000;
        if (amount <= 0) {
            System.out.println("Amount to be debited should be greater than 0");
        } else if (amount > (balance - minimumBalance)) {
            System.out.println("Enter amount less than the allowable limit with minimum balance");
        } else {
            balance -= amount;
            System.out.println("Your new balance is: " + balance);
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "SavingsAccount [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
    }
}
