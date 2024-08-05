package com.aurionpro.model;
import java.util.Scanner;
public class AreaCalculator {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		//input
		System.out.println("Enter the value of base 1:");
		double base1=scanner.nextDouble();
		System.out.println("Enter the value of base 2:");
		double base2=scanner.nextDouble();
		System.out.println("Enter the value of height:");
		double height=scanner.nextDouble();
		
		//formula
		double area= height*((base1+base2)/2);
		
		//output
		System.out.println("The area of trapezoid is: "+area);
		
		
	}

}
