package com.aurionpro.iterative;
import java.util.Scanner;
public class AtmMachine {
	public static void main(String[] args) {
		int balance = 1000;
		Scanner scanner = new Scanner(System.in);
		
		            System.out.println("ATM Menu:");
		            System.out.println("1. Check Balance");
		            System.out.println("2. Deposit Money");
		            System.out.println("3. Withdraw Money");
		            System.out.println("4. Exit");
		            System.out.print("Please choose an option: ");
		            int option = scanner.nextInt();
		            
		 
		            switch(option)
		            {
		            case 1: System.out.print("Your current balance is:"+balance);
		            break;

		            case 2:  System.out.printf("Enter amount to deposit: ");
		            int amount1=scanner.nextInt();
		            System.out.println("Your new balance is:"+(amount1+balance));
		            break;
		            
		            case 3: System.out.println("Enter amount to withdraw:");
		            int amount2=scanner.nextInt();
		            if (amount2 > 0 && amount2 <= balance) 
                	{
                    balance -= amount2;
                    System.out.printf("Your new balance is:"+balance);
                	} 
                	else if (amount2 > balance) 
                	{
                    System.out.println("Insufficient balance.");
                	} 
                	else 
                	{
                    System.out.println("Invalid amount. Withdrawal amount should be greater than zero.");
                	}
		            break;
		            
		            case 4: System.out.println("Exit");
		            break;
		            
		            default: System.out.println("Enter a valid option");
		            }
	}
}
		            

		            
		            
		            
		             


