package com.aurionpro.array;

import java.util.Scanner;

public class ProductOfElementsInArray {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int[] prod = getProductArray(array);
        System.out.print("The product array is: ");
        for (int p : prod) {
            System.out.print(p + " ");
        }
        scanner.close();
    }
    public static int[] getProductArray(int[] array) {
        int n = array.length;
        int[] prod = new int[n];
        
        if (n == 0) {
            return prod;
        }
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * array[i - 1];
        }
        
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * array[i + 1];
        }

        for (int i = 0; i < n; i++) {
            prod[i] = left[i] * right[i];
        }
        
        return prod;
	}

}
