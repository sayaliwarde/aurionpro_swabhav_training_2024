//package com.aurionpro.model;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class DBConnection {
//	
//	private Connection connection=null;
//	Statement statement = connection.createStatement();
//	public void connectToDb() {
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/organization", "root", "root");
//			System.out.println("Connection Successful");
//		
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
//	
//	public void getOrganizationDetails() {
//		
//		try {
//			
//			ResultSet dbOrganizationData=statement.executeQuery("select * from department");
//			
//			while(dbOrganizationData.next())
//			{
//				System.out.println(dbOrganizationData.getInt(0)+"\t"+dbOrganizationData.getString(1));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//
//}


package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnection {

 private Connection connection = null;
 private Statement statement = null;
 private PreparedStatement preparedStatement= null;
 
 public void connectToDb() {
  try {
	  
   //1. Register Driver
   Class.forName("com.mysql.cj.jdbc.Driver");
   
   
   //2. Create Connection
   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/organization", "root","root");
   System.out.println("Connection Succesfull");
      
  } catch (ClassNotFoundException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  catch (SQLException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  
 }
 
 public void getOrganizationDetails() {
  
  //3. Create Statement
  
  try {
   statement = connection.createStatement();
   //4. Execute query and store it in a ResultSet
   ResultSet dbOrganizationData = statement.executeQuery("select * from department");
   
   while(dbOrganizationData.next()) {
    System.out.println(dbOrganizationData.getInt(1)+"\t"+dbOrganizationData.getString(2)+"\t"+dbOrganizationData.getString(3));
   }
  } catch (SQLException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  
  
 }
 
 public void addOrganizationDetails() {

  try {
   statement = connection.createStatement();
   //5. Add a record into the data
   
   Scanner scanner = new Scanner(System.in);
   System.out.println("Enter your department no:");
   int departmentNumber=scanner.nextInt();
   System.out.println("Enter your department name:");
   String departmentName=scanner.next();
   System.out.println("Enter your location:");
   String location=scanner.next();
   
   
   	preparedStatement= connection.prepareStatement("insert into department values(?,?,?)");
   	preparedStatement.setInt(1, departmentNumber);
   	preparedStatement.setString(2, departmentName);
   	preparedStatement.setString(3, location);
   	preparedStatement.executeUpdate();
   	
   	
     //statement.executeUpdate("Insert into department values"+departmentNumber+",'"+departmentName+"',"+"'"+location+"'");
   
  } catch (SQLException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } 
  
 }
 

}
