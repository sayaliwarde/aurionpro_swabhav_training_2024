package com.aurionpro.model;

public class Swapping4 {
	public static void main(String[] args) {
		int number1 = Integer.parseInt(args[0]);
		int number2 = Integer.parseInt(args[1]);
		System.out.println("Before swapping");
		System.out.println("Number 1 is:" +number1+"\tNumber 2 is:"+number2);
		int temp = number1;
		number1 = number2;
		number2 = temp;
		System.out.println("After swapping");
		System.out.println("Number 1 is:"+number1+"\tNumber 2 is:"+number2);
		
	}
	
			
}
