package com.dao;

import com.model.UserPojo;

public interface UserLoginDao {
    UserPojo checkUserLogin(String username, String password);  // ✅ Ensure correct return type
    UserPojo getUserDetails(String username);
}
