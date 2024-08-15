package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BatchProcessing {
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	private Statement statement=null;
	
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
	
	public void addStudentDetail() {
		
		try {
			connection.setAutoCommit(false);
			preparedStatement=connection.prepareStatement("INSERT INTO student VALUES(?,?,?,?,?)");
			
			Scanner scanner=new Scanner(System.in);
			while(true) {
			System.out.println("Enter student id:");
			int studentId=scanner.nextInt();
			
			//scanner.nextLine();
			
			System.out.println("Enter student name:");
			String studentName=scanner.next();
			
			System.out.println("Enter student marks:");
			double studentMarks=scanner.nextDouble();
			//scanner.nextLine();
			
			System.out.println("Enter the city:");
			String studentCity=scanner.next();
			
			System.out.println("Enter student age:");
			int studentAge=scanner.nextInt();
			//scanner.nextLine();
			
			preparedStatement.setInt(1, studentId);
			preparedStatement.setString(2, studentName);
			preparedStatement.setDouble(3, studentMarks);
			preparedStatement.setString(4, studentCity);
			preparedStatement.setInt(5, studentAge);
			
			
			preparedStatement.addBatch();
			
			System.out.println("Do you want to add more entries?(Y/N)");
			String decision= scanner.next();
			if(decision.toUpperCase().equals("N")) {
				break;
			}			
			}
			
			int[] batchResult=preparedStatement.executeBatch();
			connection.commit();
			System.out.println("Batch executed successfully!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	 public void getStudentDetails() {
		 
	 
		  try {
		   statement = connection.createStatement();
		   
		   ResultSet dbCollegeData = statement.executeQuery("select * from student");
		   
		   while(dbCollegeData.next()) {
		    System.out.println(dbCollegeData.getInt(1)+"\t"+dbCollegeData.getString(2)+"\t"+dbCollegeData.getDouble(3)+"\t"+dbCollegeData.getString(4)+"\t"+dbCollegeData.getInt(5));
		   }
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
	 }
		  

}
