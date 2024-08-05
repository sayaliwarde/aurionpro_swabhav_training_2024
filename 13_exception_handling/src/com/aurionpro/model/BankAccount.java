package com.aurionpro.model;

public abstract class BankAccount {
    private long accountNo;
    private String name;
    private double balance;

    public BankAccount(long accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
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

    public void display() {
        System.out.println("Account Number: " + accountNo);
        System.out.println("Account Holder: " + name);
        System.out.println("Balance: $" + balance);
    }

    public void credit(double amount) {
        this.balance += amount;
        System.out.println("Credited: $" + amount);
    }
    
    public void debit(double amount) {
    	
    }

}