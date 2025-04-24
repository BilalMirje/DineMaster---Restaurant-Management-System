package com.service;

import java.util.ArrayList;
import com.model.MenuPojo;

public interface MenuService {
    String addMenuItem(MenuPojo menu);
    ArrayList<MenuPojo> getAllMenuItems();
    public boolean deleteMenuItem(int id);
}
