package com.aurionpro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.model.Account;

public class AccountDAO {
    private Connection connection;

    public AccountDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addAccount(Account account) throws SQLException {
        String sql = "INSERT INTO accounts (account_number, user_id, balance) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, account.getAccountNumber());
        statement.setInt(2, account.getUserId());
        statement.setDouble(3, account.getBalance());
        return statement.executeUpdate() > 0;
    }

    public Account getAccountByUserId(int userId) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE user_id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, userId);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            Account account = new Account();
            account.setId(resultSet.getInt("id"));
            account.setAccountNumber(resultSet.getString("account_number"));
            account.setUserId(resultSet.getInt("user_id"));
            account.setBalance(resultSet.getDouble("balance"));
            return account;
        }
        return null;
    }

    public void updateAccountBalance(int accountId, double newBalance) throws SQLException {
        String sql = "UPDATE accounts SET balance=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, newBalance);
        statement.setInt(2, accountId);
        statement.executeUpdate();
    }

    public List<Account> getAllAccounts() throws SQLException {
        String sql = "SELECT * FROM accounts";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<Account> accounts = new ArrayList<>();
        while (resultSet.next()) {
            Account account = new Account();
            account.setId(resultSet.getInt("id"));
            account.setAccountNumber(resultSet.getString("account_number"));
            account.setUserId(resultSet.getInt("user_id"));
            account.setBalance(resultSet.getDouble("balance"));
            accounts.add(account);
        }
        return accounts;
    }
}
