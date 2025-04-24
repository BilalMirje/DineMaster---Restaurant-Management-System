package com.service;

import java.util.ArrayList;

import com.dao.MenuDaoImpl;
import com.model.MenuPojo;

public class MenuServiceImpl implements MenuService {
	 private MenuDaoImpl menuDao = new MenuDaoImpl();
	@Override
	public String addMenuItem(MenuPojo menu) {
		 boolean success = menuDao.addMenuItem(menu);
	        return success ? "Menu Item Added Successfully!" : "Failed to Add Menu Item!";
	}

	@Override
	public ArrayList<MenuPojo> getAllMenuItems() {
		return menuDao.getAllMenuItems();
	}

	@Override
	public boolean deleteMenuItem(int id) {
		return menuDao.deleteMenuItem(id);
	}

}
