package com.aurionpro.selection.test;
import java.util.Scanner;

public class EvenOddChecker {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a number: ");
		int d=scanner.nextInt();
		if (d%2==0) 
		{
			System.out.println("it is even");
			
		}
		else 
		{
		System.out.println("it is odd");
	    }
	}
}


