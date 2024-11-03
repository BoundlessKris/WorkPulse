<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Orders</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/manage-order.css">
</head>
<body>
<nav class="navbar">
    <div class="nav-container">
        <a href="#" class="logo">
            <img src="assets/landing%20page%20imgs/workpulse.png" alt="WorkPulse">
        </a>
        <div class="search-container">
            <input type="text" class="search-input" placeholder="What service are you looking for today?">
            <i class="fas fa-search search-icon"></i>
        </div>
        <div class="nav-right">
            <div class="nav-icons">
                <i class="far fa-bell nav-icon"></i>
                <i class="far fa-envelope nav-icon"></i>
                <i class="far fa-heart nav-icon"></i>
                <a href="#" class="nav-icon">Orders</a>
            </div>
            <div class="profile-dropdown">
                <img src="#" alt="Profile" class="profile-image" id="profileDropdown">
                <div class="dropdown-menu" id="dropdownMenu">
                    <a href="#" class="dropdown-item"><i class="fas fa-shopping-bag"></i> Orders</a>
                    <a href="#" class="dropdown-item"><i class="fas fa-store"></i> Gigs</a>
                    <a href="#" class="dropdown-item"><i class="fas fa-user"></i> Profile</a>
                    <a href="#" class="dropdown-item"><i class="fas fa-sign-out-alt"></i> Logout</a>
                </div>
            </div>
        </div>
    </div>
</nav>

<div class="categories">
    <div class="categories-container">
        <a href="#" class="category-link">Graphics & Design</a>
        <a href="#" class="category-link">Programming & Tech</a>
        <a href="#" class="category-link">Digital Marketing</a>
        <a href="#" class="category-link">Video & Animation</a>
        <a href="#" class="category-link">Writing & Translation</a>
        <a href="#" class="category-link">Music & Audio</a>
        <a href="#" class="category-link">Business</a>
        <a href="#" class="category-link">AI Services</a>
    </div>
</div>

<div class="container">
    <h1>Order Management</h1>
    <table class="orders-table">
        <thead>
        <tr>
            <th>Order ID</th>
            <th>Gig ID</th>
            <th>Buyer ID</th>
            <th>Price ID</th>
            <th>Status</th>
            <th>Created At</th>
            <th>Completed At</th>
        </tr>
        </thead>
        <tbody>
        <%
            java.util.List<Order> orders = (java.util.List<Order>) request.getAttribute("orders");
            if (orders != null) {
                for (Order order : orders) {
        %>
        <tr>
            <td><%= order.getOrderId() %>
            </td>
            <td><%= order.getGigId() %>
            </td>
            <td><%= order.getBuyerId() %>
            </td>
            <td><%= order.getPriceId() %>
            </td>
            <td class="status <%= order.getStatus() %>"><%= order.getStatus() %>
            </td>
            <td><%= order.getCreatedAt() %>
            </td>
            <td>
                <%= (order.getCompletedAt() != null) ? order.getCompletedAt() : "–" %>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="7">No orders found.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

<script src="script/welcome.js"></script>
</body>
</html>
