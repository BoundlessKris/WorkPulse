<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>WorkPulse - Freelance Services Marketplace</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/header.jsp" />

<!-- Hero Section -->
<section class="hero">
    <div class="hero-wrapper">
        <div class="hero-content">
            <h1 class="hero-title">
                Find the perfect <i>freelance</i> services for your business
            </h1>

            <!-- Search Bar -->
            <div class="hero-search">
                <form action="${pageContext.request.contextPath}/search" method="GET">
                    <div class="search-box">
                        <i class="fas fa-search search-icon"></i>
                        <input type="text"
                               name="q"
                               placeholder="Try 'website design' or 'logo design'"
                               class="search-input">
                        <button type="submit" class="search-button">Search</button>
                    </div>
                </form>
            </div>

            <!-- Popular Tags -->
            <div class="popular-tags">
                <span class="tags-label">Popular:</span>
                <div class="tags-list">
                    <a href="#" class="tag">Website Design</a>
                    <a href="#" class="tag">WordPress</a>
                    <a href="#" class="tag">Logo Design</a>
                    <a href="#" class="tag">AI Services</a>
                </div>
            </div>
        </div>

        <!-- Hero Image -->
        <div class="hero-image">
            <div class="hero-image-wrapper">
                <img src="${pageContext.request.contextPath}/images/hero-image.png" alt="Professional services">
            </div>
        </div>
    </div>
</section>

<!-- Trusted By Section -->
<section class="trusted-by">
    <div class="container">
        <div class="trusted-content">
            <span class="trusted-text">Trusted by:</span>
            <ul class="trusted-companies">
                <li><img src="${pageContext.request.contextPath}/images/companies/company1.png" alt="Company 1"></li>
                <li><img src="${pageContext.request.contextPath}/images/companies/company2.png" alt="Company 2"></li>
                <li><img src="${pageContext.request.contextPath}/images/companies/company3.png" alt="Company 3"></li>
                <li><img src="${pageContext.request.contextPath}/images/companies/company4.png" alt="Company 4"></li>
                <li><img src="${pageContext.request.contextPath}/images/companies/company5.png" alt="Company 5"></li>
            </ul>
        </div>
    </div>
</section>\

<!-- Popular Services Section -->
<section class="popular-services">
    <div class="container">
        <h2 class="section-title">Popular Professional Services</h2>

        <div class="services-slider">
            <button class="slider-arrow prev" id="prevSlide">
                <i class="fas fa-chevron-left"></i>
            </button>

            <div class="slider-container">
                <div class="slider-track">
                    <!-- Service Card 1 -->
                    <div class="service-card">
                        <a href="${pageContext.request.contextPath}/category/logo-design">
                            <div class="service-card-background" style="background-image: url('${pageContext.request.contextPath}/images/services/logo-design.jpg')">
                                <div class="service-card-content">
                                    <p class="service-small-text">Build your brand</p>
                                    <h3 class="service-title">Logo Design</h3>
                                </div>
                            </div>
                        </a>
                    </div>

                    <!-- Service Card 2 -->
                    <div class="service-card">
                        <a href="${pageContext.request.contextPath}/category/wordpress">
                            <div class="service-card-background" style="background-image: url('${pageContext.request.contextPath}/images/services/wordpress.jpg')">
                                <div class="service-card-content">
                                    <p class="service-small-text">Customize your site</p>
                                    <h3 class="service-title">WordPress</h3>
                                </div>
                            </div>
                        </a>
                    </div>

                    <!-- Service Card 3 -->
                    <div class="service-card">
                        <a href="${pageContext.request.contextPath}/category/voice-over">
                            <div class="service-card-background" style="background-image: url('${pageContext.request.contextPath}/images/services/voice-over.jpg')">
                                <div class="service-card-content">
                                    <p class="service-small-text">Share your message</p>
                                    <h3 class="service-title">Voice Over</h3>
                                </div>
                            </div>
                        </a>
                    </div>

                    <!-- Service Card 4 -->
                    <div class="service-card">
                        <a href="${pageContext.request.contextPath}/category/video-explainer">
                            <div class="service-card-background" style="background-image: url('${pageContext.request.contextPath}/images/services/video-explainer.jpg')">
                                <div class="service-card-content">
                                    <p class="service-small-text">Engage your audience</p>
                                    <h3 class="service-title">Video Explainer</h3>
                                </div>
                            </div>
                        </a>
                    </div>

                    <!-- Service Card 5 -->
                    <div class="service-card">
                        <a href="${pageContext.request.contextPath}/category/social-media">
                            <div class="service-card-background" style="background-image: url('${pageContext.request.contextPath}/images/services/social-media.jpg')">
                                <div class="service-card-content">
                                    <p class="service-small-text">Reach more customers</p>
                                    <h3 class="service-title">Social Media</h3>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>

            <button class="slider-arrow next" id="nextSlide">
                <i class="fas fa-chevron-right"></i>
            </button>
        </div>
    </div>
</section>

<script src="${pageContext.request.contextPath}/js/header.js"></script>
<script src="${pageContext.request.contextPath}/js/home.js"></script>
</body>
</html>
