package com.aurionpro.model;

import com.aurionpro.exception.OverdraftLimitExceededException;

public class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(long accountNo, String name, double balance, double overdraftLimit) {
        super(accountNo, name, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void debit(double amount) {
        if (getBalance() - amount >= -overdraftLimit) {
            setBalance(getBalance() - amount);
            System.out.println("Debited: $" + amount);
        } else {
            throw new OverdraftLimitExceededException(overdraftLimit);
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Overdraft Limit: $" + overdraftLimit);
    }
}