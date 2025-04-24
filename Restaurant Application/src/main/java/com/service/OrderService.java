package com.service;

import java.sql.Date;
import java.util.List;

import com.model.OrderPojo;

public interface OrderService {
	
	OrderPojo placeOrder(String username, String item, int quantity, double totalAmount, Date orderDate);
	List<OrderPojo> getAllOrders(); // Fetch all orders for admin
    boolean updateOrderStatus(int orderId, String status); // Update order status
}
