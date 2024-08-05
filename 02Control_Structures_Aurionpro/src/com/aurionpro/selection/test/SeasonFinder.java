package com.aurionpro.selection.test;
import java.util.Scanner;
public class SeasonFinder {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a month: ");
		int month=scanner.nextInt();
		switch(month)
		{
		case 1:
		case 2:
		case 10:
		case 11:
		case 12:System.out.println("Winter");
		break;
		case 3:
		case 4:
		case 5:System.out.println("Summer");
		break;
		case 6:
		case 7:
		case 8:
		case 9:System.out.println("Rainy");
		break;
		
		default: System.out.println("enter a valid  month");
			
		}
		
	}

}
