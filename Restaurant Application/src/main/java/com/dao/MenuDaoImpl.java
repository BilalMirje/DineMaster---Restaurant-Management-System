package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.MenuPojo;

public class MenuDaoImpl implements MenuDao {



	@Override
	public boolean addMenuItem(MenuPojo menu) {
		 try (Connection connection = ConnectionFactory.getConnection()) {
		        String sql = "INSERT INTO menu (item_name, description, price, image_url, category) VALUES (?, ?, ?, ?, ?)";
		        PreparedStatement ps = connection.prepareStatement(sql);
		        ps.setString(1, menu.getItemName());
		        ps.setString(2, menu.getDescription());
		        ps.setDouble(3, menu.getPrice());
		        ps.setString(4, menu.getImageUrl());
		        ps.setString(5, menu.getCategory());

		        int rowsAffected = ps.executeUpdate();
		        System.out.println("Rows Inserted: " + rowsAffected);  // Debugging line

		        return rowsAffected > 0;
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return false;
	}

	@Override
	public ArrayList<MenuPojo> getAllMenuItems() {
		ArrayList<MenuPojo> menuList = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM menu";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MenuPojo menu = new MenuPojo(
                    rs.getInt("id"),
                    rs.getString("item_name"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getString("image_url"),
                    rs.getString("category")
                );
                menuList.add(menu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuList;
	}

	@Override
	public boolean deleteMenuItem(int id) {
		 try (Connection connection = ConnectionFactory.getConnection()) {
	            String sql = "DELETE FROM menu WHERE id=?";
	            PreparedStatement ps = connection.prepareStatement(sql);
	            ps.setInt(1, id);
	            return ps.executeUpdate() > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return false;
	}

}
