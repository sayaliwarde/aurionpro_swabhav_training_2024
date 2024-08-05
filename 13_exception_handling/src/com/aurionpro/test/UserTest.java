package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.exception.EmailNotValidException;
import com.aurionpro.exception.PasswordNotValidException;
import com.aurionpro.model.User;

public class UserTest {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        try {
            validateEmail(email);
            validatePassword(password);

            User user = new User(email, password);	//obj
            System.out.println("User created successfully with email: " + user.getEmail());
        } 
        catch (EmailNotValidException exception) {
            System.out.println(exception.getMessage());
        } 
        catch (PasswordNotValidException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void validateEmail(String email) throws EmailNotValidException { //methods
        if (!email.contains("@") || !email.contains(".")) {
            throw new EmailNotValidException("Email address is not valid");
        }
    }

    private static void validatePassword(String password) throws PasswordNotValidException {
        if (password.length() < 8 ||
                !password.matches(".*[A-Z].*") ||
                !password.matches(".*[0-9].*") ||
                !password.matches(".*[!@#$%^&*()].*")) {
            throw new PasswordNotValidException("Password is not valid");
        }

}
}
