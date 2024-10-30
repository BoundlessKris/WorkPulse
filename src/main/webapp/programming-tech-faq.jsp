<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Programming & Tech FAQs</title>
    <style>
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

        @import url('https://fonts.googleapis.com/css2?family=Rajdhani:wght@300&display=swap');

    </style>
</head>

<body>
<div class="faq">
    <h2 class="faq-text-h2">Programming & Tech FAQs</h2>
    <input id="faq-a" type="checkbox"/>
    <label for="faq-a">
        <p class="faq-heading">What is Web programming?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            Web programming or development use code to focus on the website functionality and ensure it works and is
            easy to use. It involves markup, writing, network security and coding which is client and server side. The
            most popular web programming languages are HTML, XML, JavaScript, PHP, ASP.Net and Python.
        </p>
    </label>
    <input id="faq-b" type="checkbox"/>
    <label for="faq-b">
        <p class="faq-heading">How do I choose the right freelance programmer for my project?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            With so many programming services, it’s a challenge to choose the right programmer. Formulate a clear brief,
            decide on a budget, deadlines and scope. Select a programmer based not only on their skills and experience
            but also on how well you might work and communicate.
        </p>
    </label>
    <input id="faq-c" type="checkbox"/>
    <label for="faq-c">
        <p class="faq-heading">Do I need to prepare something for my programmer?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            Yes, good documentation and a clear brief are crucial for the success of getting the desired result for your
            project. Formulate your initial high level idea and brainstorm it until you have a clear vision. Next, turn
            your idea into detailed functionality requirements for the backend programming and detail your technical
            requirements (platform, devices etc.) Also add non-functional requirements e.g. performance, security, load
            and clearly specify the scope of the project.
        </p>
    </label>
    <input id="faq-d" type="checkbox"/>
    <label for="faq-d">
        <p class="faq-heading">What type of services can I find in Programming & Tech?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            Starting with web development for client-side (frontend) and server-side (backend), the category also offers
            specialists in Wordpress and e-commerce development, mobile or desktop apps, support & cybersecurity, as
            well as user testing and QA.
        </p>
    </label>
    <input id="faq-e" type="checkbox"/>
    <label for="faq-e">
        <p class="faq-heading">Can I hire developers in less than 48 hours?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            Yes, on WorkPulse we have developers worldwide available 24/7. If you need urgent bug fixing, have a
            cybersecurity emergency or a server load issue, you can be sure that a professional on Fiverr is within
            reach.
            Publish a buyer request or make direct contact for best results. - proficient at both backend (server-side)
            and frontend (client-side) or a more narrow specialist. Get quotes and discuss your needs with at least 3
            developers for an informed decision.
        </p>
    </label>
</div>
</body>
</html>