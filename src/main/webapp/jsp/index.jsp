<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>WorkPulse - Freelance Services Marketplace</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header-megamenu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">

</head>
<body>
<jsp:include page="/jsp/common/header.jsp" />

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
                        <button type="submit" class="search-button-home">Search</button>
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
                <img src="hero-img.webp" alt="Professional services">
            </div>
        </div>
    </div>
</section>

<!-- Trusted By Section -->
<section class="trusted-by" style="background: linear-gradient(380deg, #0d084d 0%, #1dbf73 100%);">
    <div class="container">
        <div class="trusted-content">
            <span class="trusted-text">Trusted by:</span>
            <ul class="trusted-companies">
                <li><img src="https://fiverr-res.cloudinary.com/npm-assets/@fiverr/logged_out_homepage_perseus/google.e74f4d9.svg" alt="Company 1"></li>
                <li><img src="https://fiverr-res.cloudinary.com/npm-assets/@fiverr/logged_out_homepage_perseus/meta.ff37dd3.svg" alt="Company 2"></li>
                <li><img src="https://fiverr-res.cloudinary.com/npm-assets/@fiverr/logged_out_homepage_perseus/netflix.b310314.svg" alt="Company 3"></li>
                <li><img src="https://fiverr-res.cloudinary.com/npm-assets/@fiverr/logged_out_homepage_perseus/paypal.d398de5.svg" alt="Company 4"></li>
                <li><img src="https://fiverr-res.cloudinary.com/npm-assets/@fiverr/logged_out_homepage_perseus/payoneer.7c1170d.svg" alt="Company 5"></li>
            </ul>
        </div>
    </div>
</section>

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
                            <div class="service-card-background" style="background-image: url('https://fiverr-res.cloudinary.com/q_auto,f_auto,w_188,dpr_1.0/v1/attachments/generic_asset/asset/798403f5b92b1b5af997acc704a3d21c-1702465156494/logo-design.png')">
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
                            <div class="service-card-background" style="background-image: url('https://fiverr-res.cloudinary.com/q_auto,f_auto,w_188,dpr_1.0/v1/attachments/generic_asset/asset/798403f5b92b1b5af997acc704a3d21c-1702465156477/website-development.png')">
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
                            <div class="service-card-background" style="background-image: url('https://fiverr-res.cloudinary.com/q_auto,f_auto,w_188,dpr_1.0/v1/attachments/generic_asset/asset/798403f5b92b1b5af997acc704a3d21c-1702465156479/voice-over.png')">
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
                            <div class="service-card-background" style="background-image: url('https://fiverr-res.cloudinary.com/q_auto,f_auto,w_188,dpr_1.0/v1/attachments/generic_asset/asset/798403f5b92b1b5af997acc704a3d21c-1702465156494/video-editing.png')">
                                <div class="service-card-content">
                                    <p class="service-small-text">Engage your audience</p>
                                    <h3 class="service-title">Video Editing</h3>
                                </div>
                            </div>
                        </a>
                    </div>

                    <!-- Service Card 5 -->
                    <div class="service-card">
                        <a href="${pageContext.request.contextPath}/category/social-media">
                            <div class="service-card-background" style="background-image: url('https://fiverr-res.cloudinary.com/q_auto,f_auto,w_188,dpr_1.0/v1/attachments/generic_asset/asset/798403f5b92b1b5af997acc704a3d21c-1702465156476/social-media-marketing.png')">
                                <div class="service-card-content">
                                    <p class="service-small-text">Reach more customers</p>
                                    <h3 class="service-title">Social Media Marketing</h3>
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

<%--<!-- Marketplace Categories Section -->--%>
<%--<section class="marketplace-categories">--%>
<%--    <div class="container">--%>
<%--        <div class="category-filter">--%>
<%--            <select id="categoryFilter">--%>
<%--                <option value="all">All Categories</option>--%>
<%--                <c:forEach var="category" items="${categories}">--%>
<%--                    <option value="${category.slug}">${category.name}</option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
<%--        </div>--%>

<%--        <h2 class="section-title">Browse Talent by Category</h2>--%>

<%--        <div class="category-grid">--%>
<%--            <c:forEach var="category" items="${categories}">--%>
<%--                <div class="category-card" data-category="${category.slug}">--%>
<%--                    <a href="${pageContext.request.contextPath}/category/${category.slug}">--%>
<%--                        <div class="category-card-background" style="background-image: url('${category.imageUrl}')">--%>
<%--                            <div class="category-card-content">--%>
<%--                                <h3 class="category-title">${category.name}</h3>--%>
<%--                                <p class="category-stats">--%>
<%--                                        ${category.numServices} Services | ${category.numFreelancers} Freelancers--%>
<%--                                </p>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>


<!-- Professional Categories Section -->
<section class="professional-categories">
    <div class="container">
        <h2 class="section-title">Explore the Marketplace</h2>

        <div class="categories-grid">
            <!-- Category Card 1 -->
            <div class="category-card">
                <a href="../graphic-design.jsp" target="_blank">
                    <div class="category-icon">
                        <img src="https://fiverr-res.cloudinary.com/npm-assets/@fiverr/logged_out_homepage_perseus/graphics-design-thin.ff38893.svg" alt="Graphics & Design">
                    </div>
                    <h3 class="category-title">Graphics & Design</h3>
                    <div class="category-arrow">
                        <i class="fas fa-arrow-right"></i>
                    </div>
                </a>
            </div>

            <!-- Category Card 2 -->
            <div class="category-card">
                <a href="${pageContext.request.contextPath}/category/digital-marketing">
                    <div class="category-icon">
                        <img src="https://fiverr-res.cloudinary.com/npm-assets/@fiverr/logged_out_homepage_perseus/digital-marketing-thin.68edb44.svg" alt="Digital Marketing">
                    </div>
                    <h3 class="category-title">Digital Marketing</h3>
                    <div class="category-arrow">
                        <i class="fas fa-arrow-right"></i>
                    </div>
                </a>
            </div>

            <!-- Category Card 3 -->
            <div class="category-card">
                <a href="${pageContext.request.contextPath}/category/writing-translation">
                    <div class="category-icon">
                        <img src="https://fiverr-res.cloudinary.com/npm-assets/@fiverr/logged_out_homepage_perseus/writing-translation-thin.fd3699b.svg" alt="Writing & Translation">
                    </div>
                    <h3 class="category-title">Writing & Translation</h3>
                    <div class="category-arrow">
                        <i class="fas fa-arrow-right"></i>
                    </div>
                </a>
            </div>

            <!-- Category Card 4 -->
            <div class="category-card">
                <a href="${pageContext.request.contextPath}/category/video-animation">
                    <div class="category-icon">
                        <img src="https://fiverr-res.cloudinary.com/npm-assets/@fiverr/logged_out_homepage_perseus/video-animation-thin.9d3f24d.svg" alt="Video & Animation">
                    </div>
                    <h3 class="category-title">Video & Animation</h3>
                    <div class="category-arrow">
                        <i class="fas fa-arrow-right"></i>
                    </div>
                </a>
            </div>

            <!-- Category Card 5 -->
            <div class="category-card">
                <a href="${pageContext.request.contextPath}/category/music-audio">
                    <div class="category-icon">
                        <img src="https://fiverr-res.cloudinary.com/npm-assets/@fiverr/logged_out_homepage_perseus/music-audio-thin.43a9801.svg" alt="Music & Audio">
                    </div>
                    <h3 class="category-title">Music & Audio</h3>
                    <div class="category-arrow">
                        <i class="fas fa-arrow-right"></i>
                    </div>
                </a>
            </div>

            <!-- Category Card 6 -->
            <div class="category-card">
                <a href="${pageContext.request.contextPath}/category/programming">
                    <div class="category-icon">
                        <img src="https://fiverr-res.cloudinary.com/npm-assets/@fiverr/logged_out_homepage_perseus/programming-tech-thin.56382a2.svg" alt="Programming & Tech">
                    </div>
                    <h3 class="category-title">Programming & Tech</h3>
                    <div class="category-arrow">
                        <i class="fas fa-arrow-right"></i>
                    </div>
                </a>
            </div>

            <!-- Category Card 7 -->
            <div class="category-card">
                <a href="${pageContext.request.contextPath}/category/business">
                    <div class="category-icon">
                        <img src="https://fiverr-res.cloudinary.com/npm-assets/@fiverr/logged_out_homepage_perseus/business-thin.885e68e.svg" alt="Business">
                    </div>
                    <h3 class="category-title">Business</h3>
                    <div class="category-arrow">
                        <i class="fas fa-arrow-right"></i>
                    </div>
                </a>
            </div>

            <!-- Category Card 8 -->
            <div class="category-card">
                <a href="${pageContext.request.contextPath}/category/lifestyle">
                    <div class="category-icon">
                        <img src="https://fiverr-res.cloudinary.com/npm-assets/@fiverr/logged_out_homepage_perseus/consulting-thin.d5547ff.svg" alt="Lifestyle">
                    </div>
                    <h3 class="category-title">Lifestyle</h3>
                    <div class="category-arrow">
                        <i class="fas fa-arrow-right"></i>
                    </div>
                </a>
            </div>
        </div>
    </div>
</section>


<!-- Featured Gigs Section -->
<section class="featured-gigs">
    <div class="container">
        <div class="section-header">
            <h2 class="section-title">Recently Added Services</h2>
            <a href="${pageContext.request.contextPath}/gigs" class="view-all-link">See All <i class="fas fa-arrow-right"></i></a>
        </div>

        <div class="gigs-grid">
            <!-- Gig Card 1 -->
            <div class="gig-card">
                <a href="${pageContext.request.contextPath}/gig/details?id=1" class="gig-link">
                    <!-- Gig Image -->
                    <div class="gig-image">
                        <img src="${pageContext.request.contextPath}/images/gigs/gig-1.jpg" alt="Gig Title">
                        <button class="save-button">
                            <i class="far fa-heart"></i>
                        </button>
                    </div>

                    <!-- Seller Info -->
                    <div class="seller-info">
                        <img src="${pageContext.request.contextPath}/images/avatars/seller-1.jpg" alt="Seller Name" class="seller-avatar">
                        <div class="seller-details">
                            <span class="seller-name">John Doe</span>
                            <span class="seller-level">Level 2 Seller</span>
                        </div>
                    </div>

                    <!-- Gig Details -->
                    <h3 class="gig-title">I will create a professional logo design for your business</h3>

                    <!-- Rating -->
                    <div class="gig-rating">
                        <i class="fas fa-star"></i>
                        <span class="rating-score">4.9</span>
                        <span class="rating-count">(241)</span>
                    </div>
                </a>

                <!-- Footer -->
                <div class="gig-footer">
                    <div class="gig-info">
                        <i class="fas fa-clock"></i>
                        <span>From 3 days</span>
                    </div>
                    <div class="gig-price">
                        <span class="price-label">Starting at</span>
                        <span class="price-amount">$29.99</span>
                    </div>
                </div>
            </div>

            <!-- Repeat Gig Card structure for more gigs (usually 8 cards) -->
            <!-- You can use JSTL to loop through gigs from your backend -->
        </div>
    </div>
</section>

<!-- Business Solutions Section -->
<section class="business-solutions">
    <div class="container">
        <div class="business-wrapper">
            <!-- Left Content -->
            <div class="business-content">
                <h2 class="business-title">
                    <span class="highlight">WorkPulse</span> Business Solutions
                </h2>
                <h3 class="business-subtitle">Advanced solutions and professional talent for businesses</h3>

                <div class="business-features">
                    <!-- Feature 1 -->
                    <div class="feature-item">
                        <div class="feature-icon">
                            <i class="fas fa-check-circle"></i>
                        </div>
                        <div class="feature-text">
                            <h4>Verified Professional Talent</h4>
                            <p>Access top freelancers and professional agencies</p>
                        </div>
                    </div>

                    <!-- Feature 2 -->
                    <div class="feature-item">
                        <div class="feature-icon">
                            <i class="fas fa-headset"></i>
                        </div>
                        <div class="feature-text">
                            <h4>Dedicated Account Management</h4>
                            <p>Get personal assistance from our support team</p>
                        </div>
                    </div>

                    <!-- Feature 3 -->
                    <div class="feature-item">
                        <div class="feature-icon">
                            <i class="fas fa-chart-line"></i>
                        </div>
                        <div class="feature-text">
                            <h4>Advanced Business Tools</h4>
                            <p>Enhanced collaboration and management features</p>
                        </div>
                    </div>
                </div>

                <!-- CTA Buttons -->
                <div class="business-cta">
                    <a href="${pageContext.request.contextPath}/business/learn-more" class="btn-primary">Learn More</a>
                    <a href="${pageContext.request.contextPath}/business/contact" class="btn-secondary">Talk to Sales</a>
                </div>
            </div>

            <!-- Right Image -->
            <div class="business-image">
                <img src="https://fiverr-res.cloudinary.com/q_auto,f_auto,w_870,dpr_1.0/v1/attachments/generic_asset/asset/2321104e0c585cceea525419551d3a7c-1721984733481/fiverr-pro.png" alt="Business Solutions">
            </div>
        </div>

        <!-- Trusted By Companies -->
        <div class="trusted-companies">
            <div class="companies-label">Trusted by:</div>
            <div class="companies-logos">
                <li><img src="https://fiverr-res.cloudinary.com/npm-assets/@fiverr/logged_out_homepage_perseus/google.e74f4d9.svg" alt="Company 1"></li>
                <li><img src="https://fiverr-res.cloudinary.com/npm-assets/@fiverr/logged_out_homepage_perseus/meta.ff37dd3.svg" alt="Company 2"></li>
                <li><img src="https://fiverr-res.cloudinary.com/npm-assets/@fiverr/logged_out_homepage_perseus/netflix.b310314.svg" alt="Company 3"></li>
                <li><img src="https://fiverr-res.cloudinary.com/npm-assets/@fiverr/logged_out_homepage_perseus/paypal.d398de5.svg" alt="Company 4"></li>
            </div>
        </div>
    </div>
</section>


<!-- How It Works Section -->
<section class="how-it-works">
    <div class="container">
        <h2 class="section-title">How WorkPulse Works</h2>
        <p class="section-subtitle">Get your work done in 4 simple steps</p>

        <div class="steps-container">
            <!-- Step 1 -->
            <div class="step-card">
                <div class="step-number">1</div>
                <div class="step-icon">
                    <i class="fas fa-search"></i>
                </div>
                <h3 class="step-title">Search for Service</h3>
                <p class="step-description">Find the perfect service for your needs. Browse categories or use our search.</p>
                <div class="step-details">
                    <ul class="step-features">
                        <li><i class="fas fa-check"></i> Browse categories</li>
                        <li><i class="fas fa-check"></i> Read reviews</li>
                        <li><i class="fas fa-check"></i> Compare packages</li>
                    </ul>
                </div>
            </div>

            <!-- Step 2 -->
            <div class="step-card">
                <div class="step-number">2</div>
                <div class="step-icon">
                    <i class="fas fa-handshake"></i>
                </div>
                <h3 class="step-title">Choose & Connect</h3>
                <p class="step-description">Select the perfect package and discuss your requirements with the seller.</p>
                <div class="step-details">
                    <ul class="step-features">
                        <li><i class="fas fa-check"></i> Select package</li>
                        <li><i class="fas fa-check"></i> Contact seller</li>
                        <li><i class="fas fa-check"></i> Discuss details</li>
                    </ul>
                </div>
            </div>

            <!-- Step 3 -->
            <div class="step-card">
                <div class="step-number">3</div>
                <div class="step-icon">
                    <i class="fas fa-credit-card"></i>
                </div>
                <h3 class="step-title">Pay Securely</h3>
                <p class="step-description">Payment is held secure until you approve the delivered work.</p>
                <div class="step-details">
                    <ul class="step-features">
                        <li><i class="fas fa-check"></i> Secure payment</li>
                        <li><i class="fas fa-check"></i> Money-back guarantee</li>
                        <li><i class="fas fa-check"></i> Clear milestones</li>
                    </ul>
                </div>
            </div>

            <!-- Step 4 -->
            <div class="step-card">
                <div class="step-number">4</div>
                <div class="step-icon">
                    <i class="fas fa-thumbs-up"></i>
                </div>
                <h3 class="step-title">Review & Approve</h3>
                <p class="step-description">Receive and review your delivery. Release payment when satisfied.</p>
                <div class="step-details">
                    <ul class="step-features">
                        <li><i class="fas fa-check"></i> Review work</li>
                        <li><i class="fas fa-check"></i> Request revisions</li>
                        <li><i class="fas fa-check"></i> Release payment</li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- CTA Section -->
        <div class="steps-cta">
            <a href="${pageContext.request.contextPath}/signup" class="cta-button">Get Started</a>
            <span class="cta-separator">or</span>
            <a href="${pageContext.request.contextPath}/how-it-works" class="learn-more-link">
                Learn More <i class="fas fa-arrow-right"></i>
            </a>
        </div>
    </div>
</section>

<!-- Testimonials Section -->
<section class="testimonials">
    <div class="container">
        <div class="testimonials-header">
            <h2 class="section-title">Success Stories</h2>
            <p class="section-subtitle">From freelancers and clients who found success on WorkPulse</p>
        </div>

        <!-- Testimonials Slider -->
        <div class="testimonials-slider">
            <button class="slider-arrow prev" id="prevTestimonial">
                <i class="fas fa-chevron-left"></i>
            </button>

            <div class="testimonials-container">
                <div class="testimonials-track">
                    <!-- Testimonial 1 -->
                    <div class="testimonial-card">
                        <div class="testimonial-content">
                            <div class="quote-icon">
                                <i class="fas fa-quote-left"></i>
                            </div>
                            <p class="testimonial-text">
                                "WorkPulse transformed my freelancing career. I've been able to grow my business and connect with clients worldwide. The platform's ease of use and professional tools make it the perfect place for freelancers."
                            </p>
                        </div>
                        <div class="testimonial-author">
                            <div class="author-image">
                                <img src="${pageContext.request.contextPath}/images/testimonials/author1.jpg" alt="Sarah Johnson">
                            </div>
                            <div class="author-info">
                                <h4 class="author-name">Sarah Johnson</h4>
                                <p class="author-title">Graphic Designer</p>
                                <div class="author-rating">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <span class="rating-text">5.0</span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Testimonial 2 -->
                    <div class="testimonial-card">
                        <div class="testimonial-content">
                            <div class="quote-icon">
                                <i class="fas fa-quote-left"></i>
                            </div>
                            <p class="testimonial-text">
                                "As a business owner, finding reliable freelancers was always a challenge. WorkPulse made it simple to find and hire top talent. The quality of work and professionalism has been consistently excellent."
                            </p>
                        </div>
                        <div class="testimonial-author">
                            <div class="author-image">
                                <img src="${pageContext.request.contextPath}/images/testimonials/author2.jpg" alt="Michael Chen">
                            </div>
                            <div class="author-info">
                                <h4 class="author-name">Michael Chen</h4>
                                <p class="author-title">Business Owner</p>
                                <div class="author-rating">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star-half-alt"></i>
                                    <span class="rating-text">4.5</span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Add more testimonial cards as needed -->
                </div>
            </div>

            <button class="slider-arrow next" id="nextTestimonial">
                <i class="fas fa-chevron-right"></i>
            </button>
        </div>

        <!-- Success Stats -->
        <div class="success-stats">
            <div class="stat-item">
                <div class="stat-number">1M+</div>
                <div class="stat-label">Active Freelancers</div>
            </div>
            <div class="stat-item">
                <div class="stat-number">50K+</div>
                <div class="stat-label">Happy Clients</div>
            </div>
            <div class="stat-item">
                <div class="stat-number">100K+</div>
                <div class="stat-label">Projects Completed</div>
            </div>
            <div class="stat-item">
                <div class="stat-number">95%</div>
                <div class="stat-label">Client Satisfaction</div>
            </div>
        </div>

        <!-- CTA Banner -->
        <div class="testimonial-cta">
            <h3>Ready to start your success story?</h3>
            <div class="cta-buttons">
                <a href="${pageContext.request.contextPath}/signup" class="cta-button primary">Join as Freelancer</a>
                <a href="${pageContext.request.contextPath}/signup?type=client" class="cta-button secondary">Hire Talent</a>
            </div>
        </div>
    </div>
</section>

<!-- Join Now Section -->
<section class="join-now">
    <div class="container">
        <div class="join-wrapper">
            <!-- Left Side - For Freelancers -->
            <div class="join-card freelancer">
                <div class="join-content">
                    <div class="join-icon">
                        <i class="fas fa-user-tie"></i>
                    </div>
                    <h3 class="join-title">Join as a Freelancer</h3>
                    <ul class="join-benefits">
                        <li>
                            <i class="fas fa-check-circle"></i>
                            <span>Access global opportunities</span>
                        </li>
                        <li>
                            <i class="fas fa-check-circle"></i>
                            <span>Set your own rates</span>
                        </li>
                        <li>
                            <i class="fas fa-check-circle"></i>
                            <span>Work from anywhere</span>
                        </li>
                        <li>
                            <i class="fas fa-check-circle"></i>
                            <span>Secure payments</span>
                        </li>
                    </ul>
                    <a href="${pageContext.request.contextPath}/signup?type=freelancer" class="join-button">
                        Start Earning
                        <i class="fas fa-arrow-right"></i>
                    </a>
                </div>
            </div>

            <!-- Right Side - For Clients -->
            <div class="join-card client">
                <div class="join-content">
                    <div class="join-icon">
                        <i class="fas fa-building"></i>
                    </div>
                    <h3 class="join-title">Hire Talent</h3>
                    <ul class="join-benefits">
                        <li>
                            <i class="fas fa-check-circle"></i>
                            <span>Find expert freelancers</span>
                        </li>
                        <li>
                            <i class="fas fa-check-circle"></i>
                            <span>Post projects for free</span>
                        </li>
                        <li>
                            <i class="fas fa-check-circle"></i>
                            <span>Pay only when satisfied</span>
                        </li>
                        <li>
                            <i class="fas fa-check-circle"></i>
                            <span>24/7 support</span>
                        </li>
                    </ul>
                    <a href="${pageContext.request.contextPath}/signup?type=client" class="join-button">
                        Start Hiring
                        <i class="fas fa-arrow-right"></i>
                    </a>
                </div>
            </div>
        </div>

        <!-- Bottom Stats -->
        <div class="join-stats">
            <div class="stat-item">
                <i class="fas fa-globe"></i>
                <div class="stat-info">
                    <span class="stat-value">180+</span>
                    <span class="stat-label">Countries</span>
                </div>
            </div>
            <div class="stat-item">
                <i class="fas fa-dollar-sign"></i>
                <div class="stat-info">
                    <span class="stat-value">$1B+</span>
                    <span class="stat-label">Paid to Freelancers</span>
                </div>
            </div>
            <div class="stat-item">
                <i class="fas fa-shield-alt"></i>
                <div class="stat-info">
                    <span class="stat-value">100%</span>
                    <span class="stat-label">Payment Protection</span>
                </div>
            </div>
            <div class="stat-item">
                <i class="fas fa-headset"></i>
                <div class="stat-info">
                    <span class="stat-value">24/7</span>
                    <span class="stat-label">Support</span>
                </div>
            </div>
        </div>
    </div>
</section>
<%@ include file="/jsp/common/footer.jsp" %>

<script src="${pageContext.request.contextPath}/js/header.js"></script>
<script src="${pageContext.request.contextPath}/js/home.js"></script>
<script src="${pageContext.request.contextPath}/js/footer.js"></script>
</body>
</html>
