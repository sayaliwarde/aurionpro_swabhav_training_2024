package com.aurionpro.iterative;
import java.util.Scanner;

public class ArmstrongNumberChecker {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter a number");
		int number=scanner.nextInt();
		int pow=0;
		while(number>0)
		{
			pow++;
			number=number/10;
		}
		int temp=number;
		
		int sum=0;
		temp= number;


		while(number>0)
		{
			int remainder=number%10;
			sum= sum+(int)(Math.pow(remainder, pow));
			number=number/10;
		}
		if (temp==sum)
			System.out.println("armstrong");
		else System.out.println("not");
	}

}
