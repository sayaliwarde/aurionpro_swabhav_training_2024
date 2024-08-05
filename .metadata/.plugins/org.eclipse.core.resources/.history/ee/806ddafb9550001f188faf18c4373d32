package com.aurionpro.behavioural.observer.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private long accountNumber;
    private String name;
    private double balance;
    private List<INotifiers> notifiers = new ArrayList<>();
    
    public Account(long accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }
    
    public long getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(long accountNumber) {
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
    
    public void addNotifier(INotifiers notifier) {
        this.notifiers.add(notifier);
    }
    
    public void removeNotifier(INotifiers notifier) {
        this.notifiers.remove(notifier);
    }
    
    private void notifyAllNotifiers() {
        for (INotifiers notifier : notifiers) {
            notifier.notify(this);
        }
    }
    
    public void credit(double amount) {
        this.balance += amount;
        notifyAllNotifiers();
    }
    
    public void debit(double amount) {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for debit. Current balance: " + balance);
        }
        this.balance -= amount;
        notifyAllNotifiers();
    }
}
