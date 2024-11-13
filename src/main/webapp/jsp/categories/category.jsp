<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>${category.name} Services | WorkPulse</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/categories/category.css">
</head>
<body>
<jsp:include page="../common/header.jsp" />

<!-- Category Header -->
<div class="category-header">
  <div class="container">
    <!-- Breadcrumb -->
    <div class="breadcrumb">
      <a href="${pageContext.request.contextPath}/">Home</a>
      <i class="fas fa-chevron-right"></i>
      <a href="${pageContext.request.contextPath}/categories">Categories</a>
      <i class="fas fa-chevron-right"></i>
      <span>${category.name}</span>
    </div>

    <h1>${category.name}</h1>
    <p class="category-description">${category.description}</p>

    <!-- Services Stats -->
    <div class="category-stats">
      <div class="stat">
        <i class="fas fa-list"></i>
        <span>${category.servicesCount} Services Available</span>
      </div>
      <div class="stat">
        <i class="fas fa-star"></i>
        <span>${category.averageRating} Average Rating</span>
      </div>
    </div>
  </div>
</div>

<!-- Main Content Area -->
<div class="category-content">
  <div class="container">
    <div class="content-layout">
      <!-- Filters Sidebar -->
      <aside class="filters-sidebar">
        <!-- Price Filter -->
        <div class="filter-section">
          <h3>Budget</h3>
          <div class="price-range">
            <input type="number" id="minPrice" placeholder="Min" min="0">
            <span>to</span>
            <input type="number" id="maxPrice" placeholder="Max">
          </div>
          <button class="apply-price">Apply</button>
        </div>

        <!-- Delivery Time Filter -->
        <div class="filter-section">
          <h3>Delivery Time</h3>
          <div class="checkbox-group">
            <label>
              <input type="checkbox" name="delivery" value="24h">
              Up to 24 hours
            </label>
            <label>
              <input type="checkbox" name="delivery" value="3d">
              Up to 3 days
            </label>
            <label>
              <input type="checkbox" name="delivery" value="7d">
              Up to 7 days
            </label>
            <label>
              <input type="checkbox" name="delivery" value="anytime">
              Anytime
            </label>
          </div>
        </div>

        <!-- Seller Level Filter -->
        <div class="filter-section">
          <h3>Seller Level</h3>
          <div class="checkbox-group">
            <label>
              <input type="checkbox" name="level" value="top_rated">
              Top Rated Seller
            </label>
            <label>
              <input type="checkbox" name="level" value="level_two">
              Level 2
            </label>
            <label>
              <input type="checkbox" name="level" value="level_one">
              Level 1
            </label>
            <label>
              <input type="checkbox" name="level" value="new">
              New Seller
            </label>
          </div>
        </div>
      </aside>

      <!-- Services Grid -->
      <main class="services-main">
        <!-- Sort Controls -->
        <div class="sort-controls">
          <div class="results-count">
            <span>${totalResults} services available</span>
          </div>
          <div class="sort-options">
            <label>Sort by:</label>
            <select id="sortSelect">
              <option value="recommended">Recommended</option>
              <option value="best_selling">Best Selling</option>
              <option value="newest">Newest Arrivals</option>
              <option value="price_low">Price: Low to High</option>
              <option value="price_high">Price: High to Low</option>
            </select>
          </div>
        </div>

        <!-- Services Grid -->
        <div class="services-grid">
          <c:forEach items="${services}" var="service">
            <!-- Service Card Template -->
            <div class="service-card">
              <div class="service-image">
                <img src="${service.thumbnailUrl}" alt="${service.title}">
                <button class="save-button" data-id="${service.id}">
                  <i class="far fa-heart"></i>
                </button>
              </div>
              <div class="service-info">
                <div class="seller-info">
                  <img src="${service.seller.avatarUrl}" alt="${service.seller.name}">
                  <span class="seller-name">${service.seller.name}</span>
                  <span class="seller-level">${service.seller.level}</span>
                </div>
                <h3 class="service-title">
                  <a href="/service/${service.id}">${service.title}</a>
                </h3>
                <div class="service-rating">
                  <i class="fas fa-star"></i>
                  <span>${service.rating}</span>
                  <span>(${service.reviewsCount})</span>
                </div>
              </div>
              <div class="service-footer">
                <div class="service-price">
                  <span>Starting at</span>
                  <strong>$${service.startingPrice}</strong>
                </div>
              </div>
            </div>
          </c:forEach>
        </div>

        <!-- Pagination -->
        <div class="pagination">
          <c:if test="${currentPage > 1}">
            <a href="?page=${currentPage - 1}" class="page-link">
              <i class="fas fa-chevron-left"></i>
            </a>
          </c:if>

          <c:forEach begin="1" end="${totalPages}" var="pageNum">
            <a href="?page=${pageNum}"
               class="page-link ${pageNum == currentPage ? 'active' : ''}">
                ${pageNum}
            </a>
          </c:forEach>

          <c:if test="${currentPage < totalPages}">
            <a href="?page=${currentPage + 1}" class="page-link">
              <i class="fas fa-chevron-right"></i>
            </a>
          </c:if>
        </div>
      </main>
    </div>
  </div>
</div>

<jsp:include page="../common/footer.jsp" />

<script src="${pageContext.request.contextPath}/js/categories/category.js"></script>
</body>
</html>
