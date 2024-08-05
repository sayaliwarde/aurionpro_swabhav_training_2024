package com.aurionpro.creational.abstractfactory.model;

import java.util.Scanner;

public class CurrentAccountFactory implements IAccountFactory {

    @Override
    public IAccount makeAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scanner.next();
        System.out.println("Enter your balance:");
        double balance = scanner.nextDouble();

        return new CurrentAccount(generateRandomAccountNumber(), name, balance);
    }

    private long generateRandomAccountNumber() {
        return (long) (Math.random() * 1000000000); // Random account number
    }
}
