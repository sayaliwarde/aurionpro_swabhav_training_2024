package com.aurionpro.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher=null;
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		request.setAttribute("username", username);
		
		DbUtil dbUtil=DbUtil.getDbUtil();
		
		dbUtil.connectToDb();
		
		
		if(dbUtil.validateCredentials(username,password))
		{
			request.setAttribute("username", username);
			requestDispatcher=request.getRequestDispatcher("LoginSuccess.jsp");
			
		}
			else 
			requestDispatcher=request.getRequestDispatcher("LoginFailed.jsp");
		
		requestDispatcher.forward(request, response); //fwds the req and res to either succ/ fail page
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
