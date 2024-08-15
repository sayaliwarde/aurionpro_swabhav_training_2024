package com.aurionpro.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
	
	private Connection connection=null;
	private Statement statement=null;
	private static DbUtil dbUtil=null;
	
	private DbUtil() {
		
	}
	public static DbUtil getDbUtil() {
		if(dbUtil==null)
			dbUtil=new DbUtil();
		return dbUtil;
	}
	public void connectToDb() {
		
		   try {
			
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root","root");
			System.out.println("Connection Succesfull");
			
			statement=connection.createStatement();
		   } 
		   catch (SQLException e) {
			System.out.println("Error connecting to db" +e);
			
		   } 
		   catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		   
		   
	}
	
	public ResultSet getAllUsers() {
		ResultSet dbUsers=null;
		
		try {
			dbUsers=statement.executeQuery("select * from users");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dbUsers;
	}
	
	
	public boolean validateCredentials(String username, String password) {
		ResultSet dbUsers=getAllUsers();
		
		try {
			while(dbUsers.next())
			{
				if(dbUsers.getString("username").equals(username))
					if(dbUsers.getString("password").equals(password))
						return true;
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
