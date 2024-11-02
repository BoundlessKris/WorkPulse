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
    <img class="img-head" src="assets/video%20imgs/head-img.webp" alt=""/>
    <p class="text">
        Video & Animation <br/>
        <small>Bring your story to life with creative videos. <br/></small>
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
<h2 class="grafic-design-h2">Explore Video & Animation</h2>
<div class="grafic-design">
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/video%20imgs/img-1.webp" alt=""/>
        <h3>Editing & Post-Production</h3>
        <a href="#">Video Editing <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Visual Effects <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Video Art <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Intro & Outro Videos <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/video%20imgs/img-2.webp" alt=""/>
        <h3>Social & Marketing Videos</h3>
        <a href="#">Video Ads & Commercials <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Social Media Videos <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Music Videos <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Slideshow Videos <i class="fas fa-arrow-right"></i></a><br/>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/video%20imgs/img-3.webp" alt=""/>
        <h3>Presenter Videos</h3>
        <a href="#">UGC Videos <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Spokespersons Videos <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">UGC Ads <i class="fas fa-arrow-right"></i></a><br/>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/video%20imgs/img-4.webp" alt=""/>
        <h3>Explainer Videos</h3>
        <a href="#">Animated Explainers <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Live Action Explainers <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Screencasting Videos <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">eLearning Video Production <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/video%20imgs/img-5.webp" alt=""/>
        <h3>Animation</h3>
        <a href="#">Character Animation <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Animated GIFs <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Animation for Kids <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">NFT Animation <i class="fas fa-arrow-right"></i></a><br/>
    </div>

    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/video%20imgs/img-6.webp" alt=""/>
        <h3>Product Videos</h3>
        <a href="#">3D Product Animation <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">E-Commerce Product Videos <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Corporate Videos <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">App & Website Previews <i class="fas fa-arrow-right"></i></a><br/>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/video%20imgs/img-7.webp" alt=""/>
        <h3>Motion Graphics</h3>
        <a href="#">Logo Animation <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Lottie & Web Animation <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Text Animation <i class="fas fa-arrow-right"></i></a><br/>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/video%20imgs/img-8.webp" alt=""/>
        <h3>Filmed Video Production</h3>
        <a href="#">Filmed Video Production <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Videographers <i class="fas fa-arrow-right"></i></a><br/>
    </div>
</div>

<!-- Programming-Tech-Related-Guides -->

<div class="Graphics-Design-Related-Guides">
    <div class="graphic-guides-header">
        <h2 class="grafic-guides-h2">Video & Animation Related Guides</h2>
        <div class="anchor-tag">
            <a class="graphic-guides-anchor" href="#">See more guides </a>
            <span class="symbol">&#x003E;</span>
        </div>
    </div>

    <div class="graphic-guides-card-boss">
        <div class="graphic-guides-card">
            <img class="img-grafic-guides-card" src="assets/video%20imgs/video-1.webp"
                 alt="graphic-guides-img"/>
            <a class="graphic-guides-anchor-card" href="#">How to create a promo video on a budget? </a>
        </div>
        <div class="graphic-guides-card">
            <img class="img-grafic-guides-card" src="assets/video%20imgs/video-2.webp"
                 alt="graphic-guides-img"/>
            <a class="graphic-guides-anchor-card" href="#">10 Best Video Editing Softwares for YouTubers</a>
        </div>
        <div class="graphic-guides-card">
            <img class="img-grafic-guides-card" src="assets/video%20imgs/video-3.webp"
                 alt="graphic-guides-img"/>
            <a class="graphic-guides-anchor-card" href="#">The Complete Guide to Successful Video Advertising </a>
        </div>
    </div>
</div>

<div id="graphic_FAQ"></div>

<!-- Services-Related-Video-Animation -->
<div id="Services-Related-To-Graphics-Design">
    <h2 class="services-releted-graphic-h2">
        Services Related To Video & Animation
    </h2>

    <div class="services-releted">
        <div class="first">
            <div class="services-div">
                <a href="#" class="services-anchor-tag">Stinger Transition</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Animated Alerts For Streamers</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Youtube Intro Maker</a>
            </div>
            <div class="services-div">
                <a href="#" class="services-anchor-tag">AMV</a>
            </div>
            <div class="services-div">
                <a href="#" class="services-anchor-tag">Music Video Editing</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Color Grading</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Youtube Editor</a>
            </div>
        </div>

        <div class="first">
            <div class="services-div">
                <a href="#" class="services-anchor-tag">Spokespersons Videos</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Architecture 3D Animation</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Kids Photography Advertising</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Medical 3d Animation</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Gaming video editing</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Video Compositing</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Cartoon Animation</a>
            </div>
        </div>

        <div class="first">
            <div class="services-div">
                <a href="#" class="services-anchor-tag">Lyric video</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Music Video Editing</a>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>

<script>
    $(function () {
        $("#graphic_FAQ").load("video-animation-faq.jsp");
    });
    $(function () {
        $("#small-slider").load("small-slider-video-animation.jsp");
    });
</script>
</body>
</html>