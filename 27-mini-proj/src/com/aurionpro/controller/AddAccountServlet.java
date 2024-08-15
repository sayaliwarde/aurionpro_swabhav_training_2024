package com.aurionpro.controller;

import com.aurionpro.dao.AccountDAO;
import com.aurionpro.dao.CustomerDAO;
import com.aurionpro.model.Account;
import com.aurionpro.util.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/addBankAccount")
public class AddAccountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customer_id");

        CustomerDAO customerDAO = new CustomerDAO();
        AccountDAO accountDAO = new AccountDAO();

        if (customerDAO.getCustomerById(Integer.parseInt(customerId)) != null) {
            // Generate a random 10-digit account number
            String accountNumber = String.format("%010d", new Random().nextInt(1000000000));
            Account account = new Account();
            account.setAccountNumber(accountNumber);
            account.setCustomerId(Integer.parseInt(customerId));
            account.setBalance(5000); // Set initial balance

            boolean success = accountDAO.addAccount(account);

            if (success) {
                request.setAttribute("success", "Account added successfully.");
            } else {
                request.setAttribute("error", "Failed to add account.");
            }
        } else {
            request.setAttribute("error", "Invalid customer ID.");
        }

        request.getRequestDispatcher("addBankAccount.jsp").forward(request, response);
    }
}
