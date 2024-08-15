package com.aurionpro.dao;

import com.aurionpro.model.Transaction;
import com.aurionpro.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    public static List<Transaction> getTransactions(String filterType, String startDate, String endDate) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            Connection conn = DatabaseUtil.getConnection();
            StringBuilder query = new StringBuilder("SELECT * FROM Transactions WHERE 1=1 ");
            if (filterType != null && !filterType.isEmpty()) {
                query.append("AND transaction_type = ? ");
            }
            if (startDate != null && !startDate.isEmpty()) {
                query.append("AND transaction_date >= ? ");
            }
            if (endDate != null && !endDate.isEmpty()) {
                query.append("AND transaction_date <= ? ");
            }
            PreparedStatement pstmt = conn.prepareStatement(query.toString());
            int index = 1;
            if (filterType != null && !filterType.isEmpty()) {
                pstmt.setString(index++, filterType);
            }
            if (startDate != null && !startDate.isEmpty()) {
                pstmt.setString(index++, startDate);
            }
            if (endDate != null && !endDate.isEmpty()) {
                pstmt.setString(index++, endDate);
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionId(rs.getInt("transaction_id"));
                transaction.setSenderAccountNumber(rs.getString("sender_account_number"));
                transaction.setReceiverAccountNumber(rs.getString("receiver_account_number"));
                transaction.setTransactionType(rs.getString("transaction_type"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setTransactionDate(rs.getDate("transaction_date"));
                transactions.add(transaction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
