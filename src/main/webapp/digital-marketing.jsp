<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <link rel="stylesheet" href="css/graphic-design.css"/>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <style>
        @import url("https://fonts.googleapis.com/css2?family=Montserrat:wght@200&display=swap");
        @import url("https://fonts.googleapis.com/css2?family=Cairo:wght@300&display=swap");
        @import url("https://fonts.googleapis.com/css2?family=Quicksand:wght@300&display=swap");

    </style>
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.css"/>

    <script src="https://kit.fontawesome.com/fa5117c01c.js" crossorigin="anonymous"></script>
    <title>Digital Marketing</title>
</head>

<body onload="show()">

<%@include file="navbar.jsp" %>


<!-- head section -->
<div id="head">
    <img class="img-head" src="assets/digital marketing imgs/head-img.webp" alt=""/>
    <p class="text">
        Digital Marketing <br/>
        <small>Build your brand. Grow your business. <br/></small>
        <a class="popup-video"
           href="https://fiverr-res.cloudinary.com/video/upload/t_fiverr_hd_nl/v1/video-attachments/generic_asset/asset/ab0907217c9f9a2c1d2eee677beb7619-1626082923646/how_fiverr_works">
            <button class="btn-head"><i class="fa fa-play-circle"></i> How WorkPulse Works</button>
        </a>
    </p>
</div>
<script>
    $(function () {
        $('.popup-video').magnificPopup({
            disableOn: 700,
            type: 'iframe',
            mainClass: 'mfp-fade',
            removalDelay: 160,
            preloader: false,
            fixedContentPos: false
        });
    });
</script>

<!-- mini scroller section -->
<div id="small-slider"></div>

<!-- digital marketing section -->
<h2 class="grafic-design-h2">Explore Digital Marketing</h2>
<div class="grafic-design">
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/digital%20marketing%20imgs/img-1.webp" alt=""/>
        <h3>Search</h3>
        <a href="#">Search Engine Optimization (SEO) <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Search Engine Marketing (SEM) <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Local SEO <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">E-Commerce SEO <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/digital%20marketing%20imgs/img-2.webp" alt=""/>
        <h3>Social</h3>
        <a href="#">Social Media Marketing <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Paid Social Media <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Social Commerce <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Influencer Marketing <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Community Management <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/digital%20marketing%20imgs/img-3.webp" alt=""/>
        <h3>Methods & Techniques</h3>
        <a href="#">Video Marketing <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">E-Commerce Marketing <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Email Marketing <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Email Automations <i class="fas fa-arrow-right"></i></a>
        <a href="#">Public Relations <i class="fas fa-arrow-right"></i></a>
        <a href="#">Text Message Marketing <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/digital%20marketing%20imgs/img-4.webp" alt=""/>
        <h3>Analytics & Strategy</h3>
        <a href="#">Marketing Strategy <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Marketing Concepts & Ideation <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Marketing Advice <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Web Analytics <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/digital%20marketing%20imgs/img-5.webp" alt=""/>
        <h3>Industry & Purpose-Specific</h3>
        <a href="#">Music Promotion <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Podcast Marketing <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Book & eBook Marketing <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Mobile App Marketing <i class="fas fa-arrow-right"></i></a><br/>
    </div>

    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/digital%20marketing%20imgs/img-6.webp" alt=""/>
        <h3>Miscellaneous</h3>
        <a href="#">Crowdfunding <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Other <i class="fas fa-arrow-right"></i></a><br/>
    </div>
</div>

<!-- Digital-Marketing-Related-Guides -->

<div class="Graphics-Design-Related-Guides">
    <div class="graphic-guides-header">
        <h2 class="grafic-guides-h2">Digital Marketing Related Guides</h2>
        <div class="anchor-tag">
            <a class="graphic-guides-anchor" href="#">See more guides </a>
            <span class="symbol">&#x003E;</span>
        </div>
    </div>

    <div class="graphic-guides-card-boss">
        <div class="graphic-guides-card">
            <img class="img-grafic-guides-card" src="assets/digital%20marketing%20imgs/digital-img-1.webp"
                 alt="graphic-guides-img"/>
            <a class="graphic-guides-anchor-card" href="#">15 ways to promote your business online </a>
        </div>
        <div class="graphic-guides-card">
            <img class="img-grafic-guides-card" src="assets/digital%20marketing%20imgs/digital-img-2.webp"
                 alt="graphic-guides-img"/>
            <a class="graphic-guides-anchor-card" href="#">How to create a YouTube channel, a step-by-step guide</a>
        </div>
        <div class="graphic-guides-card">
            <img class="img-grafic-guides-card" src="assets/digital%20marketing%20imgs/digital-img-3.webp"
                 alt="graphic-guides-img"/>
            <a class="graphic-guides-anchor-card" href="#">26 Marketing Ideas For Small Businesses </a>
        </div>
    </div>
</div>

<div id="graphic_FAQ"></div>

<!-- Services-Related-To-Digital Marketing -->
<div id="Services-Related-To-Graphics-Design">
    <h2 class="services-releted-graphic-h2">
        Services Related To Digital Marketing
    </h2>

    <div class="services-releted">
        <div class="first">
            <div class="services-div">
                <a href="#" class="services-anchor-tag">SEO Services</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Marketing Strategy</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Social Media Marketing</a>
            </div>
            <div class="services-div">
                <a href="#" class="services-anchor-tag">Affiliate Marketing</a>
            </div>
            <div class="services-div">
                <a href="#" class="services-anchor-tag">eCommerce Marketing</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Influencer Marketing</a>
            </div>
        </div>

        <div class="first">
            <div class="services-div">
                <a href="#" class="services-anchor-tag">Music Promotion</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Search Engine Marketing (SEM)</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Email Marketing</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Video Marketing</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Shoutouts & Promotions</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Youtube Marketing</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Social Content</a>
            </div>
        </div>

        <div class="first">
            <div class="services-div">
                <a href="#" class="services-anchor-tag">Web Analytics Services</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Spotify Music Promotion</a>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>

<script>
    $(function () {
        $("#graphic_FAQ").load("digital-marketing-faq.jsp");
    });
    $(function () {
        $("#small-slider").load("small-slider-digital-marketing.jsp");
    });
</script>
</body>
</html>