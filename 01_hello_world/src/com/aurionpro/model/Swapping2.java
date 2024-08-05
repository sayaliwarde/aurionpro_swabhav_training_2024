package com.aurionpro.model;

public class Swapping2 {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		System.out.println("before swapping:");
		System.out.println("num 1: "+num1+"\t num 2: "+num2);
		num1=num1+num2;
		num2=num1-num2;
		num1=num1-num2;
		System.out.println("after swapping:");
		System.out.println("num 1: "+num1+"\t num 2: "+num2);
	}

}
