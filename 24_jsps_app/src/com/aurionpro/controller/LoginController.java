package com.aurionpro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public LoginController() {
        super();
        
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        String username = request.getParameter("username");
        
        // Create and add the cookie to the response
        Cookie cookie = new Cookie("username", username);
        response.addCookie(cookie);

        response.getWriter().print("<form action='PasswordController' method='post'>");
        response.getWriter().print("Password: <input type='password' name='password'><br>");
        response.getWriter().print("<input type='submit' value='Go'></form>");
        
        
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
