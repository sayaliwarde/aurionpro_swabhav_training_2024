package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.exception.AgeNotValidException;
import com.aurionpro.model.Voter;

public class VoterTest {
	
	public static void main(String[] args) {
		try {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter voter Id:");
		int voterId=scanner.nextInt();
		System.out.println("Enter first name:");
		String firstName=scanner.next();
		System.out.println("Enter last name");
		String lastName=scanner.next();
		System.out.println("enter age");
		int age=scanner.nextInt();
		Voter voter=new Voter(voterId,firstName,lastName,age);
		System.out.println(voter);
	}
	
		
		catch(AgeNotValidException exception) {
			System.out.println(exception.getMessage());
			
			}
	}
		
}


