package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.model.UserPojo;
import com.service.UserLoginServiceImpl;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserLoginServiceImpl loginService = new UserLoginServiceImpl();
        UserPojo user = loginService.validateUser(username, password);

        if (user != null) {
            session.setAttribute("user", user); // Store full user object
            response.sendRedirect("index.jsp");
        } else {
            session.setAttribute("msg", "Invalid username or password!");
            response.sendRedirect("userLogin.jsp");
        }
    }
}
