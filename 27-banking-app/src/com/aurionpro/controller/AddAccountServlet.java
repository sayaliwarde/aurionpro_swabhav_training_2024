package com.aurionpro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.db.AccountDAO;
import com.aurionpro.entity.Account;

@WebServlet("/addAccountServlet")
public class AddAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String accountNumber = request.getParameter("accountNumber");
        double balance = Double.parseDouble(request.getParameter("balance"));

        if (balance < 5000) {
            request.setAttribute("errorMessage", "Balance must be at least 5000!");
            request.getRequestDispatcher("addAccount.jsp").forward(request, response);
            return;
        }

        Account account = new Account(customerId, accountNumber, balance);
        boolean isSuccess = AccountDAO.addAccount(account);

        if (isSuccess) {
            request.setAttribute("successMessage", "Account added successfully!");
            response.sendRedirect("customerList.jsp");
        } else {
            request.setAttribute("errorMessage", "Account could not be added!");
            request.getRequestDispatcher("addAccount.jsp").forward(request, response);
        }
    }
}
