package com.aurionpro.util;

public class PasswordUtil {

    public static boolean isValidPassword(String password) {
        if (password == null || password.length() != 8) {
            return false;
        }
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isLowerCase(c)) hasLower = true;
            if (Character.isDigit(c)) hasDigit = true;
            if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public static boolean verifyPassword(String inputPassword, String storedPassword) {
        // For hardcoded passwords, just compare directly
        return storedPassword.equals(inputPassword);
    }
}
