package com.validation;

public class ServiceModuleValidationImpl implements ServiceModuleValidation {
	private String result;
	@Override
	public String serviceModuleValidation(String iconname, String title, String description) {
		
		int iconname_len=iconname.length();
		int title_len=title.length();
		int description_len=description.length();
		
		try {
			if (iconname_len<4 || iconname_len>30) {
				result="Invalid Icon Name";
			}
			else if (title_len<4 || title_len>18) {
				result="Invalid Title";

			}
			else if (description_len<30 || description_len>75) {
				result="Invalid Description";

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
