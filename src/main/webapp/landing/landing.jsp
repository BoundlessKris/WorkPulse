<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WorkPulse - Freelance Services Marketplace</title>
    <link rel="stylesheet" href="../css/home.css">
    <!-- Google Icons Link -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0">
</head>
<body>

<!-- Navbar -->
<header>
    <nav class="navbar">
        <a href="#" class="logo">
            <img src="../assets/landing page imgs/work.png" alt="WorkPulse">
        </a>
        <ul class="menu-links">
            <li><a href="landing.jsp">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#categories">Categories</a></li>
            <li><a href="#services">Services</a></li>
            <li><a href="#">Explore</a></li>
            <li class="language-item">
                <a href="#">
                    <span class="material-symbols-outlined">language</span>
                    English
                </a>
            </li>
            <li><a href="#">Become a Seller</a></li>
            <li><a href="../login.jsp">Login</a></li>
            <li class="sign-up-btn"><a href="../register.jsp">Join Us</a></li>
            <span id="close-menu-btn" class="material-symbols-outlined">close</span>
        </ul>
        <span id="hamburger-btn" class="material-symbols-outlined">menu</span>
    </nav>
</header>

<!-- Hero Section -->
<section class="hero-section"
         style="background: url('../assets/landing page imgs/hero-img.jpg') no-repeat center center/cover;">
    <div class="content">
        <h1>Find the right freelance service, right away</h1>
        <form action="#" class="search-form">
            <input type="text" placeholder="Search for any service..." required>
            <button class="material-symbols-outlined" type="submit">search</button>
        </form>
        <div class="popular-tags">
            Popular:
            <ul class="tags">
                <li><a href="#">Webite Design</a></li>
                <li><a href="#">Logo Design</a></li>
                <li><a href="#">WordPress</a></li>
                <li><a href="#">AI Design</a></li>
            </ul>
        </div>
    </div>
</section>

<!-- Popular Categories -->
<a name="categories"></a>
<section class="categories">
    <h2>Explore Popular Categories</h2>
    <div class="category-list">
        <a href="../programming-tech.jsp" class="category-item">Programming & Tech</a>
        <a href="../graphic-design.jsp" class="category-item">Graphic Design</a>
        <a href="../digital-marketing.jsp" class="category-item">Digital Marketing</a>
        <a href="../writing-translation.jsp" class="category-item">Writing & Translation</a>
        <a href="../video-animation.jsp" class="category-item">Video & Animation</a>
        <a href="../ai-services.jsp" class="category-item">AI Services</a>
        <a href="../music-audio.jsp" class="category-item">Music & Audio</a>
        <a href="../consulting.jsp" class="category-item">Consulting</a>
    </div>
</section>

<!-- Featured Services -->
<a name="services"></a>
<section class="featured">
    <h2>Featured Freelanc Services</h2>
    <div class="service-list">
        <div class="service-item">
            <div class="service-card website-development">
                <h3>Website Development</h3>
                <img src="../assets/landing page imgs/web.webp" alt="Website Development">
            </div>
        </div>
        <div class="service-item">
            <div class="service-card logo-design">
                <h3>Logo Design</h3>
                <img src="../assets/landing page imgs/logo.webp" alt="Logo Design">
            </div>
        </div>
        <div class="service-item">
            <div class="service-card seo">
                <h3>SEO</h3>
                <img src="../assets/landing page imgs/seo.webp" alt="SEO">
            </div>
        </div>
        <div class="service-item">
            <div class="service-card social-media">
                <h3>Social Media Marketing</h3>
                <img src="../assets/landing page imgs/social.webp" alt="Social Media Marketing">
            </div>
        </div>
        <div class="service-item">
            <div class="service-card software-dev">
                <h3>Software Development</h3>
                <img src="../assets/landing page imgs/software.webp" alt="Software-dev">
            </div>
        </div>
        <div class="service-item">
            <div class="service-card ecommerce">
                <h3>E-Commerce Marketing</h3>
                <img src="../assets/landing page imgs/e-commerce.webp" alt="E-Commerce">
            </div>
        </div>
        <div class="service-item">
            <div class="service-card ml">
                <h3>Data Science & ML</h3>
                <img src="../assets/landing page imgs/ml.webp" alt="Data Science & ML">
            </div>
        </div>
        <div class="service-item">
            <div class="service-card architecture-design">
                <h3>Architecture & Interior Design</h3>
                <img src="../assets/landing page imgs/architecture-design.webp" alt="Data Science & ML">
            </div>
        </div>
        <div class="service-item">
            <div class="service-card product-photography">
                <h3>Product Photography</h3>
                <img src="../assets/landing page imgs/product-photography.webp" alt="Data Science & ML">
            </div>
        </div>
        <div class="service-item">
            <div class="service-card video-edit">
                <h3>Video Editing</h3>
                <img src="../assets/landing page imgs/video-editing.webp" alt="Data Science & ML">
            </div>
        </div>
    </div>
</section>

<!-- Freelance Info Section -->
<a name="about"></a>
<section class="freelance-info">
    <h2>A whole world of freelance talent at your fingertips</h2>
    <div class="info-container">
        <div class="info-item">
            <h3>Over 700 categories</h3>
            <p>Get results from skilled freelancers from all over the world,
                for every task, at any price point.</p>
        </div>
        <div class="vertical-bar"></div>
        <div class="info-item">
            <h3>Clear, transparent pricing</h3>
            <p>Pay per project or by the hour (Pro). Payments only get
                released when you approve.</p>
        </div>
        <div class="vertical-bar"></div>
        <div class="info-item">
            <h3>Quality work done faster</h3>
            <p>Filter to find the right freelancers quickly and get great
                work delivered in no time, every time.</p>
        </div>
        <div class="vertical-bar"></div>
        <div class="info-item">
            <h3>24/7 award-winning support</h3>
            <p>Chat with our team to get your questions answered or resolve
                any issues with your orders.</p>
        </div>
    </div>
</section>

<!-- Guides Section -->
<section class="guides">
    <h2>Guides to help you grow</h2>
    <div class="guides-container">
        <div class="guide-item">
            <img src="../assets/landing page imgs/business.jpg" alt="Start a side business">
            <p>Start a side business</p>
        </div>
        <div class="guide-item">
            <img src="../assets/landing page imgs/ecommerce-ideas.jpg" alt="Ecommerce business ideas">
            <p>Ecommerce business ideas</p>
        </div>
        <div class="guide-item">
            <img src="../assets/landing page imgs/online.png"
                 alt="Start an online business and work from home">
            <p>Start an online business and work from home</p>
        </div>
    </div>
</section>

<!-- WorkPulse Section -->
<section class="workpulse-section">
    <h2>
        Freelance services at your <span class="highlight">fingertips!</span>
    </h2>
    <button class="join-btn">Join WorkPulse</button>
</section>

<!-- Footer -->
<footer>
    <div class="footer-links">
        <a href="#">About Us</a> <a href="#">Terms of Service</a> <a href="#">Privacy
        Policy</a>
    </div>
    <p>&copy; 2024 WorkPulse. All rights reserved.</p>
</footer>

<script>
    const header = document.querySelector("header");
    const hamburgerBtn = document.querySelector("#hamburger-btn");
    const closeMenuBtn = document.querySelector("#close-menu-btn");

    // Toggle mobile menu on hamburger button click
    hamburgerBtn.addEventListener("click", () => header.classList.toggle("show-mobile-menu"));

    // Close mobile menu on close button click
    closeMenuBtn.addEventListener("click", () => hamburgerBtn.click());
</script>
</body>
</html>
