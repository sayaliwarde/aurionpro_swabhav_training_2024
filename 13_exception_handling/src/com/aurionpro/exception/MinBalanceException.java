package com.aurionpro.exception;

public class MinBalanceException extends RuntimeException {
    private double minBalance;

    public MinBalanceException(double minBalance) {
        super();
        this.minBalance = minBalance;
    }

    @Override
    public String getMessage() {
        return "Cannot debit: Minimum balance requirement is $" + minBalance;
    }
}