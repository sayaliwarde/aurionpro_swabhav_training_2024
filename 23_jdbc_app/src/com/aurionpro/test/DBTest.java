package com.aurionpro.test;

import com.aurionpro.model.DBConnection;

public class DBTest {
	public static void main(String[] args) {
		
		DBConnection connection=new DBConnection();
		connection.connectToDb();
		connection.getOrganizationDetails();
		connection.addOrganizationDetails();
		connection.getOrganizationDetails();
	}
	
	
	
}
