package com.aurionpro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PasswordController1")
public class PasswordController1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PasswordController1() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(false); // false to not create a new session if it doesn't exist

        if (session == null) {
            response.getWriter().print("Session expired. Please login again.");
            return;
        }

        // Retrieve username from the session
        String username = (String) session.getAttribute("username");
        
        // Get the password parameter
        String password = request.getParameter("password");

        // Display the username and password
        response.getWriter().print("Username: " + username);
        response.getWriter().print("<br>Password: " + password);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
