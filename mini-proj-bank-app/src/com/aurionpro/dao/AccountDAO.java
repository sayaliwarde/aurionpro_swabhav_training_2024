package com.aurionpro.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.model.Account;

public class AccountDAO {

    public boolean addAccount(Account account) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO Account (customerId, accountNumber, balance) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, account.getCustomerId());
        preparedStatement.setString(2, account.getAccountNumber());
        preparedStatement.setDouble(3, account.getBalance());

        int result = preparedStatement.executeUpdate();
        connection.close();
        return result > 0;
    }

    public Account getAccountByNumber(String accountNumber) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM Account WHERE accountNumber = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, accountNumber);

        ResultSet resultSet = preparedStatement.executeQuery();
        Account account = null;
        if (resultSet.next()) {
            account = new Account();
            account.setAccountId(resultSet.getInt("accountId"));
            account.setCustomerId(resultSet.getInt("customerId"));
            account.setAccountNumber(resultSet.getString("accountNumber"));
            account.setBalance(resultSet.getDouble("balance"));
        }
        connection.close();
        return account;
    }

    public List<Account> getAllAccounts() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM Account";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<Account> accounts = new ArrayList<>();
        while (resultSet.next()) {
            Account account = new Account();
            account.setAccountId(resultSet.getInt("accountId"));
            account.setCustomerId(resultSet.getInt("customerId"));
            account.setAccountNumber(resultSet.getString("accountNumber"));
            account.setBalance(resultSet.getDouble("balance"));
            accounts.add(account);
        }
        connection.close();
        return accounts;
    }

    public boolean updateAccountBalance(String accountNumber, double newBalance) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE Account SET balance = ? WHERE accountNumber = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, newBalance);
        preparedStatement.setString(2, accountNumber);

        int result = preparedStatement.executeUpdate();
        connection.close();
        return result > 0;
    }
    public List<Account> getAccountsByCustomerId(int customerId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM Account WHERE customerId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, customerId);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<Account> accounts = new ArrayList<>();
        while (resultSet.next()) {
            Account account = new Account();
            account.setAccountId(resultSet.getInt("accountId"));
            account.setCustomerId(resultSet.getInt("customerId"));
            account.setAccountNumber(resultSet.getString("accountNumber"));
            account.setBalance(resultSet.getDouble("balance"));
            accounts.add(account);
        }
        connection.close();
        return accounts;
    }

}
