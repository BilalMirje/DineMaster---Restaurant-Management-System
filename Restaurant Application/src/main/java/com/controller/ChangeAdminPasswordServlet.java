package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.AdminServiceImpl;

@WebServlet("/ChangeAdminPasswordServlet")
public class ChangeAdminPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("adminlogin"); // Fetch username from session
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        if (username == null) {
            session.setAttribute("msg", "Session expired. Please log in again.");
            response.sendRedirect("adminlogin.jsp");
            return;
        }

        AdminServiceImpl adminService = new AdminServiceImpl();
        String result = adminService.changePassword(username, oldPassword, newPassword);

        if (result.equals("Password Changed Successfully")) {
            session.setAttribute("msg", "Password updated successfully. Please log in again.");
            session.invalidate(); // Logout after password change
            response.sendRedirect("adminlogin.jsp");
        } else {
            session.setAttribute("msg", result);
            response.sendRedirect("changeAdminPassword.jsp");
        }
    }
}
