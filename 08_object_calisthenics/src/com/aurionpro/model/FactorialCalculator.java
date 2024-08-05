package com.aurionpro.model;

import java.util.Scanner;

public class FactorialCalculator {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter a number:");
		int number=scanner.nextInt();
		int factorial=calculateFactorial(number);
		
		if(factorial==-1)
		{
			System.out.println("cannot calculate factorial of negative numbers");
			return;
		}
		
	}
	private static int calculateFactorial(int number) {
		
		if(number==0)
			return 1;
		if(number<0)
			return -1;
		int fact=1;
		for(int i=1;i<=number;i++)
			fact=fact*i;
				return fact;
	}

}
