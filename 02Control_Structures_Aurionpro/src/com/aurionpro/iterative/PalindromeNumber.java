package com.aurionpro.iterative;
import java.util.Scanner;
public class PalindromeNumber {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter a number:");
		int number=scanner.nextInt();
		int reverse=0;
		int sum=0;
		int temp=number;
		
		while(number>0)
		{
			int remainder=number%10;
			reverse= (reverse*10)+remainder;
			number=number/10;
			
		}
		if (temp==reverse)
		{
			System.out.println("palindrome");
		}
		else
		{
			System.out.println("not a palindrome");
		}
		
		

		{    
		 
	    
	   }    
	}

}
