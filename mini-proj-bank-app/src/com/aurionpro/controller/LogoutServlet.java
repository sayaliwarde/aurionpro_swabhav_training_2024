package com.aurionpro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // Invalidate the session to log out the user
            HttpSession session = request.getSession(false); // Fetch session, if exists
            if (session != null) {
                session.invalidate(); // Invalidate the session
            }
            // Redirect to login page
            response.sendRedirect("login.jsp");
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
        }
    


}