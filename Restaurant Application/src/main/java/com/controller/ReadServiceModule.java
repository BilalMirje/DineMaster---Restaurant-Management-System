package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.ServiceModulePojo;
import com.service.ServiceModuleServiceImpl;

@WebServlet("/ReadServiceModule")
public class ReadServiceModule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		ServiceModuleServiceImpl serviceModuleServiceImpl=new ServiceModuleServiceImpl();
		ArrayList<ServiceModulePojo> arrayList=serviceModuleServiceImpl.readService();
		session.setAttribute("check", "FromServlet");
		
		
		if (arrayList==null) {
			session.setAttribute("msg", "Something Went Wrong : Service Layer");
			response.sendRedirect("service.jsp");
		}
		else if (arrayList.isEmpty()) {
			session.setAttribute("msg", "Something Went Wrong : Dao Layer");
			response.sendRedirect("service.jsp");
		}
		else {
			String dateTime=arrayList.get(0).getDateTime();
			if (dateTime.equals("NA")) {
				session.setAttribute("msg", "Data Does Not Exist");
				response.sendRedirect("service.jsp");
			}
			else {
				session.setAttribute("servicedata", arrayList);
				response.sendRedirect("service.jsp");
			}
		}
	}

}
