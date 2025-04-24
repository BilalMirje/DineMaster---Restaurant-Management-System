package com.service;

import com.dao.AdminLoginDaoImpl;
import com.validation.AdminLoginValidationImpl;

public class AdminLoginServiceImpl implements AdminLoginService {
	private String result;
	@Override
	public String adminLoginService1(String username, String password) {
		try {
			AdminLoginValidationImpl adminLoginValidationImpl=new AdminLoginValidationImpl();
			result =adminLoginValidationImpl.adminLoginValidation(username, password);
			
		}
		catch (Exception e) {
			e.printStackTrace();	
			result="Service Error";
		}
		return result;
	}
	@Override
	public String adminLoginService2(String username, String password) {
		try {
			//DAO
			AdminLoginDaoImpl adminLoginDaoImpl=new AdminLoginDaoImpl();
			result=adminLoginDaoImpl.checkAdminLoginData(username, password);  
			
			
		}
		catch (Exception e) {
			e.printStackTrace();	
			result="Service Error";
		}
		return result;
	}

}
