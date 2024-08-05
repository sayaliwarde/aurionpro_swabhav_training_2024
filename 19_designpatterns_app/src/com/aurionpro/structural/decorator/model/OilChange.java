package com.aurionpro.structural.decorator.model;

public class OilChange extends CarDecorator{
	
	
	
	private ICarService carobj=null;
	public OilChange(ICarService carobj) {
		super(carobj);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 500+super.getCost();
	}
	
	
	

}
