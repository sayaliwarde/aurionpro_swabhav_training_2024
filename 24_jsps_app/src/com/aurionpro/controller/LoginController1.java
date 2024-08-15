package com.aurionpro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginController1")
public class LoginController1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginController1() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        
        // Retrieve username from the session
        String username = (String) session.getAttribute("username");

        if (username != null) {
            response.getWriter().print("Username is already set. Proceeding to password input form.<br>");
        } else {
            // Retrieve the username from request and store it in the session
            username = request.getParameter("username");
            session.setAttribute("username", username);
        }

        response.getWriter().print("<form action='PasswordController' method='post'>");
        response.getWriter().print("Password: <input type='password' name='password' required><br>");
        response.getWriter().print("<input type='submit' value='Go'></form>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
