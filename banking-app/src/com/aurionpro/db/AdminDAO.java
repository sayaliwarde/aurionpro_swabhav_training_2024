package com.aurionpro.db;

import com.aurionpro.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {
    private Connection connection;

    public AdminDAO() {
        connection = DbUtil.getConnection();
    }

    public void addCustomer(Customer customer) {
        try {
            String query = "INSERT INTO customers (firstName, lastName, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBankAccount(BankAccount account) {
        try {
            String query = "INSERT INTO accounts (customerId, accountNumber, balance) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, account.getCustomerId());
            ps.setString(2, account.getAccountNumber());
            ps.setDouble(3, account.getBalance());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            String query = "SELECT * FROM customers";
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()) {
                Customer customer = new Customer(rs.getInt("customerId"), rs.getString("firstName"),
                        rs.getString("lastName"), rs.getString("email"), rs.getString("password"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try {
            String query = "SELECT * FROM transactions";
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()) {
                Transaction transaction = new Transaction(rs.getInt("transactionId"), rs.getString("senderAccount"),
                        rs.getString("receiverAccount"), rs.getDouble("amount"), rs.getDate("date"),
                        rs.getString("type"));
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
