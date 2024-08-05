package com.aurionpro.array;

import java.util.Scanner;

public class PeakNumberChecker {
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	     System.out.print("Enter the size of the array: ");
	     int size = scanner.nextInt();

	     int array[] = new int[size];

	     System.out.print("Enter the elements of the array:");
	     for (int i = 0; i < size; i++) 
	     {
	      array[i] = scanner.nextInt();
	     }    

	     System.out.println("Peak elements in the array:"+"");
	     for (int i = 0; i < size; i++) 
	     {

	         if ((i == 0 || array[i] >= array[i - 1]) && (i == size - 1 || array[i] >= array[i + 1]))
	         {
	             System.out.print(array[i]);
	         }
	     }

	}

}

