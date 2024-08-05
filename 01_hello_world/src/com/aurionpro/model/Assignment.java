package com.aurionpro.model;

public class Assignment {
	public static void main(String[] args) {
		 int a = 10;
	        int b = 5;
	 
	        // Simple assignment
	        int c = a;
	        System.out.println("c = a: " + c); 
	 
	        // Add and assign
	        c += a;
	        System.out.println("c += a: " + c); 
	 
	        // Subtract and assign
	        c -= a;
	        System.out.println("c -= a: " + c); 
	 
	        // Multiply and assign
	        c *= a;
	        System.out.println("c *= a: " + c); 
	 
	        // Divide and assign
	        c /= a;
	        System.out.println("c /= a: " + c); 
	 
	        // Modulus and assign
	        c %= b;
	        System.out.println("c %= b: " + c); 
	 
	        // Left shift and assign
	        c <<= 2;
	        System.out.println("c <<= 2: " + c); 
	 
	        // Right shift and assign
	        c >>= 1;
	        System.out.println("c >>= 1: " + c); 
	 
	        // Bitwise AND and assign
	        c &= b;
	        System.out.println("c &= b: " + c); 
	 
	        // Bitwise OR and assign
	        c |= a;
	        System.out.println("c |= a: " + c); 
	 
	        // Bitwise XOR and assign
	        c ^= b;
	        System.out.println("c ^= b: " + c); 
	    }
	}