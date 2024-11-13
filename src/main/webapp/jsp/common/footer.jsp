<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<footer class="site-footer">
    <div class="container">
        <!-- Top Footer -->
        <div class="footer-grid">
            <!-- Categories -->
            <div class="footer-section">
                <h4 class="footer-title">Categories</h4>
                <ul class="footer-links">
                    <li><a href="${pageContext.request.contextPath}/category/graphics-design">Graphics & Design</a></li>
                    <li><a href="${pageContext.request.contextPath}/category/digital-marketing">Digital Marketing</a></li>
                    <li><a href="${pageContext.request.contextPath}/category/writing-translation">Writing & Translation</a></li>
                    <li><a href="${pageContext.request.contextPath}/category/video-animation">Video & Animation</a></li>
                    <li><a href="${pageContext.request.contextPath}/category/programming-tech">Programming & Tech</a></li>
                    <li><a href="${pageContext.request.contextPath}/category/business">Business</a></li>
                </ul>
            </div>

            <!-- About -->
            <div class="footer-section">
                <h4 class="footer-title">About</h4>
                <ul class="footer-links">
                    <li><a href="${pageContext.request.contextPath}/about">About Us</a></li>
                    <li><a href="${pageContext.request.contextPath}/careers">Careers</a></li>
                    <li><a href="${pageContext.request.contextPath}/press">Press & News</a></li>
                    <li><a href="${pageContext.request.contextPath}/partnerships">Partnerships</a></li>
                    <li><a href="${pageContext.request.contextPath}/privacy">Privacy Policy</a></li>
                    <li><a href="${pageContext.request.contextPath}/terms">Terms of Service</a></li>
                </ul>
            </div>

            <!-- Support -->
            <div class="footer-section">
                <h4 class="footer-title">Support</h4>
                <ul class="footer-links">
                    <li><a href="${pageContext.request.contextPath}/help">Help & Support</a></li>
                    <li><a href="${pageContext.request.contextPath}/trust-safety">Trust & Safety</a></li>
                    <li><a href="${pageContext.request.contextPath}/selling">Selling on WorkPulse</a></li>
                    <li><a href="${pageContext.request.contextPath}/buying">Buying on WorkPulse</a></li>
                </ul>
            </div>

            <!-- Community -->
            <div class="footer-section">
                <h4 class="footer-title">Community</h4>
                <ul class="footer-links">
                    <li><a href="${pageContext.request.contextPath}/events">Events</a></li>
                    <li><a href="${pageContext.request.contextPath}/blog">Blog</a></li>
                    <li><a href="${pageContext.request.contextPath}/forum">Forum</a></li>
                    <li><a href="${pageContext.request.contextPath}/podcast">Podcast</a></li>
                    <li><a href="${pageContext.request.contextPath}/affiliates">Affiliates</a></li>
                </ul>
            </div>
        </div>

        <!-- Bottom Footer -->
        <div class="footer-bottom">
            <div class="footer-left">
                <div class="footer-logo">
                    <img src="${pageContext.request.contextPath}/images/logo-white.png" alt="WorkPulse">
                </div>
                <p class="copyright">© ${currentYear} WorkPulse. All rights reserved</p>
            </div>

            <div class="footer-right">
                <!-- Social Links -->
                <div class="social-links">
                    <a href="#" class="social-link"><i class="fab fa-facebook-f"></i></a>
                    <a href="#" class="social-link"><i class="fab fa-twitter"></i></a>
                    <a href="#" class="social-link"><i class="fab fa-linkedin-in"></i></a>
                    <a href="#" class="social-link"><i class="fab fa-instagram"></i></a>
                    <a href="#" class="social-link"><i class="fab fa-youtube"></i></a>
                </div>

                <!-- Language Selector -->
                <div class="language-selector">
                    <i class="fas fa-globe"></i>
                    <select class="language-select" onchange="changeLanguage(this.value)">
                        <option value="en">English</option>
                        <option value="es">Español</option>
                        <option value="fr">Français</option>
                        <option value="de">Deutsch</option>
                    </select>
                </div>
            </div>
        </div>
    </div>
</footer>
