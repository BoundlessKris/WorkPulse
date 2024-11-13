<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>WorkPulse - Hire Freelancers & Find Freelance Jobs Online</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header-megamenu.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/categories/category.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/js/categories/category.js">
</head>
<body>
<header class="header">
  <div class="header-wrapper">
    <!-- Top Header -->
    <div class="header-top ${scrolled ? 'header-scrolled' : ''}">
      <div class="container-fluid">
        <div class="header-row">
          <!-- Logo -->
          <div class="logo">
            <a href="${pageContext.request.contextPath}/">
              <img src="${pageContext.request.contextPath}/assets/landing page imgs/workpulse.png" alt="WorkPulse" class="main-logo">
            </a>
          </div>

          <!-- Add this in your header.jsp -->
          <div class="nav-categories">
            <button class="categories-dropdown-btn">Categories</button>
            <div class="mega-menu">
              <div class="mega-menu-content">
                <div class="menu-column">
                  <h3>Digital Marketing</h3>
                  <ul>
                    <li><a href="${pageContext.request.contextPath}/categories/digital-marketing">All Digital Marketing</a></li>
                    <li><a href="${pageContext.request.contextPath}/categories/social-media">Social Media</a></li>
                    <li><a href="${pageContext.request.contextPath}/categories/seo">SEO</a></li>
                  </ul>
                </div>

                <div class="menu-column">
                  <h3>Graphics & Design</h3>
                  <ul>
                    <li><a href="${pageContext.request.contextPath}/categories/graphics-design">All Graphics & Design</a></li>
                    <li><a href="${pageContext.request.contextPath}/categories/logo-design">Logo Design</a></li>
                    <li><a href="${pageContext.request.contextPath}/categories/illustration">Illustration</a></li>
                  </ul>
                </div>

                <div class="menu-column">
                  <h3>Programming & Tech</h3>
                  <ul>
                    <li><a href="${pageContext.request.contextPath}/categories/programming-tech">All Programming</a></li>
                    <li><a href="${pageContext.request.contextPath}/categories/web-development">Web Development</a></li>
                    <li><a href="${pageContext.request.contextPath}/categories/mobile-apps">Mobile Apps</a></li>
                  </ul>
                </div>

                <!-- View all categories link -->
                <div class="menu-footer">
                  <a href="${pageContext.request.contextPath}/jsp/categories/category.jsp" class="view-all-link">
                    Browse All Categories <i class="fas fa-arrow-right"></i>
                  </a>
                </div>
              </div>
            </div>
          </div>

          <!-- Search Bar -->
          <div class="search-container">
            <form action="${pageContext.request.contextPath}/search" method="GET" class="search-form">
              <input type="text" placeholder="What service are you looking for today?" name="q" class="search-input">
              <button type="submit" class="search-button">
                <i class="fas fa-search"></i>
              </button>
            </form>
          </div>


          <!-- Navigation -->
          <nav class="main-nav">
            <ul class="nav-list">
              <li class="nav-item">
                <a href="#" class="nav-link">Business</a>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">Explore</a>
              </li>

              <c:choose>
                <c:when test="${empty sessionScope.user}">
                  <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/jsp/auth/login.jsp" class="nav-link">Sign In</a>
                  </li>
                  <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/jsp/auth/register.jsp" class="nav-button">Join</a>
                  </li>
                </c:when>
                <c:otherwise>
                  <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/message/inbox" class="nav-link">
                      <i class="fas fa-envelope"></i>
                      <span class="badge" id="messageCount"></span>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/order/list" class="nav-link">
                      <i class="fas fa-list-alt"></i>
                      Orders
                    </a>
                  </li>
                  <li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle">
                      <img src="${sessionScope.user.profilePicture}" alt="" class="profile-pic">
                    </a>
                    <div class="dropdown-menu">
                      <a href="${pageContext.request.contextPath}/dashboard" class="dropdown-item">Dashboard</a>
                      <a href="${pageContext.request.contextPath}/profile" class="dropdown-item">Profile</a>
                      <div class="dropdown-divider"></div>
                      <a href="${pageContext.request.contextPath}/user/logout" class="dropdown-item">Logout</a>
                    </div>
                  </li>
                </c:otherwise>
              </c:choose>
            </ul>
          </nav>
        </div>
      </div>
    </div>


    <!-- Categories Menu -->
    <div class="header-categories">
      <div class="container-fluid">
        <ul class="categories-list">
          <li><a href="#">Graphics & Design</a></li>
          <li><a href="#">Digital Marketing</a></li>
          <li><a href="#">Writing & Translation</a></li>
          <li><a href="#">Video & Animation</a></li>
          <li><a href="#">Music & Audio</a></li>
          <li><a href="#">Programming & Tech</a></li>
          <li><a href="#">Business</a></li>
          <li><a href="#">Lifestyle</a></li>
        </ul>
      </div>
    </div>
  </div>
</header>
</body>
</html>
