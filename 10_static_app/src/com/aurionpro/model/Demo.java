package com.aurionpro.model;

public class Demo {
	private int a=1;
	private static  int b=1;
	private int c=1;
	
	public void increment() {
		a++;
		b++;
		c++;	
	}
	public void display() {
		System.out.println("a is:"+a);
		System.out.println("b is:"+b);
		System.out.println("c is:"+c);
	}
	static
	{
		System.out.println("magicc");
	}

}
