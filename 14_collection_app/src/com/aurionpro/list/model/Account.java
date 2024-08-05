package com.aurionpro.list.model;

import java.util.Random;

public class Account {
    private long accountNumber; 
    private String name;
    private double balance;


    public Account(long accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

   
    public long getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

  
    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

   
    public static long generateAccountNumber() {
        Random random = new Random();
        return 100000000000L + (long) (random.nextLong() * 899999999999L);
    }

    @Override
    public String toString() {
        return "Account[" +
                "accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ']';
    }
}

