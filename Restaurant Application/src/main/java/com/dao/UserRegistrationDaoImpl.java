package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserRegistrationDaoImpl implements UserRegistrationDao {

	@Override
	public String insertUser(String username, String password, String email) {
		try {
            Connection connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            int result = ps.executeUpdate();

            if (result > 0) {
                return "Registration Successful";
            } else {
                return "Registration Failed";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Database Error";
        }
	}

}
