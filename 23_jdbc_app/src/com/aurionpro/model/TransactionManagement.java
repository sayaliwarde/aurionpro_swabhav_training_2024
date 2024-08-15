package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionManagement {
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
	
	public void transaction() {
		
		try {
			connection.setAutoCommit(false);
		
				String debitQuery="UPDATE accounts SET balance= balance - ? WHERE accountNumber = ?";
			preparedStatement=connection.prepareStatement(debitQuery);
			
			withdraw.setDouble(1, 500);
			preparedStatement.setInt(2, 456);		
					
			preparedStatement.executeUpdate();
			
			String creditQuery="UPDATE accounts SET balance= balance + ? WHERE accountNumber = ?";
			preparedStatement=connection.prepareStatement(creditQuery);
			
			preparedStatement.setDouble(1, 500);
			preparedStatement.setInt(2, 123);		
			
			
			preparedStatement.executeUpdate();
			
			connection.commit();
			System.out.println("Transaction successful!!");
			
			int rowsAffectedDuringDebit=
			if()
				connection.rollback();
				System.out.println("Transaction failed :(");
				}
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
