document.addEventListener('DOMContentLoaded', function() {
    // Initialize all components
    initializeContactButton();
    initializeSaveButtons();
    initializeReviews();
    initializeGigCards();

    // Contact Button Functionality
    function initializeContactButton() {
        const contactBtn = document.querySelector('.contact-seller');
        if (contactBtn) {
            contactBtn.addEventListener('click', () => {
                openContactModal();
            });
        }
    }

    function openContactModal() {
        // Create modal element
        const modal = document.createElement('div');
        modal.className = 'contact-modal';
        modal.innerHTML = `
            <div class="modal-content">
                <div class="modal-header">
                    <h3>Contact ${document.querySelector('.profile-details h1').textContent}</h3>
                    <button class="close-modal">
                        <i class="fas fa-times"></i>
                    </button>
                </div>
                <div class="modal-body">
                    <textarea placeholder="Write your message..." rows="5"></textarea>
                </div>
                <div class="modal-footer">
                    <button class="btn-secondary cancel-btn">Cancel</button>
                    <button class="btn-primary send-btn">Send Message</button>
                </div>
            </div>
        `;

        // Add modal to body
        document.body.appendChild(modal);

        // Add event listeners
        modal.querySelector('.close-modal').addEventListener('click', () => {
            modal.remove();
        });

        modal.querySelector('.cancel-btn').addEventListener('click', () => {
            modal.remove();
        });

        modal.querySelector('.send-btn').addEventListener('click', async () => {
            const message = modal.querySelector('textarea').value.trim();
            if (message) {
                try {
                    await sendMessage(message);
                    modal.remove();
                    showSuccess('Message sent successfully!');
                } catch (error) {
                    showError('Failed to send message. Please try again.');
                }
            }
        });

        // Close modal on outside click
        modal.addEventListener('click', (e) => {
            if (e.target === modal) {
                modal.remove();
            }
        });
    }

    async function sendMessage(message) {
        const response = await fetch('/api/messages/send', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                recipientId: document.querySelector('.profile-info').dataset.userId,
                message: message
            })
        });

        if (!response.ok) {
            throw new Error('Failed to send message');
        }
    }

    // Save Buttons Functionality
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
                        method: 'POST'
                    });

                    if (!response.ok) throw new Error('Failed to save/unsave gig');

                    button.classList.toggle('saved');
                    icon.classList.toggle('far');
                    icon.classList.toggle('fas');

                } catch (error) {
                    console.error('Error saving gig:', error);
                    showError('Failed to save gig. Please try again.');
                }
            });
        });
    }

    // Reviews Management
    function initializeReviews() {
        const loadMoreBtn = document.querySelector('.load-more');
        const reviewsList = document.querySelector('.reviews-list');
        let currentPage = 1;
        let loading = false;
        let hasMore = true;

        if (loadMoreBtn && reviewsList) {
            loadMoreBtn.addEventListener('click', () => {
                if (!loading && hasMore) {
                    loadMoreReviews();
                }
            });
        }

        async function loadMoreReviews() {
            try {
                loading = true;
                loadMoreBtn.innerHTML = '<i class="fas fa-spinner fa-spin"></i> Loading...';

                const userId = document.querySelector('.profile-info').dataset.userId;
                const response = await fetch(`/api/users/${userId}/reviews?page=${currentPage + 1}`);
                const data = await response.json();

                if (data.reviews.length > 0) {
                    data.reviews.forEach(review => {
                        const reviewElement = createReviewElement(review);
                        reviewsList.appendChild(reviewElement);
                    });
                    currentPage++;
                }

                hasMore = data.hasMore;
                if (!hasMore) {
                    loadMoreBtn.style.display = 'none';
                }

            } catch (error) {
                console.error('Error loading reviews:', error);
                showError('Failed to load more reviews');
            } finally {
                loading = false;
                loadMoreBtn.innerHTML = 'Show More Reviews <i class="fas fa-chevron-down"></i>';
            }
        }

        function createReviewElement(review) {
            const element = document.createElement('div');
            element.className = 'review-item';
            element.innerHTML = `
                <div class="review-header">
                    <img src="${review.buyer.avatar}" alt="${review.buyer.name}">
                    <div class="reviewer-info">
                        <div class="reviewer-name">${review.buyer.name}</div>
                        <div class="review-meta">
                            <div class="rating-stars">
                                ${Array(5).fill('').map((_, i) =>
                `<i class="fas fa-star ${i < review.rating ? 'filled' : ''}"></i>`
            ).join('')}
                            </div>
                            <span class="review-date">${formatDate(review.date)}</span>
                        </div>
                    </div>
                </div>
                <div class="review-content">${review.content}</div>
            `;
            return element;
        }
    }

    // Gig Cards Functionality
    function initializeGigCards() {
        const gigCards = document.querySelectorAll('.gig-card');

        gigCards.forEach(card => {
            // Handle card click
            card.addEventListener('click', (e) => {
                // Don't navigate if clicking save button
                if (!e.target.closest('.save-button')) {
                    const link = card.querySelector('.gig-title a');
                    if (link) {
                        window.location.href = link.href;
                    }
                }
            });

            // Add hover effect
            card.addEventListener('mouseenter', () => {
                card.style.transform = 'translateY(-4px)';
                card.style.boxShadow = '0 4px 12px rgba(0, 0, 0, 0.1)';
            });

            card.addEventListener('mouseleave', () => {
                card.style.transform = 'none';
                card.style.boxShadow = 'none';
            });
        });
    }

    // Utility Functions
    function formatDate(dateString) {
        const options = { year: 'numeric', month: 'long', day: 'numeric' };
        return new Date(dateString).toLocaleDateString('en-US', options);
    }

    function showToast(message, type = 'info') {
        const toast = document.createElement('div');
        toast.className = `toast toast-${type}`;
        toast.textContent = message;

        document.body.appendChild(toast);

        // Trigger a reflow to enable the transition
        toast.offsetHeight;

        // Add visible class to trigger animation
        toast.classList.add('visible');

        setTimeout(() => {
            toast.classList.remove('visible');
            setTimeout(() => toast.remove(), 300);
        }, 3000);
    }

    function showSuccess(message) {
        showToast(message, 'success');
    }

    function showError(message) {
        showToast(message, 'error');
    }

    // Add CSS styles for toast notifications
    const style = document.createElement('style');
    style.textContent = `
        .toast {
            position: fixed;
            bottom: 20px;
            right: 20px;
            padding: 12px 24px;
            border-radius: 4px;
            color: white;
            font-weight: 500;
            opacity: 0;
            transform: translateY(100%);
            transition: all 0.3s ease;
            z-index: 1000;
        }

        .toast.visible {
            opacity: 1;
            transform: translateY(0);
        }

        .toast-success {
            background: #1dbf73;
        }

        .toast-error {
            background: #ff4d4d;
        }

        .toast-info {
            background: #4a73e8;
        }

        .contact-modal {
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: rgba(0, 0, 0, 0.5);
            display: flex;
            align-items: center;
            justify-content: center;
            z-index: 1000;
        }

        .modal-content {
            background: white;
            border-radius: 8px;
            width: 90%;
            max-width: 500px;
            padding: 24px;
        }

        .modal-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 16px;
        }

        .close-modal {
            background: none;
            border: none;
            font-size: 20px;
            cursor: pointer;
            color: #62646a;
        }

        .modal-body textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #e4e5e7;
            border-radius: 4px;
            resize: vertical;
            min-height: 120px;
        }

        .modal-footer {
            display: flex;
            justify-content: flex-end;
            gap: 12px;
            margin-top: 16px;
        }
    `;
    document.head.appendChild(style);
});
