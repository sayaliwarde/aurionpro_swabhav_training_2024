package com.aurionpro.structural.decorator.model;

public class GoldenHat extends HatDecorator{

	public GoldenHat(IHat decoratedHat) {
		super(decoratedHat);
		// TODO Auto-generated constructor stub
	}
	
    public String getName() {
        return decoratedHat.getName() + " with Golden Finish";
    }

    public double getPrice() {
        return decoratedHat.getPrice() + 30.0; 
    }

    public String getDescription() {
        return decoratedHat.getDescription() + " Decorated with a golden finish.";
    }
	

}
