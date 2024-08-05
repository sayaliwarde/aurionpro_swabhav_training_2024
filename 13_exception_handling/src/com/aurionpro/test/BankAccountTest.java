package com.aurionpro.test;

import java.util.Random;
import java.util.Scanner;

import com.aurionpro.exception.MinBalanceException;
import com.aurionpro.exception.OverdraftLimitExceededException;
import com.aurionpro.model.BankAccount;
import com.aurionpro.model.CurrentAccount;
import com.aurionpro.model.SavingsAccount;

public class BankAccountTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null; // Variable to hold either CurrentAccount or SavingAccount

        System.out.println("Choose account type:");
        System.out.println("1. Current Account");
        System.out.println("2. Savings Account");
        int choice = scanner.nextInt();

        long accountNo = generateRandomAccountNumber();
        scanner.nextLine(); // Clear the buffer
        System.out.println("Enter account holder name:");
        String name = scanner.nextLine();
        System.out.println("Enter initial balance:");
        double balance = scanner.nextDouble();

        switch (choice) {
            case 1:
                System.out.println("Enter overdraft limit:");
                double overdraftLimit = scanner.nextDouble();
                account = new CurrentAccount(accountNo, name, balance, overdraftLimit);
                break;
            case 2:
                System.out.println("Enter minimum balance:");
                double minBalance = scanner.nextDouble();
                account = new SavingsAccount(accountNo, name, balance, minBalance);
                break;
            default:
                System.out.println("Invalid choice");
                scanner.close();
                return;
        }

//        if (account == null) {
//            System.out.println("Account creation failed. Exiting...");
//            scanner.close();
//            return;
//        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Display Account Details");
            System.out.println("2. Credit");
            System.out.println("3. Debit");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    account.display();
                    break;
                case 2:
                    System.out.print("Enter amount to credit: ");
                    double creditAmount = scanner.nextDouble();
                    account.credit(creditAmount);
                    System.out.println("Balance after crediting " + creditAmount + ": " + account.getBalance());
                    break;
                case 3:
                    System.out.print("Enter amount to debit: ");
                    double debitAmount = scanner.nextDouble();
                    try {
                        account.debit(debitAmount);
                        System.out.println("Balance after debiting " + debitAmount + ": " + account.getBalance());
                    } catch (MinBalanceException | OverdraftLimitExceededException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

        scanner.close();
    }

    private static long generateRandomAccountNumber() {
        Random random = new Random();
        long accountNumber = 1000000000L + (long)(random.nextDouble() * 9000000000L);
        return accountNumber;
    }
}