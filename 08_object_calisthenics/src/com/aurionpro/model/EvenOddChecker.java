package com.aurionpro.model;

import java.util.Scanner;

public class EvenOddChecker {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter a number:");
		int number=scanner.nextInt();
		if(number%2==0)
		{
			System.out.println("number is even");
		return;
		}
		
	}

}
