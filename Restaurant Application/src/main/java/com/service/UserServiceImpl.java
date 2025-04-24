package com.service;

import com.dao.UserLoginDaoImpl;
import com.model.UserPojo;

public class UserServiceImpl implements UserService {

	@Override
	public UserPojo getUserDetails(String username) {
		UserLoginDaoImpl userDao = new UserLoginDaoImpl();
		
		 return userDao.getUserDetails(username);
	}

}
