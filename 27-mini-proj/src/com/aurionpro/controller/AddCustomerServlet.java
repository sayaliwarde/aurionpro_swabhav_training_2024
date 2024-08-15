package com.aurionpro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.dao.CustomerDAO;
import com.aurionpro.model.Customer;
import com.aurionpro.util.PasswordUtil;

@WebServlet("/addCustomer")
public class AddCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Check if the password is valid according to the criteria
        if (PasswordUtil.isValidPassword(password)) {
            Customer customer = new Customer();
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setEmail(email);
            customer.setPassword(password);  // Store the plain password

            CustomerDAO customerDAO = new CustomerDAO();
            if (customerDAO.addCustomer(customer)) {
                response.sendRedirect("viewCustomers.jsp");
            } else {
                request.setAttribute("error", "Failed to add customer.");
                request.getRequestDispatcher("addCustomer.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Password must be at least 8 characters long and include an uppercase letter, a lowercase letter, a special character, and a number.");
            request.getRequestDispatcher("addCustomer.jsp").forward(request, response);
        }
    }
}
