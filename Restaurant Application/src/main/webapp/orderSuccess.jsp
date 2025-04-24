<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Date"%>
<%@page import="com.model.OrderPojo"%>

<%
    HttpSession userSession = request.getSession();
    OrderPojo order = (OrderPojo) userSession.getAttribute("orderDetails");

    if (order == null) {
%>
        <script>
            alert("No order details found! Redirecting to the menu...");
            window.location.href = "menu.jsp";
        </script>
<%
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Success</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <style>
        .navbar {
            position: fixed;
            top: 0;
            width: 100%;
            z-index: 1000;
            background-color: #fff;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
            padding: 15px 20px;
        }

        body {
            padding-top: 80px;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            text-align: center;
            padding: 20px;
            border-radius: 10px;
            background: #f8f9fa;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        h2 { color: #28a745; }
        
        .navbar-nav .nav-item {
            display: none !important;
        }

        .navbar-nav .nav-item:first-child {
            display: block !important;
        }

        .navbar-nav .nav-item:first-child a {
            display: block !important;
        }

        .book-table-btn {
            display: none !important;
        }
    </style>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            // Hide "Book a Table" button
            let bookTableBtn = document.querySelector(".btn.btn-primary.py-2.px-4");
            if (bookTableBtn) {
                bookTableBtn.style.display = "none";
            }
        });
    </script>
</head>
<body>
    <%@include file="navbar.jsp" %>

    <div class="container">
        <h2>🎉 Order Placed Successfully!</h2>
        <p>Your delicious food is on the way. 🍕🍔</p>

        <h4>📋 Order Summary:</h4>
        <p><strong>Item:</strong> <%= order.getItem() %></p>
        <p><strong>Quantity:</strong> <%= order.getQuantity() %></p>
        <p><strong>Total Price:</strong> ₹<%= order.getTotalAmount() %></p>
        <p><strong>Order Date:</strong> <%= order.getOrderDate() %></p>

        <a href="index.jsp" class="btn btn-primary">Go Home</a>
        <a href="viewOrders.jsp" class="btn btn-secondary">View Orders</a>
    </div>

</body>
</html>
