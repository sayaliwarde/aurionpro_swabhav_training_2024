package com.aurionpro.debug;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter two numbers:");
		int number1=scanner.nextInt();
		int number2=scanner.nextInt();
		
		int result=addition(number1,number2);
		System.out.println("addition "+result);
		
		result=substraction(number1,number2);
		System.out.println("substraction "+result);
		
		result=multiplication(number1,number2);
		System.out.println("multiplication "+result);
		
		result=substraction(number1,number2);
		System.out.println("division"+result);
	}
	
	private static int addition(int number1, int number2)
	{
		return number1+number2;
	}
	private static int substraction(int number1, int number2)
	{
		return number1-number2;
	}
	private static int multiplication(int number1, int number2)
	{
		return number1*number2;
	}
	private static int division(int number1, int number2)
	{
		return number1/number2;
	}


}
