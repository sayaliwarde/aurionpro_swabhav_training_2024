package com.aurionpro.dao;

import com.aurionpro.model.Account;
import com.aurionpro.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AccountDAO {
    public static boolean addAccount(int customerId, String accountNumber, double initialBalance) {
        boolean isAdded = false;
        try {
            Connection conn = DatabaseUtil.getConnection();
            String query = "INSERT INTO Accounts (customer_id, account_number, balance) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, customerId);
            pstmt.setString(2, accountNumber);
            pstmt.setDouble(3, initialBalance);
            int rowsAffected = pstmt.executeUpdate();
            isAdded = (rowsAffected > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }
}
