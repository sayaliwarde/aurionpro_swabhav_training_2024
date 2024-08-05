package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Box;

public class BoxTest {

	public static void main(String[] args) {
		Box box1=new Box(); //obj creation //default constructor is called
		//System.out.println("width"+box.getWidth());
		//System.out.println(box.getDepth());
		
		//Scanner scanner=new Scanner(System.in);
		//System.out.println("enter the height");
		//int height=scanner.nextInt();
		//box.setHeight(height);
		
		//System.out.println("enter the width");
		//int width=scanner.nextInt();
		//box.setWidth(width);
		System.out.println("Box 1");
		System.out.println("the height is:"+box1.getHeight());
		
		
		System.out.println("the width is:"+box1.getWidth());
		
		
		System.out.println("the depth is:" +box1.getDepth());
		
		
		Box box2=new Box(10,20,30); //parameterized constructor gets called
//		//Scanner scanner=new Scanner(System.in);
//		//System.out.println("enter the height");
//		int height=scanner.nextInt();
//		box2.setHeight(height);
		
//		System.out.println("enter the width");
//		int width=scanner.nextInt();
//		box2.setWidth(width);
//		
//		System.out.println("depth"+box2.getDepth());
//		int depth=scanner.nextInt();
//		System.out.println(box2.getDepth());
		
		System.out.println("Box 2");
		System.out.println("the height is:"+box2.getHeight());
		
		
		System.out.println("the width is:"+box2.getWidth());
		
		
		System.out.println("the depth is:"+box2.getDepth());
		
	}

		
		
	
		


	}


