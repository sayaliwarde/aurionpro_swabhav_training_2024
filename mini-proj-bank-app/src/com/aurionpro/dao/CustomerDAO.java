package com.aurionpro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.model.Customer;

public class CustomerDAO {

    // Add new customer
    public boolean addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO Customer (firstName, lastName, email, password) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getLastName());
        preparedStatement.setString(3, customer.getEmail());
        preparedStatement.setString(4, customer.getPassword());

        int result = preparedStatement.executeUpdate();
        if (result > 0) {
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                customer.setCustomerId(rs.getInt(1)); // Set the newly generated customer ID
            }
        }
        connection.close();
        return result > 0;
    }

    // Get customer by email
    public Customer getCustomerByEmail(String email) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM Customer WHERE email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);

        ResultSet resultSet = preparedStatement.executeQuery();
        Customer customer = null;
        if (resultSet.next()) {
            customer = new Customer();
            customer.setCustomerId(resultSet.getInt("customerId"));
            customer.setFirstName(resultSet.getString("firstName"));
            customer.setLastName(resultSet.getString("lastName"));
            customer.setEmail(resultSet.getString("email"));
            customer.setPassword(resultSet.getString("password"));
        }
        connection.close();
        return customer;
    }

    // Get customers who do not have an account yet
    public List<Customer> getNewCustomers() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM Customer c WHERE NOT EXISTS (SELECT 1 FROM Account a WHERE a.customerId = c.customerId)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<Customer> customers = new ArrayList<>();
        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setCustomerId(resultSet.getInt("customerId"));
            customer.setFirstName(resultSet.getString("firstName"));
            customer.setLastName(resultSet.getString("lastName"));
            customer.setEmail(resultSet.getString("email"));
            customers.add(customer);
        }
        connection.close();
        return customers;
    }

    // Get sorted customers based on name or balance
    public List<Customer> getSortedCustomers(String sortBy) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM Customer ";
        switch (sortBy) {
            case "nameAsc":
                sql += "ORDER BY firstName ASC, lastName ASC";
                break;
            case "nameDesc":
                sql += "ORDER BY firstName DESC, lastName DESC";
                break;
            case "balanceAsc":
                sql = "SELECT c.* FROM Customer c JOIN Account a ON c.customerId = a.customerId ORDER BY a.balance ASC";
                break;
            case "balanceDesc":
                sql = "SELECT c.* FROM Customer c JOIN Account a ON c.customerId = a.customerId ORDER BY a.balance DESC";
                break;
            default:
                sql += "ORDER BY firstName ASC, lastName ASC";
                break;
        }

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Customer> customers = new ArrayList<>();
        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setCustomerId(resultSet.getInt("customerId"));
            customer.setFirstName(resultSet.getString("firstName"));
            customer.setLastName(resultSet.getString("lastName"));
            customer.setEmail(resultSet.getString("email"));
            customers.add(customer);
        }
        connection.close();
        return customers;
    }

    // Get customer by ID
    public Customer getCustomerById(int customerId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM Customer WHERE customerId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, customerId);

        ResultSet resultSet = preparedStatement.executeQuery();
        Customer customer = null;
        if (resultSet.next()) {
            customer = new Customer();
            customer.setCustomerId(resultSet.getInt("customerId"));
            customer.setFirstName(resultSet.getString("firstName"));
            customer.setLastName(resultSet.getString("lastName"));
            customer.setEmail(resultSet.getString("email"));
            customer.setPassword(resultSet.getString("password"));
        }
        connection.close();
        return customer;
    }

    // Update customer password
    public boolean updateCustomerPassword(Customer customer) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE Customer SET password = ? WHERE customerId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customer.getPassword());
        preparedStatement.setInt(2, customer.getCustomerId());

        int result = preparedStatement.executeUpdate();
        connection.close();
        return result > 0;
    }

    // Check if email exists (Optional: If you want to validate email uniqueness)
    public boolean isEmailExists(String email) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT 1 FROM Customer WHERE email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);

        ResultSet resultSet = preparedStatement.executeQuery();
        boolean exists = resultSet.next();
        connection.close();
        return exists;
    }
}
