<%@page import="com.model.ContactPojo"%>
<%@page import="java.util.ArrayList"%>
<%
    String check = (String) session.getAttribute("adminlogin");
    if (check == null) {
        response.sendRedirect("adminlogin.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel</title>
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
        <h1>Admin Panel - Read Contact Messages</h1>
        <h2><%@include file="message.jsp" %></h2>
    </header>
    <nav>
        <ul>
            <li><a href="admin.jsp">Home</a></li>
            <li><a href="ReadMessageServlet">Refresh</a></li>
        </ul>
    </nav>
    <div class="container">
        <h2>Contact Messages</h2>
        <table>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Subject</th>
                <th>Message</th>
                <th>Date Time</th>
                <th>Action</th>
            </tr>
            <% 
                ArrayList<ContactPojo> arrayList = (ArrayList<ContactPojo>) session.getAttribute("contactdata");
                if (arrayList != null && !arrayList.isEmpty()) {
                    for (ContactPojo cp : arrayList) {
            %>
            <tr>
                <td><%= cp.getName() %></td>
                <td><%= cp.getEmail() %></td>
                <td><%= cp.getSubject() %></td>
                <td><%= cp.getMessage() %></td>
                <td><%= cp.getDateTime() %></td>
                <td>
                    <form action="DeleteContactServlet" method="post">
                        <input type="hidden" name="id" value="<%= cp.getId() %>">
                        <button class="delete-btn">Delete</button>
                    </form>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="6" style="text-align:center; color: #888;">No messages found</td>
            </tr>
            <% } %>
        </table>
    </div>
    <footer>
        <p>&copy; 2025 Admin Panel. All rights reserved.</p>
    </footer>
</body>
</html>
