package com.aurionpro.model;
import java.util.Scanner;
public class Relational {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		//input
		System.out.println("Enter a number: ");
		double number1= scanner.nextDouble();
		System.out.println("Enter a number: ");
		double number2= scanner.nextDouble();
		//greater than
		System.out.println("Is first number greater than second number? "+(number1>number2));
		//less than
		System.out.println("Is first number less than second number? "+(number1<number2));
		//equal to
		System.out.println("Is first number equal to second number? "+(number1==number2));
		//not equal
		System.out.println("Is first number not equal to second number? "+(number1!=number2));
		//greater than equal to
		System.out.println("Is first number greater than equal second number? "+(number1>=number2));
		//less than equal to
		System.out.println("Is first number less than equal to second number? "+(number1<=number2));
		
				
	}

}
