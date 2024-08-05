package com.aurionpro.stream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerializationTester {
		 public static void main(String[] args) {
		        // Deserialize the object from "userProfile.ser"
		        try (FileInputStream fileIn = new FileInputStream("C:\\Users\\sayali.warde\\Documents\\sertest");
		             ObjectInputStream in = new ObjectInputStream(fileIn)) {

		        	SerializationTester userProfile = ("C:\\Users\\sayali.warde\\Documents\\sertest") in.readObject();
		            System.out.println("Object deserialized successfully:");
		            System.out.println(userProfile);
		        }
}
	 }
	       