document.addEventListener('DOMContentLoaded', function() {
    // Initialize all components
    initializeGallery();
    initializePackages();
    initializeReviews();
    initializeSaveButtons();
    initializeContactButtons();
    initializeSticky();

    // Gallery Initialization
    function initializeGallery() {
        // Initialize Swiper
        const swiper = new Swiper('.swiper', {
            slidesPerView: 1,
            spaceBetween: 0,
            loop: true,
            navigation: {
                nextEl: '.swiper-button-next',
                prevEl: '.swiper-button-prev',
            },
            pagination: {
                el: '.swiper-pagination',
                clickable: true
            }
        });

        // Gallery Thumbnails
        const thumbs = document.querySelectorAll('.thumb');
        thumbs.forEach((thumb, index) => {
            thumb.addEventListener('click', () => {
                // Remove active class from all thumbs
                thumbs.forEach(t => t.classList.remove('active'));
                // Add active class to clicked thumb
                thumb.classList.add('active');
                // Go to slide
                swiper.slideTo(index);
            });
        });

        // Update thumbnails on slide change
        swiper.on('slideChange', () => {
            thumbs.forEach(t => t.classList.remove('active'));
            thumbs[swiper.realIndex].classList.add('active');
        });
    }

    // Packages Tab Functionality
    function initializePackages() {
        const packageTabs = document.querySelectorAll('.package-tab');
        const packages = {
            basic: {
                name: "Basic Package",
                price: document.querySelector('[data-package="basic"]').dataset.price,
                description: document.querySelector('[data-package="basic"]').dataset.description,
                deliveryTime: document.querySelector('[data-package="basic"]').dataset.delivery,
                revisions: document.querySelector('[data-package="basic"]').dataset.revisions,
                features: JSON.parse(document.querySelector('[data-package="basic"]').dataset.features)
            },
            standard: {
                name: "Standard Package",
                price: document.querySelector('[data-package="standard"]').dataset.price,
                description: document.querySelector('[data-package="standard"]').dataset.description,
                deliveryTime: document.querySelector('[data-package="standard"]').dataset.delivery,
                revisions: document.querySelector('[data-package="standard"]').dataset.revisions,
                features: JSON.parse(document.querySelector('[data-package="standard"]').dataset.features)
            },
            premium: {
                name: "Premium Package",
                price: document.querySelector('[data-package="premium"]').dataset.price,
                description: document.querySelector('[data-package="premium"]').dataset.description,
                deliveryTime: document.querySelector('[data-package="premium"]').dataset.delivery,
                revisions: document.querySelector('[data-package="premium"]').dataset.revisions,
                features: JSON.parse(document.querySelector('[data-package="premium"]').dataset.features)
            }
        };

        packageTabs.forEach(tab => {
            tab.addEventListener('click', () => {
                // Remove active class from all tabs
                packageTabs.forEach(t => t.classList.remove('active'));
                // Add active class to clicked tab
                tab.classList.add('active');
                // Update package content
                updatePackageContent(packages[tab.dataset.package]);
            });
        });

        function updatePackageContent(package) {
            const content = document.querySelector('.package-content');
            content.innerHTML = `
                <div class="package-header">
                    <h3 class="package-name">${package.name}</h3>
                    <div class="package-price">$${package.price}</div>
                </div>
                
                <div class="package-description">
                    ${package.description}
                </div>

                <div class="package-details">
                    <div class="detail-item">
                        <i class="fas fa-clock"></i>
                        <span>${package.deliveryTime} Days Delivery</span>
                    </div>
                    <div class="detail-item">
                        <i class="fas fa-sync"></i>
                        <span>${package.revisions} Revisions</span>
                    </div>
                </div>

                <div class="package-features">
                    ${package.features.map(feature => `
                        <div class="feature-item">
                            <i class="fas fa-check"></i>
                            <span>${feature}</span>
                        </div>
                    `).join('')}
                </div>

                <button class="continue-btn" onclick="proceedToOrder('${package.name.toLowerCase()}')">
                    Continue
                    <i class="fas fa-arrow-right"></i>
                </button>
            `;
        }
    }

    // Reviews Functionality
    function initializeReviews() {
        const ratingFilter = document.querySelector('.rating-filter');
        const reviewsList = document.querySelector('.reviews-list');
        const loadMoreBtn = document.querySelector('.load-more-reviews');
        let currentPage = 1;

        if (ratingFilter) {
            ratingFilter.addEventListener('change', () => {
                currentPage = 1;
                loadReviews(true);
            });
        }

        if (loadMoreBtn) {
            loadMoreBtn.addEventListener('click', () => {
                currentPage++;
                loadReviews(false);
            });
        }

        async function loadReviews(reset = false) {
            const gigId = document.querySelector('[data-gig-id]').dataset.gigId;
            const rating = ratingFilter ? ratingFilter.value : '';

            try {
                const response = await fetch(`/api/gigs/${gigId}/reviews?page=${currentPage}&rating=${rating}`);
                const data = await response.json();

                if (reset) {
                    reviewsList.innerHTML = '';
                }

                data.reviews.forEach(review => {
                    const reviewElement = createReviewElement(review);
                    reviewsList.appendChild(reviewElement);
                });

                // Hide load more button if no more reviews
                if (loadMoreBtn) {
                    loadMoreBtn.style.display = data.hasMore ? 'flex' : 'none';
                }

            } catch (error) {
                console.error('Error loading reviews:', error);
            }
        }

        function createReviewElement(review) {
            const div = document.createElement('div');
            div.className = 'review-item';
            div.innerHTML = `
                <div class="review-header">
                    <img src="${review.buyer.avatar}" alt="${review.buyer.name}">
                    <div class="reviewer-info">
                        <div class="reviewer-name">${review.buyer.name}</div>
                        <div class="review-meta">
                            <div class="rating-stars">
                                ${Array(5).fill('').map((_, i) => `
                                    <i class="fas fa-star ${i < review.rating ? 'filled' : ''}"></i>
                                `).join('')}
                            </div>
                            <span class="review-date">${formatDate(review.date)}</span>
                        </div>
                    </div>
                </div>
                <div class="review-content">
                    ${review.content}
                </div>
            `;
            return div;
        }

        function formatDate(dateString) {
            const options = { year: 'numeric', month: 'long', day: 'numeric' };
            return new Date(dateString).toLocaleDateString('en-US', options);
        }
    }

    // Save Button Functionality
    function initializeSaveButtons() {
        const saveButtons = document.querySelectorAll('.save-button');

        saveButtons.forEach(button => {
            button.addEventListener('click', async (e) => {
                e.preventDefault();
                e.stopPropagation();

                const gigId = button.dataset.id;
                const icon = button.querySelector('i');
                const isSaved = button.classList.contains('saved');

                try {
                    const response = await fetch(`/api/gigs/${gigId}/${isSaved ? 'unsave' : 'save'}`, {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    });

                    if (!response.ok) throw new Error('Failed to save/unsave gig');

                    button.classList.toggle('saved');
                    icon.classList.toggle('far');
                    icon.classList.toggle('fas');

                } catch (error) {
                    console.error('Error saving gig:', error);
                    showToast('Error saving gig. Please try again.');
                }
            });
        });
    }

    // Contact Button Functionality
    function initializeContactButtons() {
        const contactButtons = document.querySelectorAll('.contact-seller, .contact-seller-btn');

        contactButtons.forEach(button => {
            button.addEventListener('click', () => {
                const sellerId = button.dataset.sellerId;
                openContactModal(sellerId);
            });
        });
    }

    function openContactModal(sellerId) {
        // Implementation for contact modal
        console.log('Opening contact modal for seller:', sellerId);
    }

    // Sticky Sidebar
    function initializeSticky() {
        const sidebar = document.querySelector('.gig-sidebar');
        const content = document.querySelector('.gig-main');
        let lastScroll = window.scrollY;
        let ticking = false;

        if (window.innerWidth > 992) { // Only on desktop
            window.addEventListener('scroll', () => {
                lastScroll = window.scrollY;
                if (!ticking) {
                    window.requestAnimationFrame(() => {
                        updateStickyPosition(lastScroll);
                        ticking = false;
                    });
                    ticking = true;
                }
            });
        }

        function updateStickyPosition(scrollY) {
            if (!sidebar || !content) return;

            const sidebarHeight = sidebar.offsetHeight;
            const contentHeight = content.offsetHeight;
            const windowHeight = window.innerHeight;
            const maxScroll = content.offsetTop + contentHeight - sidebarHeight;

            if (scrollY > content.offsetTop && sidebarHeight < contentHeight) {
                if (scrollY > maxScroll) {
                    sidebar.style.position = 'absolute';
                    sidebar.style.top = `${contentHeight - sidebarHeight}px`;
                } else {
                    sidebar.style.position = 'fixed';
                    sidebar.style.top = '24px';
                }
            } else {
                sidebar.style.position = 'static';
            }
        }
    }

    // Utility Functions
    function showToast(message) {
        const toast = document.createElement('div');
        toast.className = 'toast';
        toast.textContent = message;
        document.body.appendChild(toast);

        setTimeout(() => {
            toast.remove();
        }, 3000);
    }

    // Order Processing
    window.proceedToOrder = function(packageType) {
        const gigId = document.querySelector('[data-gig-id]').dataset.gigId;
        window.location.href = `/order/new?gig=${gigId}&package=${packageType}`;
    }
});
