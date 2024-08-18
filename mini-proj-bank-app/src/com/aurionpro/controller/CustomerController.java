package com.aurionpro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.aurionpro.dao.AccountDAO;
import com.aurionpro.dao.CustomerDAO;
import com.aurionpro.dao.TransactionDAO;
import com.aurionpro.model.Account;
import com.aurionpro.model.Customer;
import com.aurionpro.model.Transaction;

@WebServlet("/customer")
public class CustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AccountDAO accountDAO = new AccountDAO();
    private CustomerDAO customerDAO = new CustomerDAO();
    private TransactionDAO transactionDAO = new TransactionDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "newTransaction":
                    newTransaction(request, response);
                    break;
                case "editProfile":
                    updateProfile(request, response);
                    break;
                default:
                    response.sendRedirect("customerDashboard.jsp");
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "viewPassbook":
                    viewPassbook(request, response);
                    break;
                case "viewProfile":
                    viewProfile(request, response);
                    break;
                default:
                    response.sendRedirect("customerDashboard.jsp");
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void newTransaction(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String senderAccountNumber = (String) request.getSession().getAttribute("accountNumber");

        if (senderAccountNumber == null || senderAccountNumber.isEmpty()) {
            request.setAttribute("message", "Sender account not found");
            RequestDispatcher dispatcher = request.getRequestDispatcher("newTransaction.jsp");
            dispatcher.forward(request, response);
            return;
        }

        String type = request.getParameter("type");
        double amount;

        try {
            amount = Double.parseDouble(request.getParameter("amount"));
        } catch (NumberFormatException e) {
            request.setAttribute("message", "Invalid amount");
            RequestDispatcher dispatcher = request.getRequestDispatcher("newTransaction.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (amount <= 0) {
            request.setAttribute("message", "Transaction amount must be greater than zero");
            RequestDispatcher dispatcher = request.getRequestDispatcher("newTransaction.jsp");
            dispatcher.forward(request, response);
            return;
        }

        Account senderAccount = accountDAO.getAccountByNumber(senderAccountNumber);
        if (senderAccount == null) {
            request.setAttribute("message", "Sender account not found");
            RequestDispatcher dispatcher = request.getRequestDispatcher("newTransaction.jsp");
            dispatcher.forward(request, response);
            return;
        }

        String receiverAccountNumber = senderAccountNumber;
        if (type.equals("transfer")) {
            receiverAccountNumber = request.getParameter("receiverAccountNumber");
            Account receiverAccount = accountDAO.getAccountByNumber(receiverAccountNumber);
            if (receiverAccount == null) {
                request.setAttribute("message", "Receiver account not found");
                RequestDispatcher dispatcher = request.getRequestDispatcher("newTransaction.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }

        Transaction transaction = new Transaction();
        transaction.setSenderAccountNumber(senderAccountNumber);
        transaction.setReceiverAccountNumber(receiverAccountNumber);
        transaction.setType(type);
        transaction.setAmount(amount);

        boolean success = transactionDAO.addTransaction(transaction);

        if (success) {
            accountDAO.updateAccountBalance(senderAccountNumber, senderAccount.getBalance() - amount);
            if (type.equals("transfer")) {
                Account receiverAccount = accountDAO.getAccountByNumber(receiverAccountNumber);
                accountDAO.updateAccountBalance(receiverAccountNumber, receiverAccount.getBalance() + amount);
            }
            request.setAttribute("message", "Transaction completed successfully!");
        } else {
            request.setAttribute("message", "Error completing transaction!");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("newTransaction.jsp");
        dispatcher.forward(request, response);
    }

    private void viewPassbook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String accountNumber = (String) request.getSession().getAttribute("accountNumber");
        List<Transaction> transactions = transactionDAO.getTransactionsByAccountNumber(accountNumber);
        request.setAttribute("transactions", transactions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewPassbook.jsp");
        dispatcher.forward(request, response);
    }

    private void viewProfile(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        Integer customerId = (Integer) request.getSession().getAttribute("customerId");

        if (customerId == null) {
            request.setAttribute("message", "No customer ID found in session.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("customerDashboard.jsp");
            dispatcher.forward(request, response);
            return;
        }

        Customer customer = customerDAO.getCustomerById(customerId);

        if (customer != null) {
            request.setAttribute("customer", customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("editProfile.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("message", "Customer details not available. Please try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("customerDashboard.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void updateProfile(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int customerId = (int) request.getSession().getAttribute("customerId");
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");

        Customer customer = customerDAO.getCustomerById(customerId);

        if (customer != null && customer.getPassword().equals(currentPassword)) {
            customer.setPassword(newPassword);
            boolean success = customerDAO.updateCustomerPassword(customer);
            if (success) {
                request.setAttribute("message", "Password updated successfully.");
            } else {
                request.setAttribute("message", "Error updating password.");
            }
        } else {
            request.setAttribute("message", "Current password is incorrect.");
        }

        request.setAttribute("customer", customer); // Ensure customer details are passed back to the page
        RequestDispatcher dispatcher = request.getRequestDispatcher("editProfile.jsp");
        dispatcher.forward(request, response);
    }
}
