package com.aurionpro.controller;

import com.aurionpro.dao.CustomerDAO;
import com.aurionpro.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/customerLogin")
public class CustomerLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = customerDAO.getCustomerByEmail(email);

        // Only check if the entered password matches the stored password without hashing
        if (customer != null && password.equals(customer.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            response.sendRedirect("customerHome.jsp");
        } else {
            request.setAttribute("error", "Invalid email or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
