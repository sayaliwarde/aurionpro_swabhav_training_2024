package com.aurionpro.test;

public class Test {
	public static void main(String[] args) {
		int number1 =Integer.parseInt(args[0]);
		int number2=Integer.parseInt(args[1]);
		
		try {
		double result=number1/number2;
		
		System.out.println("Division is: "+result);
		}
		catch(ArithmeticException exception) {
			System.out.println("Invalid Input. Check the input values.Input values cannot be zero.");
		}
		catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("Division requires two values. Please enter two values.");
		}
		catch(NumberFormatException exception) {
			System.out.println("Division can be performed only on numbers. Please enter number values.");
		}
		catch(Exception exception) {
			System.out.println("Exception occured.");
		}
		finally {
			System.out.println("Inside Finally.");
		}
		
		System.out.println("Exit.");
		
	}

}
