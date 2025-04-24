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

@WebServlet("/ReadMenuServlet")
public class ReadMenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
        MenuServiceImpl menuService = new MenuServiceImpl();
        ArrayList<MenuPojo> menuList = menuService.getAllMenuItems();

        // Debugging - Check if menu items are retrieved
        System.out.println("Fetched Menu Items: " + menuList.size());

        session.setAttribute("menuData", menuList);
        response.sendRedirect("menu.jsp");
    }
}
