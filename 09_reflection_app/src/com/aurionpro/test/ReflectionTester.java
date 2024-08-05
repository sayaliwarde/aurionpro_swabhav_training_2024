package com.aurionpro.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionTester {
	public static void main(String[] args) throws ClassNotFoundException {
		Class stringClass=Class.forName("java.lang.String");
		System.out.println(stringClass.getName());
		System.out.println(stringClass.getSimpleName());
		System.out.println(stringClass.getSuperclass());
		
		System.out.println("methods");
		Method stringMethods[]=stringClass.getMethods();
		for(Method method: stringMethods) {
			System.out.println(method.getName());
		}
		
		System.out.println("constructor:");
		Constructor stringConstructors[]=stringClass.getConstructors();
		for(Constructor constructor:stringConstructors) {
			Parameter parameters[]=constructor.getParameters();
			
		}
	}
	

}

