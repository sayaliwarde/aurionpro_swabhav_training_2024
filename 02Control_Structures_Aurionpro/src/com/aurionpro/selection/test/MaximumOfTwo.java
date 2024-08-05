package com.aurionpro.selection.test;
import java.util.Scanner;
public class MaximumOfTwo {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter the first number");
		int number01=scanner.nextInt();
		System.out.println("Enter the second number");
		int number02=scanner.nextInt();
		if (number01>number02)
		{
			System.out.println("First number is maximum");
		}
		else
		{
			System.out.println("Second number is maximum");
		}
		scanner.close();
		
	}

	}
	


