package com.aurionpro.model;


import java.sql.Timestamp;

public class Transaction {
    private int transactionId;
    private int senderAccountId;
    private int receiverAccountId;
    private String transactionType;
    private double amount;
    private Timestamp date;

    // Getters and Setters
    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int transactionId) { this.transactionId = transactionId; }

    public int getSenderAccountId() { return senderAccountId; }
    public void setSenderAccountId(int senderAccountId) { this.senderAccountId = senderAccountId; }

    public int getReceiverAccountId() { return receiverAccountId; }
    public void setReceiverAccountId(int receiverAccountId) { this.receiverAccountId = receiverAccountId; }

    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public Timestamp getDate() { return date; }
    public void setDate(Timestamp date) { this.date = date; }
}

