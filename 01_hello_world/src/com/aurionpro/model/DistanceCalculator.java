package com.aurionpro.model;
import java.util.Scanner;
public class DistanceCalculator {
public static void main(String[] args) {
	Scanner scanner= new Scanner(System.in);
	//input
	System.out.println("Enter the value of x1");
	double x1= scanner.nextDouble();
	System.out.println("Enter the value of y1");
	double y1= scanner.nextDouble();
	System.out.println("Enter the value of x2");
	double x2= scanner.nextDouble();
	System.out.println("Enter the value of y2");
	double y2= scanner.nextDouble();
	//formula
	double distance= Math.sqrt(Math.pow(x2-x1 , 2)+ Math.pow(y2-y1, 2));
	System.out.println("The distance between two points is: "+distance);
}
}
