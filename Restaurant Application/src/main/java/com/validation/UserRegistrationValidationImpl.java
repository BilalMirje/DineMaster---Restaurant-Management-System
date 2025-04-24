package com.validation;

public class UserRegistrationValidationImpl implements UserRegistrationValidation {

	@Override
	public String validate(String username, String password, String email) {
		 if (username.length() < 4 || username.length() > 16) {
	            return "Invalid Username";
	        }
	        if (password.length() < 4 || password.length() > 16) {
	            return "Invalid Password";
	        }
	        if (!email.contains("@") || !email.contains(".")) {
	            return "Invalid Email";
	        }
	        return "Valid";
	}

}
