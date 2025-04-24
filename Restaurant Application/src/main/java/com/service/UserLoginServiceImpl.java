package com.service;

import com.dao.UserLoginDaoImpl;
import com.model.UserPojo;
import com.validation.UserLoginValidationImpl;

public class UserLoginServiceImpl {

    public UserPojo validateUser(String username, String password) {
        UserLoginValidationImpl validation = new UserLoginValidationImpl();
        String validationResult = validation.validate(username, password);

        if (!"Valid".equals(validationResult)) {
            return null;  // Login failed, return null
        }

        UserLoginDaoImpl loginDao = new UserLoginDaoImpl();
        return loginDao.checkUserLogin(username, password); // Return full user details
    }
}
