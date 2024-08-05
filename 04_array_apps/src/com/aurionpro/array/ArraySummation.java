package com.aurionpro.array;

import java.util.Scanner;

public class ArraySummation {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the size");
		int size=scanner.nextInt();
		int array[]=new int[size];
		System.out.println("enter array elements");
		int sum=0;
		int i;
		for( i=0;i<size;i++) 
		{		
		array[i]=scanner.nextInt();
		sum+=array[i];
		
	   }
		System.out.print("The sum is:" +sum);
			
			
			
		
			
		
		
		

				
	}
	
	
	

}
