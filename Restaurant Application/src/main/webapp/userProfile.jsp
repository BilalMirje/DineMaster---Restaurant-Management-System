<%@page import="com.model.UserPojo"%>
<%@page import="com.service.UserServiceImpl"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%
    HttpSession currentSession = request.getSession(false);
    UserPojo loggedInUser = (currentSession != null) ? (UserPojo) currentSession.getAttribute("user") : null;

    if (loggedInUser == null) {
        response.sendRedirect("userLogin.jsp");
        return;
    }

    // No need to fetch user details again if already stored in session
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
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

        .profile-container {
            max-width: 600px;
            margin: 50px auto;
            text-align: center;
            padding: 20px;
            border-radius: 10px;
            background: #f8f9fa;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        .profile-info { 
            text-align: left; 
            margin-top: 20px; 
        }

        .profile-info p { 
            font-size: 18px; 
            margin-bottom: 10px; 
        }

        .logout-btn { 
            background-color: #dc3545; 
            color: white; 
            padding: 10px 15px; 
            text-decoration: none; 
            border-radius: 5px; 
            display: inline-block;
            margin-top: 20px;
        }

        .logout-btn:hover { 
            background-color: #c82333; 
        }

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

    <div class="profile-container">
        <h2>User Profile</h2>

        <div class="profile-info">
            <p><strong>Username:</strong> <%= loggedInUser.getUsername() %></p>
            <p><strong>Email:</strong> <%= loggedInUser.getEmail() %></p>
        </div>

        <a href="UserLogoutServlet" class="logout-btn">Logout</a>
    </div>

</body>
</html>
