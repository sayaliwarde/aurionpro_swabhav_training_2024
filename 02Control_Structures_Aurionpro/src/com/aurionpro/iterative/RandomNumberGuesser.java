package com.aurionpro.iterative;
import java.util.Random;
import java.util.Scanner;

public class RandomNumberGuesser {
	
	    public static void main(String[] args) {
	    	Scanner scanner = new Scanner(System.in);
	    	        Random random = new Random();
	    	 
	    	        do 
	    	        {
	    	            int numberToGuess = random.nextInt(100) + 1;
	    	            int numberOfTries = 0;
	    	 
	    	            System.out.println("Guess a random number generated  between 1 and 100.");
	    	            
	    	            while (numberOfTries < 5) 
	    	            {
	    	                System.out.print("Enter your guess: ");
	    	                int userGuess = scanner.nextInt();
	    	                numberOfTries++;
	    	 
	    	                if (userGuess < numberToGuess) 
	    	                {
	    	                    System.out.println("Sorry, Too Low.");
	    	                } 
	    	                else if (userGuess > numberToGuess) 
	    	                {
	    	                    System.out.println("Sorry, Too High.");
	    	                } 
	    	                else 
	    	                {
	    	                    System.out.println("Congratulations! You've guessed the number correctly in " + numberOfTries + " tries.");
	    	                    break;
	    	                }
	    	            }
	    	 
	    	            if (numberOfTries >= 5 && scanner.nextInt() != numberToGuess) 
	    	            {
	    	                System.out.println("Game Over! The number was: " + numberToGuess);
	    	            }
	    	 
	    	            System.out.print("Do you want to play again? (yes/no): ");
	    	        } 
	    	        while (scanner.next().equalsIgnoreCase("yes"));
	    	        System.out.println("Exit");
	    	        scanner.close();
	    	    }
	    	
	}


