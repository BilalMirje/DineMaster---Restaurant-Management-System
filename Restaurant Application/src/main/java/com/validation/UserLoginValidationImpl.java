package com.validation;

public class UserLoginValidationImpl implements UserLoginValidation {

	@Override
	public String validate(String username, String password) {
		if (username.length() < 4 || username.length() > 16) {
            return "Invalid Username";
        }
        if (password.length() < 4 || password.length() > 16) {
            return "Invalid Password";
        }
        return "Valid";
	}

}
