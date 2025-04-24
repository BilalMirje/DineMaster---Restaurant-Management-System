<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
    String check = (String) session.getAttribute("adminlogin");
    if (check == null) {
        response.sendRedirect("adminlogin.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Change Password</title>
</head>
<body>

<h2>Change Password</h2>



<jsp:include page="message.jsp" />
<form action="ChangeAdminPasswordServlet" method="post">
    <label>Old Password:</label>
    <input type="password" name="oldPassword" required><br><br>
    <label>New Password:</label>
    <input type="password" name="newPassword" required><br><br>
    <button type="submit">Change Password</button>
</form>


</body>
</html>
