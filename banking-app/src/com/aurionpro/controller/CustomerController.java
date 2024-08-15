package com.aurionpro.controller;

import com.aurionpro.db.CustomerDAO;
import com.aurionpro.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
    private CustomerDAO customerDAO;

    @Override
    public void init() {
        customerDAO = new CustomerDAO();
    }

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
                break;
        }
    }

    private void editProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");

        Customer customer = new Customer(customerId, firstName, lastName, null, password);

        customerDAO.updateProfile(customer);

        response.sendRedirect("customerHome.jsp");
    }

    private void createTransaction(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String senderAccount = request.getParameter("senderAccount");
        String receiverAccount = request.getParameter("receiverAccount");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String type = request.getParameter("type");

        Transaction transaction = new Transaction();
        transaction.setSenderAccount(senderAccount);
        transaction.setReceiverAccount(receiverAccount);
        transaction.setAmount(amount);
        transaction.setDate(new Date());
        transaction.setType(type);

        customerDAO.createTransaction(transaction);

        response.sendRedirect("customerHome.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "viewPassbook":
                viewPassbook(request, response);
                break;
            default:
                break;
        }
    }

    private void viewPassbook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        List<Transaction> transactions = customerDAO.getTransactionsForCustomer(customerId);
        request.setAttribute("transactions", transactions);
        request.getRequestDispatcher("customerPassbook.jsp").forward(request, response);
    }
}