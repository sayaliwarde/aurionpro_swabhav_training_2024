package com.aurionpro.model;

public class InputValidator {
	public String username;
	public String password;
	public String emailId;

	
//	public InputValidator(String username, String password, String emailId) {
//		this.username=username;
//		this.password=password;
//		this.emailId=emailId;
//	}
	public boolean validateUsername(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        int length = username.length();
        return length >= 3 && length <= 20;
    }
	
	public boolean validatePassword(String password) {
		if (password == null || password.isEmpty()) {
	        return false;
	     }
	     int length = password.length();
	     return length >= 8 && length <= 30;
	}
	public boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        int length = email.length();
        return length >= 5 && length <= 50 && email.contains("@") && email.contains(".");
    }
	public boolean validateLength(int length) {
		return false;
		
	}

}


	

	


