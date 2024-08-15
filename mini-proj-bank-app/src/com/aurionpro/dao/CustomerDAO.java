package com.aurionpro.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.model.Customer;

public class CustomerDAO {

    public boolean addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO Customer (firstName, lastName, email, password) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getLastName());
        preparedStatement.setString(3, customer.getEmail());
        preparedStatement.setString(4, customer.getPassword());

        int result = preparedStatement.executeUpdate();
        connection.close();
        return result > 0;
    }

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

    public List<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM Customer";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<Customer> customers = new ArrayList<>();
        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setCustomerId(resultSet.getInt("customerId"));
            customer.setFirstName(resultSet.getString("firstName"));
            customer.setLastName(resultSet.getString("lastName"));
            customer.setEmail(resultSet.getString("email"));
            customer.setPassword(resultSet.getString("password"));
            customers.add(customer);
        }
        connection.close();
        return customers;
    }

    public boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE Customer SET firstName = ?, lastName = ?, email = ?, password = ? WHERE customerId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getLastName());
        preparedStatement.setString(3, customer.getEmail());
        preparedStatement.setString(4, customer.getPassword());
        preparedStatement.setInt(5, customer.getCustomerId());

        int result = preparedStatement.executeUpdate();
        connection.close();
        return result > 0;
    }

    public boolean deleteCustomer(int customerId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "DELETE FROM Customer WHERE customerId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, customerId);

        int result = preparedStatement.executeUpdate();
        connection.close();
        return result > 0;
    }
}
