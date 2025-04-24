<%@page import="com.model.MenuPojo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.service.MenuServiceImpl"%>
<%
    String check = (String) session.getAttribute("adminlogin");
    if (check == null) {
        response.sendRedirect("adminlogin.jsp");
        return;
    }
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel - View Menu</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }
        body {
            background-color: white;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        header {
            background-color: #f7d33e;
            color: black;
            padding: 15px;
            text-align: center;
            font-size: 24px;
        }
        nav {
            background-color: #fff;
            padding: 10px;
            text-align: center;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        }
        nav ul {
            list-style-type: none;
            padding: 0;
        }
        nav ul li {
            display: inline;
            margin: 0 15px;
        }
        nav ul li a {
            text-decoration: none;
            color: #333;
            font-size: 18px;
            padding: 8px 15px;
            border-radius: 5px;
            transition: background 0.3s ease;
        }
        nav ul li a:hover {
            background-color: #f7d33e;
        }
        .container {
            flex: 1;
            width: 100%;
            padding: 20px;
            overflow-x: auto;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #f7d33e;
            color: black;
        }
        tr:nth-child(even) {
            background-color: #fdf5c9;
        }
        .delete-btn {
            background-color: #dc3545;
            color: white;
            border: none;
            padding: 8px 12px;
            border-radius: 5px;
            cursor: pointer;
            transition: background 0.3s ease;
        }
        .delete-btn:hover {
            background-color: #c82333;
        }
        footer {
            background-color: #f7d33e;
            color: black;
            text-align: center;
            padding: 10px;
            margin-top: auto;
        }
    </style>
</head>
<body>
    <header>
        <h1>Admin Panel - Manage Menu</h1>
        <h2><%@include file="message.jsp" %></h2>
    </header>

    <nav>
        <ul>
            <li><a href="admin.jsp">Home</a></li>
            <li><a href="adminViewMenu.jsp">Refresh</a></li>
        </ul>
    </nav>

    <div class="container">
        <h2>All Menu Items</h2>
        <% 
            MenuServiceImpl menuService = new MenuServiceImpl();
            ArrayList<MenuPojo> menuList = menuService.getAllMenuItems();
        %>
        
        <% if (menuList != null && !menuList.isEmpty()) { %>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Item Name</th>
                    <th>Description</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Image</th>
                    <th>Action</th>
                </tr>
                <% for (MenuPojo item : menuList) { %>
                <tr>
                    <td><%= item.getId() %></td>
                    <td><%= item.getItemName() %></td>
                    <td><%= item.getDescription() %></td>
                    <td><%= item.getCategory() %></td>
                    <td>&#8377;<%= item.getPrice() %></td>
                    <td><img src="<%= item.getImageUrl() %>" width="50"></td>
                    <td>
                        <form action="DeleteMenuServlet" method="post">
                            <input type="hidden" name="id" value="<%= item.getId() %>">
                            <button class="delete-btn" type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
                <% } %>
            </table>
        <% } else { %>
            <p class="text-center">No menu items available.</p>
        <% } %>
    </div>

    <footer>
        <p>&copy; 2025 Admin Panel. All rights reserved.</p>
    </footer>

</body>
</html>
