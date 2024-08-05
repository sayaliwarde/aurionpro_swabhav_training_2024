package com.aurionpro.behavioural.observer.model;

public class SmsNotifiers implements INotifiers {

    @Override
    public void notify(Account account) {
        System.out.println("SMS Notification:");
        System.out.println("Amount credited: " + account.getBalance());
        System.out.println("Your new balance is: " + account.getBalance());
    }
    
    public String sendSms() {
        return "SMS received";
    }
}
