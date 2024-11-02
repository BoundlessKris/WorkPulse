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
    <title>Writing & Translation</title>
</head>

<body onload="show()">

<%@include file="navbar.jsp" %>


<!-- head section -->
<div id="head">
    <img class="img-head" src="assets/writing%20imgs/head-img.webp" alt=""/>
    <p class="text">
        Writing & Translation <br/>
        <small>Get your words across—in any language. <br/></small>
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
<h2 class="grafic-design-h2">Explore Writing & Translation</h2>
<div class="grafic-design">
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/writing%20imgs/img-1.webp" alt=""/>
        <h3>Content Writing</h3>
        <a href="#">Articles & Blog Posts <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Content Strategy <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Website Content <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Scriptwriting <i class="fas fa-arrow-right"></i></a>
        <a href="#">Creative Writing <i class="fas fa-arrow-right"></i></a>
        <a href="#">Speech Writing <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/writing%20imgs/img-2.webp" alt=""/>
        <h3>Editing & Critique</h3>
        <a href="#">Proofreading & Editing <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">AI Content Editing <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Writing Advice <i class="fas fa-arrow-right"></i></a><br/>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/writing%20imgs/img-3.webp" alt=""/>
        <h3>Book & eBook Publishing</h3>
        <a href="#">Book & eBook Writing <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Book Editing <i class="fas fa-arrow-right"></i></a><br/>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/writing%20imgs/img-4.webp" alt=""/>
        <h3>Translation & Transcription</h3>
        <a href="#">Translation <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Localization <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Transcription <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Interpretation <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/writing%20imgs/img-5.webp" alt=""/>
        <h3>Business & Marketing Copy</h3>
        <a href="#">Brand Voice & Tone <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Business Names & Slogans <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Case Studies <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Product Descriptions <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Social Media Copywriting <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">UX Writing <i class="fas fa-arrow-right"></i></a><br/>
    </div>

    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/writing%20imgs/img-6.webp" alt=""/>
        <h3>Career Writing</h3>
        <a href="#">Resume Writing <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Cover Letters <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">LinkedIn Profiles <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Job Descriptions <i class="fas fa-arrow-right"></i></a><br/>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/writing%20imgs/img-7.webp" alt=""/>
        <h3>Miscellaneous</h3>
        <a href="#">eLearning Content Development <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Technical Writing <i class="fas fa-arrow-right"></i></a><br/>
    </div>
</div>

<!-- Writing-Translation-Related-Guides -->

<div class="Graphics-Design-Related-Guides">
    <div class="graphic-guides-header">
        <h2 class="grafic-guides-h2">Writing & Translation Related Guides</h2>
        <div class="anchor-tag">
            <a class="graphic-guides-anchor" href="#">See more guides </a>
            <span class="symbol">&#x003E;</span>
        </div>
    </div>

    <div class="graphic-guides-card-boss">
        <div class="graphic-guides-card">
            <img class="img-grafic-guides-card" src="assets/writing%20imgs/writing-img-1.webp"
                 alt="graphic-guides-img"/>
            <a class="graphic-guides-anchor-card" href="#">What is copywriting and what does a copywriter do? </a>
        </div>
        <div class="graphic-guides-card">
            <img class="img-grafic-guides-card" src="assets/writing%20imgs/writing-img-2.webp"
                 alt="graphic-guides-img"/>
            <a class="graphic-guides-anchor-card" href="#">So, You’ve Written a Book? Your Guide on How to Self-Publish a Book</a>
        </div>
        <div class="graphic-guides-card">
            <img class="img-grafic-guides-card" src="assets/writing%20imgs/writing-img-3.webp"
                 alt="graphic-guides-img"/>
            <a class="graphic-guides-anchor-card" href="#">10 Content Marketing Trends for Small Businesses in 2024 </a>
        </div>
    </div>
</div>

<div id="graphic_FAQ"></div>

<!-- Services-Related-To-Writing & Translation -->
<div id="Services-Related-To-Graphics-Design">
    <h2 class="services-releted-graphic-h2">
        Services Related To Writing & Translation
    </h2>

    <div class="services-releted">
        <div class="first">
            <div class="services-div">
                <a href="#" class="services-anchor-tag">Proofreading & Editing</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Website Content</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">English to German Translations</a>
            </div>
            <div class="services-div">
                <a href="#" class="services-anchor-tag">English to Spanish Translations</a>
            </div>
            <div class="services-div">
                <a href="#" class="services-anchor-tag">Resume Writing</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Scriptwriting</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Translation Services</a>
            </div>
        </div>

        <div class="first">
            <div class="services-div">
                <a href="#" class="services-anchor-tag">AI Content Editing</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Articles and Blogposts</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Book and eBook Writing</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Creative Writing</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Transcription Services</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Cover Letters</a>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>

<script>
    $(function () {
        $("#graphic_FAQ").load("writing-translation-faq.jsp");
    });
    $(function () {
        $("#small-slider").load("small-slider-writing-translation.jsp");
    });
</script>
</body>
</html>