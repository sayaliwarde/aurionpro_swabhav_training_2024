package com.aurionpro.dip.violation.model;

public class DBLogger {
	private String err;
	public void log(String err) {
	 System.out.println("Logged to database" +  err);
	}	

}
