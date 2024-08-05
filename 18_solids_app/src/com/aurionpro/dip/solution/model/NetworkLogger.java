package com.aurionpro.dip.solution.model;

public class NetworkLogger implements Logger{

	@Override
	public void log(String err) {
		System.out.println("logged into network logger" +err);
		
	}

}
