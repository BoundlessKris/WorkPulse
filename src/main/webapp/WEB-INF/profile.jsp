<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fiverr Profile</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link rel="stylesheet" href="../css/profile.css">
</head>
<body>
<header class="header">
    <nav class="nav">
        <div class="nav-left">
            <div class="logo"><img class="logo" src="logo-no-background.png"></div>
            <ul class="nav-menu">
                <li><i class="fas fa-chart-line"></i> Dashboard</li>
                <li><i class="fas fa-briefcase"></i> My Business</li>
                <li><i class="fas fa-bullhorn"></i> Growth & Marketing</li>
                <li><i class="fas fa-chart-bar"></i> Analytics</li>
            </ul>
        </div>
        <div class="nav-right">
            <div class="nav-icon"><i class="far fa-bell"></i></div>
            <div class="nav-icon"><i class="far fa-envelope"></i></div>
            <div class="nav-icon"><i class="fas fa-user"></i></div>
        </div>
    </nav>
</header>

<div class="container">
    <!-- Profile Card -->
    <div class="profile-card">
        <div class="profile-header">
            <div class="profile-image">
                <img src="/api/placeholder/120/120" alt="Profile">
            </div>
            <span class="online-badge"><i class="fas fa-circle"></i> Online</span>
            <h1 class="username">
                Satyajyoti
                <span class="new-badge">NEW</span>
            </h1>
            <p class="handle"><i class="fas fa-at"></i>satyajyoti_</p>
            <button class="preview-btn">
                <i class="far fa-eye"></i>
                Preview Fiverr Profile
            </button>
        </div>
        <div class="profile-info">
            <div class="info-item">
                <i class="fas fa-map-marker-alt"></i>
                <span>From</span>
                <strong>India</strong>
            </div>
            <div class="info-item">
                <i class="far fa-clock"></i>
                <span>Member since</span>
                <strong>Oct 2024</strong>
            </div>
        </div>
    </div>

    <!-- Content Section -->
    <div class="content-section">
        <div class="content-card">
            <div class="tabs">
                <div class="tab active">
                    <i class="fas fa-briefcase"></i>
                    ACTIVE GIGS
                </div>
            </div>
            <div class="create-gig">
                <div class="plus-icon">+</div>
                <span>Create a new Gig</span>
            </div>
        </div>

        <!-- Description Section -->
        <div class="description-section">
            <div class="section-header">
                <h2 class="section-title">
                    <i class="fas fa-user"></i>
                    Description
                </h2>
                <a href="#" class="edit-link">
                    <i class="fas fa-pencil-alt"></i>
                    Edit Description
                </a>
            </div>
            <p class="description-text">jkghakjghhgakjjvkjzbfafheuigrugbjhvbjdbsaguygyhvbhjfafguygfhjvbhdfuaegfyugfsvjhbagguyghfhjhvsaugfyugbhjfasgfuegfuyasggryvagfuyagfuygstuegftufgfuyagyuwgurtgf</p>

            <div class="section-header">
                <h2 class="section-title">
                    <i class="fas fa-globe"></i>
                    Languages
                </h2>
                <a href="#" class="edit-link">
                    <i class="fas fa-plus"></i>
                    Add New
                </a>
            </div>
            <div class="language-item">
                <i class="fas fa-language"></i>
                English - <span class="language-level">Conversational</span>
            </div>
            <div class="language-item">
                <i class="fas fa-language"></i>
                Hindi (हिंदी) - <span class="language-level">Fluent</span>
            </div>
            <div class="language-item">
                <i class="fas fa-language"></i>
                Oriya (ଓଡ଼ିଆ) - <span class="language-level">Native/Bilingual</span>
            </div>

            <div class="section-header">
                <h2 class="section-title">Skills</h2>
                <a href="#" class="edit-link">Add New</a>
            </div>
            <div class="skills-list">
                <span class="skill-tag">HTML</span>
                <span class="skill-tag">CSS</span>
                <span class="skill-tag">JavaScript</span>
            </div>

            <div class="section-header">
                <h2 class="section-title">Education</h2>
                <a href="#" class="edit-link">Add New</a>
            </div>
            <p class="placeholder-text">Add your Education.</p>

            <div class="section-header">
                <h2 class="section-title">Certification</h2>
                <a href="#" class="edit-link">Add New</a>
            </div>
            <p class="placeholder-text">Add your Certification.</p>
        </div>
    </div>
</div>
</body>
</html>