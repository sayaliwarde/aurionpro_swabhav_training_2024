package com.aurionpro.array;

import java.util.Scanner;

public class SecondLargestNumberInArray {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the size of the array: ");
	        int size = scanner.nextInt();
	        int[] arr = new int[size];
	        System.out.println("Enter the elements of the array:");
	        for (int i = 0; i < size; i++) {
	            arr[i] = scanner.nextInt();
	        }
	        
	        if (size < 2) {
	            System.out.println("The array does not have a second largest number.");
	        } else {
	            int firstLargest = Integer.MIN_VALUE;
	            int secondLargest = Integer.MIN_VALUE;

	            for (int i = 0; i < size; i++) {
	                if (arr[i] > firstLargest) {
	                    secondLargest = firstLargest;
	                    firstLargest = arr[i];
	                } else if (arr[i] > secondLargest && arr[i] != firstLargest) {
	                    secondLargest = arr[i];
	                }
	            }

	            if (secondLargest != Integer.MIN_VALUE) {
	                System.out.println("The second largest number is: " + secondLargest);
	            } else {
	                System.out.println("The array does not have a second largest number.");
	            }
	        } scanner.close();
	}

}
