package com.aurionpro.model;

public class Account {
	private int accountNumbert;
	private String name;
	private int balance;
	private AccountType accountType;
	public Account(int accountNumbert, String name, int balance, AccountType accountType) {
		super();
		this.accountNumbert = accountNumbert;
		this.name = name;
		this.balance = balance;
		this.accountType = accountType;
	}
	public int getAccountNumbert() {
		return accountNumbert;
	}
	public void setAccountNumbert(int accountNumbert) {
		this.accountNumbert = accountNumbert;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

}
