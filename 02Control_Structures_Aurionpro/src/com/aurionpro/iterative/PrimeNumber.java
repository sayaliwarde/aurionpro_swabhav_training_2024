package com.aurionpro.iterative;
import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter a number");
		int number = scanner.nextInt();
		int i=2;
		while(i<number)
		{
			if (number%i==0)
			{
				break;
			}
			i++;
		}
		if(i>=number)
			System.out.println("prime number");
		else System.out.println("not a prime");
		{
			
		}
	}
	

}
