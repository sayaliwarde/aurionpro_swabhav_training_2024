package com.aurionpro.list.model;

public class Student {
	private int rollNumber;
	private String Name;
	private double percentage;
	public Student(int rollNumber, String name, double percentage) {
		super();
		this.rollNumber = rollNumber;
		Name = name;
		this.percentage = percentage;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", Name=" + Name + ", percentage=" + percentage + "]";
	}
	
	

}
