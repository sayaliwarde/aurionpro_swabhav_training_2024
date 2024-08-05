package com.aurionpro.isp.violation.model;

public class Labour implements IWorker {

	@Override
	public void startWork() {
		System.out.println("labours starts the work");
		
	}

	@Override
	public void stopWork() {
	System.out.println("labour stops the work");
		
	}

	@Override
	public void eat() {
	System.out.println("labour eats");
		
	}

	@Override
	public void drink() {
		System.out.println("labour drinks");
		
	}
	

}
