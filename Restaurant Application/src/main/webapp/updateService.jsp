<%@page import="com.model.ServiceModulePojo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
    int index = Integer.parseInt(request.getParameter("index"));
    ArrayList<ServiceModulePojo> arrayList = (ArrayList<ServiceModulePojo>) session.getAttribute("servicedata");
    ServiceModulePojo sm = arrayList.get(index);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Service</title>
    
</head>
<body>

<!-- Form to Update Service -->
<form action="UpdateServiceServlet" method="post">
    <input type="hidden" name="id" value="<%=sm.getId() %>">
    
    <label>Icon</label><br>
    <input type="text" name="icon" value="<%=sm.getIconname() %>"><br>
    
    <label>Title</label><br>
    <input type="text" name="title" value="<%=sm.getTitle() %>"><br>
    
    <label>Description</label><br>
    <textarea name="description" rows="10" cols="40"><%=sm.getDescription() %></textarea><br>
    
    <button type="submit">Update Service</button>
</form>

</body>
</html>
