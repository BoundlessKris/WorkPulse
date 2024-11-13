<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>${category.name} Services | WorkPulse</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header-megamenu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/category/category.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/category/category.js">
</head>
<body>
<jsp:include page="../jsp/common/header.jsp" />

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

<div class="container category-content">
    <div class="category-layout">
        <!-- Filters Sidebar -->
        <aside class="filters-sidebar">
            <div class="filter-section">
                <h3>Budget</h3>
                <div class="price-range">
                    <input type="number" placeholder="Min" min="0">
                    <span>to</span>
                    <input type="number" placeholder="Max">
                    <button class="apply-price">Apply</button>
                </div>
            </div>

            <div class="filter-section">
                <h3>Delivery Time</h3>
                <div class="checkbox-group">
                    <label class="checkbox-label">
                        <input type="checkbox" name="delivery" value="24h">
                        <span>Up to 24 hours</span>
                    </label>
                    <label class="checkbox-label">
                        <input type="checkbox" name="delivery" value="3d">
                        <span>Up to 3 days</span>
                    </label>
                    <label class="checkbox-label">
                        <input type="checkbox" name="delivery" value="7d">
                        <span>Up to 7 days</span>
                    </label>
                    <label class="checkbox-label">
                        <input type="checkbox" name="delivery" value="anytime">
                        <span>Anytime</span>
                    </label>
                </div>
            </div>

            <div class="filter-section">
                <h3>Seller Level</h3>
                <div class="checkbox-group">
                    <label class="checkbox-label">
                        <input type="checkbox" name="level" value="top">
                        <span>Top Rated Seller</span>
                    </label>
                    <label class="checkbox-label">
                        <input type="checkbox" name="level" value="level2">
                        <span>Level 2</span>
                    </label>
                    <label class="checkbox-label">
                        <input type="checkbox" name="level" value="level1">
                        <span>Level 1</span>
                    </label>
                    <label class="checkbox-label">
                        <input type="checkbox" name="level" value="new">
                        <span>New Seller</span>
                    </label>
                </div>
            </div>

            <div class="filter-section">
                <h3>Pro Services</h3>
                <div class="checkbox-group">
                    <label class="checkbox-label">
                        <input type="checkbox" name="pro" value="true">
                        <span>Pro services only</span>
                    </label>
                </div>
            </div>

            <div class="filter-section">
                <h3>Seller Location</h3>
                <select class="location-select">
                    <option value="">Select a location</option>
                    <option value="us">United States</option>
                    <option value="uk">United Kingdom</option>
                    <option value="ca">Canada</option>
                    <!-- Add more locations -->
                </select>
            </div>
        </aside>

        <!-- Main Content -->
        <main class="services-content">
            <!-- Top Bar -->
            <div class="services-top-bar">
                <div class="services-count">
                    <span>${category.servicesCount} services available</span>
                </div>
                <div class="sort-controls">
                    <label>Sort by:</label>
                    <select class="sort-select">
                        <option value="recommended">Recommended</option>
                        <option value="best-selling">Best Selling</option>
                        <option value="newest">Newest Arrivals</option>
                        <option value="price-low">Price: Low to High</option>
                        <option value="price-high">Price: High to Low</option>
                    </select>
                </div>
            </div>

            <!-- Services Grid -->
            <div class="services-grid">
                <c:forEach items="${services}" var="service">
                    <div class="service-card">
                        <div class="service-image">
                            <img src="${service.thumbnail}" alt="${service.title}">
                            <button class="save-button">
                                <i class="far fa-heart"></i>
                            </button>
                        </div>
                        <div class="service-info">
                            <div class="seller-info">
                                <img src="${service.seller.avatar}" alt="${service.seller.name}">
                                <span class="seller-name">${service.seller.name}</span>
                                <span class="seller-level">${service.seller.level}</span>
                            </div>
                            <h3 class="service-title">
                                <a href="${pageContext.request.contextPath}/gig/${service.id}">${service.title}</a>
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
                <button class="page-btn" disabled><i class="fas fa-chevron-left"></i></button>
                <button class="page-btn active">1</button>
                <button class="page-btn">2</button>
                <button class="page-btn">3</button>
                <span class="page-dots">...</span>
                <button class="page-btn">12</button>
                <button class="page-btn"><i class="fas fa-chevron-right"></i></button>
            </div>
        </main>
    </div>
</div>

<jsp:include page="../jsp/common/footer.jsp" />

<script src="${pageContext.request.contextPath}/js/categories/category.js"></script>
</body>
</html>
