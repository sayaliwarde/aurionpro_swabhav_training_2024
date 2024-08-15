package com.aurionpro.controller;



import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.db.AccountDAO;
import com.aurionpro.db.AdminDAO;
import com.aurionpro.db.CustomerDAO;
import com.aurionpro.entity.Account;
import com.aurionpro.entity.Customer;
import com.aurionpro.entity.Transaction;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
    private AdminDAO adminDAO;
    private CustomerDAO customerDAO;
    private AccountDAO accountDAO;

    @Override
    public void init() {
        adminDAO = new AdminDAO();
        customerDAO = new CustomerDAO();
        accountDAO = new AccountDAO();
    }

    @Override
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
                response.sendRedirect("adminHome.jsp");
                break;
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            response.sendRedirect("error.jsp?message=All fields are required.");
            return;
        }

        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
            response.sendRedirect("error.jsp?message=Password must be at least 8 characters long and include an uppercase letter, a lowercase letter, a number, and a special character.");
            return;
        }

        Customer customer = new Customer(firstName, lastName, email, password);
        adminDAO.addCustomer(customer);

        response.sendRedirect("adminHome.jsp");
    }

    private void addBankAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        double balance = Double.parseDouble(request.getParameter("balance"));

        if (balance < 5000) {
            response.sendRedirect("error.jsp?message=Minimum balance must be 5000.");
            return;
        }

        String accountNumber = generateAccountNumber(); // Generate random 10-digit account number

        Account account = new Account(customerId, accountNumber, balance);
        accountDAO.addAccount(account);

        response.sendRedirect("viewCustomers.jsp"); // Redirect to updated customer list
    }

    private String generateAccountNumber() {
        // Generate a random 10-digit account number
        return String.format("%010d", (int) (Math.random() * 1000000000));
    }

    @Override
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
                response.sendRedirect("adminHome.jsp");
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewTransactions.jsp");
        dispatcher.forward(request, response);
    }
}
