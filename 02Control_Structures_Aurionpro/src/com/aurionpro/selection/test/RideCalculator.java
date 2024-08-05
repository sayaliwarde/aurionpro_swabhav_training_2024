package com.aurionpro.selection.test;
import java.util.Scanner;
public class RideCalculator {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
        System.out.print("Enter your height in cm: ");
        int height = scanner.nextInt();
 
        if (height > 120) 
        {
            System.out.println("You can ride.");
 
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
 
            int cost = 0;
 
            if (age < 12) 
            {
                 cost = 5;
            } 
            else if (age >= 12 && age < 18) 
            {
                cost = 7;
            } 
            else if (age >= 18 && age <= 55) 
            {
                if (age >= 45 && age <= 55) 
                {
                    cost = 0;
                } 
                else 
                {
                   cost = 12;  
                }
            } 
            else 
            {
                System.out.println("Your age exceeds the limit.");
            }
 
            System.out.print("Do you want photos? (yes/no): ");
            String wantsPhotos = scanner.next();
 
            if (wantsPhotos.equalsIgnoreCase("yes")) 
            {
                cost += 3;
            }
 
            System.out.println("The total bill is $" + cost);
        } 
        else 
        {
            System.out.println("You can't ride.");
        }
 
        scanner.close();
    }
}

