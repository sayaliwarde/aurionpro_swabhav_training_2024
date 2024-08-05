package com.aurionpro.test;

import java.util.Random;
import java.util.Scanner;

import com.aurionpro.model.BankAccount;
import com.aurionpro.model.Employee;

public class BankAccountTest {
	public static void main(String[] args) {
		BankAccount bankaccount=new BankAccount(); //obj creation of bankacc
		
		Scanner sc=new Scanner(System.in);	
		Random random= new Random(); 
		//set details	
		System.out.println("Enter your name:");
		String user_name=sc.next();
		bankaccount.setUser_name(user_name);
		
		int account_number = 1000000000 + random.nextInt(900000000);
		System.out.println("Your account number is:" +account_number);
		
		
		System.out.println("Enter your balance:");
		double user_balance=sc.nextDouble();
		bankaccount.setUser_balance(user_balance);
		
	       // Menu for operations
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Withdrawal");
            System.out.println("2. Deposit");
            System.out.println("3. Exit");
            
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawalAmount = sc.nextDouble();
                    if (withdrawalAmount > bankaccount.getUser_balance()) {
                        System.out.println("Insufficient funds. Withdrawal canceled.");
                    } else {
                        bankaccount.setWithdrawl(withdrawalAmount);
                        double newBalanceAfterWithdrawal = bankaccount.getUser_balance() - withdrawalAmount;
                        bankaccount.setUser_balance(newBalanceAfterWithdrawal);
                        System.out.println("Withdrawal successful. New balance: " + newBalanceAfterWithdrawal);
                    }
                    break;
                
                case 2:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = sc.nextDouble();
                    bankaccount.setDeposit(depositAmount);
                    double newBalanceAfterDeposit = bankaccount.getUser_balance() + depositAmount;
                    bankaccount.setUser_balance(newBalanceAfterDeposit);
                    System.out.println("Deposit successful. New balance: " + newBalanceAfterDeposit);
                    break;
                
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
	
	}

}
