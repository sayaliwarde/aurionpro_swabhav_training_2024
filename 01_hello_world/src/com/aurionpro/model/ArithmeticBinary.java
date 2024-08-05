package com.aurionpro.model;
import java.util.Scanner;
public class ArithmeticBinary {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		//input
		System.out.println("Enter a number: ");
		double number1= scanner.nextDouble();
		System.out.println("Enter a number: ");
		double number2= scanner.nextDouble();
		//addition
		double add=number1+number2;
		System.out.println("Addition of the given numbers is: "+add);
		//substraction
		double sub=number1-number2;
		System.out.println("Substraction of the given numbers is: "+sub);
		//multiplication
		double mul=number1*number2;
		System.out.println("Multiplication of the given numbers is: "+mul);
		//division
		double div=number1/number2;
		System.out.println("Division of the given numbers is: "+div);
		//remainder
		double rem=number1%number2;
		System.out.println("Remainder of the given numbers is: "+rem);
	}
	

}
