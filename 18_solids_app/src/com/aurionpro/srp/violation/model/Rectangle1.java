package com.aurionpro.srp.violation.model;

public class Rectangle1 implements Shapes{
	
	private int width;
	private int height;
	

	public Rectangle1(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}


	@Override
	public void area() {
		System.out.println("area of rectangle is:" +width*height);
		
	}

}
