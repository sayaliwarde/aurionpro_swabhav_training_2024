package com.aurionpro.test;

import com.aurionpro.model.ISayable;

public class SayableTest {
	public static void main(String[] args) {
		
		ISayable sayable=() -> System.out.println("I am inside sayable");	//lambda expression
		
		sayHello(sayable);
		//sayable.say();
			
		}
	private static void sayHello(ISayable sayable) {
		sayable.say();
	}
	}


