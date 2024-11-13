document.addEventListener('DOMContentLoaded', function() {
    const navCategories = document.querySelector('.nav-categories');
    const megaMenu = document.querySelector('.mega-menu');
    let timeoutId;

    // Handle mouse interactions
    navCategories.addEventListener('mouseenter', () => {
        clearTimeout(timeoutId);
        megaMenu.style.visibility = 'visible';
        megaMenu.style.opacity = '1';
        megaMenu.style.transform = 'translateY(0)';
    });

    navCategories.addEventListener('mouseleave', () => {
        timeoutId = setTimeout(() => {
            megaMenu.style.visibility = 'hidden';
            megaMenu.style.opacity = '0';
            megaMenu.style.transform = 'translateY(10px)';
        }, 200);
    });

    // Handle touch interactions for mobile
    let touchStartY;

    navCategories.addEventListener('touchstart', (e) => {
        touchStartY = e.touches[0].clientY;
    });

    navCategories.addEventListener('touchend', (e) => {
        const touchEndY = e.changedTouches[0].clientY;
        const deltaY = touchEndY - touchStartY;

        if (Math.abs(deltaY) < 5) { // If it's a tap (not a scroll)
            e.preventDefault();
            megaMenu.classList.toggle('active');
        }
    });

    // Close mega menu when clicking outside
    document.addEventListener('click', (e) => {
        if (!navCategories.contains(e.target)) {
            megaMenu.classList.remove('active');
        }
    });
});
