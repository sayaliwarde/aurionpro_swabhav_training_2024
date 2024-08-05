package com.aurionpro.creational.singleton.test;

import com.aurionpro.creational.singleton.model.Database;

public class DatabaseTest {
	public static void main(String[] args) {
		Database database1 = Database.getDatabase(); 	//both the objects will have same hash code 
		database1.status();
		System.out.println(database1.hashCode());
		
		Database database2 = Database.getDatabase();
		database1.status();
		System.out.println(database1.hashCode());
		
	}

}
