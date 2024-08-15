package com.aurionpro.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.dao.AccountDAO;
import com.aurionpro.dao.TransactionDAO;
import com.aurionpro.dao.UserDAO;
import com.aurionpro.model.Account;
import com.aurionpro.model.Transaction;
import com.aurionpro.model.User;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdatabase", "root", "root");

            if ("viewPassbook".equals(action)) {
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("user");

                AccountDAO accountDAO = new AccountDAO(connection);
                Account account = accountDAO.getAccountByUserId(user.getId());

                TransactionDAO transactionDAO = new TransactionDAO(connection);
                List<Transaction> transactions = transactionDAO.getTransactionsByAccountNumber(account.getAccountNumber());
                request.setAttribute("transactions", transactions);

                RequestDispatcher dispatcher = request.getRequestDispatcher("viewPassbook.jsp");
                dispatcher.forward(request, response);

            } else if ("editProfile".equals(action)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("editProfile.jsp");
                dispatcher.forward(request, response);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdatabase", "root", "root");

            if ("editProfile".equals(action)) {
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("user");

                user.setFirstName(request.getParameter("firstName"));
                user.setLastName(request.getParameter("lastName"));
                user.setEmail(request.getParameter("email"));
                user.setPassword(request.getParameter("password"));

                UserDAO userDAO = new UserDAO(connection);
                if (userDAO.updateUser(user)) {
                    session.setAttribute("user", user);
                    request.setAttribute("message", "Profile updated successfully!");
                } else {
                    request.setAttribute("message", "Error updating profile.");
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher("customerHome.jsp");
                dispatcher.forward(request, response);

            } else if ("newTransaction".equals(action)) {
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("user");

                AccountDAO accountDAO = new AccountDAO(connection);
                Account account = accountDAO.getAccountByUserId(user.getId());

                String transactionType = request.getParameter("transactionType");
                double amount = Double.parseDouble(request.getParameter("amount"));
                String receiverAccount = request.getParameter("receiverAccount");

                Transaction transaction = new Transaction();
                transaction.setSenderAccount(account.getAccountNumber());
                transaction.setAmount(amount);
                transaction.setType(transactionType);

                if ("transfer".equals(transactionType)) {
                    transaction.setReceiverAccount(receiverAccount);
                } else {
                    transaction.setReceiverAccount(account.getAccountNumber());
                }

                TransactionDAO transactionDAO = new TransactionDAO(connection);
                if (transactionDAO.addTransaction(transaction)) {
                    if ("debit".equals(transactionType) || "transfer".equals(transactionType)) {
                        account.setBalance(account.getBalance() - amount);
                    } else if ("credit".equals(transactionType)) {
                        account.setBalance(account.getBalance() + amount);
                    }
                    accountDAO.updateAccountBalance(account.getId(), account.getBalance());

                    request.setAttribute("message", "Transaction successful!");
                } else {
                    request.setAttribute("message", "Error processing transaction.");
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher("customerHome.jsp");
                dispatcher.forward(request, response);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
    }
}
