package com.aurionpro.model;

public class Bitwise {
	public static void main(String[] args) {
		int a = 5;  
        int b = 3;  
 
        // Bitwise AND
        //int andResult = a & b;
        //System.out.println("a & b: " + andResult); 
 
        // Bitwise OR
        //int orResult = a | b;
        //System.out.println("a | b: " + orResult); 
 
        // Bitwise XOR
        //int xorResult = a ^ b;
        //System.out.println("a ^ b: " + xorResult); 
 
        // Bitwise NOT
        int notResult = ~a;
        System.out.println("~a: " + notResult); 
 
        // Left shift
        int leftShiftResult = a << 1;
        System.out.println("a << 1: " + leftShiftResult); 
 
        // Right shift
        int rightShiftResult = a >> 1;
        System.out.println("a >> 1: " + rightShiftResult); 
 
	    		
	}

}
