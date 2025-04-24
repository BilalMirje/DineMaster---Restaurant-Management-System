package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.ContactPojo;
import com.service.ContactServiceImpl;

@WebServlet("/ReadMessageServlet")
public class ReadMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ContactServiceImpl contactServiceImpl=new ContactServiceImpl();
		ArrayList<ContactPojo> arrayList=contactServiceImpl.readContactService();
		//Pojo : Data Exist
		//clear : Dao :Exception , Data Not Exist
		//null : Service Exception
		
		if (arrayList==null) {
			session.setAttribute("msg", "Something Went Wrong : Service Layer");
			response.sendRedirect("admin.jsp");
		}
		else if (arrayList.isEmpty()) {
			session.setAttribute("msg", "Something Went Wrong : Dao Layer");
			response.sendRedirect("admin.jsp");
		}
		else {
			String dateTime=arrayList.get(0).getDateTime();
			if (dateTime.equals("NA")) {
				session.setAttribute("msg", "Data Does Not Exist");
				response.sendRedirect("admin.jsp");
			}
			else {
				session.setAttribute("contactdata", arrayList);
				response.sendRedirect("readContact.jsp");
			}
		}
	}

}
