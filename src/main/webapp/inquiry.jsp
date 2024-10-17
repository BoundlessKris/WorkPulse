<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            overflow: hidden;
            height: 100vh;
            margin: 0;
        }

        .card-popup {
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            display: none;
            width: 50%;
            max-width: 500px;
            padding: 20px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
            z-index: 1000;
        }

        .overlay {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.5);
            z-index: 500;
            display: none;
        }

        .card {
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-bottom: 15px;
        }

        .card-step {
            display: none;
        }

        .active-step {
            display: block;
        }

        .navigation-buttons {
            margin-top: 20px;
            display: flex;
            justify-content: space-between;
        }

        .next-right {
            justify-content: flex-end;
        }

        .background-iframe {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            border: none;
            z-index: 1;
        }

        .top-right-checkbox {
            position: absolute;
            top: 10px;
            right: 10px;
            transform: scale(1.5);
        }
    </style>
</head>
<body>

<!-- Background iframe for the welcome page -->
<iframe class="background-iframe" src="welcome.jsp" title="Welcome Page"></iframe>

<!-- Overlay -->
<div class="overlay" id="overlay"></div>

<!-- Step 1: Buyer/Seller Selection -->
<div class="card card-popup active-step" id="step1">
    <div class="card-body text-center">
        <h4><span id="usernameDisplay"></span>, your account has been created!</h4>
        <p>What brings you here? (You can select multiple options)</p>
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card position-relative">
                    <input type="checkbox" class="top-right-checkbox" name="userChoice" value="buyer" id="buyerCheckbox">
                    <div class="card-body text-center">
                        <img src="assets/landing page imgs/buy.png" alt="Buyer Icon" class="img-fluid mb-2">
                        <br>Buying freelance services
                    </div>
                </div>
            </div>
            <div class="col-md-5">
                <div class="card position-relative">
                    <input type="checkbox" class="top-right-checkbox" name="userChoice" value="seller" id="sellerCheckbox">
                    <div class="card-body text-center">
                        <img src="assets/landing page imgs/sell.jpg" alt="Seller Icon" class="img-fluid mb-2">
                        <br>Selling freelance services
                    </div>
                </div>
            </div>
        </div>
        <div class="navigation-buttons next-right mt-3">
            <button id="nextStep1" class="btn btn-primary">Next</button>
        </div>
    </div>
</div>

<!-- Step 2: Buyer-Related Options -->
<div class="card card-popup card-step" id="buyerStep2">
    <div class="card-body text-center">
        <h4>What do you plan to buy services for</h4>
        <div class="row">
            <div class="col-md-4">
                <div class="card position-relative">
                    <input type="checkbox" class="top-right-checkbox" name="buyerPreference" value="graphics">
                    <div class="card-body text-center">
                        <img src="assets/landing page imgs/monitor.png" alt="primary" class="img-fluid mb-2">
                        <br>My primary job or business
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card position-relative">
                    <input type="checkbox" class="top-right-checkbox" name="buyerPreference" value="writing">
                    <div class="card-body text-center">
                        <img src="assets/landing page imgs/listing.png" alt="secondary" class="img-fluid mb-2">
                        <br>A secondary business need
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card position-relative">
                    <input type="checkbox" class="top-right-checkbox" name="buyerPreference" value="marketing">
                    <div class="card-body text-center">
                        <img src="assets/landing page imgs/coffee-cup.png" alt="personal" class="img-fluid mb-2">
                        <br>Personal use
                    </div>
                </div>
            </div>
        </div>
        <div class="navigation-buttons mt-3">
            <button id="backBuyerStep2" class="btn btn-secondary">Back</button>
            <button id="nextBuyerStep2" class="btn btn-primary">Next</button>
        </div>
    </div>
</div>

<!-- Seller-Related Options -->
<div class="card card-popup card-step" id="sellerStep2">
    <div class="card-body text-center">
        <h4>How many people work at your company?</h4>
        <div class="row">
            <div class="col-md-4">
                <div class="card">
                    <input type="checkbox" class="top-right-checkbox" name="sellerPreference" value="webDev">
                    <div class="card-body text-center">
                        <img src="assets/landing page imgs/user.png" alt="one" class="img-fluid mb-2">
                        <br>Just me
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <input type="checkbox" class="top-right-checkbox" name="sellerPreference" value="seo">
                    <div class="card-body text-center">
                        <img src="assets/landing page imgs/people.png" alt="two" class="img-fluid mb-2">
                        <br>11-15
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <input type="checkbox" class="top-right-checkbox" name="sellerPreference" value="content">
                    <div class="card-body text-center">
                        <img src="assets/landing page imgs/enterprise.png" alt="three" class="img-fluid mb-2">
                        <br>500+
                    </div>
                </div>
            </div>
        </div>
        <div class="navigation-buttons mt-3">
            <button id="backSellerStep2" class="btn btn-secondary">Back</button>
            <button id="nextSellerStep2" class="btn btn-primary">Next</button>
        </div>
    </div>
</div>

<!-- Final Step -->
<div class="card card-popup card-step" id="step3">
    <div class="card-body text-center">
        <h4>Nice! and what are you looking for today?</h4>
        <p>we are here to help you make it happen.</p>
        <div class="row">
            <div class="col-md-4">
                <div class="card">
                    <input type="checkbox" class="top-right-checkbox" name="sellerPreference" value="webDev">
                    <div class="card-body text-center">
                        <img src="assets/landing page imgs/project-management.png" alt="one" class="img-fluid mb-2">
                        <br>To start a project
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <input type="checkbox" class="top-right-checkbox" name="sellerPreference" value="seo">
                    <div class="card-body text-center">
                        <img src="assets/landing page imgs/house-plan.png" alt="two" class="img-fluid mb-2">
                        <br>A specific service
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <input type="checkbox" class="top-right-checkbox" name="sellerPreference" value="content">
                    <div class="card-body text-center">
                        <img src="assets/landing page imgs/binoculars.png" alt="three" class="img-fluid mb-2">
                        <br>Just exploring
                    </div>
                </div>
            </div>
        </div>
        <div class="navigation-buttons">
            <button id="backStep3" class="btn btn-secondary">Back</button>
            <button id="finishBtn" class="btn btn-success">Finish</button>
        </div>
    </div>
</div>

<script>
    window.onload = function () {
        const username = "<%= request.getAttribute("username") != null ? request.getAttribute("username") : "User" %>";
        document.getElementById("usernameDisplay").innerText = username;

        // Show the overlay and the first step after 1 second
        setTimeout(function () {
            document.getElementById("overlay").style.display = "block";
            document.getElementById("step1").style.display = "block";
        }, 500);
    };

    const step1 = document.getElementById("step1");
    const buyerStep2 = document.getElementById("buyerStep2");
    const sellerStep2 = document.getElementById("sellerStep2");
    const step3 = document.getElementById("step3");

    const buyerCheckbox = document.getElementById("buyerCheckbox");
    const sellerCheckbox = document.getElementById("sellerCheckbox");

    // Step 1 -> Step 2 (Conditional Navigation)
    document.getElementById("nextStep1").addEventListener("click", function () {
        step1.style.display = "none";
        if (buyerCheckbox.checked) {
            buyerStep2.style.display = "block";
        }
        if (sellerCheckbox.checked) {
            sellerStep2.style.display = "block";
        }
    });

    // Buyer Step 2 -> Final Step
    document.getElementById("nextBuyerStep2").addEventListener("click", function () {
        buyerStep2.style.display = "none";
        step3.style.display = "block";
    });

    // Seller Step 2 -> Final Step
    document.getElementById("nextSellerStep2").addEventListener("click", function () {
        sellerStep2.style.display = "none";
        step3.style.display = "block";
    });

    // Back from Buyer Step 2 -> Step 1
    document.getElementById("backBuyerStep2").addEventListener("click", function () {
        buyerStep2.style.display = "none";
        step1.style.display = "block";
    });

    // Back from Seller Step 2 -> Step 1
    document.getElementById("backSellerStep2").addEventListener("click", function () {
        sellerStep2.style.display = "none";
        step1.style.display = "block";
    });

    // Back from Final Step -> Buyer/Seller Step 2
    document.getElementById("backStep3").addEventListener("click", function () {
        step3.style.display = "none";
        if (buyerCheckbox.checked) {
            buyerStep2.style.display = "block";
        }
        if (sellerCheckbox.checked) {
            sellerStep2.style.display = "block";
        }
    });

    // Final Step: Complete Setup
    document.getElementById("finishBtn").addEventListener("click", function () {
        alert("Setup Complete!");
        document.getElementById("overlay").style.display = "none";
        window.location.href = "welcome.jsp";
    });
</script>
</body>
</html>
