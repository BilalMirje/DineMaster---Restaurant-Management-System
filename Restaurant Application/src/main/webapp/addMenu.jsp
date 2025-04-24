
<%
    String check = (String) session.getAttribute("adminlogin");
    if (check == null) {
        response.sendRedirect("adminlogin.jsp");
        return;
    }
%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Menu Item</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
        }
        h2 {
            color: #333;
            margin-bottom: 20px;
        }
        input, select, textarea {
            width: 90%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            width: 100%;
            background: #007bff;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Add Menu Item</h2>
        
        <%@include file="message.jsp" %>

        <form action="AddMenuServlet" method="post">
            <input type="text" name="item_name" placeholder="Enter Item Name" required><br>
            <textarea name="description" placeholder="Enter Description" required></textarea><br>
            <input type="number" step="0.01" name="price" placeholder="Enter Price" required><br>
            <input type="text" name="image_url" placeholder="Enter Image URL" required><br>

            <!-- Category Dropdown -->
            
            <select name="category" required>
                <option value="">Select Category</option>
                <option value="Breakfast">Breakfast</option>
                <option value="Lunch">Lunch</option>
                <option value="Dinner">Dinner</option>
            </select><br>

            <input type="submit" value="Add Menu">
        </form>
    </div>

</body>
</html>
