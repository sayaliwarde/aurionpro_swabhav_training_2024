package com.aurionpro.exception;

public class EmailNotValidException extends RuntimeException {
	private String email;

	public EmailNotValidException(String email) {
	
		this.email = email;
	}
	public String getMessage() 
	{
		return "Email validation failed. Check if your email id contains @ or .com";
	}
	
     
    

}
