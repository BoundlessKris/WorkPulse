<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>Edit Profile | WorkPulse</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile/edit.css">
</head>
<body>
<jsp:include page="../common/header.jsp" />

<div class="profile-edit">
  <div class="container">
    <!-- Page Header -->
    <div class="page-header">
      <h1>Edit Profile</h1>
      <p>Manage your profile information and visibility</p>
    </div>

    <div class="edit-content">
      <!-- Left Sidebar - Navigation -->
      <aside class="edit-nav">
        <nav class="nav-sections">
          <a href="#personal" class="nav-item active">
            <i class="fas fa-user"></i>
            Personal Info
          </a>
          <a href="#professional" class="nav-item">
            <i class="fas fa-briefcase"></i>
            Professional Info
          </a>
          <a href="#skills" class="nav-item">
            <i class="fas fa-tools"></i>
            Skills & Experience
          </a>
          <a href="#education" class="nav-item">
            <i class="fas fa-graduation-cap"></i>
            Education
          </a>
          <a href="#certifications" class="nav-item">
            <i class="fas fa-certificate"></i>
            Certifications
          </a>
          <a href="#social" class="nav-item">
            <i class="fas fa-share-alt"></i>
            Social Accounts
          </a>
        </nav>
      </aside>

      <!-- Main Content - Edit Forms -->
      <main class="edit-forms">
        <!-- Personal Info Section -->
        <section id="personal" class="edit-section">
          <h2>Personal Information</h2>
          <form class="edit-form" id="personalForm">
            <!-- Profile Picture -->
            <div class="form-group avatar-group">
              <label>Profile Picture</label>
              <div class="avatar-upload">
                <div class="current-avatar">
                  <img src="${user.avatarUrl}" alt="Profile Picture">
                </div>
                <div class="upload-controls">
                  <button type="button" class="btn-secondary upload-btn">
                    <i class="fas fa-upload"></i>
                    Upload New Picture
                  </button>
                  <input type="file" id="avatarInput" accept="image/*" hidden>
                  <p class="upload-hint">Maximum size 1MB. JPG, PNG or GIF.</p>
                </div>
              </div>
            </div>

            <!-- Full Name -->
            <div class="form-row">
              <div class="form-group">
                <label for="firstName">First Name</label>
                <input type="text" id="firstName" name="firstName"
                       value="${user.firstName}" required>
              </div>
              <div class="form-group">
                <label for="lastName">Last Name</label>
                <input type="text" id="lastName" name="lastName"
                       value="${user.lastName}" required>
              </div>
            </div>

            <!-- Display Name -->
            <div class="form-group">
              <label for="displayName">Display Name</label>
              <input type="text" id="displayName" name="displayName"
                     value="${user.displayName}" required>
              <p class="input-hint">This is how you'll appear to other users</p>
            </div>

            <!-- Location -->
            <div class="form-group">
              <label for="location">Location</label>
              <select id="location" name="location" required>
                <c:forEach items="${countries}" var="country">
                  <option value="${country.code}"
                    ${user.location == country.code ? 'selected' : ''}>
                      ${country.name}
                  </option>
                </c:forEach>
              </select>
            </div>

            <!-- Description -->
            <div class="form-group">
              <label for="description">Description</label>
              <textarea id="description" name="description" rows="5"
                        maxlength="600">${user.description}</textarea>
              <div class="char-count">0/600</div>
            </div>

            <!-- Save Button -->
            <div class="form-actions">
              <button type="submit" class="btn-primary">
                Save Changes
              </button>
            </div>
          </form>
        </section>

        <!-- Professional Info Section -->
        <section id="professional" class="edit-section hidden">
          <h2>Professional Information</h2>
          <form class="edit-form" id="professionalForm">
            <!-- Professional Title -->
            <div class="form-group">
              <label for="title">Professional Title</label>
              <input type="text" id="title" name="title"
                     value="${user.professionalTitle}" required>
              <p class="input-hint">Example: Web Developer, Graphic Designer, etc.</p>
            </div>

            <!-- Languages -->
            <div class="form-group">
              <label>Languages</label>
              <div class="languages-list">
                <c:forEach items="${user.languages}" var="language">
                  <div class="language-item">
                    <select name="language[]" required>
                      <c:forEach items="${availableLanguages}" var="lang">
                        <option value="${lang.code}"
                          ${language.code == lang.code ? 'selected' : ''}>
                            ${lang.name}
                        </option>
                      </c:forEach>
                    </select>
                    <select name="languageLevel[]" required>
                      <option value="basic" ${language.level == 'basic' ? 'selected' : ''}>
                        Basic
                      </option>
                      <option value="conversational" ${language.level == 'conversational' ? 'selected' : ''}>
                        Conversational
                      </option>
                      <option value="fluent" ${language.level == 'fluent' ? 'selected' : ''}>
                        Fluent
                      </option>
                      <option value="native" ${language.level == 'native' ? 'selected' : ''}>
                        Native/Bilingual
                      </option>
                    </select>
                    <button type="button" class="remove-language">
                      <i class="fas fa-times"></i>
                    </button>
                  </div>
                </c:forEach>
              </div>
              <button type="button" class="btn-secondary add-language">
                <i class="fas fa-plus"></i>
                Add Language
              </button>
            </div>

            <!-- Skills -->
            <div class="form-group">
              <label>Skills</label>
              <div class="skills-input">
                <div class="skills-list">
                  <c:forEach items="${user.skills}" var="skill">
                                            <span class="skill-tag">
                                                ${skill}
                                                <button type="button" class="remove-skill">
                                                    <i class="fas fa-times"></i>
                                                </button>
                                            </span>
                  </c:forEach>
                </div>
                <input type="text" id="skillInput" placeholder="Add a skill...">
              </div>
              <p class="input-hint">Add up to 15 skills</p>
            </div>

            <!-- Save Button -->
            <div class="form-actions">
              <button type="submit" class="btn-primary">
                Save Changes
              </button>
            </div>
          </form>
        </section>

        <!-- Skills & Experience Section -->
        <section id="skills" class="edit-section hidden">
          <h2>Skills & Experience</h2>
          <form class="edit-form" id="skillsForm">
            <!-- Skills Categories -->
            <div class="form-group">
              <label>Skill Categories</label>
              <div class="skill-categories">
                <c:forEach items="${skillCategories}" var="category">
                  <div class="category-card">
                    <h3>${category.name}</h3>
                    <div class="category-skills">
                      <c:forEach items="${category.skills}" var="skill">
                        <label class="checkbox-label">
                          <input type="checkbox" name="skills[]"
                                 value="${skill.id}"
                            ${user.skills.contains(skill.id) ? 'checked' : ''}>
                          <span>${skill.name}</span>
                        </label>
                      </c:forEach>
                    </div>
                  </div>
                </c:forEach>
              </div>
            </div>

            <!-- Experience Level -->
            <div class="form-group">
              <label for="experienceLevel">Experience Level</label>
              <select id="experienceLevel" name="experienceLevel" required>
                <option value="entry" ${user.experienceLevel == 'entry' ? 'selected' : ''}>
                  Entry Level
                </option>
                <option value="intermediate" ${user.experienceLevel == 'intermediate' ? 'selected' : ''}>
                  Intermediate
                </option>
                <option value="expert" ${user.experienceLevel == 'expert' ? 'selected' : ''}>
                  Expert
                </option>
              </select>
            </div>

            <!-- Save Button -->
            <div class="form-actions">
              <button type="submit" class="btn-primary">
                Save Changes
              </button>
            </div>
          </form>
        </section>

        <!-- Education Section -->
        <section id="education" class="edit-section hidden">
          <!-- Education form content -->
        </section>

        <!-- Certifications Section -->
        <section id="certifications" class="edit-section hidden">
          <!-- Certifications form content -->
        </section>

        <!-- Social Accounts Section -->
        <section id="social" class="edit-section hidden">
          <!-- Social accounts form content -->
        </section>
      </main>
    </div>
  </div>
</div>

<jsp:include page="../common/footer.jsp" />

<script src="${pageContext.request.contextPath}/js/profile/edit.js"></script>
</body>
</html>
