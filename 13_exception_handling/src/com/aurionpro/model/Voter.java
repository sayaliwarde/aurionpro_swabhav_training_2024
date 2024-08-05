package com.aurionpro.model;

import com.aurionpro.exception.AgeNotValidException;

public class Voter {
	private int voterId;
	private String firstName;
	private String secondName;
	private int age;
	public Voter(int voterId, String firstName, String secondName, int age) {
		super();
		this.voterId = voterId;
		this.firstName = firstName;
		this.secondName = secondName;

			if(age<18)
				throw new AgeNotValidException(age);
		this.age = age;

		}
	public int getVoterId() {
		return voterId;
	}
	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
	
		
	if(age<18)
		throw new AgeNotValidException(age);
	
		this.age = age;
	
	
	}
	
	@Override
	public String toString() {
		return "Voter [voterId=" + voterId + ", firstName=" + firstName + ", secondName=" + secondName + ", age=" + age
				+ "]";
	}

}
