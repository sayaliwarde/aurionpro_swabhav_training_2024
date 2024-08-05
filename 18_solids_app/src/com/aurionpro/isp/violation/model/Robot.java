package com.aurionpro.isp.violation.model;

public class Robot implements IWorker {

	@Override
	public void startWork() {
		System.out.println("robot starts the work");
		
	}

	@Override
	public void stopWork() {
		System.out.println("robot stops the work");
		
	}

	@Override
	public void eat() {
		System.out.println("robot eats");
		
	}

	@Override
	public void drink() {
		System.out.println("robot drinks");
		
	}
	

}
