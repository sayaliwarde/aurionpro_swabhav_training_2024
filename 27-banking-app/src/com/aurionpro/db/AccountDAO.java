package com.aurionpro.db;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.aurionpro.entity.Account;

public class AccountDAO {

    public void addAccount(Account account) {
        String sql = "INSERT INTO bank_accounts (customerId, accountNumber, balance) VALUES (?, ?, ?)";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, account.getCustomerId());
            stmt.setString(2, account.getAccountNumber());
            stmt.setDouble(3, account.getBalance());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
