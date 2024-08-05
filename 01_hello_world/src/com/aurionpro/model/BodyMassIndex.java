package com.aurionpro.model;
import java.util.Scanner;
public class BodyMassIndex {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in); 
		//input
		System.out.println("Enter your weight in kilogram: ");
		double weight= scanner.nextDouble();
		System.out.println("Enter your height in meters: ");
		double height= scanner.nextDouble();
		//formula
		double bmi=weight/(height*height);
		//output
		System.out.println("Your BMI is: "+bmi);
		
		
		
	}

}
