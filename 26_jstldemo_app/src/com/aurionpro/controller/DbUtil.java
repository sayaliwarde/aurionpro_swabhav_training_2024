package com.aurionpro.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.entity.Student;


public class DbUtil {
	private Connection connection;
	private Statement statement;
	private static DbUtil dbUtil;
			private DbUtil()
			{
		
			}
	
			public static DbUtil getDbUtil()
			{
				if(dbUtil==null)
					dbUtil = new DbUtil();
				return dbUtil;
			}
	
	public void connectToDb() 
	{
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		   
	
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root","root");
		
	        System.out.println("Connection Successful");
	
		statement = connection.createStatement();
	}
	   catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		   System.out.println("error connecting to database"+e);
	} 
		 catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println(e);
	}
}
	
	public List<Student> getAllStudents()
	{
		ResultSet dbStudents= null;
		List<Student> students = new ArrayList<Student>();
		try {
		dbStudents=statement.executeQuery("select * from students");
		while(dbStudents.next())
		{
			students.add(new Student(dbStudents.getInt(1),dbStudents.getString(2),dbStudents.getDouble(3)));
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		return students;
	}
	 
}
