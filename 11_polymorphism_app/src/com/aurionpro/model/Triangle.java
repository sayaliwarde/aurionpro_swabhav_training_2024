package com.aurionpro.model;

public class Triangle extends Shape {
	public Triangle(int base, int height) {
		super();
		this.base = base;
		this.height = height;
	}
	private int base;
	private int height;
	@Override
	public void area() {
		System.out.println("area of triangle:"+0.5*base*height);
		
	}
	

}
