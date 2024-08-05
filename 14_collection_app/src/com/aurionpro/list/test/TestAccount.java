package com.aurionpro.list.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.list.model.Account;

public class TestAccount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of accounts to create: ");
        int numAccounts = scanner.nextInt();

        ArrayList<Account> accounts = new ArrayList<Account>();

        for (int i = 0; i < numAccounts; i++) {
            System.out.println("\nEnter the account details");

            System.out.print("Enter name: ");
            String name = scanner.next();
            
            long accountNumber = Account.generateAccountNumber();
            System.out.println("Your account number is:" +accountNumber);
            
            System.out.print("Enter balance: ");
            double balance = scanner.nextDouble();

            Account account = new Account(accountNumber, name, balance);
            accounts.add(account);
        }

        
        Account maxBalanceAccount = getMaxBalanceAccount(accounts);
        System.out.println("\nAccount with maximum balance:");
        System.out.println(maxBalanceAccount);

        System.out.println("\nAccounts in descending order of balance:");
        sortInReverseOrder(accounts);

        scanner.close();
    }

    private static Account getMaxBalanceAccount(ArrayList<Account> accounts) {
        Account maxBalanceAccount = accounts.get(0);
        for (Account account : accounts) {
            if (account.getBalance() > maxBalanceAccount.getBalance()) {
                maxBalanceAccount = account;
            }
        }
        return maxBalanceAccount;
    }

   private static void sortInReverseOrder(ArrayList<Account> accounts) {

        for (int i = 0; i < accounts.size(); i++) {
        	for(int j=i+1;j<accounts.size();j++) {
                if (accounts.get(i).getBalance() < accounts.get(j).getBalance()) {
                	 Account temp = accounts.get(i);
                     accounts.set(i, accounts.get(j));
                     accounts.set(j, temp);            	
                }
            }
        }
   
        for (Account account : accounts) {
            System.out.println(account);
        
    }
   }
}
