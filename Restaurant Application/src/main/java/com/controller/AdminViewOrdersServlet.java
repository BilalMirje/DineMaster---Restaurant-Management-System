package com.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.model.OrderPojo;
import com.service.OrderServiceImpl;

@WebServlet("/AdminViewOrdersServlet")
public class AdminViewOrdersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 HttpSession session = request.getSession();
         OrderServiceImpl orderService = new OrderServiceImpl();

         System.out.println("Step 4: Calling getAllOrders()...");

         List<OrderPojo> orderList = orderService.getAllOrders();

         System.out.println("Step 5: Orders Retrieved in Servlet: " + orderList.size());

         // Debugging output
         for (OrderPojo order : orderList) {
             System.out.println("Step 6: Order ID: " + order.getOrderId() + ", User: " + order.getUsername() + ", Item: " + order.getItem());
         }

         session.setAttribute("orderList", orderList);
         response.sendRedirect("viewOrders.jsp");
    }
}
