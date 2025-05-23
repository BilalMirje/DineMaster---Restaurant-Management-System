package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.ServiceModuleServiceImpl;

@WebServlet("/ServiceModuleServlet1")
public class ServiceModuleServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		String iconname=request.getParameter("iconname");
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		
		ServiceModuleServiceImpl serviceModuleServiceImpl=new ServiceModuleServiceImpl();
		String result=serviceModuleServiceImpl.validateService(iconname, title, description);
		
		if (result.equals("Valid")) {
			//forward
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("ServiceModuleServlet2");
			requestDispatcher.forward(request, response);
		}
		else {
			session.setAttribute("msg", result);
			response.sendRedirect("addService.jsp");
		}
	}

}
