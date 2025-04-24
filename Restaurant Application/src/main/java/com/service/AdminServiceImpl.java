package com.service;

import com.dao.AdminLoginDaoImpl;

public class AdminServiceImpl {

    public String changePassword(String username, String oldPassword, String newPassword) {
        AdminLoginDaoImpl adminDao = new AdminLoginDaoImpl();
        return adminDao.updateAdminPassword(username, oldPassword, newPassword);
    }
}
