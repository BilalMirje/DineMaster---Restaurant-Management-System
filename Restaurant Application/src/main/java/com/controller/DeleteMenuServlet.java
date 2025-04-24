package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.service.MenuServiceImpl;

@WebServlet("/DeleteMenuServlet")
public class DeleteMenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String idStr = request.getParameter("id");

        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            MenuServiceImpl menuService = new MenuServiceImpl();
            boolean success = menuService.deleteMenuItem(id);

            if (success) {
                session.setAttribute("msg", "Menu Item Deleted Successfully!");
            } else {
                session.setAttribute("msg", "Failed to Delete Menu Item.");
            }
        } else {
            session.setAttribute("msg", "Invalid Menu ID.");
        }

        response.sendRedirect("viewMenu.jsp");
    }
}
