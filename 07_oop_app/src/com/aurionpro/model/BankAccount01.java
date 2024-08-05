package com.aurionpro.model;
import java.util.Random;

public class BankAccount01 {
    private int accountNumber;
    private String name;
    private double balance;
    private String accountType;
    private static Random random = new Random(); // Static random instance for generating account numbers

    public BankAccount01(int accountNumber, String name, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.accountType = accountType;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
    // Credit method
    public void credit(double amount) {
        if (amount <= 0) {
            System.out.println("Credit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Credited: " + amount + ". New balance: " + balance);
    }
    
    // Debit method
    public void debit(double amount) {
        if (amount <= 0) {
            System.out.println("Debit amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance. Debit amount exceeds current balance.");
            return;
        }
        balance -= amount;
        System.out.println("Debited: " + amount + ". New balance: " + balance);
    }
    
    // Display method
    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
        System.out.println("Account Type: " + accountType);
    }
    
    // Static method to generate random 10-digit account number
    public static int generateAccountNumber() {
        return 1000000000 + random.nextInt(900000000);
    }
}
