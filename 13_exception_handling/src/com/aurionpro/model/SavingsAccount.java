package com.aurionpro.model;

import com.aurionpro.exception.MinBalanceException;

public class SavingsAccount extends BankAccount {
    private double minBalance;

    public SavingsAccount(long accountNo, String name, double balance, double minBalance) {
        super(accountNo, name, balance);
        this.minBalance = minBalance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    @Override
    public void debit(double amount) {
        if (getBalance() - amount >= minBalance) {
            setBalance(getBalance() - amount);
            System.out.println("Debited: $" + amount);
        } else {
            throw new MinBalanceException(minBalance);
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Minimum Balance: $" + minBalance);
    }
}