package com.aurionpro.dao;

import com.aurionpro.model.Account;
import com.aurionpro.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {

    public boolean addAccount(Account account) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO Account (account_number, customer_id, balance) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, account.getAccountNumber());
            stmt.setInt(2, account.getCustomerId());
            stmt.setDouble(3, account.getBalance());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
