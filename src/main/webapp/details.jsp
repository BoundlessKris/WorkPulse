<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gig Details</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/details.css">
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

<div class="container">
    <div class="gig-details">
        <h1 class="gig-title">I will create professional website designs using Figma</h1>

        <div class="gig-images">
            <img src="/api/placeholder/600/400" alt="Gig preview 1">
        </div>

        <div class="gig-description">
            <p>Are you looking for a stunning website design that captures attention and converts visitors? Look no
                further! With over 5 years of experience in UI/UX design, I'll create a modern, responsive, and
                user-friendly website design that perfectly matches your brand identity.</p>
            <br>
            <p>What you'll get:</p>
            <ul>
                <li>Custom website design</li>
                <li>Responsive layouts for all devices</li>
                <li>Modern UI/UX best practices</li>
                <li>Source Figma files</li>
                <li>Unlimited revisions</li>
            </ul>
        </div>

        <div class="reviews">
            <h3>Reviews (253)</h3>
            <div class="review">
                <div class="review-header">
                    <strong>John D.</strong>
                    <div class="stars">★★★★★</div>
                </div>
                <p class="review-content">Amazing work! The designer understood exactly what I wanted and delivered
                    beyond my expectations. Will definitely work with again!</p>
            </div>
            <div class="review">
                <div class="review-header">
                    <strong>Sarah M.</strong>
                    <div class="stars">★★★★★</div>
                </div>
                <p class="review-content">Very professional and responsive. The design looks exactly like what I had
                    in mind. Great communication throughout the project.</p>
            </div>
        </div>
    </div>

    <div class="pricing-section">
        <div class="pricing-cards">
            <div class="pricing-tabs">
                <button class="pricing-tab active" onclick="switchPackage('basic')">Basic</button>
                <button class="pricing-tab" onclick="switchPackage('standard')">Standard</button>
                <button class="pricing-tab" onclick="switchPackage('premium')">Premium</button>
            </div>

            <div class="pricing-content">
                <div class="price">$49</div>
                <div class="delivery-time">
                    <svg width="16" height="16" viewBox="0 0 16 16" fill="#62646a">
                        <path
                                d="M8 0C3.6 0 0 3.6 0 8s3.6 8 8 8 8-3.6 8-8-3.6-8-8-8zm0 14c-3.3 0-6-2.7-6-6s2.7-6 6-6 6 2.7 6 6-2.7 6-6 6z"/>
                        <path d="M9 4H7v5h5V7H9V4z"/>
                    </svg>
                    3 days delivery
                </div>

                <ul class="features">
                    <li>1 page design</li>
                    <li>Responsive design</li>
                    <li>Source files</li>
                    <li>2 revisions</li>
                </ul>

                <button class="order-button">Continue ($49)</button>
            </div>
        </div>

        <div class="seller-info">
            <div class="seller-header">
                <img src="/api/placeholder/60/60" alt="Seller avatar" class="seller-avatar">
                <div>
                    <div class="seller-name">David Wilson</div>
                    <div class="seller-level">Level 2 Seller</div>
                </div>
            </div>
            <button class="order-button">Contact Me</button>
        </div>
    </div>
</div>

<script src="script/details.js"></script>
<%@include file="footer.jsp" %>
</body>

</html>