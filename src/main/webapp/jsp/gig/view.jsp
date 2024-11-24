<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>${gig.title} | WorkPulse</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/gig/view.css">
</head>
<body>
<jsp:include page="../common/header.jsp" />

<main class="gig-view">
    <!-- Breadcrumb -->
    <div class="breadcrumb-container">
        <div class="container">
            <div class="breadcrumb">
                <a href="/">Home</a>
                <i class="fas fa-chevron-right"></i>
                <a href="/categories/${gig.category.slug}">${gig.category.name}</a>
                <i class="fas fa-chevron-right"></i>
                <span>${gig.subcategory.name}</span>
            </div>
        </div>
    </div>

    <!-- Gig Content -->
    <div class="container">
        <div class="gig-content">
            <!-- Left Column -->
            <div class="gig-main">
                <h1 class="gig-title">${gig.title}</h1>

                <!-- Seller Info -->
                <div class="seller-info">
                    <img src="${gig.seller.avatar}" alt="${gig.seller.name}" class="seller-avatar">
                    <div class="seller-details">
                        <div class="seller-name-level">
                            <a href="/profile/${gig.seller.username}" class="seller-name">${gig.seller.name}</a>
                            <span class="seller-level">${gig.seller.level}</span>
                        </div>
                        <div class="seller-rating">
                            <div class="rating-stars">
                                <i class="fas fa-star"></i>
                                <span>${gig.seller.rating}</span>
                            </div>
                            <span class="rating-count">(${gig.seller.reviewCount})</span>
                        </div>
                    </div>
                    <button class="contact-seller">
                        <i class="fas fa-comment"></i>
                        Contact Me
                    </button>
                </div>

                <!-- Gig Gallery -->
                <div class="gig-gallery">
                    <div class="swiper">
                        <div class="swiper-wrapper">
                            <c:forEach items="${gig.images}" var="image">
                                <div class="swiper-slide">
                                    <img src="${image.url}" alt="${gig.title}">
                                </div>
                            </c:forEach>
                        </div>
                        <div class="swiper-pagination"></div>
                        <div class="swiper-button-prev"></div>
                        <div class="swiper-button-next"></div>
                    </div>
                    <div class="gallery-thumbs">
                        <c:forEach items="${gig.images}" var="image" varStatus="status">
                            <div class="thumb ${status.index == 0 ? 'active' : ''}">
                                <img src="${image.url}" alt="Thumbnail">
                            </div>
                        </c:forEach>
                    </div>
                </div>

                <!-- About This Gig -->
                <section class="gig-section">
                    <h2>About This Gig</h2>
                    <div class="gig-description">
                        ${gig.description}
                    </div>
                </section>

                <!-- About The Seller -->
                <section class="gig-section">
                    <h2>About The Seller</h2>
                    <div class="seller-profile">
                        <div class="seller-header">
                            <img src="${gig.seller.avatar}" alt="${gig.seller.name}">
                            <div class="seller-info-detailed">
                                <h3>${gig.seller.name}</h3>
                                <p>${gig.seller.tagline}</p>
                                <div class="seller-stats">
                                    <div class="stat">
                                        <i class="fas fa-star"></i>
                                        <span>${gig.seller.rating} Rating</span>
                                    </div>
                                    <div class="stat">
                                        <i class="fas fa-check-circle"></i>
                                        <span>${gig.seller.completedOrders} Orders</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="seller-bio">
                            ${gig.seller.bio}
                        </div>
                    </div>
                </section>

                <!-- Compare Packages -->
                <section class="gig-section">
                    <h2>Compare Packages</h2>
                    <div class="packages-table">
                        <table>
                            <thead>
                            <tr>
                                <th>Package</th>
                                <th>Basic</th>
                                <th>Standard</th>
                                <th>Premium</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="price-row">
                                <td>Price</td>
                                <td>$${gig.packages.basic.price}</td>
                                <td>$${gig.packages.standard.price}</td>
                                <td>$${gig.packages.premium.price}</td>
                            </tr>
                            <tr>
                                <td>Delivery Time</td>
                                <td>${gig.packages.basic.deliveryTime} days</td>
                                <td>${gig.packages.standard.deliveryTime} days</td>
                                <td>${gig.packages.premium.deliveryTime} days</td>
                            </tr>
                            <tr>
                                <td>Revisions</td>
                                <td>${gig.packages.basic.revisions}</td>
                                <td>${gig.packages.standard.revisions}</td>
                                <td>${gig.packages.premium.revisions}</td>
                            </tr>
                            <!-- Add more package features -->
                            </tbody>
                        </table>
                    </div>
                </section>

                <!-- Reviews -->
                <section class="gig-section">
                    <div class="reviews-header">
                        <h2>Reviews</h2>
                        <div class="rating-summary">
                            <div class="rating-average">
                                <span class="rating-number">${gig.rating}</span>
                                <div class="rating-stars">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star-half-alt"></i>
                                </div>
                            </div>
                            <span class="review-count">${gig.reviewCount} reviews</span>
                        </div>
                    </div>

                    <!-- Review Filters -->
                    <div class="review-filters">
                        <select class="rating-filter">
                            <option value="">All Ratings</option>
                            <option value="5">5 Stars</option>
                            <option value="4">4 Stars</option>
                            <option value="3">3 Stars</option>
                            <option value="2">2 Stars</option>
                            <option value="1">1 Star</option>
                        </select>
                    </div>

                    <!-- Reviews List -->
                    <div class="reviews-list">
                        <c:forEach items="${gig.reviews}" var="review">
                            <div class="review-item">
                                <div class="review-header">
                                    <img src="${review.buyer.avatar}" alt="${review.buyer.name}">
                                    <div class="reviewer-info">
                                        <div class="reviewer-name">${review.buyer.name}</div>
                                        <div class="review-meta">
                                            <div class="rating-stars">
                                                <c:forEach begin="1" end="5" var="i">
                                                    <i class="fas fa-star ${i <= review.rating ? 'filled' : ''}"></i>
                                                </c:forEach>
                                            </div>
                                            <span class="review-date">${review.date}</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="review-content">
                                        ${review.content}
                                </div>
                            </div>
                        </c:forEach>
                    </div>

                    <!-- Load More Reviews -->
                    <button class="load-more-reviews">
                        Show More Reviews
                        <i class="fas fa-chevron-down"></i>
                    </button>
                </section>
            </div>

            <!-- Right Column - Pricing Packages -->
            <div class="gig-sidebar">
                <div class="pricing-packages">
                    <!-- Package Tabs -->
                    <div class="package-tabs">
                        <button class="package-tab active" data-package="basic">Basic</button>
                        <button class="package-tab" data-package="standard">Standard</button>
                        <button class="package-tab" data-package="premium">Premium</button>
                    </div>

                    <!-- Package Content -->
                    <div class="package-content">
                        <div class="package-header">
                            <h3 class="package-name">Basic Package</h3>
                            <div class="package-price">$${gig.packages.basic.price}</div>
                        </div>

                        <div class="package-description">
                            ${gig.packages.basic.description}
                        </div>

                        <div class="package-details">
                            <div class="detail-item">
                                <i class="fas fa-clock"></i>
                                <span>${gig.packages.basic.deliveryTime} Days Delivery</span>
                            </div>
                            <div class="detail-item">
                                <i class="fas fa-sync"></i>
                                <span>${gig.packages.basic.revisions} Revisions</span>
                            </div>
                        </div>

                        <div class="package-features">
                            <c:forEach items="${gig.packages.basic.features}" var="feature">
                                <div class="feature-item">
                                    <i class="fas fa-check"></i>
                                    <span>${feature}</span>
                                </div>
                            </c:forEach>
                        </div>

                        <button class="continue-btn">
                            Continue
                            <i class="fas fa-arrow-right"></i>
                        </button>
                    </div>
                </div>

                <!-- Contact Seller -->
                <div class="contact-section">
                    <button class="contact-seller-btn">
                        <i class="fas fa-comment"></i>
                        Contact Seller
                    </button>
                </div>
            </div>
        </div>

        <!-- Related Gigs -->
        <section class="related-gigs">
            <h2>Related Gigs</h2>
            <div class="related-gigs-grid">
                <c:forEach items="${relatedGigs}" var="relatedGig">
                    <div class="gig-card">
                        <div class="gig-image">
                            <img src="${relatedGig.thumbnail}" alt="${relatedGig.title}">
                            <button class="save-button" data-id="${relatedGig.id}">
                                <i class="far fa-heart"></i>
                            </button>
                        </div>
                        <div class="gig-info">
                            <div class="seller-info">
                                <img src="${relatedGig.seller.avatar}" alt="${relatedGig.seller.name}">
                                <span class="seller-name">${relatedGig.seller.name}</span>
                            </div>
                            <h3 class="gig-title">
                                <a href="/gig/${relatedGig.id}">${relatedGig.title}</a>
                            </h3>
                            <div class="gig-rating">
                                <i class="fas fa-star"></i>
                                <span>${relatedGig.rating}</span>
                                <span>(${relatedGig.reviewCount})</span>
                            </div>
                            <div class="gig-price">
                                <span>Starting at</span>
                                <strong>$${relatedGig.startingPrice}</strong>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>
    </div>
</main>

<jsp:include page="../common/footer.jsp" />

<script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/js/gig/view.js"></script>
</body>
</html>
