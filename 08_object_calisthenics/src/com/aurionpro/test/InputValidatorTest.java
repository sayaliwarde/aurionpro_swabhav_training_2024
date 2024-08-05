package com.aurionpro.test;
import java.util.Scanner;

import com.aurionpro.model.InputValidator;

public class InputValidatorTest {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		InputValidator inputvalidator=new InputValidator();
		System.out.println("Enter username:");
		String username=scanner.next();
		if(inputvalidator.validateUsername(username)){
			return;
		}
		
		
		
	}

}
