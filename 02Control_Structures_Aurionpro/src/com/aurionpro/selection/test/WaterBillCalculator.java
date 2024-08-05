package com.aurionpro.selection.test;
import java.util.Scanner;
public class WaterBillCalculator {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Number of units consumed:");
		double units_consumed = scanner.nextDouble();
		int meter_charge = 75;
		if (units_consumed<=100)
		{
			double charge100 = units_consumed*5;
			System.out.println("Total water bill:"+charge100+meter_charge);
			
		}
		else
		{
			if (units_consumed<=250)
			{
				double charge250=units_consumed*10;
				System.out.println("Total water bill:"+charge250+meter_charge);
				
			}
			else
			{
				double charge_more_250=units_consumed*20;
				System.out.println("Total water bill:"+charge_more_250+meter_charge);
				
		}
		
		}
		
}

}
