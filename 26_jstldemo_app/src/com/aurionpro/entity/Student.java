package com.aurionpro.entity;

public class Student {
	private int rool_Number;
	private String student_name;
	private double percentage;
	public int getRool_Number() {
		return rool_Number;
	}
	public Student(int rool_Number, String student_name, double percentage) {
		super();
		this.rool_Number = rool_Number;
		this.student_name = student_name;
		this.percentage = percentage;
	}
	public void setRool_Number(int rool_Number) {
		this.rool_Number = rool_Number;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "Student [rool_Number=" + rool_Number + ", student_name=" + student_name + ", percentage=" + percentage
				+ "]";
	}
	
	
	

}
