package com.aurionpro.selection.test;
import java.util.Scanner;
public class CurrencyDenomination {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter an amount:");
		int amount=scanner.nextInt();
		if (amount<=50000)
		{
			if (amount%100==0)
			{
				int a=amount/2000;
				amount %= 2000;
					if (a>0)
					{
					System.out.println("2000:"+a);
					}
				int b=amount/500;
				amount %= 500;
					if (b>0)
					{
					System.out.println("500:"+b);
					}
				int c= amount/200;
				amount %= 200;
					if (c>0)
					{
					System.out.println("200:"+c);
					}
				int d= amount/100;
					if (d>0)
					{
					System.out.println("100:"+d);
					}
				
				
			  }
			else
				
			{
				System.out.println("Amount is not a multiple of 100");
			}
		}
		else
		{
			System.out.println("Amount exceeds the limit");
		}
	}

}
