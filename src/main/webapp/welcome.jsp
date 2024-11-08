<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<%@include file="header.jsp"%>
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
<a name="categories"></a>
<section class="categories">
    <h2>Explore Popular Categories</h2>
    <div class="category-list">
        <a href="programming-tech.jsp" class="category-item">Programming & Tech</a>
        <a href="graphic-design.jsp" class="category-item">Graphic Design</a>
        <a href="digital-marketing.jsp" class="category-item">Digital Marketing</a>
        <a href="writing-translation.jsp" class="category-item">Writing & Translation</a>
        <a href="video-animation.jsp" class="category-item">Video & Animation</a>
        <a href="ai-services.jsp" class="category-item">AI Services</a>
        <a href="music-audio.jsp" class="category-item">Music & Audio</a>
        <a href="consulting.jsp" class="category-item">Consulting</a>
    </div>
</section>
<script src="script/welcome.js"></script>
<%@include file="footer.jsp" %>
</body>
</html>
