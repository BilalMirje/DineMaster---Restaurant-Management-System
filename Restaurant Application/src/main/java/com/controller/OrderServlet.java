package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.model.OrderPojo;
import com.model.UserPojo;
import com.service.OrderServiceImpl;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        // Ensure user is logged in
        UserPojo user = (UserPojo) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("userLogin.jsp?message=Please log in to order");
            return;
        }
        
        String username = user.getUsername(); // Assuming UserPojo has getUsername() method
        
        try {
            // Get form data
            String item = request.getParameter("item");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            double price = Double.parseDouble(request.getParameter("price"));
            double totalAmount = quantity * price;
            Date orderDate = Date.valueOf(LocalDate.now());

            // Call Service Layer
            OrderServiceImpl orderService = new OrderServiceImpl();
            OrderPojo order = orderService.placeOrder(username, item, quantity, totalAmount, orderDate);

            if (order != null) {
                // Store order details in session for display on orderSuccess.jsp
                session.setAttribute("orderDetails", order);
                response.sendRedirect("orderSuccess.jsp");
            } else {
                session.setAttribute("msg", "Failed to place order!");
                response.sendRedirect("menu.jsp");
            }
        } catch (NumberFormatException e) {
            session.setAttribute("msg", "Invalid input values!");
            response.sendRedirect("menu.jsp");
        }
    }
}
