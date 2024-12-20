<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <link rel="stylesheet" href="old%20css/css/graphic-design.css"/>
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
    <title>Graphic Design</title>
</head>

<body onload="show()">

<%@include file="navbar.jsp" %>

<!-- head section -->
<div id="head">
    <img class="img-head" src="assets/graphic design imgs/head-img.webp" alt=""/>
    <p class="text">
        Graphics Design <br/>
        <small>Designs to make you stand out. <br/></small>
        <a class="popup-video"
           href="https://fiverr-res.cloudinary.com/video/upload/t_fiverr_hd_nl/v1/video-attachments/generic_asset/asset/ab0907217c9f9a2c1d2eee677beb7619-1626082923646/how_fiverr_works">
            <button class="btn-head"><i class="fa fa-play-circle"></i> How
                WorkPulse Works
            </button>
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
<h2 class="grafic-design-h2">Explore Graphics & Design</h2>
<div class="grafic-design">
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/graphic design imgs/img-1.webp" alt=""/>
        <h3>Logo & Brand Identity</h3>
        <a href="#">Logo Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Brand Style Guides <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Fonts & Typography <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Business Cards & Stationery <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/graphic design imgs/img-2.webp" alt=""/>
        <h3>Web & App Design</h3>
        <a href="#">Website Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">App Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">UX Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Landing Page Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Icon Design <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/graphic design imgs/img-3.webp" alt=""/>
        <h3>Art & Illustration</h3>
        <a href="#">Illustration <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">NFT Art <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Pattern Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Portraits & Caricatures <i class="fas fa-arrow-right"></i></a>
        <br/>
        <a href="#">Cartoons & Comics <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Tattoo Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Storyboards <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/graphic design imgs/img-4.webp" alt=""/>
        <h3>Marketing Design</h3>
        <a href="#">Social Media Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Email Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Web Banners <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Signage Design <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/graphic design imgs/img-5.webp" alt=""/>
        <h3>Gaming</h3>
        <a href="#">Game Art <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Graphics for Streamers <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Twitch Store <i class="fas fa-arrow-right"></i></a><br/>
    </div>

    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/graphic design imgs/img-6.webp" alt=""/>
        <h3>Visual Design</h3>
        <a href="#">Image Editing <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Presentation Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Infographic Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Vector Tracing <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Resume Design <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/graphic design imgs/img-7.webp" alt=""/>
        <h3>Print Design</h3>
        <a href="#">T-Shirts & Merchandise <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Flyer Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Brochure Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Poster Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Catalog Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Menu Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Invitation Design <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/graphic design imgs/img-8.webp" alt=""/>
        <h3>Packaging & Covers</h3>
        <a href="#">Packaging & Label Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Book Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Album Cover Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Podcast Cover Art <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Car Wraps <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/graphic design imgs/img-9.webp" alt=""/>
        <h3>Architecture & Building Design</h3>
        <a href="#">Architecture & Interior Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Landscape Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Building Engineering <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Building Information Modeling <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/graphic design imgs/img-10.webp" alt=""/>
        <h3>Product & Characters Design</h3>
        <a href="#">Industrial & Product Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Character Modeling <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Trade Booth Design <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/graphic design imgs/img-11.webp" alt=""/>
        <h3>Fashion & Jewelry</h3>
        <a href="#">Fashion Design <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Jewelry Design <i class="fas fa-arrow-right"></i></a>
    </div>
    <div class="grafic-child-card">
        <img class="img-grafic" src="assets/graphic design imgs/img-12.webp" alt=""/>
        <h3>Miscellaneous</h3>
        <a href="#">Logo Maker Tool <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Design Advice <i class="fas fa-arrow-right"></i></a><br/>
        <a href="#">Other <i class="fas fa-arrow-right"></i></a><br/>
    </div>
</div>

<!-- Graphics-Design-Related-Guides -->
<div class="Graphics-Design-Related-Guides">
    <div class="graphic-guides-header">
        <h2 class="grafic-guides-h2">Graphics & Design Related Guides</h2>
        <div class="anchor-tag">
            <a class="graphic-guides-anchor" href="#">See more guides </a>
            <span class="symbol">&#x003E;</span>
        </div>
    </div>

    <div class="graphic-guides-card-boss">
        <div class="graphic-guides-card">
            <img class="img-grafic-guides-card" src="assets/graphic design imgs/graphic-guides-img-1.webp"
                 alt="graphic-guides-img"/>
            <a class="graphic-guides-anchor-card" href="#">How to illustrate a children's book: 9 steps to
                illustrate your
                book</a>
        </div>
        <div class="graphic-guides-card">
            <img class="img-grafic-guides-card" src="assets/graphic design imgs/graphic-guides-img-2.webp"
                 alt="graphic-guides-img"/>
            <a class="graphic-guides-anchor-card" href="#">Graphic design 101: what is graphic design?</a>
        </div>
        <div class="graphic-guides-card">
            <img class="img-grafic-guides-card" src="assets/graphic design imgs/graphic-guides-img-3.webp"
                 alt="graphic-guides-img"/>
            <a class="graphic-guides-anchor-card" href="#">How to design a logo: 12 steps to creating a business
                logo from
                scratch
            </a>
        </div>
    </div>
</div>

<div id="graphic_FAQ"></div>

<!-- Services-Related-To-Graphics-Design -->
<div id="Services-Related-To-Graphics-Design">
    <h2 class="services-releted-graphic-h2">
        Services Related To Graphics & Design
    </h2>

    <div class="services-releted">
        <div class="first">
            <div class="services-div">
                <a href="#" class="services-anchor-tag">Minimalist logo design</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Signature logo design</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Mascot logo design</a>
            </div>
            <div class="services-div">
                <a href="#" class="services-anchor-tag">3d logo design</a>
            </div>
            <div class="services-div">
                <a href="#" class="services-anchor-tag">Hand drawn logo design</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Vintage logo design</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Remove background</a>
            </div>
        </div>

        <div class="first">
            <div class="services-div">
                <a href="#" class="services-anchor-tag">Photo restoration</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Photo retouching</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Image resize</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Product label design</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Custom twitch overlay</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Custom twitch emotes</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Gaming logo</a>
            </div>
        </div>

        <div class="first">
            <div class="services-div">
                <a href="#" class="services-anchor-tag">Children book illustration</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Instagram design</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Movie poster design</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Box design</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Logo maker</a>
            </div>

            <div class="services-div">
                <a href="#" class="services-anchor-tag">Logo ideas</a>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>

<script>
    $(function () {
        $("#graphic_FAQ").load("graphic-design-faq.jsp");
    });
    $(function () {
        $("#small-slider").load("small-slider-graphic-design.jsp");
    });
</script>
</body>
</html>