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


document.addEventListener('DOMContentLoaded', function() {
    // Lazy loading for category cards
    function lazyLoadCategories() {
        const categoryCards = document.querySelectorAll('.category-card');
        const observerOptions = {
            root: null,
            rootMargin: '0px',
            threshold: 0.5
        };

        const observer = new IntersectionObserver(function(entries) {
            entries.forEach(function(entry) {
                if (entry.isIntersecting) {
                    const card = entry.target;
                    card.classList.add('loaded');
                    observer.unobserve(card);
                }
            });
        }, observerOptions);

        categoryCards.forEach(function(card) {
            observer.observe(card);
        });
    }

    // Implement category filtering
    const filterSelect = document.getElementById('categoryFilter');
    if (filterSelect) {
        filterSelect.addEventListener('change', function() {
            const selectedCategory = this.value;
            filterCategories(selectedCategory);
        });
    }

    function filterCategories(category) {
        const categoryCards = document.querySelectorAll('.category-card');
        categoryCards.forEach(function(card) {
            const cardCategory = card.dataset.category;
            if (category === 'all' || cardCategory === category) {
                card.style.display = 'block';
            } else {
                card.style.display = 'none';
            }
        });
    }

    // Call the lazy loading function
    lazyLoadCategories();
});

// Handle save/favorite functionality
document.addEventListener('DOMContentLoaded', function() {
    const saveButtons = document.querySelectorAll('.save-button');

    saveButtons.forEach(button => {
        button.addEventListener('click', function(e) {
            e.preventDefault(); // Prevent link navigation

            const icon = this.querySelector('i');
            if (icon.classList.contains('far')) {
                icon.classList.remove('far');
                icon.classList.add('fas');
                // Add to saved gigs
            } else {
                icon.classList.remove('fas');
                icon.classList.add('far');
                // Remove from saved gigs
            }

            // Send AJAX request to server to save/unsave gig
            // Add your AJAX code here
        });
    });
});

// Smooth scroll for business solution links
document.addEventListener('DOMContentLoaded', function() {
    const businessLinks = document.querySelectorAll('.business-cta a');

    businessLinks.forEach(link => {
        link.addEventListener('click', function(e) {
            // Add smooth scroll if needed
            if (this.getAttribute('href').startsWith('#')) {
                e.preventDefault();
                const target = document.querySelector(this.getAttribute('href'));
                if (target) {
                    target.scrollIntoView({
                        behavior: 'smooth'
                    });
                }
            }
        });
    });

    // Add animation when section comes into view
    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.querySelectorAll('.feature-item').forEach((item, index) => {
                    setTimeout(() => {
                        item.classList.add('animate-in');
                    }, index * 200);
                });
            }
        });
    }, { threshold: 0.2 });

    const businessSection = document.querySelector('.business-solutions');
    if (businessSection) {
        observer.observe(businessSection);
    }
});

// Intersection Observer for step cards
document.addEventListener('DOMContentLoaded', function() {
    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add('visible');
            }
        });
    }, {
        threshold: 0.1,
        rootMargin: '50px'
    });

    // Observe step cards
    document.querySelectorAll('.step-card').forEach(card => {
        observer.observe(card);
    });

    // Hover effect for step cards
    document.querySelectorAll('.step-card').forEach(card => {
        card.addEventListener('mouseenter', function() {
            document.querySelectorAll('.step-card').forEach(c => {
                if (c !== this) {
                    c.style.transform = 'scale(0.98)';
                    c.style.opacity = '0.7';
                }
            });
        });

        card.addEventListener('mouseleave', function() {
            document.querySelectorAll('.step-card').forEach(c => {
                c.style.transform = '';
                c.style.opacity = '';
            });
        });
    });
});


// Intersection Observer for step cards
document.addEventListener('DOMContentLoaded', function() {
    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add('visible');
            }
        });
    }, {
        threshold: 0.1,
        rootMargin: '50px'
    });

    // Observe step cards
    document.querySelectorAll('.step-card').forEach(card => {
        observer.observe(card);
    });

    // Hover effect for step cards
    document.querySelectorAll('.step-card').forEach(card => {
        card.addEventListener('mouseenter', function() {
            document.querySelectorAll('.step-card').forEach(c => {
                if (c !== this) {
                    c.style.transform = 'scale(0.98)';
                    c.style.opacity = '0.7';
                }
            });
        });

        card.addEventListener('mouseleave', function() {
            document.querySelectorAll('.step-card').forEach(c => {
                c.style.transform = '';
                c.style.opacity = '';
            });
        });
    });
});

// Join Now Section Animations
document.addEventListener('DOMContentLoaded', function() {
    // Intersection Observer for animations
    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add('animated');

                // Animate stats when in view
                if (entry.target.classList.contains('join-stats')) {
                    animateStats();
                }
            }
        });
    }, {
        threshold: 0.2
    });

    // Observe elements
    document.querySelectorAll('.join-card, .join-stats').forEach(el => {
        observer.observe(el);
    });

    // Stats animation
    function animateStats() {
        document.querySelectorAll('.stat-value').forEach((stat, index) => {
            setTimeout(() => {
                stat.classList.add('counted');
            }, index * 200);
        });
    }

    // Hover effects for join cards
    document.querySelectorAll('.join-card').forEach(card => {
        card.addEventListener('mouseenter', () => {
            card.style.transform = 'translateY(-10px)';
        });

        card.addEventListener('mouseleave', () => {
            card.style.transform = 'translateY(0)';
        });
    });
});
