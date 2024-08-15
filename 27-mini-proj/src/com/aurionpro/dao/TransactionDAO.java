package com.aurionpro.dao;


import com.aurionpro.model.Transaction;
import com.aurionpro.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    public boolean addTransaction(Transaction transaction) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO Transaction (sender_account_id, receiver_account_id, transaction_type, amount) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, transaction.getSenderAccountId());
            stmt.setInt(2, transaction.getReceiverAccountId());
            stmt.setString(3, transaction.getTransactionType());
            stmt.setDouble(4, transaction.getAmount());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Transaction> getTransactionsByAccountId(int accountId) {
        List<Transaction> transactions = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM Transaction WHERE sender_account_id = ? OR receiver_account_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, accountId);
            stmt.setInt(2, accountId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionId(rs.getInt("transaction_id"));
                transaction.setSenderAccountId(rs.getInt("sender_account_id"));
                transaction.setReceiverAccountId(rs.getInt("receiver_account_id"));
                transaction.setTransactionType(rs.getString("transaction_type"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setDate(rs.getTimestamp("date"));
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM Transaction";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionId(rs.getInt("transaction_id"));
                transaction.setSenderAccountId(rs.getInt("sender_account_id"));
                transaction.setReceiverAccountId(rs.getInt("receiver_account_id"));
                transaction.setTransactionType(rs.getString("transaction_type"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setDate(rs.getTimestamp("date"));
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
