package com.aurionpro.selection.test;
import java.util.Scanner;
public class TreasureIsland {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Welcome!");
		System.out.println("You want to go Left or Right?");
		String choice1=scanner.next();
		if (choice1.equalsIgnoreCase("Left"))
		{
			System.out.println("Do you want to Swim or Wait?");
			String choice2=scanner.next();
			if (choice2.equalsIgnoreCase("Wait"))
			{
				System.out.println("Choose a door.(Red/Yellow/Blue)?");
				String choice3=scanner.next();
				if (choice3.equalsIgnoreCase("Red"))
				{
					System.out.println("Burned by fire. Game over.");
				}
				if (choice3.equalsIgnoreCase("Blue"))
				{
					System.out.println("eaten");
				}
				if (choice3.equalsIgnoreCase("Yellow"))
				{
					System.out.println("You Win!");
				}
				else
				{
					System.out.println("Game over.");
				}
			}
			else
			{
				System.out.println("Attacked by trout. Game over.");
			}
			
		}
		else
		{
			System.out.println("Fall into a hole. Game over.");
		}
		scanner.close();
	}
}
