package com.aurionpro.test;

import java.util.Scanner;
import java.util.Random;
import com.aurionpro.model.Account01;
import com.aurionpro.model.Savings01;
import com.aurionpro.model.Current01;

public class AccountTestTrial {
    private static Random random = new Random();

    private static long generateAccountNumber() {
        return 100000000L + random.nextInt(900000000);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        
        Account01 account = null;
        
        System.out.print("Do you want to create a Savings (S) or Current (C) account? ");
        String accountType = scanner.next().toUpperCase();
        
        long accountNumber = generateAccountNumber(); 
        
        switch (accountType) {
            case "S":
                account = new Savings01(initialBalance);
                break;
            case "C":
                account = new Current01(initialBalance);
                break;
            default:
                System.out.println("Invalid account type selected.");
                return;
        }
        
        account.setAccountNumber(accountNumber);
        account.setName(name);
        
        int choice = 0;
        while (choice != 3) {
            System.out.println("\n1. Credit");
            System.out.println("2. Debit");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to credit: ");
                    double creditAmount = scanner.nextDouble();
                    account.credit(creditAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to debit: ");
                    double debitAmount = scanner.nextDouble();
                    account.debit(debitAmount);
                    break;
                case 3:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
                    break;
            }
        }
        
        scanner.close();
    }
}
