<%
	String check=(String)session.getAttribute("adminlogin");
	if(check==null){
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
    /* Reset default styles */
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }
    body {
        font-family: Arial, sans-serif;
    }
    /* Header styles */
    header {
        background-color: #333;
        color: #fff;
        padding: 10px;
    }
    header h1 {
        margin: 0;
    }
    /* Navigation styles */
    nav {
        background-color: #f0f0f0;
        padding: 10px;
    }
    nav ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
    }
    nav ul li {
        display: inline;
        margin-right: 10px;
    }
    nav ul li a {
        color: #333;
        text-decoration: none;
        padding: 5px 10px;
        border-radius: 5px;
    }
    nav ul li a:hover {
        background-color: #ddd;
        color: #333;
    }
    /* Main content styles */
    .content {
        padding: 200px;
    }
    /* Footer styles */
    footer {
        background-color: #333;
        color: #fff;
        padding: 10px;
        text-align: center;
    }
</style>
</head>
<body>
    <header>
        <h1>Admin Panel</h1>
        <h2><%@include file="message.jsp" %></h2>
    </header>
    <nav>
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="ReadMessageServlet">Read Message</a></li>
            <li><a href="addService.jsp">Add Service</a></li>
            <li><a href="ReadServiceDeleteUpdate">Read Service</a></li>
            <li><a href="addMenu.jsp">Add Menu's</a></li>
            <li><a href="viewMenu.jsp">View Menu's</a></li>
            <li><a href="viewOrders.jsp">View Orders</a></li>

            <li><a href="AdminLogoutServlet">Logout</a></li>
            <li><a href="changeAdminPassword.jsp">Change Password</a></li>
        </ul>
    </nav>
    <div class="content">
        <h2>Welcome to the Admin Panel</h2>
        <p>This is the main content area where you can manage your admin tasks.</p>
    </div>
    <footer>
        <p>&copy; 2024 Admin Panel. All rights reserved.</p>
    </footer>
</body>
</html>