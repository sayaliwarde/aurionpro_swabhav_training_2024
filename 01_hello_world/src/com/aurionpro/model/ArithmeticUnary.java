package com.aurionpro.model;

public class ArithmeticUnary {
	public static void main(String[] args) {
		int x=5;
		System.out.println("Current value is:"+x);
		//prefix
		int a=++x;
		System.out.println("Value of x after prefix increment is:"+a);
		System.out.println("Current value is:"+x);
		int b=--x;
		System.out.println("Value of x after prefix decrement is:"+b);
		System.out.println("Current value is: "+x);
		//postfix
		int c=x++;
		System.out.println("Value of x after postfix increment is:"+c);
		System.out.println("Current value is: "+x);
		int d=x--;
		System.out.println("Value of x after postfix decrement is:"+d);
		System.out.println("Current value is: "+x);		
		
	
	}
}
