<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="header">
  <div class="header-wrapper">
    <!-- Top Header -->
    <div class="header-top ${scrolled ? 'header-scrolled' : ''}">
      <div class="container-fluid">
        <div class="header-row">
          <!-- Logo -->
          <div class="logo">
            <a href="${pageContext.request.contextPath}/">
              <img src="${pageContext.request.contextPath}/images/logo.png" alt="WorkPulse" class="main-logo">
            </a>
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
                    <a href="${pageContext.request.contextPath}/user/login" class="nav-link">Sign In</a>
                  </li>
                  <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/user/register" class="nav-button">Join</a>
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
