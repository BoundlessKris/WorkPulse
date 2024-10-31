<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WorkPulse - Freelance Services Marketplace</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/welcome.css">
</head>
<body>
<nav class="navbar">
    <div class="nav-container">
        <a href="#" class="logo">
            <img src="assets/landing page imgs/workpulse.png" alt="WorkPulse">
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
                <img src="/api/placeholder/32/32" alt="Profile" class="profile-image" id="profileDropdown">
                <div class="dropdown-menu" id="dropdownMenu">
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-shopping-bag"></i> Orders
                    </a>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-store"></i> Gigs
                    </a>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-user"></i> Profile
                    </a>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-sign-out-alt"></i> Logout
                    </a>
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

<section class="hero">
    <div class="hero-container">
        <h1>Welcome back, <span id="username">User</span></h1>
        <div class="cards-container">
            <div class="action-card">
                <h3>Post a project brief</h3>
                <p>Get tailored offers for your needs.</p>
                <a href="#" class="action-button">Get started</a>
            </div>
            <div class="action-card">
                <h3>Complete your business info</h3>
                <p>Get personalized suggestions.</p>
                <a href="#" class="action-button">Complete info</a>
            </div>
        </div>
    </div>
</section>

<section class="gigs-section">
    <div class="gigs-container">
        <div class="section-header">
            <h2>New Available Gigs</h2>
            <div class="nav-buttons">
                <button onclick="navigateGigs('prev')">&lt;</button>
                <button onclick="navigateGigs('next')">&gt;</button>
            </div>
        </div>
        <div class="gigs-grid" id="gigsGrid">
            <!-- Gigs will be dynamically inserted here -->
        </div>
    </div>
</section>

<script src="script/welcome.js"></script>
<%@include file="footer.jsp"%>
</body>
</html>
