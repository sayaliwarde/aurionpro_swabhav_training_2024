package com.aurionpro.exception;

public class InsufficientBalanceException extends RuntimeException{
	private double balance;

	public InsufficientBalanceException(double balance) {
	
		this.balance = balance;
	}
	public String getMessage() 
	{
		return "You dont have sufficient balance. Enter amount less than or equal to" +balance;
	}
	

}
