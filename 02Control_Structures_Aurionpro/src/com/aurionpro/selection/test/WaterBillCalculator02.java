package com.aurionpro.selection.test;

import java.util.Scanner;

public class WaterBillCalculator02 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Number of units consumed:");
		double units = scanner.nextDouble();
		int meter = 75;
		if (units<=100)
		{
			meter +=units*5;
		}
		else if (units<=250)
		{
			meter += 100*5;
			meter +=(units-100)*10;
		}
		else
		{
			meter +=100*5;
			meter +=150*10;
			meter +=(units-250)*20;
		}
		System.out.println("Total water bill is:"+meter);
	}

}
