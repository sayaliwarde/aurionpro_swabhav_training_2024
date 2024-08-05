package com.aurionpro.stream;

import java.util.Scanner;

public class Practice {
	public static String votingChcek(int age) {
		if(age>=18) {
			
			return "can vote";
			
		}
		else {
				
			
		return "cannot vote";
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your age");
		int age=sc.nextInt();
		
		String eligibility= votingChcek(age);
		System.out.println(eligibility);
		
	}
	

}
