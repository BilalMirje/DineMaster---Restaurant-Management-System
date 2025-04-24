package com.validation;

public class AdminLoginValidationImpl implements AdminLoginValidation {
	private String result;
	@Override
	public String adminLoginValidation(String username, String password) {
		
		int user_length=username.length();
		int pass_length=password.length();
		
	
		try {
			if (user_length<4 || user_length>16) {
				result="Invalid Username";
			}
			else if (pass_length<4 || pass_length>16) {
				result="Invalid Password";
			}
			else {
				result="Valid";

			}
		} 
		catch (Exception e) {
			result="Something Went Wrong!!";
			e.printStackTrace();	
			
		}
		return result;
	}

}
