package com.aurionpro.structural.adapter.model;

public class Chocolate implements IItems{
	
	String name;
	double price;
	

	public Chocolate(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	

	public void setName(String name) {
		this.name = name;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
	

}
