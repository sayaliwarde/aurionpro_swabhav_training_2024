package com.aurionpro.iterative;
import java.util.Scanner;

public class InputNumberAdder {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter a number");
		int number=scanner.nextInt();
		int sum=0;
		while(number>0)
		{
			int remainder=number%10;
			sum=sum+remainder;
			number=number/10;
		}
		System.out.println("the addition is: "+sum);
		
		
	}

}
