package com.aurionpro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.dao.CustomerDAO;
import com.aurionpro.dao.AccountDAO;
import com.aurionpro.model.Customer;
import com.aurionpro.model.Account;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CustomerDAO customerDAO = new CustomerDAO();
    private AccountDAO accountDAO = new AccountDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email.equals("admin@gmail.com") && password.equals("Admin#12")) {
            HttpSession session = request.getSession();
            session.setAttribute("userRole", "admin");
            response.sendRedirect("adminDashboard.jsp");
        } else {
            try {
                Customer customer = customerDAO.getCustomerByEmail(email);
                if (customer != null && customer.getPassword().equals(password)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("userRole", "customer");
                    session.setAttribute("customerName", customer.getFirstName() + " " + customer.getLastName());

                    // Fetch customer's account details and store the account number in session
                    Account account = accountDAO.getAccountsByCustomerId(customer.getCustomerId()).get(0); // Assuming each customer has only one account
                    session.setAttribute("accountNumber", account.getAccountNumber());

                    response.sendRedirect("customerDashboard.jsp");
                } else {
                    request.setAttribute("errorMessage", "Invalid credentials");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }
    }
}
