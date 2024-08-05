package com.aurionpro.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySquareSorter {
	public static void main(String[] args) {
		
	        Scanner scanner = new Scanner(System.in);
	        
	        // Take input for the size of the array
	        System.out.print("Enter the size of the array: ");
	        int size = scanner.nextInt();
	        
	        // Initialize the array
	        int[] array = new int[size];
	        
	        // Take input for the elements of the array
	        System.out.println("Enter the elements of the array:");
	        for (int i = 0; i < size; i++) 
	        {
	            array[i] = scanner.nextInt();
	        }
	        
	        // Close the scanner after input is taken
	        scanner.close();
	        
	        // Compute the sorted squares array

	        int[] result = new int[size];
	        
	        int left = 0;
	        int right = size - 1;
	        
	        for (int i = 0; i <size; i++) {
	            int squareLeft = array[left] * array[left];
	            int squareRight = array[right] * array[right];
	            
	            if (squareLeft > squareRight) {
	                result[i] = squareLeft;
	                left--;
	            } else {
	                result[i] = squareRight;
	                right++;
	            }
	        }
	        
	        // Print the sorted squares array
	        System.out.println("Sorted squares array: " + Arrays.toString(result));
	}

}
