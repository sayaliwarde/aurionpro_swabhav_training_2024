package com.aurionpro.array;

import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for matrix 1
        System.out.println("Enter number of rows for matrix 1:");
        int rows1 = scanner.nextInt();
        System.out.println("Enter number of columns for matrix 1:");
        int cols1 = scanner.nextInt();

        int[][] matrix1 = new int[rows1][cols1];
        System.out.println("Enter elements of matrix 1:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        // Input for matrix 2
        System.out.println("Enter number of rows for matrix 2:");
        int rows2 = scanner.nextInt();
        System.out.println("Enter number of columns for matrix 2:");
        int cols2 = scanner.nextInt();

        int[][] matrix2 = new int[rows2][cols2];
        System.out.println("Enter elements of matrix 2:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // Check if matrices can be multiplied
        if (cols1 != rows2) {
            System.out.println("Matrices cannot be multiplied. Number of columns in matrix 1 must equal number of rows in matrix 2.");
            return;
        }

        // Initialize result matrix
        int[][] result = new int[rows1][cols2];

        // Perform matrix multiplication
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        // Display the result matrix
        System.out.println("Result of Matrix Multiplication:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
