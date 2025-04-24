<%@page import="java.util.*"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="com.model.UserPojo"%> <!-- Import UserPojo model -->

<%
    // Get session and avoid duplicate variable declaration
    HttpSession sessionObj = request.getSession(false);
    UserPojo user = (sessionObj != null) ? (UserPojo) sessionObj.getAttribute("user") : null;
%>

<div class="container-xxl position-relative p-0">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark px-4 px-lg-5 py-3 py-lg-0">
        <a href="index.jsp" class="navbar-brand p-0">
            <h1 class="text-primary m-0"><i class="fa fa-utensils me-3"></i>Al-Muntaha</h1>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="fa fa-bars"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto py-0 pe-4">
                <a href="index.jsp" class="nav-item nav-link active">Home</a>
                <a href="about.jsp" class="nav-item nav-link">About</a>
                <a href="service.jsp" class="nav-item nav-link">Service</a>
                <a href="menu.jsp" class="nav-item nav-link">Menu</a>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
                    <div class="dropdown-menu m-0">
                        <a href="booking.jsp" class="dropdown-item">Booking</a>
                        <a href="team.jsp" class="dropdown-item">Our Team</a>
                        <a href="testimonial.jsp" class="dropdown-item">Testimonial</a>
                    </div>
                </div>
                <a href="contact.jsp" class="nav-item nav-link">Contact</a>

                <!-- User Profile Section -->
                <% if (user != null) { %>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            <i class="fa fa-user-circle"></i> <%= user.getUsername() %> <!-- Display only username -->
                        </a>
                        <div class="dropdown-menu m-0">
                            <a href="userProfile.jsp" class="dropdown-item"><i class="fa fa-user"></i> Profile</a>
                            <a href="UserLogoutServlet" class="dropdown-item text-danger"><i class="fa fa-sign-out-alt"></i> Logout</a>
                        </div>
                    </div>
                <% } else { %>
                    <a href="userLogin.jsp" class="nav-item nav-link"><i class="fa fa-sign-in-alt"></i> Login</a>
                <% } %>

            </div>
            <a href="booking.jsp" class="btn btn-primary py-2 px-4">Book A Table</a>
        </div>
    </nav>
</div>
