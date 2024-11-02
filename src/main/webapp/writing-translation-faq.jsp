<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Writing & Translation FAQs</title>
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
    <h2 class="faq-text-h2">Writing & Translation FAQs</h2>
    <input id="faq-a" type="checkbox"/>
    <label for="faq-a">
        <p class="faq-heading">How should I choose a writer?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            Great content is now a must for your business so finding the right writer is one of the keys to success.
            Clearly define your content goals before you even start looking for a freelancer, then choose the right
            category and research by reading reviews and looking at portfolios, skills, and experience before you
            shortlist a few writers. Contact the few sellers you have selected and directly ask them some questions to
            assess their level of knowledge and expertise.
        </p>
    </label>
    <input id="faq-b" type="checkbox"/>
    <label for="faq-b">
        <p class="faq-heading">How can content help my business?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            Content can make or break your business so it’s important that you use it in all your channels - website,
            social media, emails, adverts, etc. - in a way that helps and promotes your business. A good content writer
            will not only craft compelling text but will be able to ask the right questions beforehand so they can be
            sure to create an article or advert or microcopy that sells your brand in the right way to the right people.
        </p>
    </label>
    <input id="faq-c" type="checkbox"/>
    <label for="faq-c">
        <p class="faq-heading">What is the difference between copywriting and content writing?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            Storytelling is key for both copywriters and content writers, but it is used for different purposes. A
            copywriter aims to convert and sell a product or service with the story. Whereas a content writer is more
            about engagement and building commitment and it can take many detours before even remotely mentioning the
            brand or product. Copywriting commands the reader with a clear call to action, whereas content writers craft
            an intricate interaction through more prolonged conversation with the audience.
        </p>
    </label>
    <input id="faq-d" type="checkbox"/>
    <label for="faq-d">
        <p class="faq-heading">Why is content important?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            Whether it’s website content, brand identity deck, sales materials, or any other content, it’s the most
            important tool you have to tell a compelling story. Even though images tell a thousand words, you still need
            to actually use the words to attract visitors and turn them into (loyal) customers. With so much choice of
            talent from all different backgrounds and industries, it’s never been easier to achieve thoroughly
            researched polished content that shines consistently and engages the right audience.
        </p>
    </label>
    <input id="faq-e" type="checkbox"/>
    <label for="faq-e">
        <p class="faq-heading">What languages do you support for translation?</p>
        <div class="faq-arrow"></div>
        <p class="faq-text">
            Find a professional certified and/or native translator in almost any language that you need here on Fiverr.
            Starting with Spanish, French, German, Mandarin, Tamil, Portuguese, Indonesian, and also not so widely
            spoken languages such as Icelandic or Maltese. Freelancers can take on small niche orders or bigger projects
            to be delivered in milestones and depending on their experience and competence level can translate from and
            to any language, with English most frequently the target/source language.
        </p>
    </label>
</div>
</body>
</html>