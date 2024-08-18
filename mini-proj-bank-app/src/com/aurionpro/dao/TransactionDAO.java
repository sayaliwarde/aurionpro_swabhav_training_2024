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

    public List<Transaction> getFilteredTransactions(String startDate, String endDate, String transactionType) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        StringBuilder sql = new StringBuilder("SELECT * FROM Transaction WHERE 1=1");

        // Add conditions based on available filters
        if (startDate != null && !startDate.isEmpty()) {
            sql.append(" AND transactionDate >= ?");
        }
        if (endDate != null && !endDate.isEmpty()) {
            sql.append(" AND transactionDate <= ?");
        }
        if (transactionType != null && !transactionType.isEmpty()) {
            sql.append(" AND type = ?");
        }

        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());

        // Set parameters based on available filters
        int paramIndex = 1;
        if (startDate != null && !startDate.isEmpty()) {
            preparedStatement.setString(paramIndex++, startDate);
        }
        if (endDate != null && !endDate.isEmpty()) {
            preparedStatement.setString(paramIndex++, endDate);
        }
        if (transactionType != null && !transactionType.isEmpty()) {
            preparedStatement.setString(paramIndex++, transactionType);
        }

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
