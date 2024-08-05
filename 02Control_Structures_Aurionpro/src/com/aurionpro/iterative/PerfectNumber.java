package com.aurionpro.iterative;
import java.util.Scanner;
public class PerfectNumber {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter a number");
		int number=scanner.nextInt();
		int i =1, sum=0;
		while(i<=(number/2))
		{
			if(number%i==0)
			{
				sum=sum+i;
				i++;
			}
			if(sum==number)
			{
				System.out.println("perfect");
			}
			else 
				{
				System.out.println("not perfct");
				}
		}
		
	}

}
