document.addEventListener('DOMContentLoaded', function() {
    let currentStep = 1;
    const totalSteps = 5;
    const formData = new FormData();

    // Initialize all components
    initializeNavigation();
    initializeFormValidation();
    initializeTitleCounter();
    initializeCategorySelects();
    initializeTagsInput();
    initializePackages();
    initializeFeatures();
    initializeRequirements();
    initializeFAQs();
    initializeImageUploader();
    initializeVideoUploader();

    // Step Navigation
    function initializeNavigation() {
        const nextBtn = document.querySelector('.next-btn');
        const backBtn = document.querySelector('.back-btn');
        const publishBtn = document.querySelector('.publish-btn');

        nextBtn?.addEventListener('click', () => {
            if (validateCurrentStep()) {
                saveCurrentStep();
                goToStep(currentStep + 1);
            }
        });

        backBtn?.addEventListener('click', () => {
            goToStep(currentStep - 1);
        });

        publishBtn?.addEventListener('click', publishGig);
    }

    function goToStep(step) {
        // Hide current step
        document.querySelector(`#step${currentStep}`).classList.remove('active');

        // Show new step
        document.querySelector(`#step${step}`).classList.add('active');

        // Update progress
        updateProgress(step);

        // Update navigation buttons
        updateNavigationButtons(step);

        currentStep = step;
    }

    function updateProgress(step) {
        // Update progress bar
        const progressFill = document.querySelector('.progress-fill');
        progressFill.style.width = `${(step / totalSteps) * 100}%`;

        // Update step indicators
        document.querySelectorAll('.progress-step').forEach((stepEl, index) => {
            if (index + 1 < step) {
                stepEl.classList.add('completed');
                stepEl.classList.remove('active');
            } else if (index + 1 === step) {
                stepEl.classList.add('active');
                stepEl.classList.remove('completed');
            } else {
                stepEl.classList.remove('active', 'completed');
            }
        });
    }

    function updateNavigationButtons(step) {
        const backBtn = document.querySelector('.back-btn');
        const nextBtn = document.querySelector('.next-btn');
        const publishBtn = document.querySelector('.publish-btn');

        // Show/hide back button
        backBtn.style.display = step === 1 ? 'none' : 'flex';

        // Show/hide next and publish buttons
        if (step === totalSteps) {
            nextBtn.style.display = 'none';
            publishBtn.style.display = 'flex';
        } else {
            nextBtn.style.display = 'flex';
            publishBtn.style.display = 'none';
        }
    }

    // Form Validation
    function validateCurrentStep() {
        const currentForm = document.querySelector(`#step${currentStep} form`);
        if (!currentForm) return true;

        const requiredFields = currentForm.querySelectorAll('[required]');
        let isValid = true;

        requiredFields.forEach(field => {
            if (!field.value.trim()) {
                isValid = false;
                showError(field, 'This field is required');
            } else {
                removeError(field);
            }
        });

        // Step-specific validation
        switch(currentStep) {
            case 1:
                isValid = isValid && validateOverview();
                break;
            case 2:
                isValid = isValid && validatePricing();
                break;
            case 3:
                isValid = isValid && validateDescription();
                break;
            case 4:
                isValid = isValid && validateGallery();
                break;
        }

        return isValid;
    }

    function showError(field, message) {
        removeError(field);
        const errorDiv = document.createElement('div');
        errorDiv.className = 'field-error';
        errorDiv.textContent = message;
        field.parentNode.appendChild(errorDiv);
        field.classList.add('error');
    }

    function removeError(field) {
        const existingError = field.parentNode.querySelector('.field-error');
        if (existingError) {
            existingError.remove();
        }
        field.classList.remove('error');
    }

    // Title Counter
    function initializeTitleCounter() {
        const titleInput = document.getElementById('gigTitle');
        const counter = titleInput?.parentNode.querySelector('.char-count');

        if (titleInput && counter) {
            titleInput.addEventListener('input', () => {
                const remaining = titleInput.maxLength - titleInput.value.length;
                counter.textContent = `${titleInput.value.length}/${titleInput.maxLength}`;

                if (remaining < 10) {
                    counter.classList.add('warning');
                } else {
                    counter.classList.remove('warning');
                }
            });
        }
    }

    // Category Selection
    function initializeCategorySelects() {
        const categorySelect = document.getElementById('category');
        const subcategorySelect = document.getElementById('subcategory');

        if (categorySelect && subcategorySelect) {
            categorySelect.addEventListener('change', async () => {
                const categoryId = categorySelect.value;
                if (!categoryId) {
                    subcategorySelect.disabled = true;
                    subcategorySelect.innerHTML = '<option value="">Select Subcategory</option>';
                    return;
                }

                try {
                    const response = await fetch(`/api/categories/${categoryId}/subcategories`);
                    const subcategories = await response.json();

                    subcategorySelect.innerHTML = `
                        <option value="">Select Subcategory</option>
                        ${subcategories.map(sub => `
                            <option value="${sub.id}">${sub.name}</option>
                        `).join('')}
                    `;
                    subcategorySelect.disabled = false;
                } catch (error) {
                    console.error('Error fetching subcategories:', error);
                    showToast('Error loading subcategories. Please try again.');
                }
            });
        }
    }

    // Tags Input
    function initializeTagsInput() {
        const tagInput = document.getElementById('tagInput');
        const tagsList = document.querySelector('.tags-list');
        const tags = new Set();
        const MAX_TAGS = 5;

        if (tagInput && tagsList) {
            tagInput.addEventListener('keydown', (e) => {
                if (e.key === 'Enter' || e.key === ',') {
                    e.preventDefault();
                    const tag = tagInput.value.trim().toLowerCase();

                    if (tag && tags.size < MAX_TAGS) {
                        tags.add(tag);
                        renderTags();
                        tagInput.value = '';
                    }
                }
            });
        }

        function renderTags() {
            tagsList.innerHTML = Array.from(tags).map(tag => `
                <div class="tag">
                    ${tag}
                    <button type="button" onclick="removeTag('${tag}')">
                        <i class="fas fa-times"></i>
                    </button>
                </div>
            `).join('');
        }

        window.removeTag = function(tag) {
            tags.delete(tag);
            renderTags();
        };
    }

    // Packages Management
    function initializePackages() {
        const packageTabs = document.querySelectorAll('.package-tab');
        const packages = {
            basic: { title: '', description: '', price: '', delivery: '', revisions: '', features: [] },
            standard: { title: '', description: '', price: '', delivery: '', revisions: '', features: [] },
            premium: { title: '', description: '', price: '', delivery: '', revisions: '', features: [] }
        };

        packageTabs.forEach(tab => {
            tab.addEventListener('click', () => {
                // Save current package data
                savePackageData(packages[currentPackage]);

                // Switch to new package
                packageTabs.forEach(t => t.classList.remove('active'));
                tab.classList.add('active');
                currentPackage = tab.dataset.package;

                // Load new package data
                loadPackageData(packages[currentPackage]);
            });
        });

        function savePackageData(package) {
            const form = document.getElementById('pricingForm');
            package.title = form.querySelector('[name="packageTitle"]').value;
            package.description = form.querySelector('[name="packageDescription"]').value;
            package.price = form.querySelector('[name="price"]').value;
            package.delivery = form.querySelector('[name="deliveryTime"]').value;
            package.revisions = form.querySelector('[name="revisions"]').value;
            package.features = Array.from(form.querySelectorAll('.feature-item'))
                .map(item => item.textContent.trim());
        }

        function loadPackageData(package) {
            const form = document.getElementById('pricingForm');
            form.querySelector('[name="packageTitle"]').value = package.title;
            form.querySelector('[name="packageDescription"]').value = package.description;
            form.querySelector('[name="price"]').value = package.price;
            form.querySelector('[name="deliveryTime"]').value = package.delivery;
            form.querySelector('[name="revisions"]').value = package.revisions;

            const featuresList = form.querySelector('.features-items');
            featuresList.innerHTML = package.features.map(feature => `
                <div class="feature-item">
                    <i class="fas fa-check"></i>
                    ${feature}
                    <button type="button" class="remove-feature">
                        <i class="fas fa-times"></i>
                    </button>
                </div>
            `).join('');
        }
    }

    // Features Management
    function initializeFeatures() {
        const addFeatureBtn = document.querySelector('.add-feature');
        const featureInput = document.querySelector('.feature-input input');
        const featuresItems = document.querySelector('.features-items');

        if (addFeatureBtn && featureInput && featuresItems) {
            addFeatureBtn.addEventListener('click', () => {
                const feature = featureInput.value.trim();
                if (feature) {
                    addFeature(feature);
                    featureInput.value = '';
                }
            });
        }

        function addFeature(feature) {
            const featureElement = document.createElement('div');
            featureElement.className = 'feature-item';
            featureElement.innerHTML = `
                <i class="fas fa-check"></i>
                ${feature}
                <button type="button" class="remove-feature">
                    <i class="fas fa-times"></i>
                </button>
            `;

            featureElement.querySelector('.remove-feature').addEventListener('click', () => {
                featureElement.remove();
            });

            featuresItems.appendChild(featureElement);
        }
    }

    // Requirements Management
    function initializeRequirements() {
        const addRequirementBtn = document.querySelector('.add-requirement');
        const requirementInput = document.querySelector('.requirement-input input');
        const requirementsItems = document.querySelector('.requirements-items');

        if (addRequirementBtn && requirementInput && requirementsItems) {
            addRequirementBtn.addEventListener('click', () => {
                const requirement = requirementInput.value.trim();
                if (requirement) {
                    addRequirement(requirement);
                    requirementInput.value = '';
                }
            });
        }

        function addRequirement(requirement) {
            const requirementElement = document.createElement('div');
            requirementElement.className = 'requirement-item';
            requirementElement.innerHTML = `
                ${requirement}
                <button type="button" class="remove-requirement">
                    <i class="fas fa-times"></i>
                </button>
            `;

            requirementElement.querySelector('.remove-requirement').addEventListener('click', () => {
                requirementElement.remove();
            });

            requirementsItems.appendChild(requirementElement);
        }
    }

    // FAQs Management
    function initializeFAQs() {
        const addFAQBtn = document.querySelector('.add-faq');
        const faqsList = document.querySelector('.faqs-list');

        if (addFAQBtn && faqsList) {
            addFAQBtn.addEventListener('click', () => {
                addFAQ();
            });
        }

        function addFAQ() {
            const faqElement = document.createElement('div');
            faqElement.className = 'faq-item';
            faqElement.innerHTML = `
                <div class="faq-header">
                    <input type="text" placeholder="Question" class="faq-question">
                    <button type="button" class="remove-faq">
                        <i class="fas fa-times"></i>
                    </button>
                </div>
                <textarea placeholder="Answer" class="faq-answer"></textarea>
            `;

            faqElement.querySelector('.remove-faq').addEventListener('click', () => {
                faqElement.remove();
            });

            faqsList.insertBefore(faqElement, addFAQBtn);
        }
    }

    // Image Uploader
    function initializeImageUploader() {
        const imageUploader = document.getElementById('imageUploader');
        const uploadedImages = document.querySelector('.uploaded-images');
        const MAX_IMAGES = 3;
        let uploadedFiles = [];

        if (imageUploader && uploadedImages) {
            imageUploader.addEventListener('click', () => {
                if (uploadedFiles.length < MAX_IMAGES) {
                    const input = imageUploader.querySelector('input');
                    input.click();
                } else {
                    showToast(`Maximum ${MAX_IMAGES} images allowed`);
                }
            });

            imageUploader.addEventListener('dragover', (e) => {
                e.preventDefault();
                imageUploader.classList.add('dragover');
            });

            imageUploader.addEventListener('dragleave', () => {
                imageUploader.classList.remove('dragover');
            });

            imageUploader.addEventListener('drop', (e) => {
                e.preventDefault();
                imageUploader.classList.remove('dragover');
                const files = e.dataTransfer.files;
                handleImageFiles(files);
            });

            const input = imageUploader.querySelector('input');
            input.addEventListener('change', (e) => {
                handleImageFiles(e.target.files);
                input.value = ''; // Reset input
            });
        }

        function handleImageFiles(files) {
            Array.from(files).forEach(file => {
                if (uploadedFiles.length >= MAX_IMAGES) {
                    showToast(`Maximum ${MAX_IMAGES} images allowed`);
                    return;
                }

                if (!file.type.startsWith('image/')) {
                    showToast('Only image files are allowed');
                    return;
                }

                const reader = new FileReader();
                reader.onload = (e) => {
                    uploadedFiles.push(file);
                    addImagePreview(e.target.result, uploadedFiles.length - 1);
                };
                reader.readAsDataURL(file);
            });
        }

        function addImagePreview(src, index) {
            const preview = document.createElement('div');
            preview.className = 'uploaded-image';
            preview.innerHTML = `
                <img src="${src}" alt="Uploaded Image">
                <button type="button" class="remove-image" data-index="${index}">
                    <i class="fas fa-times"></i>
                </button>
            `;

            preview.querySelector('.remove-image').addEventListener('click', () => {
                uploadedFiles.splice(index, 1);
                renderImages();
            });

            uploadedImages.appendChild(preview);
        }

        function renderImages() {
            uploadedImages.innerHTML = '';
            uploadedFiles.forEach((file, index) => {
                const reader = new FileReader();
                reader.onload = (e) => {
                    addImagePreview(e.target.result, index);
                };
                reader.readAsDataURL(file);
            });
        }
    }

    // Video Uploader
    function initializeVideoUploader() {
        const videoUploader = document.getElementById('videoUploader');
        const uploadedVideo = document.querySelector('.uploaded-video');
        let uploadedVideoFile = null;

        if (videoUploader && uploadedVideo) {
            videoUploader.addEventListener('click', () => {
                if (!uploadedVideoFile) {
                    const input = videoUploader.querySelector('input');
                    input.click();
                }
            });

            const input = videoUploader.querySelector('input');
            input.addEventListener('change', (e) => {
                handleVideoFile(e.target.files[0]);
                input.value = ''; // Reset input
            });
        }

        function handleVideoFile(file) {
            if (!file.type.startsWith('video/')) {
                showToast('Only video files are allowed');
                return;
            }

            if (file.size > 100 * 1024 * 1024) { // 100MB limit
                showToast('Video size should be less than 100MB');
                return;
            }

            uploadedVideoFile = file;
            addVideoPreview(file);
        }

        function addVideoPreview(file) {
            const preview = document.createElement('div');
            preview.className = 'video-preview';
            preview.innerHTML = `
                <video controls>
                    <source src="${URL.createObjectURL(file)}" type="${file.type}">
                </video>
                <button type="button" class="remove-video">
                    <i class="fas fa-times"></i>
                </button>
                <div class="video-info">
                    <span>${file.name}</span>
                    <span>${formatFileSize(file.size)}</span>
                </div>
            `;

            preview.querySelector('.remove-video').addEventListener('click', () => {
                uploadedVideoFile = null;
                uploadedVideo.innerHTML = '';
            });

            uploadedVideo.innerHTML = '';
            uploadedVideo.appendChild(preview);
        }
    }

    // Save Step Data
    function saveCurrentStep() {
        switch(currentStep) {
            case 1:
                saveOverviewData();
                break;
            case 2:
                savePricingData();
                break;
            case 3:
                saveDescriptionData();
                break;
            case 4:
                saveGalleryData();
                break;
        }
    }

    function saveOverviewData() {
        const form = document.getElementById('overviewForm');
        formData.set('title', form.querySelector('#gigTitle').value);
        formData.set('category', form.querySelector('#category').value);
        formData.set('subcategory', form.querySelector('#subcategory').value);
        formData.set('serviceType', form.querySelector('input[name="serviceType"]:checked').value);

        // Save tags
        const tags = Array.from(document.querySelectorAll('.tag'))
            .map(tag => tag.textContent.trim());
        formData.set('tags', JSON.stringify(tags));
    }

    function savePricingData() {
        const packages = ['basic', 'standard', 'premium'].reduce((acc, type) => {
            acc[type] = {
                title: document.querySelector(`[data-package="${type}"] [name="packageTitle"]`).value,
                description: document.querySelector(`[data-package="${type}"] [name="packageDescription"]`).value,
                price: document.querySelector(`[data-package="${type}"] [name="price"]`).value,
                deliveryTime: document.querySelector(`[data-package="${type}"] [name="deliveryTime"]`).value,
                revisions: document.querySelector(`[data-package="${type}"] [name="revisions"]`).value,
                features: Array.from(document.querySelectorAll(`[data-package="${type}"] .feature-item`))
                    .map(item => item.textContent.trim())
            };
            return acc;
        }, {});

        formData.set('packages', JSON.stringify(packages));
    }

    function saveDescriptionData() {
        const form = document.getElementById('descriptionForm');
        formData.set('description', form.querySelector('#gigDescription').value);

        // Save requirements
        const requirements = Array.from(document.querySelectorAll('.requirement-item'))
            .map(item => item.textContent.trim());
        formData.set('requirements', JSON.stringify(requirements));

        // Save FAQs
        const faqs = Array.from(document.querySelectorAll('.faq-item')).map(item => ({
            question: item.querySelector('.faq-question').value,
            answer: item.querySelector('.faq-answer').value
        }));
        formData.set('faqs', JSON.stringify(faqs));
    }

    function saveGalleryData() {
        // Images are already in uploadedFiles array
        const imageFormData = new FormData();
        uploadedFiles.forEach((file, index) => {
            imageFormData.append(`image${index + 1}`, file);
        });

        if (uploadedVideoFile) {
            imageFormData.append('video', uploadedVideoFile);
        }

        // Merge with main formData
        for (let [key, value] of imageFormData.entries()) {
            formData.set(key, value);
        }
    }

    // Publish Gig
    async function publishGig() {
        try {
            showLoading();

            const response = await fetch('/api/gigs/create', {
                method: 'POST',
                body: formData
            });

            if (!response.ok) {
                throw new Error('Failed to create gig');
            }

            const data = await response.json();

            showSuccess('Gig published successfully!');

            // Redirect to the new gig page after short delay
            setTimeout(() => {
                window.location.href = `/gig/${data.gigId}`;
            }, 2000);

        } catch (error) {
            console.error('Error publishing gig:', error);
            showError('Failed to publish gig. Please try again.');
        } finally {
            hideLoading();
        }
    }

    // Utility Functions
    function formatFileSize(bytes) {
        if (bytes < 1024) return bytes + ' B';
        else if (bytes < 1048576) return (bytes / 1024).toFixed(1) + ' KB';
        else return (bytes / 1048576).toFixed(1) + ' MB';
    }

    function showLoading() {
        // Implement loading overlay
        const overlay = document.createElement('div');
        overlay.className = 'loading-overlay';
        overlay.innerHTML = `
            <div class="loading-spinner"></div>
            <span>Publishing your gig...</span>
        `;
        document.body.appendChild(overlay);
    }

    function hideLoading() {
        const overlay = document.querySelector('.loading-overlay');
        if (overlay) {
            overlay.remove();
        }
    }

    function showToast(message, type = 'info') {
        const toast = document.createElement('div');
        toast.className = `toast toast-${type}`;
        toast.textContent = message;
        document.body.appendChild(toast);

        setTimeout(() => {
            toast.remove();
        }, 3000);
    }

    function showSuccess(message) {
        showToast(message, 'success');
    }

    function showError(message) {
        showToast(message, 'error');
    }
});
