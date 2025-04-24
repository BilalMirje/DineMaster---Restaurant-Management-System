package com.service;

import java.sql.Date;
import java.util.List;

import com.dao.OrderDaoImpl;

import com.dao.UserLoginDaoImpl;
import com.model.OrderPojo;
import com.model.UserPojo;

public class OrderServiceImpl implements OrderService {
    private OrderDaoImpl orderDao = new OrderDaoImpl();
    private UserLoginDaoImpl userDao = new UserLoginDaoImpl(); // ✅ Correct DAO

    @Override
    public OrderPojo placeOrder(String username, String item, int quantity, double totalAmount, Date orderDate) {
        UserPojo user = userDao.getUserDetails(username); // ✅ Get user by username
        if (user == null) return null; // ✅ Ensure user exists

        return orderDao.placeOrder(user.getId(), item, quantity, totalAmount, orderDate); // ✅ Pass user ID
    }

	@Override
	public List<OrderPojo> getAllOrders() {
		// TODO Auto-generated method stub
		return orderDao.getAllOrders(); 
	}

	@Override
	public boolean updateOrderStatus(int orderId, String status) {
		// TODO Auto-generated method stub
		return orderDao.updateOrderStatus(orderId, status); 
	}
}
