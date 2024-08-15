package com.aurionpro.servlets;

import com.aurionpro.dao.CustomerDAO;
import com.aurionpro.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        if ("admin".equalsIgnoreCase(role)) {
            if ("admin".equalsIgnoreCase(username) && "admin".equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("role", "admin");
                response.sendRedirect("admin_home.jsp");
            } else {
                request.setAttribute("error", "Invalid Admin Credentials");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else if ("customer".equalsIgnoreCase(role)) {
            Customer customer = CustomerDAO.getCustomerById(Integer.parseInt(username));
            if (customer != null && customer.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("role", "customer");
                session.setAttribute("customer", customer);
                response.sendRedirect("customer_home.jsp");
            } else {
                request.setAttribute("error", "Invalid Customer Credentials");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Invalid Role");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
