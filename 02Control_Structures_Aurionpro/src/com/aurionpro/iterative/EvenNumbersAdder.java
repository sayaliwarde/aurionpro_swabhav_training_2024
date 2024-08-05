package com.aurionpro.iterative;

public class EvenNumbersAdder {
	public static void main(String[] args) {
		int sum=0;
		int i=2;
		while(i<=100)
		{
			
			sum=(sum+i);
			i+=2;
		}
		System.out.println("sum of first 100 numbers is:" +(sum));
	}

}
