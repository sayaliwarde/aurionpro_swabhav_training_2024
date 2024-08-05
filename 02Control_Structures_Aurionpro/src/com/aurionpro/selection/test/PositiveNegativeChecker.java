package com.aurionpro.selection.test;
import java.util.Scanner;

public class PositiveNegativeChecker {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int number=scanner.nextInt();
		if (number>=0)
		{
			System.out.println("number is positive");
		}
		else
		{
			System.out.println("number is negative");
		}
	}

}
