package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.ContactServiceImpl;

@WebServlet("/DeleteContactServlet")
public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		String id=request.getParameter("id");
		
		ContactServiceImpl contactServiceImpl=new ContactServiceImpl();
		String result=contactServiceImpl.deleteService(id);
		
		session.setAttribute("msg", result);
		response.sendRedirect("ReadMessageServlet");
	}

}
