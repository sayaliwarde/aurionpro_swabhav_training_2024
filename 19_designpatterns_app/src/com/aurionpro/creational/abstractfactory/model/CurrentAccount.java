package com.aurionpro.creational.abstractfactory.model;

public class CurrentAccount implements IAccount {

    private long accountNumber;
    private String name;
    private double balance;

    public CurrentAccount(long accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public void credit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount should be greater than 0");
        } else {
            balance += amount;
            System.out.println("Your balance is: " + balance);
        }
    }

    @Override
    public void debit(double amount) {
        double overDraftLimit = 500;
        if (amount <= 0) {
            System.out.println("Amount should be greater than 0");
        } else if (amount > (balance + overDraftLimit)) {
            System.out.println("Your overdraft limit is exceeded");
        } else {
            balance -= amount;
            System.out.println("Your balance is: " + balance);
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "CurrentAccount [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
    }
}
