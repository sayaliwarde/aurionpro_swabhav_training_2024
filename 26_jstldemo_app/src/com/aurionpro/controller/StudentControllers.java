package com.aurionpro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.entity.Student;


@WebServlet("/StudentControllers")
public class StudentControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public StudentControllers() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		  DbUtil dbUtil = DbUtil.getDbUtil();
	       dbUtil.connectToDb();

	      List<Student> students = dbUtil.getAllStudents();
	        request.setAttribute("students", students);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("/StudentView.jsp");
	        dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
