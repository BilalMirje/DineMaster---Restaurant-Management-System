<%@page import="java.util.List"%>
<%@page import="com.model.OrderPojo"%>
<%
    String check = (String) session.getAttribute("adminlogin");
    if (check == null) {
        response.sendRedirect("adminlogin.jsp");
        return;
    }

    List<OrderPojo> orderList = (List<OrderPojo>) session.getAttribute("orderList");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="refresh" content="5"> <!-- Refresh every 5					 seconds -->
    <title>Admin Panel - View Orders</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: white; margin: 0; padding: 0; }
        header { background-color: #f7d33e; padding: 15px; text-align: center; font-size: 24px; }
        nav ul { list-style-type: none; padding: 0; text-align: center; background: #fff; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); }
        nav ul li { display: inline; margin: 0 15px; }
        nav ul li a { text-decoration: none; color: #333; font-size: 18px; padding: 8px 15px; transition: background 0.3s ease; }
        nav ul li a:hover { background-color: #f7d33e; }
        .container { padding: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #f7d33e; color: black; }
        tr:nth-child(even) { background-color: #fdf5c9; }
        .btn { padding: 8px 12px; border-radius: 5px; cursor: pointer; text-decoration: none; }
        .btn-delivered { background-color: #28a745; color: white; }
        .btn-cancel { background-color: #dc3545; color: white; }
        .delivered {
    background-color: green;
    color: white;
    border: none;
    padding: 5px 10px;
    cursor: pointer;
}

.cancelled {
    background-color: red;
    color: white;
    border: none;
    padding: 5px 10px;
    cursor: pointer;
}
        
    </style>
</head>
<body>
    <header>Admin Panel - View Orders</header>
    <nav>
        <ul>
            <li><a href="admin.jsp">Home</a></li>
            <li><a href="AdminViewOrdersServlet">Refresh</a></li>
        </ul>
    </nav>

    <div class="container">
        <h2>Customer Orders</h2>
        <table>
            <tr>
                <th>Order ID</th>
                <th>Customer</th>
                <th>Item</th>
                <th>Quantity</th>
                <th>Total Amount</th>
                <th>Order Date</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            <%
                if (orderList != null && !orderList.isEmpty()) {
                    for (OrderPojo order : orderList) {
            %>
            <tr>
                <td><%= order.getOrderId() %></td>
                <td><%= order.getUsername() %></td>
                <td><%= order.getItem() %></td>
                <td><%= order.getQuantity() %></td>
                <td><%= "&#8377;" + order.getTotalAmount() %></td>
                <td><%= order.getOrderDate() %></td>
                <td><%= order.getOrderStatus() %></td>
                <td>
                    <form class="statusForm" action="UpdateOrderStatusServlet" method="post">
    <input type="hidden" name="orderId" value="<%= order.getOrderId() %>">
    <button type="submit" name="status" value="Delivered" class="delivered">Delivered</button>
    <button type="submit" name="status" value="Cancelled" class="cancelled">Cancel</button>
</form>

                </td>
            </tr>
            <% } } else { %>
            <tr><td colspan="8" style="text-align:center; color: #888;">No orders found</td></tr>
            <% } %>
        </table>
    </div>
</body>
</html>
