<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WorkPulse Profile</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link rel="stylesheet" href="css/profile.css">
</head>
<header class="header">
    <nav class="nav">
        <div class="nav-left">
            <div class="logo"><img class="logo" src="assets/landing%20page%20imgs/workpulse.png"></div>
            <ul class="nav-menu">
                <li><i class="fas fa-chart-line"></i> Dashboard</li>
                <li><i class="fas fa-briefcase"></i> My Business</li>
                <li><i class="fas fa-bullhorn"></i> Growth & Marketing</li>
                <li><i class="fas fa-chart-bar"></i> Analytics</li>
            </ul>
        </div>
        <div class="nav-right">
            <div class="notification-icon-container">
                <i class="far fa-bell nav-icon notification-icon" onclick="toggleNotifications()"></i>
                <span id="notification-count" class="notification-count">3</span>

                <!-- Notification Dropdown -->
                <div id="notification-dropdown" class="notification-dropdown">
                    <div class="dropdown-header">
                        <span>Notifications</span>
                        <button onclick="markAllAsRead()" class="mark-as-read-btn">Mark all as read</button>
                    </div>
                    <ul class="notification-list">
                        <li class="notification-item unread">
                            <span>New message from John</span>
                            <small>5 mins ago</small>
                        </li>
                        <li class="notification-item unread">
                            <span>Project update from Sarah</span>
                            <small>10 mins ago</small>
                        </li>
                        <li class="notification-item">
                            <span>Your payment was processed</span>
                            <small>1 hour ago</small>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="nav-icon"><i class="far fa-envelope"></i></div>
            <div class="profile-dropdown">
                <img src="/api/placeholder/32/32" alt="Profile" class="profile-image-nav" id="profileDropdown">
                <div class="dropdown-menu" id="dropdownMenu">
                    <a href="manage-order.jsp" class="dropdown-item">
                        <i class="fas fa-shopping-bag"></i> Orders
                    </a>
                    <a href="myGigs.jsp" class="dropdown-item">
                        <i class="fas fa-store"></i> Gigs
                    </a>
                    <a href="profile.jsp" class="dropdown-item">
                        <i class="fas fa-user"></i> Profile
                    </a>
                    <a href="" class="dropdown-item">
                        <i class="fas fa-sign-out-alt"></i> Logout
                    </a>
                </div>
            </div>
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
            <button class="preview-btn edit-btn" onclick="toggleDescription()">
                <i class="far fa-edit"></i>
                Edit Profile
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
            <a href="addGig.jsp" class="create-gig">
                <div class="plus-icon">+</div>
                <span>Create a new Gig</span>
            </a>
        </div>

        <!-- Description Section -->
        <div id="description-section" class="description-section" style="display: none;">
            <form id="profile-form" onsubmit="handleSubmit(event)">
        <!-- Description -->
        <div class="section-header">
            <h2 class="section-title">
                <i class="fas fa-user"></i>
                Description
            </h2>
        </div>
        <div class="input-group">
            <textarea class="description-input" name="description">I am a developer.</textarea>
            <button type="button" class="edit-icon" onclick="enableEdit(this)">
                <i class="far fa-edit"></i>
            </button>
        </div>

        <!-- Languages -->
        <div class="section-header">
            <h2 class="section-title">
                <i class="fas fa-globe"></i>
                Languages
            </h2>
            <button type="button" class="edit-link" onclick="addLanguage()">
                <i class="fas fa-plus"></i>
                Add New
            </button>
        </div>
        <div id="languages-container">
            <div class="language-input-group">
                <select name="language[]" class="language-select">
                    <option value="English">English</option>
                    <option value="Hindi">Hindi (हिंदी)</option>
                    <option value="Oriya">Oriya (ଓଡ଼ିଆ)</option>
                </select>
                <select name="proficiency[]" class="proficiency-select">
                    <option value="Conversational">Conversational</option>
                    <option value="Fluent">Fluent</option>
                    <option value="Native">Native/Bilingual</option>
                </select>
                <button type="button" class="edit-icon" onclick="enableEdit(this)">
                    <i class="far fa-edit"></i>
                </button>
            </div>
        </div>
        <!-- Skills -->
        <div class="section-header">
            <h2 class="section-title">Skills</h2>
            <button type="button" class="edit-link" onclick="addSkill()">
                <i class="fas fa-plus"></i>
                Add New
            </button>
        </div>
        <div id="skills-container" class="skills-list">
            <div class="input-group">
                <input type="text" class="skill-input" name="skills[]" value="HTML, CSS, JavaScript" disabled>
                <button type="button" class="edit-icon" onclick="enableEdit(this)">
                    <i class="far fa-edit"></i>
                </button>
            </div>
        </div>
        <!-- Education -->
        <div class="section-header">
            <h2 class="section-title">Education</h2>
        </div>
        <div class="input-group">
            <textarea class="education-input" name="education" placeholder="Add your Education"></textarea>
            <button type="button" class="edit-icon" onclick="enableEdit(this)">
                <i class="far fa-edit"></i>
            </button>
        </div>

        <!-- Certification -->
        <div class="section-header">
            <h2 class="section-title">Certification</h2>
        </div>
        <div class="input-group">
            <textarea class="certification-input" name="certification" placeholder="Add your Certification"></textarea>
            <button type="button" class="edit-icon" onclick="enableEdit(this)">
                <i class="far fa-edit"></i>
            </button>
        </div>

        <!-- Submit Button -->
        <button type="submit" class="preview-btn save-btn">
            <i class="fas fa-save"></i>
            Save Changes
        </button>
            </form>
    </div>
    </div>
    </div>
    <script>
        // Profile Dropdown Functionality
        const profileDropdown = document.getElementById("profileDropdown");
        const dropdownMenu = document.getElementById("dropdownMenu");

        profileDropdown.addEventListener("click", () => {
            dropdownMenu.style.display = dropdownMenu.style.display === "block" ? "none" : "block";
        });

        window.addEventListener("click", (event) => {
            if (!profileDropdown.contains(event.target) && !dropdownMenu.contains(event.target)) {
                dropdownMenu.style.display = "none";
            }
        });

        function toggleDescription() {
            const descriptionSection = document.getElementById('description-section');
            if (descriptionSection.style.display === 'none' || descriptionSection.style.display === '') {
                descriptionSection.style.display = 'block';
            } else {
                descriptionSection.style.display = 'none';
            }
        }

        // Toggle Edit Mode
        function enableEdit(button) {
            const inputField = button.previousElementSibling;
            inputField.disabled = !inputField.disabled;
            button.innerHTML = inputField.disabled ? '<i class="far fa-edit"></i>' : '<i class="far fa-save"></i>';
        }

        // Add New Language Field
        function addLanguage() {
            const languageContainer = document.getElementById("languages-container");
            const newLanguageGroup = document.createElement("div");
            newLanguageGroup.classList.add("language-input-group");

            newLanguageGroup.innerHTML =
                `<select name="language[]" class="language-select">
                    <option value="English">English</option>
                    <option value="Hindi">Hindi (हिंदी)</option>
                    <option value="Oriya">Oriya (ଓଡ଼ିଆ)</option>
                </select>
            <select name="proficiency[]" class="proficiency-select">
                <option value="Conversational">Conversational</option>
                <option value="Fluent">Fluent</option>
                <option value="Native">Native/Bilingual</option>
            </select>
            <button type="button" class="edit-icon" onclick="enableEdit(this)">
                <i class="far fa-edit"></i>
            </button>`
            ;
            languageContainer.appendChild(newLanguageGroup);
        }

        // Add New Skill Field
        function addSkill() {
            const skillsContainer = document.getElementById("skills-container");
            const newSkillGroup = document.createElement("div");
            newSkillGroup.classList.add("input-group");

            newSkillGroup.innerHTML =
                `<input type="text" class="skill-input" name="skills[]" placeholder="New Skill" disabled>
                    <button type="button" class="edit-icon" onclick="enableEdit(this)">
                        <i class="far fa-edit"></i>
                    </button>`
                    ;
                    skillsContainer.appendChild(newSkillGroup);
                    }
                    // Toggle Dropdown Visibility
                    function toggleNotifications() {
                    const dropdown = document.getElementById("notification-dropdown");
                    dropdown.style.display = dropdown.style.display === "block" ? "none" : "block";
                }

                    // Mark All as Read
                    function markAllAsRead() {
                    const notifications = document.querySelectorAll(".notification-item.unread");
                    notifications.forEach(notification => {
                    notification.classList.remove("unread");
                });

                    // Hide Notification Count
                    document.getElementById("notification-count").style.display = "none";
                }

                    // Close Dropdown when clicked outside
                    window.onclick = function(event) {
                    const dropdown = document.getElementById("notification-dropdown");
                    const notificationIcon = document.querySelector(".notification-icon");
                    if (!notificationIcon.contains(event.target) && dropdown.style.display === "block") {
                    dropdown.style.display = "none";
                }
                };

    </script>
</body>
</html>