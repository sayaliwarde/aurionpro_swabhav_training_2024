package com.aurionpro.model;

import java.util.Scanner;

public class Rectangle {
	
	public int height;
	public int width; 



public void initialize(int h, int w){
	this.height=h;
	this.width=w;

	
}
public void calculateArea(){

	System.out.println("area"+height*width);
	
	
	
}
public void display(){

		
		System.out.println(height);
		System.out.println(width);
		
}
}
