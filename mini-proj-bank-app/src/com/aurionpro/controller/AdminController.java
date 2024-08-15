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


@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

    private CustomerDAO customerDAO = new CustomerDAO();
    private AccountDAO accountDAO = new AccountDAO();
    private TransactionDAO transactionDAO = new TransactionDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "addCustomer":
                    addCustomer(request, response);
                    break;
                case "addAccount":
                    addAccount(request, response);
                    break;
                default:
                    response.sendRedirect("adminDashboard.jsp");
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
                case "viewCustomers":
                    viewCustomers(request, response);
                    break;
                case "viewTransactions":
                    viewTransactions(request, response);
                    break;
                default:
                    response.sendRedirect("adminDashboard.jsp");
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validation for email and password
        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            request.setAttribute("message", "Invalid email format");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addCustomer.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$")) {
            request.setAttribute("message", "Password must be 8 characters long and include uppercase, lowercase, special character, and number");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addCustomer.jsp");
            dispatcher.forward(request, response);
            return;
        }

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPassword(password);

        boolean success = customerDAO.addCustomer(customer);
        if (success) {
            request.setAttribute("message", "Customer added successfully!");
        } else {
            request.setAttribute("message", "Error adding customer!");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("addCustomer.jsp");
        dispatcher.forward(request, response);
    }

    private void addAccount(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String accountNumber = String.valueOf((long) (Math.random() * 10000000000L));
        double balance = Double.parseDouble(request.getParameter("balance"));

        if (balance < 5000) {
            request.setAttribute("message", "Minimum balance required is 5000");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addAccount.jsp");
            dispatcher.forward(request, response);
            return;
        }

        Account account = new Account();
        account.setCustomerId(customerId);
        account.setAccountNumber(accountNumber);
        account.setBalance(balance);

        boolean success = accountDAO.addAccount(account);
        if (success) {
            request.setAttribute("message", "Account added successfully! Account Number: " + accountNumber);
        } else {
            request.setAttribute("message", "Error adding account!");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("addAccount.jsp");
        dispatcher.forward(request, response);
    }

    private void viewCustomers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Customer> customers = customerDAO.getAllCustomers();
        request.setAttribute("customers", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewCustomers.jsp");
        dispatcher.forward(request, response);
    }

    private void viewTransactions(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Transaction> transactions = transactionDAO.getAllTransactions();
        request.setAttribute("transactions", transactions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewTransactions.jsp");
        dispatcher.forward(request, response);
    }
}
           
