package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.OrderPojo;

public class OrderDaoImpl implements OrderDao {

	@Override
	public String saveOrder(String username, String item, int quantity, double totalAmount) {
		 String result;
		 try (Connection conn = ConnectionFactory.getConnection()) {
	            String sql = "INSERT INTO orders (user_id, username, item, quantity, total_amount, order_date, order_status) " +
	                         "VALUES ((SELECT id FROM users WHERE username=?), ?, ?, ?, ?, CURRENT_DATE, 'Pending')";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, username);
	            ps.setString(2, username); // Store username
	            ps.setString(3, item);
	            ps.setInt(4, quantity);
	            ps.setDouble(5, totalAmount);

	            int rows = ps.executeUpdate();
	            result = (rows > 0) ? "Order placed successfully!" : "Order failed!";
	        } catch (SQLException e) {
	            e.printStackTrace();
	            result = "Database error!";
	        }
	        return result;
	}

	@Override
	public OrderPojo placeOrder(int userId, String item, int quantity, double totalAmount, Date orderDate) {
		
		OrderPojo order = null;
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO orders (user_id, item, quantity, total_amount, order_date) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, userId);  // ✅ Use userId instead of username
            preparedStatement.setString(2, item);
            preparedStatement.setInt(3, quantity);
            preparedStatement.setDouble(4, totalAmount);
            preparedStatement.setDate(5, orderDate);

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int orderId = generatedKeys.getInt(1);
                    order = new OrderPojo(orderId, userId, item, quantity, totalAmount, orderDate, "Pending");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (connection != null) connection.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return order;
	}

	@Override
	public List<OrderPojo> getAllOrders() {
		List<OrderPojo> orderList = new ArrayList<>();
		Connection conn = null;

		try {
	        conn = ConnectionFactory.getConnection();
	        String sql = "SELECT o.order_id, o.user_id, u.username, o.item, o.quantity, o.total_amount, o.order_date, o.order_status " +
	                     "FROM orders o JOIN users u ON o.user_id = u.id";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            OrderPojo order = new OrderPojo(
	                rs.getInt("order_id"),
	                rs.getInt("user_id"),
	                rs.getString("username"), // Ensure username is fetched
	                rs.getString("item"),
	                rs.getInt("quantity"),
	                rs.getDouble("total_amount"),
	                rs.getDate("order_date"),
	                rs.getString("order_status")
	            );

	            // Debug: Print fetched order
	          //  System.out.println("Fetched Order: " + order.getOrderId() + " | " + order.getUsername() + " | " + order.getItem());

	            orderList.add(order);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	    }

	    return orderList;

	}

	@Override
	public boolean updateOrderStatus(int orderId, String status) {
		 try {
	            Connection connection = ConnectionFactory.getConnection();
	            String sql = "UPDATE orders SET order_status = ? WHERE order_id = ?";
	            PreparedStatement ps = connection.prepareStatement(sql);
	            ps.setString(1, status);
	            ps.setInt(2, orderId);

	            int rowsUpdated = ps.executeUpdate();
	            return rowsUpdated > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	}

}
