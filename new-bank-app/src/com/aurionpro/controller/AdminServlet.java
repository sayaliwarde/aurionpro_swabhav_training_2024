package com.aurionpro.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.dao.AccountDAO;
import com.aurionpro.dao.TransactionDAO;
import com.aurionpro.dao.UserDAO;
import com.aurionpro.model.Account;
import com.aurionpro.model.Transaction;
import com.aurionpro.model.User;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdatabase", "root", "root");

            if ("viewCustomers".equals(action)) {
                String sortBy = request.getParameter("sortBy") != null ? request.getParameter("sortBy") : "first_name";
                UserDAO userDAO = new UserDAO(connection);
                List<User> customers = userDAO.getAllCustomers(sortBy);
                request.setAttribute("customers", customers);

                RequestDispatcher dispatcher = request.getRequestDispatcher("viewCustomers.jsp");
                dispatcher.forward(request, response);

            } else if ("addAccount".equals(action)) {
                UserDAO userDAO = new UserDAO(connection);
                List<User> customers = userDAO.getAllCustomers("first_name");
                request.setAttribute("customers", customers);

                RequestDispatcher dispatcher = request.getRequestDispatcher("addAccount.jsp");
                dispatcher.forward(request, response);

            } else if ("viewTransactions".equals(action)) {
                String accountNumber = request.getParameter("accountNumber");
                String type = request.getParameter("type");
                String startDateStr = request.getParameter("startDate");
                String endDateStr = request.getParameter("endDate");

                Date startDate = startDateStr != null ? Date.valueOf(startDateStr) : null;
                Date endDate = endDateStr != null ? Date.valueOf(endDateStr) : null;

                TransactionDAO transactionDAO = new TransactionDAO(connection);
                List<Transaction> transactions = transactionDAO.getTransactionsByFilter(accountNumber, type, startDate, endDate);

                request.setAttribute("transactions", transactions);
                RequestDispatcher dispatcher = request.getRequestDispatcher("viewTransactions.jsp");
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

            if ("addCustomer".equals(action)) {
                UserDAO userDAO = new UserDAO(connection);
                User user = new User();
                user.setUsername(request.getParameter("username"));
                user.setPassword(request.getParameter("password"));
                user.setFirstName(request.getParameter("firstName"));
                user.setLastName(request.getParameter("lastName"));
                user.setEmail(request.getParameter("email"));
                user.setRole("customer");

                if (userDAO.addUser(user)) {
                    request.setAttribute("message", "Customer added successfully!");
                } else {
                    request.setAttribute("message", "Error adding customer.");
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher("adminHome.jsp");
                dispatcher.forward(request, response);

            } else if ("addAccount".equals(action)) {
                String customerId = request.getParameter("customerId");
                double initialDeposit = Double.parseDouble(request.getParameter("initialDeposit"));
                String accountNumber = request.getParameter("accountNumber");

                Account account = new Account();
                account.setUserId(Integer.parseInt(customerId));
                account.setAccountNumber(accountNumber);
                account.setBalance(initialDeposit);

                AccountDAO accountDAO = new AccountDAO(connection);
                if (accountDAO.addAccount(account)) {
                    request.setAttribute("message", "Account added successfully!");
                } else {
                    request.setAttribute("message", "Error adding account.");
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher("adminHome.jsp");
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
