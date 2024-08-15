package com.aurionpro.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		//addn
//		int number1= Integer.parseInt(request.getParameter("number1"));
//		int number2= Integer.parseInt(request.getParameter("number2"));
//		int result=number1+number2;
//		
//		writer.print("<h3>Addition is: <h3><b><h3>"+result+"<b><h3>");
		
		//checkbox
		String[] colours = request.getParameterValues("colours");
		if (colours != null && colours.length > 0) {
		    writer.print("<b>Colours you chose are:</b><br>");
		    writer.print("<ul>");
		    for (String colour : colours) {
		        writer.print("<li>" + colour + "</li>");
		    }
		    writer.print("</ul>");
		} 

		
		
		
		//writer.print("<b>Hello!!<b>");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
