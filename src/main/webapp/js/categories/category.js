document.addEventListener('DOMContentLoaded', function() {
    // Initialize all components
    initializeFilters();
    initializeSorting();
    initializeSaveButtons();
    initializePagination();
    initializeMobileFilters();
    initializeScrollDetection();

    // Track active filters state
    let activeFilters = {
        price: {
            min: null,
            max: null
        },
        delivery: [],
        level: [],
        sort: 'recommended',
        page: 1
    };

    // Filters Functionality
    function initializeFilters() {
        // Price Filter
        const applyPriceBtn = document.querySelector('.apply-price');
        if (applyPriceBtn) {
            applyPriceBtn.addEventListener('click', handlePriceFilter);
        }

        // Checkbox Filters
        const checkboxes = document.querySelectorAll('.checkbox-group input[type="checkbox"]');
        checkboxes.forEach(checkbox => {
            checkbox.addEventListener('change', handleCheckboxFilter);
        });

        // Initialize price inputs validation
        const minPrice = document.getElementById('minPrice');
        const maxPrice = document.getElementById('maxPrice');

        if (minPrice && maxPrice) {
            minPrice.addEventListener('input', () => validatePriceRange(minPrice, maxPrice));
            maxPrice.addEventListener('input', () => validatePriceRange(minPrice, maxPrice));
        }
    }

    function validatePriceRange(minInput, maxInput) {
        const min = parseInt(minInput.value) || 0;
        const max = parseInt(maxInput.value) || Infinity;

        if (max < min) {
            maxInput.value = minInput.value;
        }
    }

    function handlePriceFilter() {
        const minPrice = document.getElementById('minPrice');
        const maxPrice = document.getElementById('maxPrice');

        activeFilters.price.min = minPrice.value ? parseInt(minPrice.value) : null;
        activeFilters.price.max = maxPrice.value ? parseInt(maxPrice.value) : null;

        applyFilters();
    }

    function handleCheckboxFilter(e) {
        const checkbox = e.target;
        const filterType = checkbox.name;
        const value = checkbox.value;

        if (checkbox.checked) {
            activeFilters[filterType].push(value);
        } else {
            activeFilters[filterType] = activeFilters[filterType].filter(v => v !== value);
        }

        applyFilters();
    }

    // Sorting Functionality
    function initializeSorting() {
        const sortSelect = document.getElementById('sortSelect');
        if (sortSelect) {
            sortSelect.addEventListener('change', handleSort);
        }
    }

    function handleSort(e) {
        activeFilters.sort = e.target.value;
        applyFilters();
    }

    // Save Button Functionality
    function initializeSaveButtons() {
        const saveButtons = document.querySelectorAll('.save-button');
        saveButtons.forEach(button => {
            button.addEventListener('click', handleSave);
        });
    }

    function handleSave(e) {
        e.preventDefault();
        e.stopPropagation();

        const button = e.currentTarget;
        const icon = button.querySelector('i');
        const serviceId = button.dataset.id;

        button.classList.toggle('saved');

        if (button.classList.contains('saved')) {
            icon.classList.remove('far');
            icon.classList.add('fas');
            saveService(serviceId);
        } else {
            icon.classList.remove('fas');
            icon.classList.add('far');
            unsaveService(serviceId);
        }
    }

    async function saveService(serviceId) {
        try {
            const response = await fetch('/api/services/save', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ serviceId })
            });

            if (!response.ok) {
                throw new Error('Failed to save service');
            }
        } catch (error) {
            console.error('Error saving service:', error);
            // Revert UI change on error
            const button = document.querySelector(`.save-button[data-id="${serviceId}"]`);
            if (button) {
                button.classList.remove('saved');
                const icon = button.querySelector('i');
                icon.classList.remove('fas');
                icon.classList.add('far');
            }
        }
    }

    async function unsaveService(serviceId) {
        try {
            const response = await fetch('/api/services/unsave', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ serviceId })
            });

            if (!response.ok) {
                throw new Error('Failed to unsave service');
            }
        } catch (error) {
            console.error('Error unsaving service:', error);
            // Revert UI change on error
            const button = document.querySelector(`.save-button[data-id="${serviceId}"]`);
            if (button) {
                button.classList.add('saved');
                const icon = button.querySelector('i');
                icon.classList.remove('far');
                icon.classList.add('fas');
            }
        }
    }

    // Mobile Filters Functionality
    function initializeMobileFilters() {
        const filterToggleBtn = document.createElement('button');
        filterToggleBtn.className = 'filter-toggle-btn';
        filterToggleBtn.innerHTML = '<i class="fas fa-filter"></i> Filters';

        const sortControls = document.querySelector('.sort-controls');
        if (sortControls) {
            sortControls.prepend(filterToggleBtn);
        }

        filterToggleBtn.addEventListener('click', toggleMobileFilters);

        // Add close button to mobile filters
        const filtersSidebar = document.querySelector('.filters-sidebar');
        if (filtersSidebar) {
            const closeBtn = document.createElement('button');
            closeBtn.className = 'mobile-filters-close';
            closeBtn.innerHTML = '<i class="fas fa-times"></i>';
            closeBtn.addEventListener('click', closeMobileFilters);
            filtersSidebar.prepend(closeBtn);
        }
    }

    function toggleMobileFilters() {
        const filtersSidebar = document.querySelector('.filters-sidebar');
        if (filtersSidebar) {
            filtersSidebar.classList.toggle('active');
            document.body.style.overflow = filtersSidebar.classList.contains('active') ? 'hidden' : '';
        }
    }

    function closeMobileFilters() {
        const filtersSidebar = document.querySelector('.filters-sidebar');
        if (filtersSidebar) {
            filtersSidebar.classList.remove('active');
            document.body.style.overflow = '';
        }
    }

    // Apply Filters and Update URL
    async function applyFilters() {
        showLoading();

        // Construct query parameters
        const queryParams = new URLSearchParams();

        if (activeFilters.price.min) queryParams.append('min_price', activeFilters.price.min);
        if (activeFilters.price.max) queryParams.append('max_price', activeFilters.price.max);
        if (activeFilters.delivery.length) queryParams.append('delivery', activeFilters.delivery.join(','));
        if (activeFilters.level.length) queryParams.append('level', activeFilters.level.join(','));
        queryParams.append('sort', activeFilters.sort);
        queryParams.append('page', activeFilters.page);

        // Update URL
        const newUrl = `${window.location.pathname}?${queryParams.toString()}`;
        window.history.pushState({}, '', newUrl);

        try {
            // Fetch filtered results
            const response = await fetch(`/api/services/filter?${queryParams.toString()}`);
            if (!response.ok) throw new Error('Failed to fetch filtered results');

            const data = await response.json();
            updateServices(data.services);
            updatePagination(data.pagination);

        } catch (error) {
            console.error('Error applying filters:', error);
            showError('Failed to load services. Please try again.');
        } finally {
            hideLoading();
        }
    }

    function updateServices(services) {
        const servicesGrid = document.querySelector('.services-grid');
        if (!servicesGrid) return;

        servicesGrid.innerHTML = '';

        services.forEach(service => {
            const serviceCard = createServiceCard(service);
            servicesGrid.appendChild(serviceCard);
        });

        // Reinitialize save buttons for new cards
        initializeSaveButtons();
    }

    function createServiceCard(service) {
        const card = document.createElement('div');
        card.className = 'service-card';

        card.innerHTML = `
            <div class="service-image">
                <img src="${service.thumbnailUrl}" alt="${service.title}">
                <button class="save-button ${service.isSaved ? 'saved' : ''}" data-id="${service.id}">
                    <i class="${service.isSaved ? 'fas' : 'far'} fa-heart"></i>
                </button>
            </div>
            <div class="service-info">
                <div class="seller-info">
                    <img src="${service.seller.avatarUrl}" alt="${service.seller.name}">
                    <span class="seller-name">${service.seller.name}</span>
                    <span class="seller-level">${service.seller.level}</span>
                </div>
                <h3 class="service-title">
                    <a href="/service/${service.id}">${service.title}</a>
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

    // Loading State
    function showLoading() {
        const servicesGrid = document.querySelector('.services-grid');
        if (servicesGrid) {
            servicesGrid.style.opacity = '0.5';
            // Add loading spinner if needed
        }
    }

    function hideLoading() {
        const servicesGrid = document.querySelector('.services-grid');
        if (servicesGrid) {
            servicesGrid.style.opacity = '1';
        }
    }

    function showError(message) {
        // Implement error message display
        const errorDiv = document.createElement('div');
        errorDiv.className = 'error-message';
        errorDiv.textContent = message;

        const servicesGrid = document.querySelector('.services-grid');
        if (servicesGrid) {
            servicesGrid.parentNode.insertBefore(errorDiv, servicesGrid);
            setTimeout(() => errorDiv.remove(), 5000);
        }
    }

    // Initialize from URL params
    function initializeFromURL() {
        const params = new URLSearchParams(window.location.search);

        // Set price filters
        if (params.has('min_price')) {
            const minPrice = document.getElementById('minPrice');
            if (minPrice) {
                minPrice.value = params.get('min_price');
                activeFilters.price.min = parseInt(params.get('min_price'));
            }
        }

        if (params.has('max_price')) {
            const maxPrice = document.getElementById('maxPrice');
            if (maxPrice) {
                maxPrice.value = params.get('max_price');
                activeFilters.price.max = parseInt(params.get('max_price'));
            }
        }

        // Set checkbox filters
        ['delivery', 'level'].forEach(filterType => {
            if (params.has(filterType)) {
                const values = params.get(filterType).split(',');
                values.forEach(value => {
                    const checkbox = document.querySelector(`input[name="${filterType}"][value="${value}"]`);
                    if (checkbox) {
                        checkbox.checked = true;
                        activeFilters[filterType].push(value);
                    }
                });
            }
        });

        // Set sort option
        if (params.has('sort')) {
            const sortSelect = document.getElementById('sortSelect');
            if (sortSelect) {
                sortSelect.value = params.get('sort');
                activeFilters.sort = params.get('sort');
            }
        }

        // Set page number
        if (params.has('page')) {
            activeFilters.page = parseInt(params.get('page'));
        }
    }

    // Initialize from URL on load
    initializeFromURL();
});
