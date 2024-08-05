package com.aurionpro.model;

public class Rectangle extends Shape{
	public Rectangle(int length, int breadth) {
		super();
		this.length = length;
		this.breadth = breadth;
	}
	private int length;
	private int breadth;
	@Override
	public void area() {
		System.out.println("area of rectangle is:"+length*breadth);
		
	}

}
