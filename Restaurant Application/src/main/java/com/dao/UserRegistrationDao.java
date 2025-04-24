package com.dao;

public interface UserRegistrationDao {
    String insertUser(String username, String password, String email);
}
