document.addEventListener('DOMContentLoaded', function() {
    // Search input auto-focus
    const searchInput = document.querySelector('.hero .search-input');
    if (searchInput) {
        setTimeout(() => {
            searchInput.focus();
        }, 1000);
    }

    // Dynamic popular tags
    const popularTags = [
        'Website Design',
        'WordPress',
        'Logo Design',
        'AI Services',
        'Social Media',
        'SEO',
        'Content Writing',
        'Video Editing'
    ];

    function updateTags() {
        const tagsList = document.querySelector('.tags-list');
        if (tagsList) {
            // Get random tags
            const displayTags = popularTags
                .sort(() => 0.5 - Math.random())
                .slice(0, 4);

            // Update DOM
            tagsList.innerHTML = displayTags
                .map(tag => `<a href="#" class="tag">${tag}</a>`)
                .join('');
        }
    }

    // Update tags every 5 seconds
    updateTags();
    setInterval(updateTags, 5000);
});

// Slider functionality
document.addEventListener('DOMContentLoaded', function() {
    const track = document.querySelector('.slider-track');
    const cards = document.querySelectorAll('.service-card');
    const prevButton = document.getElementById('prevSlide');
    const nextButton = document.getElementById('nextSlide');

    let currentIndex = 0;
    let cardWidth = 294; // 270px + 24px padding
    const cardsToShow = Math.floor(track.clientWidth / cardWidth);
    const maxIndex = cards.length - cardsToShow;

    function updateSliderPosition() {
        track.style.transform = `translateX(-${currentIndex * cardWidth}px)`;

        // Update button states
        prevButton.disabled = currentIndex === 0;
        nextButton.disabled = currentIndex >= maxIndex;

        // Update button opacity
        prevButton.style.opacity = currentIndex === 0 ? '0.5' : '1';
        nextButton.style.opacity = currentIndex >= maxIndex ? '0.5' : '1';
    }

    prevButton.addEventListener('click', () => {
        if (currentIndex > 0) {
            currentIndex--;
            updateSliderPosition();
        }
    });

    nextButton.addEventListener('click', () => {
        if (currentIndex < maxIndex) {
            currentIndex++;
            updateSliderPosition();
        }
    });

    // Handle window resize
    let resizeTimer;
    window.addEventListener('resize', () => {
        clearTimeout(resizeTimer);
        resizeTimer = setTimeout(() => {
            cardWidth = 294;
            currentIndex = 0;
            updateSliderPosition();
        }, 250);
    });

    // Initial setup
    updateSliderPosition();

    // Touch support for mobile devices
    let touchStartX = 0;
    let touchEndX = 0;

    track.addEventListener('touchstart', e => {
        touchStartX = e.changedTouches[0].screenX;
    }, false);

    track.addEventListener('touchend', e => {
        touchEndX = e.changedTouches[0].screenX;
        handleSwipe();
    }, false);

    function handleSwipe() {
        const difference = touchStartX - touchEndX;
        if (Math.abs(difference) > 50) { // Minimum swipe distance
            if (difference > 0 && currentIndex < maxIndex) {
                // Swipe left
                currentIndex++;
                updateSliderPosition();
            } else if (difference < 0 && currentIndex > 0) {
                // Swipe right
                currentIndex--;
                updateSliderPosition();
            }
        }
    }
});
