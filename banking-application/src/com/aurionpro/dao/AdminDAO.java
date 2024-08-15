package com.aurionpro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aurionpro.model.Admin;
import com.aurionpro.util.DatabaseUtil;

public class AdminDAO {
    private Connection connection;

    public AdminDAO() {
        connection = DatabaseUtil.getConnection();
    }

    public boolean validateAdmin(Admin admin) {
        String query = "SELECT * FROM admins WHERE username = ? AND password = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, admin.getUsername());
            pstmt.setString(2, admin.getPassword());
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
