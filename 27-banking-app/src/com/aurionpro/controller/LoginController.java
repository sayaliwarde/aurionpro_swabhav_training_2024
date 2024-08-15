package com.aurionpro.controller;

import com.aurionpro.db.CustomerDAO;
import com.aurionpro.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private CustomerDAO customerDAO;

    @Override
    public void init() {
        customerDAO = new CustomerDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        if (role.equals("admin")) {
            if (email.equals("admin@gmail.com") && password.equals("admin123")) {
                response.sendRedirect("adminHome.jsp");
            } else {
                response.getWriter().write("Invalid Admin Credentials");
            }
        } else if (role.equals("customer")) {
            Customer customer = customerDAO.getCustomerByEmailAndPassword(email, password);
            if (customer != null) {
                HttpSession session = request.getSession();
                session.setAttribute("customer", customer);
                response.sendRedirect("customerHome.jsp");
            } else {
                response.getWriter().write("Invalid Customer Credentials");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
}

