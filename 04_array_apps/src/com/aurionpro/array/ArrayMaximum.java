package com.aurionpro.array;

import java.util.Scanner;

public class ArrayMaximum {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		//input size
		System.out.println("enter the size");
		int size=scanner.nextInt();
		//array 
		int array[]=new int[size];
		//array elements
		System.out.println("enter array elements");
		for( int i=0;i<size;i++) 
		{		
		array[i]=scanner.nextInt();	
		System.out.print(array[i]);
		}
		int max=0;
		for(int i=0;i<size;i++) {
			if (array[i]>max) {
				System.out.print("max=" +array[i]);
			}
			else {
				System.out.println("invalid number");
			}
		}
		
		
		


}
}
