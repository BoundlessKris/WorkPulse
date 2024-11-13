document.addEventListener('DOMContentLoaded', function() {
    // Elements
    const filterSections = document.querySelectorAll('.filter-section');
    const saveButtons = document.querySelectorAll('.save-button');
    const sortSelect = document.querySelector('.sort-select');
    const priceInputs = document.querySelectorAll('.price-range input');
    const applyPriceButton = document.querySelector('.apply-price');
    const checkboxes = document.querySelectorAll('.checkbox-group input[type="checkbox"]');
    const locationSelect = document.querySelector('.location-select');
    const paginationButtons = document.querySelectorAll('.page-btn');

    // Initialize all event listeners
    initializeEventListeners();

    // Track active filters
    let activeFilters = {
        price: {
            min: null,
            max: null
        },
        delivery: [],
        level: [],
        pro: false,
        location: '',
        sort: 'recommended',
        page: 1
    };

    function initializeEventListeners() {
        // Save button functionality
        saveButtons.forEach(button => {
            button.addEventListener('click', handleSaveClick);
        });

        // Sort select change
        sortSelect?.addEventListener('change', handleSortChange);

        // Price filter
        applyPriceButton?.addEventListener('click', handlePriceFilter);

        // Checkbox filters
        checkboxes.forEach(checkbox => {
            checkbox.addEventListener('change', handleCheckboxFilter);
        });

        // Location select
        locationSelect?.addEventListener('change', handleLocationChange);

        // Pagination
        paginationButtons.forEach(button => {
            button.addEventListener('click', handlePagination);
        });
    }

    function handleSaveClick(e) {
        const button = e.currentTarget;
        const icon = button.querySelector('i');

        button.classList.toggle('saved');
        if (button.classList.contains('saved')) {
            icon.classList.remove('far');
            icon.classList.add('fas');
        } else {
            icon.classList.remove('fas');
            icon.classList.add('far');
        }
    }

    function handleSortChange(e) {
        activeFilters.sort = e.target.value;
        applyFilters();
    }

    function handlePriceFilter() {
        const minInput = priceInputs[0];
        const maxInput = priceInputs[1];

        activeFilters.price.min = minInput.value ? parseInt(minInput.value) : null;
        activeFilters.price.max = maxInput.value ? parseInt(maxInput.value) : null;

        applyFilters();
    }

    function handleCheckboxFilter(e) {
        const checkbox = e.target;
        const filterType = checkbox.name;
        const value = checkbox.value;

        if (filterType === 'pro') {
            activeFilters.pro = checkbox.checked;
        } else {
            if (checkbox.checked) {
                activeFilters[filterType].push(value);
            } else {
                activeFilters[filterType] = activeFilters[filterType].filter(v => v !== value);
            }
        }

        applyFilters();
    }

    function handleLocationChange(e) {
        activeFilters.location = e.target.value;
        applyFilters();
    }

    function handlePagination(e) {
        const button = e.currentTarget;
        if (button.disabled || button.classList.contains('active')) return;

        const page = button.textContent;
        activeFilters.page = parseInt(page);

        updatePaginationUI(activeFilters.page);
        applyFilters();
    }

    function updatePaginationUI(currentPage) {
        paginationButtons.forEach(button => {
            const page = button.textContent;
            button.classList.toggle('active', page === currentPage.toString());
        });
    }

    function applyFilters() {
        // Show loading state
        showLoadingState();

        // Construct query parameters
        const queryParams = new URLSearchParams();

        // Add all active filters to query params
        if (activeFilters.price.min) queryParams.append('min_price', activeFilters.price.min);
        if (activeFilters.price.max) queryParams.append('max_price', activeFilters.price.max);
        if (activeFilters.delivery.length) queryParams.append('delivery', activeFilters.delivery.join(','));
        if (activeFilters.level.length) queryParams.append('level', activeFilters.level.join(','));
        if (activeFilters.pro) queryParams.append('pro', 'true');
        if (activeFilters.location) queryParams.append('location', activeFilters.location);
        queryParams.append('sort', activeFilters.sort);
        queryParams.append('page', activeFilters.page);

        // Update URL with new filters
        const newUrl = `${window.location.pathname}?${queryParams.toString()}`;
        window.history.pushState({}, '', newUrl);

        // Fetch and update results
        fetchFilteredResults(queryParams);
    }

    function showLoadingState() {
        const servicesGrid = document.querySelector('.services-grid');
        servicesGrid.style.opacity = '0.5';
        // Add loading spinner if needed
    }

    function fetchFilteredResults(queryParams) {
        // In real implementation, this would be an API call
        fetch(`/api/services?${queryParams.toString()}`)
            .then(response => response.json())
            .then(data => {
                updateServicesGrid(data.services);
                updatePaginationUI(data.currentPage);
            })
            .catch(error => {
                console.error('Error fetching filtered results:', error);
                // Show error message to user
            })
            .finally(() => {
                // Remove loading state
                const servicesGrid = document.querySelector('.services-grid');
                servicesGrid.style.opacity = '1';
            });
    }

    function updateServicesGrid(services) {
        const servicesGrid = document.querySelector('.services-grid');
        servicesGrid.innerHTML = '';

        services.forEach(service => {
            const serviceCard = createServiceCard(service);
            servicesGrid.appendChild(serviceCard);
        });
    }

    function createServiceCard(service) {
        const card = document.createElement('div');
        card.className = 'service-card';

        card.innerHTML = `
            <div class="service-image">
                <img src="${service.thumbnail}" alt="${service.title}">
                <button class="save-button ${service.isSaved ? 'saved' : ''}">
                    <i class="${service.isSaved ? 'fas' : 'far'} fa-heart"></i>
                </button>
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

        // Add event listeners to the new card
        const saveButton = card.querySelector('.save-button');
        saveButton.addEventListener('click', handleSaveClick);

        return card;
    }

    // Mobile Filters Functionality
    const mobileFilterBtn = document.createElement('button');
    mobileFilterBtn.className = 'mobile-filter-btn';
    mobileFilterBtn.innerHTML = '<i class="fas fa-filter"></i> Filters';

    function initializeMobileFilters() {
        if (window.innerWidth <= 768) {
            const topBar = document.querySelector('.services-top-bar');
            topBar.insertBefore(mobileFilterBtn, topBar.firstChild);

            mobileFilterBtn.addEventListener('click', toggleMobileFilters);
        }
    }

    function toggleMobileFilters() {
        const filtersSidebar = document.querySelector('.filters-sidebar');
        filtersSidebar.classList.toggle('active');

        if (filtersSidebar.classList.contains('active')) {
            // Create and add close button
            const closeBtn = document.createElement('button');
            closeBtn.className = 'mobile-filters-close';
            closeBtn.innerHTML = '<i class="fas fa-times"></i>';
            filtersSidebar.insertBefore(closeBtn, filtersSidebar.firstChild);

            closeBtn.addEventListener('click', () => {
                filtersSidebar.classList.remove('active');
                closeBtn.remove();
            });

            // Prevent body scrolling
            document.body.style.overflow = 'hidden';
        } else {
            // Re-enable body scrolling
            document.body.style.overflow = '';
        }
    }

    // Price Range Input Validation
    function initializePriceInputs() {
        const [minInput, maxInput] = priceInputs;

        minInput.addEventListener('input', () => {
            if (maxInput.value && parseInt(minInput.value) > parseInt(maxInput.value)) {
                minInput.value = maxInput.value;
            }
        });

        maxInput.addEventListener('input', () => {
            if (minInput.value && parseInt(maxInput.value) < parseInt(minInput.value)) {
                maxInput.value = minInput.value;
            }
        });
    }

    // Infinite Scroll Implementation
    let isLoading = false;
    let hasMoreItems = true;

    function initializeInfiniteScroll() {
        window.addEventListener('scroll', () => {
            if (isLoading || !hasMoreItems) return;

            const { scrollTop, scrollHeight, clientHeight } = document.documentElement;
            if (scrollTop + clientHeight >= scrollHeight - 800) { // 800px before bottom
                loadMoreItems();
            }
        });
    }

    function loadMoreItems() {
        isLoading = true;
        activeFilters.page += 1;

        // Show loading indicator
        const loadingIndicator = document.createElement('div');
        loadingIndicator.className = 'loading-indicator';
        loadingIndicator.innerHTML = `
            <div class="spinner"></div>
            <span>Loading more services...</span>
        `;
        document.querySelector('.services-grid').appendChild(loadingIndicator);

        // Fetch more items
        const queryParams = new URLSearchParams(window.location.search);
        queryParams.set('page', activeFilters.page);

        fetch(`/api/services?${queryParams.toString()}`)
            .then(response => response.json())
            .then(data => {
                loadingIndicator.remove();

                if (data.services.length === 0) {
                    hasMoreItems = false;
                    showNoMoreItems();
                    return;
                }

                data.services.forEach(service => {
                    const serviceCard = createServiceCard(service);
                    document.querySelector('.services-grid').appendChild(serviceCard);
                });
            })
            .catch(error => {
                console.error('Error loading more items:', error);
                loadingIndicator.innerHTML = 'Error loading more items. Please try again.';
            })
            .finally(() => {
                isLoading = false;
            });
    }

    function showNoMoreItems() {
        const endMessage = document.createElement('div');
        endMessage.className = 'end-message';
        endMessage.innerHTML = `
            <div class="end-message-content">
                <i class="fas fa-check-circle"></i>
                <p>You've seen all services in this category!</p>
            </div>
        `;
        document.querySelector('.services-grid').appendChild(endMessage);
    }

    // URL Parameter Handling
    function initializeFromURL() {
        const params = new URLSearchParams(window.location.search);

        // Set price filters
        if (params.has('min_price')) {
            priceInputs[0].value = params.get('min_price');
            activeFilters.price.min = parseInt(params.get('min_price'));
        }
        if (params.has('max_price')) {
            priceInputs[1].value = params.get('max_price');
            activeFilters.price.max = parseInt(params.get('max_price'));
        }

        // Set delivery time filters
        if (params.has('delivery')) {
            const delivery = params.get('delivery').split(',');
            delivery.forEach(value => {
                const checkbox = document.querySelector(`input[name="delivery"][value="${value}"]`);
                if (checkbox) {
                    checkbox.checked = true;
                    activeFilters.delivery.push(value);
                }
            });
        }

        // Set seller level filters
        if (params.has('level')) {
            const levels = params.get('level').split(',');
            levels.forEach(value => {
                const checkbox = document.querySelector(`input[name="level"][value="${value}"]`);
                if (checkbox) {
                    checkbox.checked = true;
                    activeFilters.level.push(value);
                }
            });
        }

        // Set pro services filter
        if (params.has('pro')) {
            const proCheckbox = document.querySelector('input[name="pro"]');
            if (proCheckbox) {
                proCheckbox.checked = true;
                activeFilters.pro = true;
            }
        }

        // Set location filter
        if (params.has('location')) {
            locationSelect.value = params.get('location');
            activeFilters.location = params.get('location');
        }

        // Set sort option
        if (params.has('sort')) {
            sortSelect.value = params.get('sort');
            activeFilters.sort = params.get('sort');
        }

        // Set page number
        if (params.has('page')) {
            activeFilters.page = parseInt(params.get('page'));
            updatePaginationUI(activeFilters.page);
        }
    }

    // Initialize all functionality
    initializeFromURL();
    initializeMobileFilters();
    initializePriceInputs();
    initializeInfiniteScroll();
});
