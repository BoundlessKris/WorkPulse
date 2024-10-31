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
    <title>Programming & Tech</title>
</head>

<body onload="show()">

<%@include file="navbar.jsp" %>


<!-- head section -->
<div id="head">
    <img class="img-head" src="assets/graphic design imgs/head-img.webp" alt=""/>
    <p class="text">
        Programming & Tech <br/>
        <small>You think it. A Programmer develops it. <br/></small>
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

<!-- grafic-design section -->
<h2 class="grafic-design-h2">Explore Programming & Tech</h2>
<div class="grafic-design">
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/programming & tech imgs/img-1.webp" alt=""/>
        <h3>Websites</h3>
        <a href="#">Website Development <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Website Maintenance <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Wordpress <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Custom Websites <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/programming & tech imgs/img-2.webp" alt=""/>
        <h3>Application Development</h3>
        <a href="#">Web Application <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Desktop Application <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Game Development <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Chatbot Develpoment <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Browser Extension <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/programming & tech imgs/img-3.webp" alt=""/>
        <h3>Software Development</h3>
        <a href="#">Software Development <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">AI Development <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">APIs &Integrations <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Scripting<i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/programming & tech imgs/img-4.webp" alt=""/>
        <h3>Mobile Apps</h3>
        <a href="#">Mobile App Development <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Cross Platform Apps <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Android App Development <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">iOS App Development <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/programming & tech imgs/img-5.webp" alt=""/>
        <h3>Website Platforms</h3>
        <a href="#">Wix <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Webflow <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">GoDaddy <i class="fas fa-arrow-right"></i></a><br/>
    </div>

    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/programming & tech imgs/img-6.webp" alt=""/>
        <h3>Support & Cybersecurity</h3>
        <a href="#">Support & IT <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Cloud Computing <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Cybersecurity <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Convert Files <i class="fas fa-arrow-right"></i></a><br/>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/programming & tech imgs/img-7.png" alt=""/>
        <h3>Blockchain & Cryptocurrency</h3>
        <a href="#">Blockchain Development <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Decentralized Apps <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Coin Design & Tokenization <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Blockchain Security <i class="fas fa-arrow-right"></i></a><br/>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/programming & tech imgs/img-8.webp" alt=""/>
        <h3>Miscellaneous</h3>
        <a href="#">Electronics Engineering <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">QA & Review <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">User Testing <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Online Coding Lessons <i class="fas fa-arrow-right"></i></a><br/>
    </div>
</div>

<!-- Programming-Tech-Related-Guides -->

<div class="Graphics-Design-Related-Guides">
    <div class="graphic-guides-header">
        <h2 class="grafic-guides-h2">Programming & Tech Related Guides</h2>
        <div class="anchor-tag">
            <a class="graphic-guides-anchor" href="#">See more guides </a>
            <span class="symbol">&#x003E;</span>
        </div>
    </div>

    <div class="graphic-guides-card-boss">
        <div class="graphic-guides-card">
            <img class="img-grafic-guides-card" src="assets/programming & tech imgs/programming-img-1.webp"
                 alt="graphic-guides-img"/>
            <a class="graphic-guides-anchor-card" href="#">How to build a WordPress website for your small business </a>
        </div>
        <div class="graphic-guides-card">
            <img class="img-grafic-guides-card" src="assets/programming & tech imgs/programming-img-2.webp"
                 alt="graphic-guides-img"/>
            <a class="graphic-guides-anchor-card" href="#">How to Find a Web Developer in 2024</a>
        </div>
        <div class="graphic-guides-card">
            <img class="img-grafic-guides-card" src="assets/programming & tech imgs/programming-img-3.webp"
                 alt="graphic-guides-img"/>
            <a class="graphic-guides-anchor-card" href="#">10 Best Website Builders for Small Business </a>
        </div>
    </div>
</div>

<div id="graphic_FAQ"></div>

<!-- Services-Related-To-Programming-tech -->
<div id="Services-Related-To-Graphics-Design">
    <h2 class="services-releted-graphic-h2">
        Services Related To Programming & Tech
    </h2>

    <div class="services-releted">
        <div class="first">
            <div class="services-div">
                <a href="#" class="services-anchor-tag">Convert Website to App</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Custom App</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Discord Server</a>
            </div>
            <div class="services-div">
                <a href="#" class="services-anchor-tag">Python Developer</a>
            </div>
            <div class="services-div">
                <a href="#" class="services-anchor-tag">PHP Programmer</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Unity Developer</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">NFT Promotion</a>
            </div>
        </div>

        <div class="first">
            <div class="services-div">
                <a href="#" class="services-anchor-tag">Roblox Scripter</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Minecraft Builders</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Wordpress Customization</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Shopify Expert</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Wix website builder</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Fivem Script</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Custom Landing Page</a>
            </div>
        </div>

        <div class="first">
            <div class="services-div">
                <a href="#" class="services-anchor-tag">Book Formatting</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Web Scraping</a>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>

<script>
    $(function () {
        $("#graphic_FAQ").load("programming-tech-faq.jsp");
    });
    $(function () {
        $("#small-slider").load("small-slider-programming-tech.jsp");
    });
</script>
</body>
</html>