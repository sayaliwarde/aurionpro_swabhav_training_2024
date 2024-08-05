package com.aurionpro.structural.decorator.model;

public class RibbonHat extends HatDecorator {

	public RibbonHat(IHat decoratedHat) {
		super(decoratedHat);
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
        return decoratedHat.getName() + " with Ribbon";
    }
    
    public double getPrice() {
        return decoratedHat.getPrice() + 10.0; // Adding a ribbon cost
    }

    public String getDescription() {
        return decoratedHat.getDescription() + " Decorated with a ribbon.";
    }
	

}
