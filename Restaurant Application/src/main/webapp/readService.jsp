<%@page import="com.model.ServiceModulePojo"%>
<%@page import="java.util.ArrayList"%>
<%
	String check=(String)session.getAttribute("adminlogin");
	if(check==null){
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
            <li><a href="ReadServiceDeleteUpdate">Refresh</a></li>
        </ul>
    </nav>
	
	<div class="container">
        <h2>All Services</h2>
        <table>
            <tr>
                <th>Title</th>
                <th>Description</th> 
                <th>Date Time</th>
                <th>Action</th>
            </tr>
            <% 
                ArrayList<ServiceModulePojo> arrayList = (ArrayList<ServiceModulePojo>) session.getAttribute("servicedata");
             		int index=0;
                    for (ServiceModulePojo cp : arrayList) {
            %>
            <tr>
                <td><%= cp.getTitle() %></td>
                <td><%= cp.getDescription() %></td>
                <td><%= cp.getDateTime() %></td>
                <td>
                    <form action="deleteServiceServlet" method="post">
                        <input type="hidden" name="id" value="<%= cp.getId() %>">
                        <button class="delete-btn">Delete</button>
                        <a style="text-decoration:none;" href="updateService.jsp?index=<%=index%>">Update</a>
                    </form>
                    
                </td>
            </tr>
            <%
                 index++;
                    }
                
            %>
            
        </table>
    </div>
	<footer>
        <p>&copy; 2025 Admin Panel. All rights reserved.</p>
    </footer>

</body>
</html>