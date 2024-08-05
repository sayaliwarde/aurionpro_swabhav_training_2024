package com.aurionpro.model;

import java.util.Scanner;

public class Trial {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the length");
		int length=scanner.nextInt();
		System.out.println("enter the breadth");
		int breadth=scanner.nextInt();
		int area=length*breadth;
		System.out.println(area);
		
	}

}
