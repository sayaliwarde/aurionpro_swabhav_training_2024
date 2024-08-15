package com.aurionpro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.model.Account;
import com.aurionpro.model.Transaction;

public class TransactionDAO {
    private Connection connection;

    public TransactionDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addTransaction(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO transactions (sender_account, receiver_account, type, amount) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, transaction.getSenderAccount());
        statement.setString(2, transaction.getReceiverAccount());
        statement.setString(3, transaction.getType());
        statement.setDouble(4, transaction.getAmount());
        return statement.executeUpdate() > 0;
    }

    public List<Transaction> getTransactionsByFilter(String accountNumber, String type, Date startDate, Date endDate) throws SQLException {
        StringBuilder sql = new StringBuilder("SELECT * FROM transactions WHERE 1=1");

        if (accountNumber != null && !accountNumber.isEmpty()) {
            sql.append(" AND (sender_account = ? OR receiver_account = ?)");
        }
        if (type != null && !type.isEmpty()) {
            sql.append(" AND type = ?");
        }
        if (startDate != null) {
            sql.append(" AND transaction_date >= ?");
        }
        if (endDate != null) {
            sql.append(" AND transaction_date <= ?");
        }

        PreparedStatement statement = connection.prepareStatement(sql.toString());
        int index = 1;

        if (accountNumber != null && !accountNumber.isEmpty()) {
            statement.setString(index++, accountNumber);
            statement.setString(index++, accountNumber);
        }
        if (type != null && !type.isEmpty()) {
            statement.setString(index++, type);
        }
        if (startDate != null) {
            statement.setDate(index++, new java.sql.Date(startDate.getTime()));
        }
        if (endDate != null) {
            statement.setDate(index++, new java.sql.Date(endDate.getTime()));
        }

        ResultSet resultSet = statement.executeQuery();
        List<Transaction> transactions = new ArrayList<>();

        while (resultSet.next()) {
            Transaction transaction = new Transaction();
            transaction.setId(resultSet.getInt("id"));
            transaction.setSenderAccount(resultSet.getString("sender_account"));
            transaction.setReceiverAccount(resultSet.getString("receiver_account"));
            transaction.setType(resultSet.getString("type"));
            transaction.setAmount(resultSet.getDouble("amount"));
            transaction.setTransactionDate(resultSet.getTimestamp("transaction_date"));
            transactions.add(transaction);
        }

        return transactions;
    }
    public Account getAccountByAccountNumber(String accountNumber) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE account_number = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, accountNumber);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            Account account = new Account();
            account.setId(resultSet.getInt("id"));
            account.setAccountNumber(resultSet.getString("account_number"));
            account.setUserId(resultSet.getInt("user_id"));
            account.setBalance(resultSet.getDouble("balance"));
            return account;
        }
        return null;
    }
    public List<Transaction> getTransactionsByAccountNumber(String accountNumber) throws SQLException {
        String sql = "SELECT * FROM transactions WHERE sender_account = ? OR receiver_account = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, accountNumber);
        statement.setString(2, accountNumber);
        ResultSet resultSet = statement.executeQuery();

        List<Transaction> transactions = new ArrayList<>();
        while (resultSet.next()) {
            Transaction transaction = new Transaction();
            transaction.setId(resultSet.getInt("id"));
            transaction.setSenderAccount(resultSet.getString("sender_account"));
            transaction.setReceiverAccount(resultSet.getString("receiver_account"));
            transaction.setType(resultSet.getString("type"));
            transaction.setAmount(resultSet.getDouble("amount"));
            transaction.setTransactionDate(resultSet.getTimestamp("transaction_date"));
            transactions.add(transaction);
        }
        return transactions;
    }



}
