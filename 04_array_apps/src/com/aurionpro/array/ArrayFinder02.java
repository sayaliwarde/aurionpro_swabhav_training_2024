package com.aurionpro.array;

import java.util.Scanner;

public class ArrayFinder02 {
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
		 for(int i=0;i<rows;i++)
		 {
			 for(int j=0;j<columns;j++)
			 {
				 System.out.print(array[i][j] +" ");
			 }
			 System.out.println();
		 }
			 System.out.println("Enter the number to check peresent in array or not : ");
				int number = scanner.nextInt(); // [3,4,5] //3
				int temp = number; //3
				boolean exist = true;
				for(int i = 0 ; i < rows; i++) 
				{
					for(int j=0;j<columns;j++)
					{
					if(temp != array[i][j]) //3!=3
					{ 
						exist = false;
					}
				}
				
				if(exist = true) 
				{

					System.out.println("The element is Exists.");
				}
				else 
				{
					System.out.println("The element not is Exists.");
				}
		 }
	}

}
