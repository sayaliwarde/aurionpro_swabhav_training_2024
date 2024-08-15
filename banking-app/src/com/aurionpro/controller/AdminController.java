package com.aurionpro.controller;

import com.aurionpro.db.AdminDAO;
import com.aurionpro.entity.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
    private AdminDAO adminDAO;

    @Override
    public void init() {
        adminDAO = new AdminDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "addCustomer":
                addCustomer(request, response);
                break;
            case "addBankAccount":
                addBankAccount(request, response);
                break;
            default:
                break;
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPassword(password);

        adminDAO.addCustomer(customer);

        response.sendRedirect("adminHome.jsp");
    }

    private void addBankAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String accountNumber = request.getParameter("accountNumber");
        double balance = Double.parseDouble(request.getParameter("balance"));

        BankAccount account = new BankAccount();
        account.setCustomerId(customerId);
        account.setAccountNumber(accountNumber);
        account.setBalance(balance);

        adminDAO.addBankAccount(account);

        response.sendRedirect("adminHome.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "viewCustomers":
                viewCustomers(request, response);
                break;
            case "viewTransactions":
                viewTransactions(request, response);
                break;
            default:
                break;
        }
    }

    private void viewCustomers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Customer> customers = adminDAO.getAllCustomers();
        request.setAttribute("customers", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewCustomers.jsp");
        dispatcher.forward(request, response);
    }

    private void viewTransactions(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Transaction> transactions = adminDAO.getAllTransactions();
        request.setAttribute("transactions", transactions);
        request.getRequestDispatcher("viewTransactions.jsp").forward(request, response);
    }
}