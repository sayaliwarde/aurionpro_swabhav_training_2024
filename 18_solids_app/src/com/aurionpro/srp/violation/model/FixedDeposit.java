package com.aurionpro.srp.violation.model;

public class FixedDeposit {
	private int accountNumber;
	private String name;
	private int duration;
	private double setInterestRate;
	private double principle;
	public FestivalType festival;
	public FixedDeposit(int accountNumber, String name, int duration, double principle) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.duration = duration;
		this.principle=principle;
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getPrinciple() {
		return principle;
	}
	public void setPrinciple() {
		this.principle=principle;
	}
	

	private double getInterestRates() {
		switch(festival) {
		case NEWYEAR:
			return 8.0;
		case DIWALI:
			return 8.5;
		case HOLI:
			return 7.5;
		case OTHERS:
		default:
			return 6.5;
  }
 }	
	public double calculateSimpleInterest() {
		
		return principle*duration*setInterestRate;
	}
	
	
	

}
