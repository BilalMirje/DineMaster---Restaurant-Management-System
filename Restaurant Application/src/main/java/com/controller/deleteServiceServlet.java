package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.ServiceModuleServiceImpl;

@WebServlet("/deleteServiceServlet")
public class deleteServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String id=request.getParameter("id");
		
		ServiceModuleServiceImpl serviceModuleServiceImpl=new ServiceModuleServiceImpl();
		String result=serviceModuleServiceImpl.deleteService(id);
		
		session.setAttribute("msg", result);
		response.sendRedirect("ReadServiceDeleteUpdate");
		
	}
	

}
