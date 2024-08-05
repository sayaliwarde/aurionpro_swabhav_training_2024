package com.aurionpro.exception;

public class OverdraftLimitExceededException extends RuntimeException {
    private double overdraftLimit;

    public OverdraftLimitExceededException(double overdraftLimit) {
        super();
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String getMessage() {
        return "Debit amount exceeds overdraft limit of $" + overdraftLimit;
    }
}