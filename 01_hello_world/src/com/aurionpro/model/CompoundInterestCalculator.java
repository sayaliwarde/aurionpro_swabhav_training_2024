package com.aurionpro.model;
import java.util.Scanner;
public class CompoundInterestCalculator {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		//input
		System.out.println("Enter the principal amount: ");
		double principal= scanner.nextDouble();
		System.out.println("Enter the interest rate: ");
		double interest=scanner.nextDouble();
		System.out.println("Enter the time period: ");
		double time=scanner.nextDouble();
		
		//formula
		double CI = principal*Math.pow(1+(interest/100),time);
		
		//output
		System.out.println("The compound interest is: "+CI+"\t rupess");
	}

}
