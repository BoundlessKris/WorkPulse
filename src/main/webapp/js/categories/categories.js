document.addEventListener('DOMContentLoaded', function() {
    // Initialize components
    initializeCategories();
    initializePopularServices();
    initializeServiceCards();
});

function initializeCategories() {
    const categoryCards = document.querySelectorAll('.category-card');

    categoryCards.forEach(card => {
        // Add hover effects
        card.addEventListener('mouseenter', () => {
            expandSubcategories(card);
        });

        card.addEventListener('mouseleave', () => {
            collapseSubcategories(card);
        });

        // Handle mobile touch events
        card.addEventListener('touchstart', handleTouchStart);
        card.addEventListener('touchend', handleTouchEnd);
    });
}

function expandSubcategories(card) {
    const subcategories = card.querySelector('.subcategories');
    const height = subcategories.scrollHeight;
    subcategories.style.maxHeight = `${height}px`;
}

function collapseSubcategories(card) {
    const subcategories = card.querySelector('.subcategories');
    subcategories.style.maxHeight = null;
}

let touchStartY = 0;
function handleTouchStart(e) {
    touchStartY = e.touches[0].clientY;
}

function handleTouchEnd(e) {
    const touchEndY = e.changedTouches[0].clientY;
    const diff = touchStartY - touchEndY;

    // If it's a tap (not a scroll)
    if (Math.abs(diff) < 5) {
        const card = e.currentTarget;
        const subcategories = card.querySelector('.subcategories');

        if (subcategories.style.maxHeight) {
            collapseSubcategories(card);
        } else {
            expandSubcategories(card);
        }
    }
}

function initializePopularServices() {
    // This would typically fetch from your backend
    // For demo, we'll use mock data
    const mockServices = [
        {
            id: 1,
            title: "Professional Logo Design",
            thumbnail: "/images/services/logo-design.jpg",
            seller: {
                name: "John Doe",
                avatar: "/images/avatars/john.jpg",
                level: "Top Rated"
            },
            rating: 4.9,
            reviewsCount: 245,
            startingPrice: 49
        },
        // Add more mock services as needed
    ];

    loadPopularServices(mockServices);
}

function loadPopularServices(services) {
    const slider = document.querySelector('.services-slider');
    if (!slider) return;

    services.forEach(service => {
        const card = createServiceCard(service);
        slider.appendChild(card);
    });
}

function createServiceCard(service) {
    const card = document.createElement('div');
    card.className = 'service-card';

    card.innerHTML = `
        <div class="service-image">
            <img src="${service.thumbnail}" alt="${service.title}">
        </div>
        <div class="service-info">
            <div class="seller-info">
                <img src="${service.seller.avatar}" alt="${service.seller.name}">
                <span class="seller-name">${service.seller.name}</span>
                <span class="seller-level">${service.seller.level}</span>
            </div>
            <h3 class="service-title">
                <a href="/gig/${service.id}">${service.title}</a>
            </h3>
            <div class="service-rating">
                <i class="fas fa-star"></i>
                <span>${service.rating}</span>
                <span>(${service.reviewsCount})</span>
            </div>
        </div>
        <div class="service-footer">
            <div class="service-price">
                <span>Starting at</span>
                <strong>$${service.startingPrice}</strong>
            </div>
        </div>
    `;

    return card;
}

function initializeServiceCards() {
    // Handle service card interactions
    const serviceCards = document.querySelectorAll('.service-card');

    serviceCards.forEach(card => {
        // Add click handler
        card.addEventListener('click', (e) => {
            // Prevent navigation if clicking on specific elements
            if (e.target.closest('.save-button')) return;

            const link = card.querySelector('.service-title a');
            if (link) {
                window.location.href = link.href;
            }
        });

        // Add save button functionality if present
        const saveButton = card.querySelector('.save-button');
        if (saveButton) {
            saveButton.addEventListener('click', handleSaveService);
        }
    });
}

function handleSaveService(e) {
    e.preventDefault();
    const button = e.currentTarget;
    const icon = button.querySelector('i');

    // Toggle saved state
    button.classList.toggle('saved');
    if (button.classList.contains('saved')) {
        icon.classList.remove('far');
        icon.classList.add('fas');
    } else {
        icon.classList.remove('fas');
        icon.classList.add('far');
    }

    // Here you would typically make an API call to save/unsave the service
    const serviceId = button.dataset.serviceId;
    // Example API call:
    // toggleSaveService(serviceId);
}

// Lazy loading for images
function initializeLazyLoading() {
    const images = document.querySelectorAll('img[data-src]');

    const imageObserver = new IntersectionObserver((entries, observer) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                const img = entry.target;
                img.src = img.dataset.src;
                img.removeAttribute('data-src');
                observer.unobserve(img);
            }
        });
    });

    images.forEach(img => imageObserver.observe(img));
}

// Search functionality for categories
const searchInput = document.querySelector('.category-search');
if (searchInput) {
    searchInput.addEventListener('input', debounce(function(e) {
        const searchTerm = e.target.value.toLowerCase();
        const categoryCards = document.querySelectorAll('.category-card');

        categoryCards.forEach(card => {
            const title = card.querySelector('h3').textContent.toLowerCase();
            const subcategories = Array.from(card.querySelectorAll('.subcategories li'))
                .map(li => li.textContent.toLowerCase());

            const isMatch = title.includes(searchTerm) ||
                subcategories.some(sub => sub.includes(searchTerm));

            card.style.display = isMatch ? 'block' : 'none';
        });
    }, 300));
}

// Utility function for debouncing
function debounce(func, wait) {
    let timeout;
    return function executedFunction(...args) {
        const later = () => {
            clearTimeout(timeout);
            func(...args);
        };
        clearTimeout(timeout);
        timeout = setTimeout(later, wait);
    };
}

// Handle window resize events
window.addEventListener('resize', debounce(() => {
    const isMobile = window.innerWidth <= 768;
    const categoryCards = document.querySelectorAll('.category-card');

    categoryCards.forEach(card => {
        if (!isMobile) {
            // Reset any mobile-specific styles
            const subcategories = card.querySelector('.subcategories');
            subcategories.style.maxHeight = null;
        }
    });
}, 250));
