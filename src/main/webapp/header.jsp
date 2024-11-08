<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WorkPulse - Header</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="css/header.css">
</head>
<body>
<nav class="navbar">
    <div class="nav-container">
        <a href="#" class="logo">
            <img src="assets/landing page imgs/workpulse.png" alt="WorkPulse Logo">
        </a>

        <div class="search-container">
            <input type="text" class="search-input" placeholder="What service are you looking for today?">
            <i class="fas fa-search search-icon"></i>
        </div>

        <div class="nav-right">
            <div class="notification-icon-container">
                <div class="nav-icon" onclick="toggleNotifications()" aria-haspopup="true" aria-expanded="false">
                    <i class="far fa-bell"></i>
                    <span id="notification-count" class="notification-count">3</span>
                </div>
                <div id="notification-dropdown" class="notification-dropdown">
                    <div class="dropdown-header">
                        <span>Notifications</span>
                        <button onclick="markAllAsRead()" class="mark-as-read-btn">Mark all as read</button>
                    </div>
                    <div class="notification-list">
                        <div class="notification-item unread" onclick="markAsRead(this)">
                            <div class="notification-content">
                                <div class="notification-message">New message from John</div>
                                <div class="notification-time">5 mins ago</div>
                            </div>
                        </div>
                        <div class="notification-item unread" onclick="markAsRead(this)">
                            <div class="notification-content">
                                <div class="notification-message">Project update from Sarah</div>
                                <div class="notification-time">10 mins ago</div>
                            </div>
                        </div>
                        <div class="notification-item">
                            <div class="notification-content">
                                <div class="notification-message">Your payment was processed</div>
                                <div class="notification-time">1 hour ago</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="nav-icon">
                <i class="far fa-envelope"></i>
            </div>

            <div class="profile-dropdown">
                <img src="/api/placeholder/32/32" alt="Profile" class="nav-icon" onclick="toggleProfileDropdown()">
                <div id="dropdownMenu" class="dropdown-menu">
                    <a href="manage-order.jsp" class="dropdown-item">
                        <i class="fas fa-shopping-bag"></i>
                        Orders
                    </a>
                    <a href="myGigs.jsp" class="dropdown-item">
                        <i class="fas fa-store"></i>
                        Gigs
                    </a>
                    <a href="profile.jsp" class="dropdown-item">
                        <i class="fas fa-user"></i>
                        Profile
                    </a>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-sign-out-alt"></i>
                        Logout
                    </a>
                </div>
            </div>
        </div>
    </div>
</nav>

<div class="categories-nav">
    <div class="categories-container">
        <a href="#" class="category-link">Graphics & Design</a>
        <a href="#" class="category-link">Programming & Tech</a>
        <a href="#" class="category-link">Digital Marketing</a>
        <a href="#" class="category-link">Video & Animation</a>
        <a href="#" class="category-link">Writing & Translation</a>
        <a href="#" class="category-link">Music & Audio</a>
        <a href="#" class="category-link">Business</a>
        <a href="#" class="category-link">AI Services</a>
    </div>
</div>

<script>
    let notificationCount = 2; // Initial unread count

    function toggleNotifications() {
        const dropdown = document.getElementById("notification-dropdown");
        const currentDisplay = dropdown.style.display;
        dropdown.style.display = currentDisplay === "block" ? "none" : "block";

        // Close profile dropdown if open
        document.getElementById("dropdownMenu").style.display = "none";
    }

    function toggleProfileDropdown() {
        const dropdown = document.getElementById("dropdownMenu");
        const currentDisplay = dropdown.style.display;
        dropdown.style.display = currentDisplay === "block" ? "none" : "block";

        // Close notification dropdown if open
        document.getElementById("notification-dropdown").style.display = "none";
    }

    function updateNotificationCount() {
        const countElement = document.getElementById("notification-count");
        if (notificationCount > 0) {
            countElement.style.display = "flex";
            countElement.textContent = notificationCount;
        } else {
            countElement.style.display = "none";
        }
    }

    function markAsRead(element) {
        if (element.classList.contains('unread')) {
            element.classList.remove('unread');
            notificationCount--;
            updateNotificationCount();
        }
    }

    function markAllAsRead() {
        const unreadItems = document.querySelectorAll('.notification-item.unread');
        unreadItems.forEach(item => {
            item.classList.remove('unread');
        });
        notificationCount = 0;
        updateNotificationCount();
    }

    // Close dropdowns when clicking outside
    document.addEventListener('click', function(event) {
        const notificationContainer = document.querySelector('.notification-icon-container');
        const profileContainer = document.querySelector('.profile-dropdown');

        if (!notificationContainer.contains(event.target)) {
            document.getElementById("notification-dropdown").style.display = "none";
        }

        if (!profileContainer.contains(event.target)) {
            document.getElementById("dropdownMenu").style.display = "none";
        }
    });

    // Initialize notification count
    updateNotificationCount();
</script>
</body>
</html>