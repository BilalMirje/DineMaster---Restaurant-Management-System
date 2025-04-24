package com.validation;

public class ContactValidationImpl implements ContactValidation {
	
	private String result;
	@Override
	public String contactValidation(String name, String email, String subject, String message) {

		int name_length=name.length();
		int email_length=email.length();
		int subject_length=subject.length();
		int message_length=message.length();
		
		try {
			if (name_length<2 || name_length>50) {
				result="Invalid Name";
			}
			else if (email_length<10 || email_length>30 || !email.contains("@")) {
				result="Invalid Email";

			}
			else if (subject_length<10 || subject_length>70) {
				result="Invalid Subject";

			}
			else if (message_length<10 || message_length>500) {
				result="Invalid Message";

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
