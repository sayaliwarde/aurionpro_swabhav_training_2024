package com.aurionpro.dip.solution.model;

public class FileLogger implements Logger{

	@Override
	public void log(String err) {
		System.out.println("logged into file logger" +err);
		
	}


}
