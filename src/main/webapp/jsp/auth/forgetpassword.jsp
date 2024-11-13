<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>WorkPulse - Reset Password</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/auth/auth.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/auth/forgot-password.css">
</head>
<body>

<div class="auth-container">
    <!-- Step 1: Email Input -->
    <div class="auth-box" id="step1">
        <div class="auth-header">
            <h1>Reset Your Password</h1>
            <p>Enter your email address and we'll send you a link to reset your password.</p>
        </div>

        <form class="auth-form" id="resetForm">
            <div class="form-group">
                <label for="email">Email</label>
                <div class="input-group">
                    <i class="fas fa-envelope"></i>
                    <input type="email" id="email" name="email" required
                           placeholder="Enter your email address">
                </div>
                <div class="error-message" id="emailError"></div>
            </div>

            <button type="submit" class="auth-button">
                Send Reset Link
                <i class="fas fa-arrow-right"></i>
            </button>

            <div class="form-footer">
                <p>Remember your password? <a href="${pageContext.request.contextPath}/login" class="link-green">Back to Login</a></p>
            </div>
        </form>
    </div>

    <!-- Step 2: Email Sent Confirmation -->
    <div class="auth-box hidden" id="step2">
        <div class="auth-header">
            <div class="confirmation-icon">
                <i class="fas fa-envelope"></i>
            </div>
            <h1>Check Your Email</h1>
            <p>We've sent a password reset link to <span id="sentEmailAddress">your email</span></p>
        </div>

        <div class="confirmation-content">
            <div class="instruction-box">
                <h3>Didn't receive the email?</h3>
                <ul>
                    <li>Check your spam folder</li>
                    <li>Make sure the email address is correct</li>
                    <li>Wait a few minutes and check again</li>
                </ul>
            </div>

            <button type="button" class="auth-button secondary" id="resendButton">
                Resend Email
                <span class="countdown hidden">(<span id="countdown">60</span>s)</span>
            </button>

            <div class="form-footer">
                <p>Need help? <a href="#" class="link-green">Contact Support</a></p>
            </div>
        </div>
    </div>

    <!-- Step 3: New Password Form (shown when user clicks reset link) -->
    <div class="auth-box hidden" id="step3">
        <div class="auth-header">
            <h1>Create New Password</h1>
            <p>Please enter a new password for your account.</p>
        </div>

        <form class="auth-form" id="newPasswordForm">
            <div class="form-group">
                <label for="newPassword">New Password</label>
                <div class="input-group">
                    <i class="fas fa-lock"></i>
                    <input type="password" id="newPassword" name="newPassword" required>
                    <button type="button" class="toggle-password">
                        <i class="fas fa-eye"></i>
                    </button>
                </div>
                <div class="password-strength">
                    <div class="strength-meter"></div>
                    <span class="strength-text">Password strength: <span id="strengthLabel">Poor</span></span>
                </div>
            </div>

            <div class="form-group">
                <label for="confirmPassword">Confirm New Password</label>
                <div class="input-group">
                    <i class="fas fa-lock"></i>
                    <input type="password" id="confirmPassword" name="confirmPassword" required>
                    <button type="button" class="toggle-password">
                        <i class="fas fa-eye"></i>
                    </button>
                </div>
                <div class="error-message" id="passwordError"></div>
            </div>

            <button type="submit" class="auth-button">
                Reset Password
                <i class="fas fa-arrow-right"></i>
            </button>
        </form>
    </div>

    <!-- Step 4: Success Confirmation -->
    <div class="auth-box hidden" id="step4">
        <div class="auth-header">
            <div class="confirmation-icon success">
                <i class="fas fa-check"></i>
            </div>
            <h1>Password Reset Successfully</h1>
            <p>Your password has been changed successfully.</p>
        </div>

        <div class="confirmation-content">
            <a href="${pageContext.request.contextPath}/login" class="auth-button">
                Continue to Login
                <i class="fas fa-arrow-right"></i>
            </a>
        </div>
    </div>
</div>


<script src="${pageContext.request.contextPath}/js/auth/forgot-password.js"></script>
</body>
</html>
