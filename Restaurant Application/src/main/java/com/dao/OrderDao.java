package com.dao;

import java.sql.Date;
import java.util.List;

import com.model.OrderPojo;

public interface OrderDao {
	 public String saveOrder(String username, String item, int quantity, double totalAmount);
	 OrderPojo placeOrder(int userId, String item, int quantity, double totalAmount, Date orderDate);
	 public List<OrderPojo> getAllOrders();
	 public boolean updateOrderStatus(int orderId, String status);
}
