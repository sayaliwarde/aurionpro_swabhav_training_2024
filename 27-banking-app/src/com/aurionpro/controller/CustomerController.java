package com.aurionpro.controller;





import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.db.CustomerDAO;
import com.aurionpro.db.TransactionDAO;
import com.aurionpro.entity.Customer;
import com.aurionpro.entity.Transaction;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
    private CustomerDAO customerDAO;
    private TransactionDAO transactionDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        customerDAO = new CustomerDAO();
        transactionDAO = new TransactionDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "editProfile":
                editProfile(request, response);
                break;
            case "createTransaction":
                createTransaction(request, response);
                break;
            default:
                response.sendRedirect("customerHome.jsp");
                break;
        }
    }

    private void editProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");

        if (firstName.isEmpty() || lastName.isEmpty() || password.isEmpty()) {
            response.sendRedirect("error.jsp?message=All fields are required.");
            return;
        }

        Customer customer = new Customer(customerId, firstName, lastName, null, password);
        customerDAO.updateProfile(customer);

        response.sendRedirect("customerHome.jsp");
    }

    private void createTransaction(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String senderAccount = request.getParameter("senderAccount");
        String receiverAccount = request.getParameter("receiverAccount");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String type = request.getParameter("type");

        if (amount <= 0) {
            response.sendRedirect("error.jsp?message=Amount must be greater than zero.");
            return;
        }

        if (!type.equalsIgnoreCase("credit") && !type.equalsIgnoreCase("debit") && !type.equalsIgnoreCase("bank transfer")) {
            response.sendRedirect("error.jsp?message=Invalid transaction type.");
            return;
        }

        Transaction transaction = new Transaction(senderAccount, receiverAccount, amount, new Date(), type);
        transactionDAO.createTransaction(transaction);

        response.sendRedirect("customerHome.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "viewPassbook":
                viewPassbook(request, response);
                break;
            default:
                response.sendRedirect("customerHome.jsp");
                break;
        }
    }

    private void viewPassbook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        List<Transaction> transactions = transactionDAO.getTransactionsForCustomer(customerId);
        request.setAttribute("transactions", transactions);
        request.getRequestDispatcher("/customerPassbook.jsp").forward(request, response);
    }
}

