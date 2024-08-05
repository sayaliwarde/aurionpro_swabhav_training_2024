package com.aurionpro.test;

import java.util.Random;
import java.util.Scanner;

import com.aurionpro.exception.InsufficientBalanceException;
import com.aurionpro.model.Account;

public class AccountTest {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  
  Random random = new Random();
  int accountNumber = random.nextInt(1000000000);
  
  System.out.println("Enter the name : ");
  String name = sc.next();
  System.out.println("Enter the balance : ");
  double balance = sc.nextDouble();
  
  Account user =  new Account(accountNumber, name, balance);
  System.out.println(user);
  try {
   System.out.println("Choose option credit or debit : ");
   System.out.println("1.Credit amount");
   System.out.println("2.Debit Amount");
   int choice = sc.nextInt();
     
   switch(choice) {
   case 1 : 
    System.out.println("Enter the amount to credit: ");
    double creditAmount = sc.nextInt();
    user.credit(creditAmount);
    break;
   case 2:
    System.out.println("Enter the amount to debit: ");
    double debitAmount = sc.nextInt();
    user.debit(debitAmount);
    break;
   default:
    System.out.println("Enter the valid input");
   
   }
  }catch(InsufficientBalanceException exception)
  {
   System.out.println(exception.getMessage());
   
  }
    
 }

}