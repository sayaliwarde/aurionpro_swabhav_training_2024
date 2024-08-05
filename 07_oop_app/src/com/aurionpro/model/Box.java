package com.aurionpro.model;

public class Box {
	public int height;
	public int width; 
	public int depth;
	
	public Box() {  //default constructor
		width=10;
		height=20;
		depth=30;
	}
	
	public Box(int height,int width, int depth) { //parameterized constructor
		this.width=width;
		this.height=height;
		this.depth=depth;
	}
	
	public void setHeight(int h) {
		this.height=height;		
	}
	public int getHeight() {
		return height;
	}
	
	public void setWidth(int w) {
		this.width=width;
	}
	public int getWidth() {
		return width;
	}
	
	public void setDepth(int d) {
		this.depth=depth;
	}
	public int getDepth() {
		return depth;
	}
	
	

	

}
