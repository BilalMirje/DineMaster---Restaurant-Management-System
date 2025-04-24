package com.controller;

import com.model.ServiceModulePojo;
import com.service.ServiceModuleService;
import com.service.ServiceModuleServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/UpdateServiceServlet")
public class UpdateServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServiceModuleService serviceModuleService = new ServiceModuleServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String icon = request.getParameter("icon");
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        ServiceModulePojo service = new ServiceModulePojo(id, icon, title, description, description);
        service.setId(id);
        service.setIconname(icon);
        service.setTitle(title);
        service.setDescription(description);

        String result = serviceModuleService.updateService(service);
        request.getSession().setAttribute("message", result);

        // 🔴 Refresh session data after update
        ArrayList<ServiceModulePojo> updatedList = serviceModuleService.readService();
        request.getSession().setAttribute("servicedata", updatedList);

        // Redirecting to JSP to show updated services
        response.sendRedirect("readService.jsp");
    }
}