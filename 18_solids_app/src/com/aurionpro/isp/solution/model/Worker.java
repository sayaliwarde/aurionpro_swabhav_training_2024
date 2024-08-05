package com.aurionpro.isp.solution.model;

public class Worker implements IWorkable, ILunchInterval{

	@Override
	public void eat() {
		System.out.println("labour eats");
		
	}

	@Override
	public void drink() {
		System.out.println("labour drinks");
		
	}

	@Override
	public void startWork() {
		System.out.println("labour starts work");
		
	}

	@Override
	public void stopWork() {
		System.out.println("labour stops work");
		
	}
	

}
