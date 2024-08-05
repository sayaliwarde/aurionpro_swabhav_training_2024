package com.aurionpro.structural.adapter.model;

public class Biscuit implements IItems {
	String name;
	double price;
	

	public Biscuit(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	

	public void setName(String name) {
		this.name = name;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	@Override
	public String getName() {
		return name;
		
	}

	@Override
	public double getPrice() {
		return price;
		
		
	}
	
	

}
