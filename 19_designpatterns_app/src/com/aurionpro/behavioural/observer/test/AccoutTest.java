package com.aurionpro.behavioural.observer.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.behavioural.observer.model.Account;
import com.aurionpro.behavioural.observer.model.EmailNotifier;
import com.aurionpro.behavioural.observer.model.InsufficientFundsException;
import com.aurionpro.behavioural.observer.model.SmsNotifiers;

public class AccoutTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Account Number: ");
        long accountNumber = scanner.nextLong();
        scanner.nextLine(); 
        
        System.out.print("Enter Account Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();
        
        Account account = new Account(accountNumber, name, balance);
        
        
        System.out.println("Choose notification methods (type 'sms' or 'email'):");
        System.out.println("Enter 'sms' to receive SMS notifications");
        System.out.println("Enter 'email' to receive Email notifications");
  
        
       // List<String> notificationPreferences = new ArrayList<>();
        while (true) {
            String preference = scanner.next();

            if (preference.equalsIgnoreCase("sms")) {
                account.addNotifier(new SmsNotifiers());
            } 
            else
                account.addNotifier(new EmailNotifier());

        while (true) {
            System.out.println("Choose a transaction type:");
            System.out.println("1. Credit");
            System.out.println("2. Debit");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to credit: ");
                    double creditAmount = scanner.nextDouble();
                    account.credit(creditAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to debit: ");
                    double debitAmount = scanner.nextDouble();
                    try {
                        account.debit(debitAmount);
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Exit");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }

        }
        
    }
  }
}
