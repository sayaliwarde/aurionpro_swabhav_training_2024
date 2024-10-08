package com.aurionpro.streams.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aurionpro.streams.model.Account;

public class AccountTest {
    public static void main(String[] args) {
        List<Account> accounts = Arrays.asList(
                new Account(1234, "Sayali", 5648),
                new Account(6789, "Neha", 3684),
                new Account(2537, "Aagya" , 2739),
                new Account(1236, "Namrata",2334),
                new Account(1240, "Mrunalini", 2349),
                new Account(1235, "Sakshi", 3798)
        );

        // a. Show Account details of account with minimum Balance
        Optional<Account> minimumBalanceAccount = accounts.stream()
                                                          .min(Comparator.comparingDouble(Account::getBalance));
        minimumBalanceAccount.ifPresent(account -> System.out.println("Account with minimum balance: " + account));

        // b. Show Account details of account with maximum Balance
        Optional<Account> maximumBalanceAccount = accounts.stream()
                                                          .max(Comparator.comparingDouble(Account::getBalance));
        maximumBalanceAccount.ifPresent(account -> System.out.println("Account with maximum balance: " + account));

        // c. Show names greater than 6 characters
        List<String> namesGreaterThan6Characters = accounts.stream()
                                                          .map(Account::getAccountName)
                                                          .filter(name -> name.length() > 6)
                                                          .collect(Collectors.toList());
        System.out.println("Names with more than 6 characters: " + namesGreaterThan6Characters);

        // d. Find total of balance of all accounts
        double totalBalance = accounts.stream()
                                      .mapToDouble(Account::getBalance)
                                      .sum();
        System.out.println("Total balance of all accounts: " + totalBalance);
    }
}
