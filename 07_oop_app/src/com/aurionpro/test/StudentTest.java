package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Student;

public class StudentTest {
	public static void main(String[] args) {
		Student student=new Student();
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter your name");
		String name=scanner.next();
		student.setName(name);
		
		System.out.println("enter your age:");
		int age=scanner.nextInt();
		student.setAge(age);
		
		System.out.println("enter your roll number");
		int rollnumber=scanner.nextInt();
		student.setRollnumber(rollnumber);
		
		System.out.println("enter your percentage");
		int percentage=scanner.nextInt();
		student.setPercentage(percentage);
		
		System.out.println("name is:");
		student.getName();
		
		System.out.println("age is:");
		student.getAge();
		
		System.out.println("roll number is:");
		student.getRollNumber();
		
		System.out.println("percentage is:");
		student.getPercentage();
	}


}
