package com.aurionpro.model;
import java.util.Scanner;
public class TimeConverter {
	
		public static void main(String[] args) {
			Scanner scanner=new Scanner(System.in); 
			//input
			System.out.println("Enter the number of minutes");
			int totalminutes=scanner.nextInt();
			//formula
			int hour=totalminutes/60;
			int minutes=totalminutes%60;
			//output
			System.out.println("Total minutes is equivalent to: "+hour+"hours\t"+minutes+"minutes");
		}

	}

