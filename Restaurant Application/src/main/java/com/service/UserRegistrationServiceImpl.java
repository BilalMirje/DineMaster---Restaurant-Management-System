package com.service;

import com.dao.UserRegistrationDaoImpl;
import com.validation.UserRegistrationValidationImpl;

public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Override
	public String registerUser(String username, String password, String email) {
		UserRegistrationValidationImpl validation = new UserRegistrationValidationImpl();
        String validationResult = validation.validate(username, password, email);

        if (!"Valid".equals(validationResult)) {
            return validationResult;
        }

        UserRegistrationDaoImpl registrationDao = new UserRegistrationDaoImpl();
        return registrationDao.insertUser(username, password, email);
	}
		
}
