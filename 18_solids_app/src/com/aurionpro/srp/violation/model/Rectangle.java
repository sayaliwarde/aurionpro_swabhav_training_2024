package com.aurionpro.srp.violation.model;

public class Rectangle {
	private int width;
	private int height;
	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	public int getArea() {
		return width*height;
	}

}
