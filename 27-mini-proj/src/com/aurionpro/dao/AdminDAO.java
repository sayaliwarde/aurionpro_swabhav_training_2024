package com.aurionpro.dao;

import com.aurionpro.model.Admin;

public class AdminDAO {

    private static final String ADMIN_USERNAME = "admin@gmail.com";
    private static final String ADMIN_PASSWORD = "admin"; // Note: For demonstration only, use a hashed password in real applications

    public Admin getAdminByUsername(String username) {
        if (ADMIN_USERNAME.equals(username)) {
            Admin admin = new Admin();
            admin.setAdminId(1); // Hardcoded ID, adjust as needed
            admin.setUsername(ADMIN_USERNAME);
            admin.setPassword(ADMIN_PASSWORD);
            return admin;
        }
        return null;
    }
}
