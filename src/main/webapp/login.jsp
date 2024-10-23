<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login & Sign Up</title>
    <!-- Link to external CSS for styles -->
    <link rel="stylesheet" href="./css/login.css">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

<div class="wrapper">
    <!-- Background animation spans -->
    <span class="bg-animate"></span>
    <span class="bg-animate2"></span>

    <!-- Login form container -->
    <div class="form-box login">
        <h2 class="animation" style="--data:0;">Login</h2>
        <!-- Modify form to post to UserLoginServlet -->
        <form action="UserLoginServlet" method="post">
            <!-- Username input -->
            <div class="input-box animation" style="--data:1;">
                <input type="text" name="username" placeholder="">
                <label>Username</label>
                <i class="fa-solid fa-user"></i> <!-- User icon -->
            </div>

            <!-- Password input -->
            <div class="input-box animation" style="--data:3;">
                <input type="password" name="password" placeholder="">
                <label>Password</label>
                <i class="fa-solid fa-lock"></i> <!-- Lock icon -->
            </div>

            <!-- Submit button -->
            <button type="submit" class="btn animation" style="--data:4">Login</button>

            <!-- Link to sign-up form -->
            <div class="reg-link animation" style="--data:4;">
                <p>Don't have an account? <a href="#" class="signup-link">Sign Up</a></p>
            </div>
        </form>
    </div>

    <!-- Welcome back message for login -->
    <div class="info-text login">
        <h2 class="animation" style="--data:0;">Welcome Back!</h2>
        <p class="animation" style="--data:1">Lorem ipsum dolor sit amet consectetur adipisicing.</p>
    </div>

    <!-- Sign-Up form container -->
    <div class="form-box signup">
        <h2 class="animation">Sign Up</h2>
        <!-- Modify form to post to UserRegistrationServlet -->
        <form action="UserRegistrationServlet" method="post">
            <!-- Username input -->
            <div class="input-box animation" style="--data:17">
                <input type="text" name="username" placeholder="">
                <label>Username</label>
                <i class="fa-solid fa-user"></i> <!-- User icon -->
            </div>

            <!-- Email input -->
            <div class="input-box animation" style="--data:18">
                <input type="email" name="email" placeholder="">
                <label>Email</label>
                <i class="fa-solid fa-envelope"></i> <!-- Envelope icon -->
            </div>

            <!-- Password input -->
            <div class="input-box animation" style="--data:19">
                <input type="password" name="password" placeholder="">
                <label>Password</label>
                <i class="fa-solid fa-lock"></i> <!-- Lock icon -->
            </div>
            <div class="input-box animation" style="--data:19">
                <input type="password" name="confirmPassword" placeholder="" >
                <label>Confirm Password</label>
                <i class="fa-solid fa-lock"></i> <!-- Lock icon -->
            </div>
            <div class="input-box animation" style="--data:19">
                UserType :
                <select name="userType" class="select">
                    <option value="" disabled selected>Select Role</option>
                    <option value="buyer">Buyer</option>
                    <option value="seller">Seller</option>
                </select>
            </div>
            <!-- Submit button -->
            <button type="submit" class="btn animation" style="--data:20">Sign Up</button>

            <!-- Link to login form -->
            <div class="reg-link animation" style="--data:21">
                <p>Already have an account? <a href="#" class="login-link">Login</a></p>
            </div>
        </form>
    </div>

    <!-- Welcome back message for signup -->
    <div class="info-text signup">
        <h2 class="animation" style="--data:22">Welcome Back!</h2>
        <p class="animation" style="--data:23">Lorem ipsum dolor sit amet consectetur adipisicing.</p>
    </div>
</div>

<!-- External JavaScript file -->
<script src="./script/login.js"></script>
</body>
</html>
