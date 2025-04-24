package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDaoImpl implements AdminLoginDao {
	private String result;
	@Override
	public String checkAdminLoginData(String username, String password) {
		try {
			Connection connection=ConnectionFactory.getConnection();
			String sql="select * from adminlogin where username=? and password=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				result="Exist";
			}
			else {
				result="Not Exist"; 
			}

		} 
		catch (Exception e) {
			result="Failed";
			e.printStackTrace();
			
		}
		
		return result;
	}
	@Override
	public String updateAdminPassword(String username, String oldPassword, String newPassword) {
		 try {
	            Connection connection = ConnectionFactory.getConnection();

	            // Step 1: Verify old password
	            String checkSql = "SELECT * FROM adminlogin WHERE username=? AND password=?";
	            PreparedStatement checkStmt = connection.prepareStatement(checkSql);
	            checkStmt.setString(1, username);
	            checkStmt.setString(2, oldPassword);
	            ResultSet resultSet = checkStmt.executeQuery();

	            if (!resultSet.next()) {
	                return "Incorrect Old Password!";
	            }

	            // Step 2: Update password
	            String updateSql = "UPDATE adminlogin SET password=? WHERE username=?";
	            PreparedStatement updateStmt = connection.prepareStatement(updateSql);
	            updateStmt.setString(1, newPassword);
	            updateStmt.setString(2, username);
	            int updated = updateStmt.executeUpdate();

	            return (updated > 0) ? "Password Changed Successfully" : "Password Update Failed";

	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Error Occurred!";
	        }
	}
	
}
