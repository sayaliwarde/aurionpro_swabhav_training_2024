package com.aurionpro.array;

import java.util.Scanner;

public class ArrayPrinter {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the size");
		int size=scanner.nextInt();
		int array[]=new int[size];
		System.out.println("enter array elements");
		for(int i=0;i<size;i++)
		
			array[i]=scanner.nextInt();
			System.out.println("array is:");
		
		for(int i=0;i<size;i++)
		
		System.out.print(array[i]+"\t");
		
		
		
		
		
	}

}
