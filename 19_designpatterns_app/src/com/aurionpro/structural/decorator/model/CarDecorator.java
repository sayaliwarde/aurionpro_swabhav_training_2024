package com.aurionpro.structural.decorator.model;

public class CarDecorator implements ICarService {
	
	private ICarService carObj=null;
	
	
	public CarDecorator(ICarService carObj) {
		super();
		this.carObj = carObj;
	}
	


	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return carObj.getCost();
	}
	


}
