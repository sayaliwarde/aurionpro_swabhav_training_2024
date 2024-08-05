package com.aurionpro.structural.decorator.model;

public class WheelAlignment extends CarDecorator{
	
	private ICarService carobj=null;
	public WheelAlignment(ICarService carobj) {
		super(carobj);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 500+super.getCost();
	}
	

}
