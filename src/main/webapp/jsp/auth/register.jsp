<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>Join WorkPulse - Create Account</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/auth/auth.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/auth/register.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/category/category.css">
</head>
<body>
<jsp:include page="../common/header.jsp" />
<div style="margin: 100px"></div>
<div class="auth-container">
  <div class="auth-box registration-box">
    <!-- Registration Steps Progress -->
    <div class="registration-progress">
      <div class="progress-step active" data-step="1">
        <div class="step-number">1</div>
        <span class="step-label">Account Type</span>
      </div>
      <div class="progress-step" data-step="2">
        <div class="step-number">2</div>
        <span class="step-label">Basic Info</span>
      </div>
      <div class="progress-step" data-step="3">
        <div class="step-number">3</div>
        <span class="step-label">Verification</span>
      </div>
    </div>

    <!-- Step 1: Account Type Selection -->
    <div class="registration-step" id="step1">
      <div class="auth-header">
        <h1>Join WorkPulse</h1>
        <p>Already have an account? <a href="${pageContext.request.contextPath}/login" class="link-green">Sign In</a></p>
      </div>

      <div class="account-types">
        <div class="account-type-card" data-type="buyer">
          <div class="type-icon">
            <i class="fas fa-shopping-bag"></i>
          </div>
          <h3>Join as a Buyer</h3>
          <p>Looking to hire talent and get work done</p>
          <button class="select-type-btn" data-type="buyer">
            Choose Buyer
            <i class="fas fa-arrow-right"></i>
          </button>
        </div>

        <div class="account-type-card" data-type="seller">
          <div class="type-icon">
            <i class="fas fa-user-tie"></i>
          </div>
          <h3>Join as a Seller</h3>
          <p>Looking to offer services and earn money</p>
          <button class="select-type-btn" data-type="seller">
            Choose Seller
            <i class="fas fa-arrow-right"></i>
          </button>
        </div>
      </div>
    </div>

    <!-- Step 2: Basic Information -->
    <div class="registration-step hidden" id="step2">
      <div class="auth-header">
        <h1>Create Your Account</h1>
        <p class="account-type-display">Registering as a <span id="selectedType">Buyer</span></p>
      </div>

      <form id="registrationForm" class="auth-form" novalidate>
        <div class="form-row">
          <div class="form-group">
            <label for="firstName">First Name</label>
            <div class="input-group">
              <i class="fas fa-user"></i>
              <input type="text" id="firstName" name="firstName" required>
            </div>
          </div>

          <div class="form-group">
            <label for="lastName">Last Name</label>
            <div class="input-group">
              <i class="fas fa-user"></i>
              <input type="text" id="lastName" name="lastName" required>
            </div>
          </div>
        </div>

        <div class="form-group">
          <label for="email">Email Address</label>
          <div class="input-group">
            <i class="fas fa-envelope"></i>
            <input type="email" id="email" name="email" required>
          </div>
        </div>

        <div class="form-group">
          <label for="username">Username</label>
          <div class="input-group">
            <i class="fas fa-at"></i>
            <input type="text" id="username" name="username" required>
          </div>
          <span class="input-hint">This will be your public display name</span>
        </div>

        <div class="form-group">
          <label for="password">Password</label>
          <div class="input-group">
            <i class="fas fa-lock"></i>
            <input type="password" id="password" name="password" required>
            <button type="button" class="toggle-password">
              <i class="fas fa-eye"></i>
            </button>
          </div>
          <div class="password-strength">
            <div class="strength-meter"></div>
            <span class="strength-text">Password strength: <span id="strengthLabel">Poor</span></span>
          </div>
        </div>

        <div class="form-group terms-group">
          <label class="checkbox-label">
            <input type="checkbox" name="terms" required>
            <span class="checkbox-custom"></span>
            I agree to the <a href="#" class="link-green">Terms of Service</a> and <a href="#" class="link-green">Privacy Policy</a>
          </label>
        </div>

        <div class="form-buttons">
          <button type="button" class="btn-secondary back-btn" data-step="1">
            <i class="fas fa-arrow-left"></i>
            Back
          </button>
          <button type="submit" class="auth-button">
            Continue
            <i class="fas fa-arrow-right"></i>
          </button>
        </div>
      </form>
    </div>

    <!-- Step 3: Verification -->
    <div class="registration-step hidden" id="step3">
      <div class="auth-header">
        <h1>Verify Your Email</h1>
        <p>We've sent a verification code to your email</p>
      </div>

      <div class="verification-content">
        <div class="verification-code-input">
          <input type="text" maxlength="1" class="code-digit">
          <input type="text" maxlength="1" class="code-digit">
          <input type="text" maxlength="1" class="code-digit">
          <input type="text" maxlength="1" class="code-digit">
          <input type="text" maxlength="1" class="code-digit">
          <input type="text" maxlength="1" class="code-digit">
        </div>

        <p class="verification-hint">
          Didn't receive the code?
          <button type="button" class="resend-btn" id="resendCode">
            Resend Code
            <span class="countdown hidden">(<span id="countdown">60</span>s)</span>
          </button>
        </p>

        <div class="form-buttons">
          <button type="button" class="btn-secondary back-btn" data-step="2">
            <i class="fas fa-arrow-left"></i>
            Back
          </button>
          <button type="button" class="auth-button" id="verifyButton">
            Verify & Complete
            <i class="fas fa-arrow-right"></i>
          </button>
        </div>
      </div>
    </div>
  </div>
</div>

<jsp:include page="../common/footer.jsp" />

<script src="${pageContext.request.contextPath}/js/auth/register.js"></script>
</body>
</html>
