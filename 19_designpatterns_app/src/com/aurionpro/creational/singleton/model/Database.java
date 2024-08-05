package com.aurionpro.creational.singleton.model;

public class Database {
	
	private static Database database; //2. declare static reference of same class
	
		private Database() { //1. constructor made private
			System.out.println("Database created");
			
		}
		
		public static Database getDatabase() { //3. public static method to get instance of class
			if(database==null)
				database = new Database();
			return database;
		}
		public void status()
		{
			System.out.println("database connected successfully");
		}
		
}
