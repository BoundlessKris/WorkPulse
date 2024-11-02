<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Digital Marketing FAQs</title>
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
    <h2 class="faq-text-h2">Digital Marketing FAQs</h2>
    <input id="faq-a" type="checkbox"/>
    <label for="faq-a">
        <p class="faq-heading">What is Internet marketing services?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            By definition, digital marketing (aka online marketing or Internet marketing services) promotes a client’s
            brand, products and services via the Internet or other digital channels. A digital marketing campaign is
            typically delivered via an electronic device, such as a computer, tablet, phone or other medium, and
            leverages one or more channels, such as social media, search engines, websites, email and others, as chosen
            by the digital marketer based on your goals, to raise brand awareness amongst potential and current
            customers.
        </p>
    </label>
    <input id="faq-b" type="checkbox"/>
    <label for="faq-b">
        <p class="faq-heading">What does a digital marketer do?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            A digital marketer finds creative solutions to drive brand awareness and lead generation via free or paid
            digital channels, including email, search engines, social media, the company’s website and blog. The exact
            mix will depend on the client’s specific goals. The digital marketer focuses on relevant KPIs (key
            performance indicators) to measure performance and maximize revenue potential. Some companies have in-house
            digital marketers whilst others prefer to outsource, seeking different skills in agencies or freelancers,
            depending on their channel mix.
        </p>
    </label>
    <input id="faq-c" type="checkbox"/>
    <label for="faq-c">
        <p class="faq-heading">How do digital campaigns work?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            A well-planned and executed digital marketing campaign will target the right prospects for your products or
            services at the right time, which means they are more likely to buy or book what you offer. It’s more
            flexible, efficient, and cost-effective than many traditional marketing methods and it allows you to compete
            with the big guns in your industry even if you are only a small player. It also provides detailed analytics
            so you can measure everything from the number of visitors, to how long they spent on your page, whether or
            not they made a sale and so much more, including cost per click and ROI (return on investment)
        </p>
    </label>
    <input id="faq-d" type="checkbox"/>
    <label for="faq-d">
        <p class="faq-heading">Why is digital marketing important?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            Nowadays, it’s no longer a case of IF you have a digital presence but HOW good you are at making the most of
            your digital presence so you can be, and stay, competitive. That’s where Internet marketing plays a critical
            role. Consumers are becoming increasingly sophisticated. They have higher expectations when it comes to the
            brands they engage with and the many ways they can be reached, such as video, email, search engines, and
            social media.
        </p>
    </label>
    <input id="faq-e" type="checkbox"/>
    <label for="faq-e">
        <p class="faq-heading">What are the benefits of digital marketing?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            Digital marketing is a must for every business. If you need customers (and who doesn’t?), you need to do
            online marketing. One of its key benefits is that it provides a cost-effective way to reach a huge audience
            while simultaneously targeting a specific group within that audience (reach and accuracy). It also allows
            you to personalize the delivery channel and message to communicate more quickly and effectively with your
            customers for short- and long-term relationship building.
        </p>
    </label>
</div>
</body>
</html>