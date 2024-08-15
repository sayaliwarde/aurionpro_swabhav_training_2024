package com.aurionpro.db;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.aurionpro.entity.Transaction;

public class TransactionDAO {

    public void createTransaction(Transaction transaction) {
        String sql = "INSERT INTO transactions (senderAccount, receiverAccount, amount, date, type) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, transaction.getSenderAccount());
            stmt.setString(2, transaction.getReceiverAccount());
            stmt.setDouble(3, transaction.getAmount());
            stmt.setDate(4, new java.sql.Date(transaction.getDate().getTime()));
            stmt.setString(5, transaction.getType());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

