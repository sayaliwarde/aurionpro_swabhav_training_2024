package com.aurionpro.test;

import com.aurionpro.model.Demo;

public class DemoTest {
	public static void main(String[] args) {
		System.out.println("for demo1");
		Demo demo1=new Demo();
		demo1.display();
		demo1.increment();
		demo1.display();
		
		System.out.println("for demo 2");
		Demo demo2=new Demo();
		demo2.display();
		demo2.increment();
		demo2.display();
		
		System.out.println("for demo 3");
		Demo demo3=new Demo();
		demo3.display();
		demo3.increment();
		demo3.display();
	}

}
