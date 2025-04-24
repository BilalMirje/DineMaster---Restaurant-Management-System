package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.AdminLoginServiceImpl;

@WebServlet("/AdminLoginServlet2")
public class AdminLoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession session=request.getSession();
		
    	String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		AdminLoginServiceImpl adminLoginServiceImpl=new AdminLoginServiceImpl();   
		String result=adminLoginServiceImpl.adminLoginService2(username, password);
		
		if (result.equals("Exist")) {
			//ADMIN PANEL
			session.setAttribute("adminlogin", username	);
			response.sendRedirect("admin.jsp"); 

		}
		else {
			session.setAttribute("msg", result);
			response.sendRedirect("adminlogin.jsp"); 
		}
		
	} 

}
