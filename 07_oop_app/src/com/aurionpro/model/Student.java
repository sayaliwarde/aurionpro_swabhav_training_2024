package com.aurionpro.model;

public class Student {
	public String name;
	public int age; 
	public int rollnumber;
	public double percentage;
	
	
	public void setName(String n) {
		name=n;		
	}
	public String getName() {
		return name;
	}
	
	public void setAge(int a) {
		age=a;
	}
	public int getAge() {
		return age;
	}
	
	public void setRollnumber(int r) {
		rollnumber=r;
	}
	public int getRollNumber() {
		return rollnumber;
	}
	
	public void setPercentage(int p) {
		percentage=p;
	}
	public double getPercentage() {
		return percentage;
	}

}
