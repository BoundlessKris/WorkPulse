<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>${users.username} | WorkPulse</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile/view.css">
</head>
<body>
<jsp:include page="../common/header.jsp" />
<div style="margin: 100px"></div>

<main class="profile-view">
  <!-- Profile Header -->
  <div class="profile-header">
    <div class="container">
      <div class="profile-info">
        <div class="profile-avatar">
          <img src="${pageContext.request.contextPath}/profile.jpeg" alt="${users.username}">
          ${users.isOnline ? '<span class="online-status"></span>' : ''}
        </div>
        <div class="profile-details">
          <div class="name-status">
            <h1>${users.username}</h1>
            <div class="user-status">
              <span class="status-dot ${users.isOnline ? 'online' : ''}"></span>
              ${users.isOnline ? 'Online' : 'Offline'}
            </div>
          </div>
          <div class="user-title">${users.title}</div>
          <div class="user-meta">
            <div class="meta-item">
              <i class="fas fa-map-marker-alt"></i>
              <span>${users.location}</span>
            </div>
            <div class="meta-item">
              <i class="fas fa-user-clock"></i>
              <span>Member since ${users.created_at}</span>
            </div>
            <div class="meta-item">
              <i class="fas fa-clock"></i>
              <span>Last delivery ${users.created_at}</span>
            </div>
          </div>
          <div class="profile-actions">
            <button class="btn-primary contact-seller">
              <i class="fas fa-comment"></i>
              Contact Me
            </button>
            <c:if test="${isOwnProfile}">
              <a href="/profile/edit" class="btn-secondary">
                <i class="fas fa-edit"></i>
                Edit Profile
              </a>
            </c:if>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="container">
    <div class="profile-content">
      <!-- Left Column -->
      <div class="profile-main">
        <!-- Stats Section -->
        <section class="profile-section stats-section">
          <div class="stats-grid">
            <div class="stat-card">
              <div class="stat-value">
                <i class="fas fa-star"></i>
                ${users.rating}
              </div>
              <div class="stat-label">Rating</div>
            </div>
            <div class="stat-card">
              <div class="stat-value">${users.created_at}</div>
              <div class="stat-label">Orders Completed</div>
            </div>
            <div class="stat-card">
              <div class="stat-value">${users.created_at}</div>
              <div class="stat-label">Response Time</div>
            </div>
            <div class="stat-card">
              <div class="stat-value">${users.deliveryRate}%</div>
              <div class="stat-label">On-time Delivery</div>
            </div>
          </div>
        </section>

        <!-- Description Section -->
        <section class="profile-section">
          <h2>About Me</h2>
          <div class="description-content">
            ${users.description}
          </div>
        </section>

        <!-- Languages Section -->
        <section class="profile-section">
          <h2>Languages</h2>
          <div class="languages-list">
            <c:forEach items="${user.languages}" var="language">
              <div class="language-item">
                <span class="language-name">${language.name}</span>
                <span class="language-level">${language.level}</span>
              </div>
            </c:forEach>
          </div>
        </section>

        <!-- Skills Section -->
        <section class="profile-section">
          <h2>Skills</h2>
          <div class="skills-list">
            <c:forEach items="${user.skills}" var="skill">
              <span class="skill-tag">${skill}</span>
            </c:forEach>
          </div>
        </section>

        <!-- Education Section -->
        <section class="profile-section">
          <h2>Education</h2>
          <div class="education-list">
            <c:forEach items="${user.education}" var="edu">
              <div class="education-item">
                <div class="education-icon">
                  <i class="fas fa-graduation-cap"></i>
                </div>
                <div class="education-details">
                  <h3>${edu.degree}</h3>
                  <div class="education-meta">
                    <span>${edu.institution}</span>
                    <span>${edu.graduationYear}</span>
                  </div>
                </div>
              </div>
            </c:forEach>
          </div>
        </section>

        <!-- Certifications Section -->
        <section class="profile-section">
          <h2>Certifications</h2>
          <div class="certifications-list">
            <c:forEach items="${user.certifications}" var="cert">
              <div class="certification-item">
                <div class="certification-icon">
                  <i class="fas fa-certificate"></i>
                </div>
                <div class="certification-details">
                  <h3>${cert.name}</h3>
                  <div class="certification-meta">
                    <span>${cert.issuer}</span>
                    <span>${cert.year}</span>
                  </div>
                </div>
              </div>
            </c:forEach>
          </div>
        </section>

        <!-- Reviews Section -->
        <section class="profile-section reviews-section">
          <div class="section-header">
            <h2>Reviews</h2>
            <div class="reviews-summary">
              <div class="rating-stars">
                <i class="fas fa-star"></i>
                <span>${user.rating}</span>
              </div>
              <span class="review-count">${user.reviewCount} reviews</span>
            </div>
          </div>

          <div class="reviews-list">
            <c:forEach items="${reviews}" var="review">
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

          <button class="load-more">
            Show More Reviews
            <i class="fas fa-chevron-down"></i>
          </button>
        </section>
      </div>

      <!-- Right Column -->
      <aside class="profile-sidebar">
        <!-- Active Gigs Section -->
        <section class="sidebar-section">
          <h2>Active Gigs</h2>
          <div class="gigs-list">
            <c:forEach items="${user.gigs}" var="gig">
              <div class="gig-card">
                <div class="gig-image">
                  <img src="${gig.thumbnail}" alt="${gig.title}">
                  <button class="save-button" data-id="${gig.id}">
                    <i class="far fa-heart"></i>
                  </button>
                </div>
                <div class="gig-info">
                  <h3 class="gig-title">
                    <a href="/gig/${gig.id}">${gig.title}</a>
                  </h3>
                  <div class="gig-rating">
                    <i class="fas fa-star"></i>
                    <span>${gig.rating}</span>
                    <span>(${gig.reviewCount})</span>
                  </div>
                  <div class="gig-price">
                    <span>Starting at</span>
                    <strong>$${gig.startingPrice}</strong>
                  </div>
                </div>
              </div>
            </c:forEach>
          </div>
        </section>

        <!-- Linked Accounts -->
        <section class="sidebar-section">
          <h2>Linked Accounts</h2>
          <div class="linked-accounts">
            <c:forEach items="${user.linkedAccounts}" var="account">
              <a href="${account.url}" class="social-link ${account.platform}">
                <i class="fab fa-${account.platform}"></i>
                <span>${account.username}</span>
              </a>
            </c:forEach>
          </div>
        </section>
      </aside>
    </div>
  </div>
</main>

<jsp:include page="../common/footer.jsp" />

<script src="${pageContext.request.contextPath}/js/profile/view.js"></script>
</body>
</html>
