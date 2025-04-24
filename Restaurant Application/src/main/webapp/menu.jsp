<%@page import="com.model.MenuPojo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.service.MenuServiceImpl"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Food Menu</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    
    <script>
    function placeOrder(itemName, price) {
        let userLoggedIn = "<%= (session.getAttribute("user") != null) ? "true" : "false" %>";
        
        if (userLoggedIn === "true") {
            let quantityField = document.getElementById("quantity_" + itemName);
            let quantity = quantityField ? parseInt(quantityField.value) : 0;

            if (isNaN(quantity) || quantity <= 0) {
                alert("Please select a valid quantity.");
            } else {
                document.getElementById("orderForm_" + itemName).submit();
            }
        } else {
            window.location.href = "userLogin.jsp?message=Please log in to order";
        }
    }

    </script>
</head>
<body>
    <div class="container-xxl bg-white p-0">
        <%@include file="navbar.jsp" %>

        <div class="container-xxl py-5 bg-dark hero-header mb-5">
            <div class="container text-center my-5 pt-5 pb-4">
                <h1 class="display-3 text-white mb-3 animated slideInDown">Food Menu</h1>
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb justify-content-center text-uppercase">
                        <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                        <li class="breadcrumb-item text-white active" aria-current="page">Menu</li>
                    </ol>
                </nav>
            </div>
        </div>

        <!-- Fetch Menu Data -->
        <%
            MenuServiceImpl menuService = new MenuServiceImpl();
            ArrayList<MenuPojo> menuList = menuService.getAllMenuItems();
        %>

        <!-- Menu Section -->
        <div class="container-xxl py-5">
            <div class="container">
                <div class="text-center">
                    <h5 class="section-title text-primary fw-normal">Food Menu</h5>
                    <h1 class="mb-5">Most Popular Items</h1>
                </div>
                <div class="row g-4">
                    <%
                        if (menuList != null && !menuList.isEmpty()) {
                            for (MenuPojo item : menuList) {
                    %>
                    <div class="col-lg-6">
                        <div class="d-flex align-items-center p-3 border rounded shadow-sm">
                            <img class="flex-shrink-0 img-fluid rounded" src="<%= item.getImageUrl() %>" alt="Food Image" style="width: 80px; height: 80px;">
                            <div class="w-100 d-flex flex-column text-start ps-4">
                                <h5 class="d-flex justify-content-between border-bottom pb-2">
                                    <span><%= item.getItemName() %> <small>(<%= item.getCategory() %>)</small></span>
                                    <span class="text-primary">&#8377;<%= item.getPrice() %></span>
                                </h5>
                                <small class="fst-italic"><%= item.getDescription() %></small>

                                <!-- Order Form -->
                                <form action="OrderServlet" method="post" id="orderForm_<%= item.getItemName() %>">
                                    <input type="hidden" name="item" value="<%= item.getItemName() %>">
                                    <input type="hidden" name="price" value="<%= item.getPrice() %>">

                                    <!-- Quantity Selection -->
                                    <div class="mt-2">
                                        <label>Qty:</label>
                                        <input type="number" id="quantity_<%= item.getItemName() %>" name="quantity" min="1" value="1" class="form-control w-25 d-inline">
                                    </div>

                                    <!-- Order Now Button -->
                                    <button type="button" class="btn btn-success mt-2"
    onclick="this.disabled=true; placeOrder('<%= item.getItemName() %>', <%= item.getPrice() %>)">
    Order Now
</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <%
                            }
                        } else {
                    %>
                    <p class="text-center">No menu items available.</p>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>

        <%@include file="footer.jsp" %>
    </div>

    <!-- Bootstrap JS (required for modal) -->
    <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
