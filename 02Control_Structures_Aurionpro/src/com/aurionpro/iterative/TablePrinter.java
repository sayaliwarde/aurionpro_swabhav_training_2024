package com.aurionpro.iterative;
import java.util.Scanner;

public class TablePrinter {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("enter a number");
		int number=scanner.nextInt();
		int i =1;
		for(i=1; i<=10; i++)
		{
			System.out.println(number*i);
		}
			
		
		
		
	}

}
