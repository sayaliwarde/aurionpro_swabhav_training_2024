package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Rectangle;

public class RectangleTest {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the height:");
		
		int h=scanner.nextInt();
		System.out.println("enter the width:");
		int w=scanner.nextInt();
		


				Rectangle rectangle=new Rectangle();

			
				rectangle.initialize(h,w);
				rectangle.display();
				rectangle.calculateArea();
		

			}

		
	}


