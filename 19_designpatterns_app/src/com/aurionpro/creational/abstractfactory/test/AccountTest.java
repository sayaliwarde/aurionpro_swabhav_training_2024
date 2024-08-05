package com.aurionpro.creational.abstractfactory.test;

import com.aurionpro.creational.abstractfactory.model.IAccount;
import com.aurionpro.creational.abstractfactory.model.IAccountFactory;
import com.aurionpro.creational.abstractfactory.model.SavingsAccountFactory;
import com.aurionpro.creational.abstractfactory.model.CurrentAccountFactory;

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IAccountFactory accountFactory = null;
        IAccount account = null;

        System.out.println("Select account type: \n1. Savings Account \n2. Current Account");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
            	accountFactory = new SavingsAccountFactory();
                break;
            case 2:
                accountFactory = new CurrentAccountFactory();
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        account = accountFactory.makeAccount();
        System.out.println("Account created: " + account);

        while (true) {
            System.out.println("Choose operation: \n1. Credit \n2. Debit \n3. Exit");
            int operation = scanner.nextInt();
            
            if (operation == 3) {
                break;
            }
            
            System.out.println("Enter amount:");
            double amount = scanner.nextDouble();

            switch (operation) {
                case 1:
                    account.credit(amount);
                    break;
                case 2:
                    account.debit(amount);
                    break;
                default:
                    System.out.println("Invalid operation");
            }
        }
        scanner.close();
    }
}
