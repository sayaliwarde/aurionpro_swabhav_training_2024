package com.aurionpro.creational.abstractfactory.model;

public class Maruti implements ICar{

	@Override
	public void start() {
		System.out.println("Maruti car has started");
		
	}

	@Override
	public void stop() {
		System.out.println("Maruti car has stopped");
		
	}
	

}
