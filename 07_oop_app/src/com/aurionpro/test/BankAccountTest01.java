package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.BankAccount01;

public class BankAccountTest01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of accounts to create: ");
        int n = scanner.nextInt();
        //scanner.nextLine(); // Consume newline

        BankAccount01[] accounts = new BankAccount01[n]; //array 

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for account " + (i + 1) + ":");

            System.out.print("Enter Name: ");
            String name = scanner.next();

            int accountNumber = BankAccount01.generateAccountNumber();
            System.out.println("Your Account Number is: " + accountNumber);

            System.out.print("Enter Initial Balance: ");
            double balance = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Account Type: ");
            String accountType = scanner.nextLine();

            accounts[i] = new BankAccount01(accountNumber, name, balance, accountType); //object
        }
        

        BankAccount01 maxBalanceAccount = getMaximumBalanceAccount(accounts); //calls getmaxbalanceacc method
        if (maxBalanceAccount != null) {
            System.out.println("\nAccount with the maximum balance:");
            maxBalanceAccount.display();
        } else {
            System.out.println("No accounts found.");
        }

        scanner.close();
    }

    public static BankAccount01 getMaximumBalanceAccount(BankAccount01[] accounts) { //method declared
        if (accounts == null || accounts.length == 0) { //elements of array are null
            return null;
        }

        BankAccount01 maxBalanceAccount = accounts[0]; //initialize 
        for (int i = 1; i < accounts.length; i++) {
            if (accounts[i].getBalance() > maxBalanceAccount.getBalance()) {
                maxBalanceAccount = accounts[i];
            }
        }
        return maxBalanceAccount;
    }
}
