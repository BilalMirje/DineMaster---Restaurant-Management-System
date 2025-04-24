package com.model;

import java.sql.Date;

public class OrderPojo {
    private int orderId;
    private int userId;
    private String username; // Added for fetching user details
    private String item;
    private int quantity;
    private double totalAmount;
    private Date orderDate;
    private String orderStatus;

    // ✅ Default Constructor
    public OrderPojo() {}

    // ✅ Constructor for saving a new order (Without orderId)
    public OrderPojo(int userId, String item, int quantity, double totalAmount, Date orderDate, String orderStatus) {
        this.userId = userId;
        this.item = item;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    // ✅ Constructor for inserting new order (With orderId but without username)
    public OrderPojo(int orderId, int userId, String item, int quantity, double totalAmount, Date orderDate, String orderStatus) {
        this.orderId = orderId;
        this.userId = userId;
        this.item = item;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    // ✅ Constructor that matches getAllOrders (With orderId + username)
    public OrderPojo(int orderId, int userId, String username, String item, int quantity, double totalAmount, Date orderDate, String orderStatus) {
        this.orderId = orderId;
        this.userId = userId;
        this.username = username;
        this.item = item;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    // ✅ Getters
    public int getOrderId() { return orderId; }
    public int getUserId() { return userId; }
    public String getUsername() { return username; } // Getter for username
    public String getItem() { return item; }
    public int getQuantity() { return quantity; }
    public double getTotalAmount() { return totalAmount; }
    public Date getOrderDate() { return orderDate; }
    public String getOrderStatus() { return orderStatus; }

    // ✅ Setters
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public void setUserId(int userId) { this.userId = userId; }
    public void setUsername(String username) { this.username = username; } // Setter for username
    public void setItem(String item) { this.item = item; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }
}
