package com.aurionpro.dip.solution.model;

public class DBLogger implements Logger{
	
	@Override
	public void log(String err) {
		System.out.println("logged into database" +err);
		
	}
	

}
