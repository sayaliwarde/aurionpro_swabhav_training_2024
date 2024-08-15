package com.aurionpro.entity;



import java.util.Date;

public class Transaction {
    private int transactionId;
    private String senderAccount;
    private String receiverAccount;
    private double amount;
    private Date date;
    private String type;

    public Transaction() {}

    public Transaction(String senderAccount, String receiverAccount, double amount, Date date, String type) {
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    // Getters and Setters
    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int transactionId) { this.transactionId = transactionId; }

    public String getSenderAccount() { return senderAccount; }
    public void setSenderAccount(String senderAccount) { this.senderAccount = senderAccount; }

    public String getReceiverAccount() { return receiverAccount; }
    public void setReceiverAccount(String receiverAccount) { this.receiverAccount = receiverAccount; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
