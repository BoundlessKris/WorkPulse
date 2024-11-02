<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Video & Animation FAQs</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Rajdhani:wght@300&display=swap');

        .faq-heading {
            font-family: Lato;
            font-weight: 400;
            font-size: 19px;
            text-indent: 20px;
            color: #949090;
        }

        .faq-text {
            font-family: Macan, Helvetica Neue, Helvetica, Arial, sans-serif;
            color: #949090;
            font-size: 15px;
            width: 92%;
            padding-left: 20px;
            margin-bottom: 30px;
        }

        .faq {
            width: 90%;
            margin: auto;
            margin-top: 25px;
            background: white;
            border-radius: 4px;
            position: relative;
            border: 1px solid #e1e1e1;
            margin-bottom: 60px;
        }

        .faq-text-h2 {
            text-align: center;
            color: #5b5b5b;
        }

        .faq label {
            display: block;
            position: relative;
            overflow: hidden;
            cursor: pointer;
            padding-top: 1px;
            background-color: #fafafa;
            border-bottom: 1px solid #e1e1e1;
        }

        .faq input[type="checkbox"] {
            display: none;
        }

        .faq .faq-arrow {
            width: 5px;
            height: 5px;
            transition: transform 0.2s;
            border-top: 2px solid rgba(0, 0, 0, 0.33);
            border-right: 2px solid rgba(0, 0, 0, 0.33);
            float: right;
            position: relative;
            top: -30px;
            right: 27px;
            -webkit-transform: rotate(45deg);
            transform: rotate(45deg);
        }

        .faq input[type="checkbox"]:checked + label > .faq-arrow {
            transition: transform 0.2s;
            -webkit-transform: rotate(135deg);
            transform: rotate(135deg);
        }

        .faq input[type="checkbox"]:checked + label {
            display: block;
            background: rgba(255, 255, 255, 255) !important;
            color: #4f7351;
            height: 225px;
            transition: height 0.2s;
        }

        .faq input[type="checkbox"]:not(:checked) + label {
            display: block;
            transition: height 0.2s;
            height: 60px;
        }

    </style>
</head>

<body>
<div class="faq">
    <h2 class="faq-text-h2">Video & Animation FAQs</h2>
    <input id="faq-a" type="checkbox"/>
    <label for="faq-a">
        <p class="faq-heading">Why does my business need videos?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            In today's marketing strategies, nothing tops the power that videos have - 90% of customers say that videos
            help them decide whether to buy or not. They visually help showcase products and services that reach and
            attract new customers. Videos convey more information in less time and are much easier for the audience to
            become immersed in. They also help your business stand out from your competition by putting a face and name
            to your brand, instilling confidence and trustworthiness. And the fact that Google loves videos is just
            another reason to start making those business videos!
        </p>
    </label>
    <input id="faq-b" type="checkbox"/>
    <label for="faq-b">
        <p class="faq-heading">What type of videos does my business need?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            Depending on what type of product or service your business provides, there are a plethora of videos to
            choose from. Product videos are great for showing off your product's features and benefits in an engaging
            way. Explainer videos are also popular for teaching or explaining how to solve a problem or issue. They're
            also great for demonstrating how to use a product or solution. Onboarding, training, and company culture
            videos are fantastic for the inner working solutions in your business, and testimonial and promotional
            videos are perfect for promoting your business. And don't forget about those fun social videos that
            customers love to see!
        </p>
    </label>
    <input id="faq-c" type="checkbox"/>
    <label for="faq-c">
        <p class="faq-heading">What are the elements of a great video?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            To create a successful video, you should keep these tips in mind. First, keep it short. The rule of thumb
            for videos is the shorter the better, and keeping it under 2 minutes is essential. Next, you need an
            attention-grabbing intro. It doesn't matter how short your video is - if you can't grab your audience's
            attention in the first few seconds, they will move on. You should also take into consideration the
            background music, video lighting, adding captions, and smooth editing of your business video. And lastly,
            you should have a decisive call to action (CTA) to finish out strong.
        </p>
    </label>
    <input id="faq-d" type="checkbox"/>
    <label for="faq-d">
        <p class="faq-heading">What are the most popular video & animation services?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            There are a variety of video services available, but the most popular services are explainers and character
            animation. Within the explainer category, you can choose a whiteboard explainer video that simulates
            animated graphics being hand-drawn on a whiteboard. 2 and 3-D animation videos are also quite popular in
            creating three-dimensional moving images that explain your product or service. Live-action explainers are
            made with actual shot video footage, which people love, and character animation brings animated characters
            to life and is excellent for attracting new customers as well as using on social media.
        </p>
    </label>
    <input id="faq-e" type="checkbox"/>
    <label for="faq-e">
        <p class="faq-heading">How do I choose the right type of service and seller for my video?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            When choosing specific services for your video, you should first know what type of video you want to create.
            This will help you narrow down what services you need tremendously. The best way to choose a seller for your
            video is by finding someone who will fit your specific business needs. Browse through a seller's experience,
            niche, and previous work. Then start reaching out and communicate what you're aiming for to determine if it
            can be a potential match. Ask what types of services the seller provides, how long the process takes, and
            their suggestions. Ultimately, you want someone who can translate your ideas into actions.
        </p>
    </label>
</div>
</body>
</html>