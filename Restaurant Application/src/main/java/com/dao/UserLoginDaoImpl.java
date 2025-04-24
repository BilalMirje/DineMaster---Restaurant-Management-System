package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.UserPojo;

public class UserLoginDaoImpl implements UserLoginDao {

    @Override
    public UserPojo checkUserLogin(String username, String password) {
        UserPojo user = null;
        try {
            Connection connection = ConnectionFactory.getConnection();
            String sql = "SELECT id, username, email FROM users WHERE username=? AND password=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new UserPojo(
                    rs.getInt("id"), // Fetch user ID
                    rs.getString("username"),
                    rs.getString("email")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public UserPojo getUserDetails(String username) {
        UserPojo user = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT id, username, email FROM users WHERE username=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new UserPojo(
                    rs.getInt("id"), // Fetch user ID
                    rs.getString("username"),
                    rs.getString("email")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
