<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>WorkPulse - Browse Categories</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/categories/categories.css">
</head>
<body>
<jsp:include page="../common/header.jsp" />

<main class="categories-main">
    <!-- Breadcrumb Navigation -->
    <div class="breadcrumb">
        <a href="${pageContext.request.contextPath}/">Home</a>
        <i class="fas fa-chevron-right"></i>
        <span>Categories</span>
    </div>

    <!-- Categories Header -->
    <div class="categories-header">
        <h1>Explore Work Categories</h1>
        <p>Get inspired to build your next project with our comprehensive service categories</p>
    </div>

    <!-- Main Categories Grid -->
    <div class="categories-grid">
        <!-- Digital Marketing -->
        <div class="category-card">
            <div class="category-icon">
                <i class="fas fa-bullhorn"></i>
            </div>
            <h3>Digital Marketing</h3>
            <ul class="subcategories">
                <li><a href="category?name=social-media">Social Media Marketing</a></li>
                <li><a href="category?name=seo">SEO</a></li>
                <li><a href="category?name=content-marketing">Content Marketing</a></li>
                <li class="more-link">
                    <a href="category?name=digital-marketing">View All <i class="fas fa-arrow-right"></i></a>
                </li>
            </ul>
        </div>

        <!-- Graphics & Design -->
        <div class="category-card">
            <div class="category-icon">
                <i class="fas fa-palette"></i>
            </div>
            <h3>Graphics & Design</h3>
            <ul class="subcategories">
                <li><a href="category?name=logo-design">Logo Design</a></li>
                <li><a href="category?name=illustrations">Illustrations</a></li>
                <li><a href="category?name=ux-design">UX Design</a></li>
                <li class="more-link">
                    <a href="category?name=graphics-design">View All <i class="fas fa-arrow-right"></i></a>
                </li>
            </ul>
        </div>

        <!-- Programming & Tech -->
        <div class="category-card">
            <div class="category-icon">
                <i class="fas fa-code"></i>
            </div>
            <h3>Programming & Tech</h3>
            <ul class="subcategories">
                <li><a href="category?name=web-development">Web Development</a></li>
                <li><a href="category?name=mobile-apps">Mobile Apps</a></li>
                <li><a href="category?name=database">Database Design</a></li>
                <li class="more-link">
                    <a href="category?name=programming">View All <i class="fas fa-arrow-right"></i></a>
                </li>
            </ul>
        </div>

        <!-- Writing & Translation -->
        <div class="category-card">
            <div class="category-icon">
                <i class="fas fa-pen-fancy"></i>
            </div>
            <h3>Writing & Translation</h3>
            <ul class="subcategories">
                <li><a href="category?name=content-writing">Content Writing</a></li>
                <li><a href="category?name=translation">Translation</a></li>
                <li><a href="category?name=proofreading">Proofreading</a></li>
                <li class="more-link">
                    <a href="category?name=writing">View All <i class="fas fa-arrow-right"></i></a>
                </li>
            </ul>
        </div>

        <!-- Video & Animation -->
        <div class="category-card">
            <div class="category-icon">
                <i class="fas fa-video"></i>
            </div>
            <h3>Video & Animation</h3>
            <ul class="subcategories">
                <li><a href="category?name=video-editing">Video Editing</a></li>
                <li><a href="category?name=animation">Animation</a></li>
                <li><a href="category?name=motion-graphics">Motion Graphics</a></li>
                <li class="more-link">
                    <a href="category?name=video">View All <i class="fas fa-arrow-right"></i></a>
                </li>
            </ul>
        </div>

        <!-- Music & Audio -->
        <div class="category-card">
            <div class="category-icon">
                <i class="fas fa-music"></i>
            </div>
            <h3>Music & Audio</h3>
            <ul class="subcategories">
                <li><a href="category?name=voice-over">Voice Over</a></li>
                <li><a href="category?name=mixing">Mixing & Mastering</a></li>
                <li><a href="category?name=singers">Singers & Musicians</a></li>
                <li class="more-link">
                    <a href="category?name=music">View All <i class="fas fa-arrow-right"></i></a>
                </li>
            </ul>
        </div>
    </div>

    <!-- Popular Services Section -->
    <section class="popular-services">
        <h2>Popular Services</h2>
        <div class="services-slider">
            <!-- Service cards will be dynamically loaded here -->
        </div>
    </section>
</main>

<jsp:include page="../common/footer.jsp" />

<script src="${pageContext.request.contextPath}/js/categories/categories.js"></script>
</body>
</html>
