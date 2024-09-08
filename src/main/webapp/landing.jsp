<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>WorkPulse - Freelance Services Marketplace</title>
<link rel="stylesheet" href="css/landing.css">
</head>
<body>
	<!-- Navbar -->
	<header>
		<nav class="navbar">
			<div class="logo">
				<img src="assets/workpulse.png" alt="WorkPulse">
			</div>
			<ul class="nav-links">
				<li><a href="landing.jsp">Home</a></li>
				<li><a href="#about">About</a></li>
				<li><a href="#categories">Categories</a></li>
				<li><a href="#services">Services</a></li>
				<li><a href="login.jsp" class="nav-btn login-btn">Log In</a></li>
				<li><a href="register.jsp" class="nav-btn sign-up-btn">Sign
						Up</a></li>
			</ul>
		</nav>
	</header>

	<!-- Hero Section -->
	<section class="hero"
		style="background: url('assets/hero.png') no-repeat center center/cover;">
		<div class="hero-content">
			<h1>Find the perfect freelance services for your business</h1>
			<form class="search-bar">
				<input type="text" placeholder="Try 'logo design'">
				<button type="submit">Search</button>
			</form>
		</div>
	</section>

	<!-- Popular Categories -->
	<a name="categories"></a>
	<section class="categories">
		<h2>Explore Popular Categories</h2>
		<div class="category-list">
			<div class="category-item">Programming & Tech</div>
			<div class="category-item">Graphic Design</div>
			<div class="category-item">Digital Marketing</div>
			<div class="category-item">Writing & Translation</div>
			<div class="category-item">Video & Animation</div>
			<div class="category-item">AI Services</div>
			<div class="category-item">Music & Audio</div>
			<div class="category-item">Consulting</div>
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
					<img src="assets/web.jpg" alt="Website Development">
				</div>
			</div>
			<div class="service-item">
				<div class="service-card logo-design">
					<h3>Logo Design</h3>
					<img src="assets/logo.jpg" alt="Logo Design">
				</div>
			</div>
			<div class="service-item">
				<div class="service-card seo">
					<h3>SEO</h3>
					<img src="assets/seo.png" alt="SEO">
				</div>
			</div>
			<div class="service-item">
				<div class="service-card social-media">
					<h3>Social Media Marketing</h3>
					<img src="assets/social.jpg" alt="Social Media Marketing">
				</div>
			</div>
			<div class="service-item">
				<div class="service-card software-dev">
					<h3>Software Development</h3>
					<img src="assets/software.jpg" alt="Software-dev">
				</div>
			</div>
			<div class="service-item">
				<div class="service-card ecommerce">
					<h3>E-Commerce Marketing</h3>
					<img src="assets/ecommerce.png" alt="E-Commerce">
				</div>
			</div>
			<div class="service-item">
				<div class="service-card dsml">
					<h3>Data Science & ML</h3>
					<img src="assets/ml.jpeg" alt="Data Science & ML">
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
				<img src="assets/business.jpg" alt="Start a side business">
				<p>Start a side business</p>
			</div>
			<div class="guide-item">
				<img src="assets/ecommerce-ideas.jpg" alt="Ecommerce business ideas">
				<p>Ecommerce business ideas</p>
			</div>
			<div class="guide-item">
				<img src="assets/online.png"
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

</body>
</html>
