package com.aurionpro.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.model.Transaction;

public class TransactionDAO {

    public boolean addTransaction(Transaction transaction) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO Transaction (senderAccountNumber, receiverAccountNumber, type, amount) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, transaction.getSenderAccountNumber());
        preparedStatement.setString(2, transaction.getReceiverAccountNumber());
        preparedStatement.setString(3, transaction.getType());
        preparedStatement.setDouble(4, transaction.getAmount());

        int result = preparedStatement.executeUpdate();
        connection.close();
        return result > 0;
    }

    public List<Transaction> getTransactionsByAccountNumber(String accountNumber) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM Transaction WHERE senderAccountNumber = ? OR receiverAccountNumber = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, accountNumber);
        preparedStatement.setString(2, accountNumber);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<Transaction> transactions = new ArrayList<>();
        while (resultSet.next()) {
            Transaction transaction = new Transaction();
            transaction.setTransactionId(resultSet.getInt("transactionId"));
            transaction.setSenderAccountNumber(resultSet.getString("senderAccountNumber"));
            transaction.setReceiverAccountNumber(resultSet.getString("receiverAccountNumber"));
            transaction.setType(resultSet.getString("type"));
            transaction.setAmount(resultSet.getDouble("amount"));
            transaction.setTransactionDate(resultSet.getTimestamp("transactionDate"));
            transactions.add(transaction);
        }
        connection.close();
        return transactions;
    }

    public List<Transaction> getAllTransactions() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM Transaction";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<Transaction> transactions = new ArrayList<>();
        while (resultSet.next()) {
            Transaction transaction = new Transaction();
            transaction.setTransactionId(resultSet.getInt("transactionId"));
            transaction.setSenderAccountNumber(resultSet.getString("senderAccountNumber"));
            transaction.setReceiverAccountNumber(resultSet.getString("receiverAccountNumber"));
            transaction.setType(resultSet.getString("type"));
            transaction.setAmount(resultSet.getDouble("amount"));
            transaction.setTransactionDate(resultSet.getTimestamp("transactionDate"));
            transactions.add(transaction);
        }
        connection.close();
        return transactions;
    }

    public List<Transaction> getTransactionsByFilter(String type, String startDate, String endDate) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM Transaction WHERE type = ? AND transactionDate BETWEEN ? AND ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, type);
        preparedStatement.setString(2, startDate);
        preparedStatement.setString(3, endDate);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<Transaction> transactions = new ArrayList<>();
        while (resultSet.next()) {
            Transaction transaction = new Transaction();
            transaction.setTransactionId(resultSet.getInt("transactionId"));
            transaction.setSenderAccountNumber(resultSet.getString("senderAccountNumber"));
            transaction.setReceiverAccountNumber(resultSet.getString("receiverAccountNumber"));
            transaction.setType(resultSet.getString("type"));
            transaction.setAmount(resultSet.getDouble("amount"));
            transaction.setTransactionDate(resultSet.getTimestamp("transactionDate"));
            transactions.add(transaction);
        }
        connection.close();
        return transactions;
    }
}

