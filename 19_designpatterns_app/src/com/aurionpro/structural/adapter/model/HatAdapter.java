package com.aurionpro.structural.adapter.model;

public class HatAdapter implements IItems {
	private Hat hat;
	public HatAdapter(Hat hat) {
		this.hat=hat;
	}
	
	

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return hat.getRealName(); 
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return hat.getTotalPrice();
	}
	
	

}
