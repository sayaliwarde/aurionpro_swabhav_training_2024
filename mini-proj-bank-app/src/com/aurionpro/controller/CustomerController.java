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
import com.aurionpro.dao.TransactionDAO;
import com.aurionpro.model.Account;
import com.aurionpro.model.Transaction;


@WebServlet("customer")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }
    

        private AccountDAO accountDAO = new AccountDAO();
        private TransactionDAO transactionDAO = new TransactionDAO();

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            try {
                switch (action) {
                    case "newTransaction":
                        newTransaction(request, response);
                        break;
                    case "editProfile":
                        editProfile(request, response);
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
                    default:
                        response.sendRedirect("customerDashboard.jsp");
                        break;
                }
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }

        private void newTransaction(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
            String senderAccountNumber = request.getParameter("senderAccountNumber");
            String receiverAccountNumber = request.getParameter("receiverAccountNumber");
            String type = request.getParameter("type");
            double amount = Double.parseDouble(request.getParameter("amount"));

            // Validation for transaction
            if (amount <= 0) {
                request.setAttribute("message", "Transaction amount must be greater than zero");
                RequestDispatcher dispatcher = request.getRequestDispatcher("customer/newTransaction.jsp");
                dispatcher.forward(request, response);
                return;
            }

            Account senderAccount = accountDAO.getAccountByNumber(senderAccountNumber);
            if (senderAccount.getBalance() < amount && type.equals("debit")) {
                request.setAttribute("message", "Insufficient balance");
                RequestDispatcher dispatcher = request.getRequestDispatcher("newTransaction.jsp");
                dispatcher.forward(request, response);
                return;
            }

            Transaction transaction = new Transaction();
            transaction.setSenderAccountNumber(senderAccountNumber);
            transaction.setReceiverAccountNumber(receiverAccountNumber);
            transaction.setType(type);
            transaction.setAmount(amount);

            boolean success = transactionDAO.addTransaction(transaction);
            if (success) {
                accountDAO.updateAccountBalance(senderAccountNumber, senderAccount.getBalance() - amount);
                Account receiverAccount = accountDAO.getAccountByNumber(receiverAccountNumber);
                accountDAO.updateAccountBalance(receiverAccountNumber, receiverAccount.getBalance() + amount);
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

        private void editProfile(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
            String accountNumber = (String) request.getSession().getAttribute("accountNumber");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            Account account = accountDAO.getAccountByNumber(accountNumber);
            account.setCustomerId(account.getCustomerId());
            // Update other fields
            boolean success = accountDAO.updateAccountBalance(accountNumber, account.getBalance());
            if (success) {
                request.setAttribute("message", "Profile updated successfully!");
            } else {
                request.setAttribute("message", "Error updating profile!");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("editProfile.jsp");
            dispatcher.forward(request, response);
        }
    

}

    