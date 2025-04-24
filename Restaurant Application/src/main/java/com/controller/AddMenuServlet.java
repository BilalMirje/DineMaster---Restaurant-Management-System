package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.model.MenuPojo;
import com.service.MenuServiceImpl;

@WebServlet("/AddMenuServlet")
public class AddMenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String itemName = request.getParameter("item_name");
        String description = request.getParameter("description");
        String priceStr = request.getParameter("price");
        String imageUrl = request.getParameter("image_url");
        String category = request.getParameter("category");

        if (itemName.isEmpty() || description.isEmpty() || priceStr.isEmpty() || imageUrl.isEmpty() || category.isEmpty()) {
            session.setAttribute("msg", "All fields are required!");
            response.sendRedirect("addMenu.jsp");
            return;
        }

        try {
            double price = Double.parseDouble(priceStr);
            MenuPojo menu = new MenuPojo(0, itemName, description, price, imageUrl, category);
            MenuServiceImpl menuService = new MenuServiceImpl();
            String result = menuService.addMenuItem(menu);

            if (result.equals("Menu Item Added Successfully")) {
                // Fetch the updated menu list and update session
                ArrayList<MenuPojo> updatedMenuList = menuService.getAllMenuItems();
                session.setAttribute("menuData", updatedMenuList);
            }

            session.setAttribute("msg", result);
        } catch (NumberFormatException e) {
            session.setAttribute("msg", "Invalid price format!");
            e.printStackTrace();
        }

        response.sendRedirect("addMenu.jsp");
    }

}
