package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.ContactServiceImpl;

@WebServlet("/ContactServlet1")
public class ContactServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String result;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String subject=request.getParameter("subject");
		String message=request.getParameter("message");
		
		ContactServiceImpl contactServiceImpl=new ContactServiceImpl();
		result=contactServiceImpl.contactService1(name, email, subject, message);
		
		if (result.equals("Valid"))
		 {
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("ContactServlet2");
			requestDispatcher.forward(request, response); 
		}
		else {
			session.setAttribute("msg", result);
			response.sendRedirect("contact.jsp");
		}
	}

}
