package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionManaging {
	private Connection connection=null;
	private Statement statement=null;
	private PreparedStatement preparedStatement=null;
	
	public void connectTo() {
		try {
			//driver registered
			Class.forName("com.mysql.cj.jdbc.Driver");	
			System.out.println("Driver Registered!");
			
			//connection established
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root","root"); 
			System.out.println("Connected to db!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void debit() {
		
		try {
			connection.setAutoCommit(false);
			try {
				String sql2="UPDATE accounts SET balance= balance - ? WHERE accountNumber = ?";
			preparedStatement=connection.prepareStatement(sql2);
			
			preparedStatement.setDouble(1, 500);
			preparedStatement.setInt(2, 456);		
			
			
			preparedStatement.executeUpdate();
			
			connection.commit();
			System.out.println("Transaction successful!!");
		}
			catch (SQLException e) { 
				connection.rollback();
				System.out.println("Transaction failed :(");
				}
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void credit() {
		try {
			connection.setAutoCommit(false);
			try {
				String sql1="UPDATE accounts SET balance= balance + ? WHERE accountNumber = ?";
			preparedStatement=connection.prepareStatement(sql1);
			
			preparedStatement.setDouble(1, 500);
			preparedStatement.setInt(2, 123);		
			
			
			preparedStatement.executeUpdate();
			connection.commit();
			System.out.println("Transaction successful!!");
			
		} catch(SQLException e) { 
			connection.rollback();
			
			System.out.println("Transaction failed :(");
			} 
			} catch (SQLException e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public void getTransactionDetails() {
			 
			 
			  try {
			   statement = connection.createStatement();
			   
			   ResultSet accountData = statement.executeQuery("SELECT * from accounts");
			   
			   while(accountData.next()) {
			    System.out.println(accountData.getInt(1)+"\t"+accountData.getDouble(2)+"\t"+accountData.getString(3));
			   }
			  } catch (SQLException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
		 }
		
	

}
