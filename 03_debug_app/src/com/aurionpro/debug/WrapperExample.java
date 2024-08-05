package com.aurionpro.debug;

public class WrapperExample {
	public static void main(String[] args) {
		int a=10;
		Integer aObj=a; //AUTOBOXING
		System.out.println(a);
		int b=aObj; //UNBOXING
		System.out.println(b+a);
	}

}
