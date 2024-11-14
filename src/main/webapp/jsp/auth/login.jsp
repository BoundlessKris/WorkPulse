<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login - WorkPulse</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/auth/auth.css">
</head>
<body>

<div class="auth-container">
    <div class="auth-box">
        <div class="auth-header">
            <h1>Sign In to WorkPulse</h1>
            <p>Don't have an account? <a href="${pageContext.request.contextPath}/register" class="link-green">Join Now</a></p>
        </div>

        <!-- Social Login Buttons -->
        <div class="social-login">
            <button class="social-btn google-btn">
                <i class="fab fa-google"></i>
                Continue with Google
            </button>
            <button class="social-btn facebook-btn">
                <i class="fab fa-facebook-f"></i>
                Continue with Facebook
            </button>
        </div>

        <div class="divider">
            <span>OR</span>
        </div>

        <!-- Login Form -->
        <form action="${pageContext.request.contextPath}/login" method="POST" class="auth-form" id="loginForm">
            <!-- Error Message -->
            <c:if test="${not empty error}">
                <div class="alert alert-error">
                    <i class="fas fa-exclamation-circle"></i>
                        ${error}
                </div>
            </c:if>

            <!-- Success Message -->
            <c:if test="${not empty success}">
                <div class="alert alert-success">
                    <i class="fas fa-check-circle"></i>
                        ${success}
                </div>
            </c:if>

            <div class="form-group">
                <label for="username">Username/Email</label>
                <div class="input-group">
                    <i class="fas fa-user"></i>
                    <input type="text"
                           id="username"
                           name="username"
                           required
                           placeholder="Enter your username or email"
                           value="${param.username}">
                </div>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <div class="input-group">
                    <i class="fas fa-lock"></i>
                    <input type="password"
                           id="password"
                           name="password"
                           required
                           placeholder="Enter your password">
                    <button type="button" class="toggle-password">
                        <i class="fas fa-eye"></i>
                    </button>
                </div>
            </div>

            <div class="form-group-inline">
                <label class="checkbox-label">
                    <input type="checkbox" name="remember" id="remember">
                    <span class="checkbox-custom"></span>
                    Remember me
                </label>
                <a href="${pageContext.request.contextPath}/jsp/auth/forgetpassword.jsp" class="forgot-link">Forgot Password?</a>
            </div>

            <button type="submit" class="auth-button">
                Sign In
                <i class="fas fa-arrow-right"></i>
            </button>
        </form>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/auth/auth.js"></script>
</body>
</html>
