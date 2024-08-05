package com.aurionpro.model;
import java.util.Scanner;
public class Swapping5 {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		System.out.println("enter first number: ");
		int num1=scanner.nextInt();
		System.out.println("enter second number:");
		int num2=scanner.nextInt();
		System.out.println("Before swapping:");
		System.out.println("num 1: "+num1+"\t num 2: "+num2);
		
		int temp=num1;
		num1=num2;
		num2=temp;
		System.out.println("After swapping:");
		System.out.println("num 1: "+num1+"\t num 2: "+num2);
		
	}
	

}
