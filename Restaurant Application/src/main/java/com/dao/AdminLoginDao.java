package com.dao;

public interface AdminLoginDao {
	public String checkAdminLoginData(String username,String password);
	public String updateAdminPassword(String username, String oldPassword, String newPassword);

}
