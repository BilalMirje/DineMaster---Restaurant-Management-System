package com.dao;

import java.util.ArrayList;
import com.model.MenuPojo;

public interface MenuDao {
    boolean addMenuItem(MenuPojo menu);
    ArrayList<MenuPojo> getAllMenuItems();
    public boolean deleteMenuItem(int id);
}
