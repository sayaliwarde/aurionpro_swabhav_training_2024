package com.aurionpro.exception;

public class PasswordNotValidException extends RuntimeException {
	private String password;

	public PasswordNotValidException(String password) {
	
		this.password = password;
	}
	public String getMessage() 
	{
		return "Password validation failed. Password must contain an uppercase, a special character and a number ";
	}
	

}
