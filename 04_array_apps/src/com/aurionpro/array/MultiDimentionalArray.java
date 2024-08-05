package com.aurionpro.array;

import java.util.Scanner;

public class MultiDimentionalArray {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the number of rows:");
		int rows=scanner.nextInt();
		System.out.println("enter the number of columns:");
		int columns=scanner.nextInt();
		 int array[][]=new int[rows][columns];
		 System.out.println("enter array elements");
		 for(int i=0;i<rows;i++)
		 {
			 for(int j=0;j<columns;j++)
			 {
				array[i][j]=scanner.nextInt(); 
			 }
			
		 }
		 System.out.println("matrix is:");
		 for(int i=0;i<rows;i++)
		 {
			 for(int j=0;j<columns;j++)
			 {
				 System.out.print(array[i][j] +" ");
			 }
			 System.out.println(" ");
			 
		 }
		
				 
	}

}
