package com.aurionpro.array;

import java.util.Scanner;

public class ArraySum03 {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter number of rows for matrix 1:");
	        int rows1 = scanner.nextInt();
	        System.out.println("Enter number of columns for matrix 1:");
	        int cols1 = scanner.nextInt();

	        int matrix[][] = new int[rows1][cols1];
	        System.out.println("Enter elements of matrix 1:");
	        for (int i = 0; i < rows1; i++) 
	        {
	            for (int j = 0; j < cols1; j++) 
	            {
	                matrix[i][j] = scanner.nextInt();
	            }
	        }

	     
	        System.out.println("Enter number of rows for matrix 2:");
	        int rows2 = scanner.nextInt();
	        System.out.println("Enter number of columns for matrix 2:");
	        int cols2 = scanner.nextInt();

	        int array[][] = new int[rows2][cols2];
	        System.out.println("Enter elements of matrix 2:");
	        for (int i = 0; i < rows2; i++) 
	        {
	            for (int j = 0; j < cols2; j++) 
	            {
	                array[i][j] = scanner.nextInt();
	            }
	        }

	       
	        if (rows1 != rows2 || cols1 != cols2) 
	        {
	            System.out.println("Matrices should have the same dimensions for addition.");
	            return;
	        }

	 
	        int[][] result = new int[rows1][cols1];

	  
	        for (int i = 0; i < rows1; i++) 
	        {
	            for (int j = 0; j < cols1; j++) 
	            {
	                result[i][j] = matrix[i][j] + array[i][j];
	            }
	        }


	        System.out.println("Result of Matrix Addition:");
	        for (int i = 0; i < rows1; i++) 
	        {
	            for (int j = 0; j < cols1; j++) 
	            {
	                System.out.print(result[i][j] + " ");
	            }
	            System.out.println();
	        }

	        scanner.close();
	    }
	

		 
	}


