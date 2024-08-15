package com.aurionpro.dao;

import com.aurionpro.model.Customer;
import com.aurionpro.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public static boolean addCustomer(Customer customer) {
        boolean isAdded = false;
        try {
            Connection conn = DatabaseUtil.getConnection();
            String query = "INSERT INTO Customers (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, customer.getFirstName());
            pstmt.setString(2, customer.getLastName());
            pstmt.setString(3, customer.getEmail());
            pstmt.setString(4, customer.getPassword());
            int rowsAffected = pstmt.executeUpdate();
            isAdded = (rowsAffected > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    public static List<Customer> getCustomers(String sortBy) {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection conn = DatabaseUtil.getConnection();
            String query = "SELECT * FROM Customers ORDER BY " + sortBy;
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));
                customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static Customer getCustomerById(int customerId) {
        Customer customer = null;
        try {
            Connection conn = DatabaseUtil.getConnection();
            String query = "SELECT * FROM Customers WHERE customer_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                customer = new Customer();
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    public static boolean updateCustomer(Customer customer) {
        boolean isUpdated = false;
        try {
            Connection conn = DatabaseUtil.getConnection();
            String query = "UPDATE Customers SET first_name = ?, last_name = ?, email = ?, password = ? WHERE customer_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, customer.getFirstName());
            pstmt.setString(2, customer.getLastName());
            pstmt.setString(3, customer.getEmail());
            pstmt.setString(4, customer.getPassword());
            pstmt.setInt(5, customer.getCustomerId());
            int rowsAffected = pstmt.executeUpdate();
            isUpdated = (rowsAffected > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
}
