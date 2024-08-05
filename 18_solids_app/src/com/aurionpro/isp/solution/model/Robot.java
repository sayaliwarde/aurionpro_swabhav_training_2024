package com.aurionpro.isp.solution.model;

public class Robot implements IWorkable{

	@Override
	public void startWork() {
		System.out.println("robot strats the work");
		
	}

	@Override
	public void stopWork() {
		System.out.println("robot stops the work");
		
	}
	

}
