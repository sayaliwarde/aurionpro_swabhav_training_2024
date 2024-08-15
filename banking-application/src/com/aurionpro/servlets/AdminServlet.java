package com.aurionpro.servlets;

import com.aurionpro.dao.AccountDAO;
import com.aurionpro.dao.CustomerDAO;
import com.aurionpro.dao.TransactionDAO;
import com.aurionpro.model.Customer;
import com.aurionpro.model.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "viewCustomers":
                viewCustomers(request, response);
                break;
            case "viewTransactions":
                viewTransactions(request, response);
                break;
            case "addAccount":
                addAccount(request, response);
                break;
            default:
                response.sendRedirect("admin_home.jsp");
                break;
        }
    }

    private void viewCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sortBy = request.getParameter("sortBy");
        List<Customer> customers = CustomerDAO.getCustomers(sortBy);
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("view_customers.jsp").forward(request, response);
    }

    private void viewTransactions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filterType = request.getParameter("transactionType");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        List<Transaction> transactions = TransactionDAO.getTransactions(filterType, startDate, endDate);
        request.setAttribute("transactions", transactions);
        request.getRequestDispatcher("view_transactions.jsp").forward(request, response);
    }

    private void addAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String accountNumber = generateAccountNumber();
        double initialBalance = Double.parseDouble(request.getParameter("initialBalance"));

        boolean isAdded = AccountDAO.addAccount(customerId, accountNumber, initialBalance);
        if (isAdded) {
            request.setAttribute("message", "Account added successfully.");
        } else {
            request.setAttribute("message", "Failed to add account.");
        }
        request.getRequestDispatcher("add_account.jsp").forward(request, response);
    }

    private String generateAccountNumber() {
        // Generate a random 10-digit account number
        return String.format("%010d", (int)(Math.random() * 1_000_000_000));
    }
}
