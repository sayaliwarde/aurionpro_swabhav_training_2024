package com.aurionpro.db;

import com.aurionpro.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private Connection connection;

    public CustomerDAO() {
        connection = DbUtil.getConnection();
    }

    public Customer getCustomerByEmailAndPassword(String email, String password) {
        Customer customer = null;
        try {
            String query = "SELECT * FROM customers WHERE email = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customer = new Customer(rs.getInt("customerId"), rs.getString("firstName"),
                        rs.getString("lastName"), rs.getString("email"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public List<Transaction> getTransactionsForCustomer(int customerId) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            String query = "SELECT * FROM transactions WHERE senderAccount = (SELECT accountNumber FROM accounts WHERE customerId = ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
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

    public void updateProfile(Customer customer) {
        try {
            String query = "UPDATE customers SET firstName = ?, lastName = ?, password = ? WHERE customerId = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getPassword());
            ps.setInt(4, customer.getCustomerId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTransaction(Transaction transaction) {
        try {
            String query = "INSERT INTO transactions (senderAccount, receiverAccount, amount, date, type) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, transaction.getSenderAccount());
            ps.setString(2, transaction.getReceiverAccount());
            ps.setDouble(3, transaction.getAmount());
            ps.setDate(4, new java.sql.Date(transaction.getDate().getTime()));
            ps.setString(5, transaction.getType());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
