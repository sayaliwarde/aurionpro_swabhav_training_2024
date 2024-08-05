package com.aurionpro.ocp.solution.model;

public class FixedDeposit {
	private int accountNumber;
	private String name;
	private double principle;
	private int duration;
	private FestivalType interest;
	public FixedDeposit(int accountNumber, String name, double principle, int duration, FestivalType interest) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.principle = principle;
		this.duration = duration;
		this.interest = interest;
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
	public double getPrinciple() {
		return principle;
	}
	public void setPrinciple(double principle) {
		this.principle = principle;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public FestivalType getInterest() {
		return interest;
	}
	public void setInterest(FestivalType interest) {
		this.interest = interest;
	}
	
	public double calculateSimpleInterest() {
		return principle*duration*interest.getInterestRate();
	}

}
