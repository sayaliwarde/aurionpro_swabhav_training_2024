package com.aurionpro.behavioural.observer.model;

public class EmailNotifier implements INotifiers {

    @Override
    public void notify(Account account) {
        System.out.println("Email Notification:");
        System.out.println("Amount credited: " + account.getBalance());
        System.out.println("Your new balance is: " + account.getBalance());
    }
    
    public String sendEmail() {
        return "Notification sent through email";
    }
}
