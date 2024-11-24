document.addEventListener('DOMContentLoaded', function() {
    // Initialize all components
    initializeNavigation();
    initializeAvatarUpload();
    initializeLanguages();
    initializeSkills();
    initializeFormValidation();
    initializeCharacterCounters();

    // Navigation between sections
    function initializeNavigation() {
        const navItems = document.querySelectorAll('.nav-item');

        navItems.forEach(item => {
            item.addEventListener('click', (e) => {
                e.preventDefault();

                // Remove active class from all items
                navItems.forEach(i => i.classList.remove('active'));

                // Add active class to clicked item
                item.classList.add('active');

                // Show corresponding section
                const sectionId = item.getAttribute('href').substring(1);
                showSection(sectionId);
            });
        });
    }

    function showSection(sectionId) {
        // Hide all sections
        document.querySelectorAll('.edit-section').forEach(section => {
            section.classList.add('hidden');
        });

        // Show selected section
        document.getElementById(sectionId).classList.remove('hidden');

        // Update URL hash without scrolling
        history.pushState(null, null, `#${sectionId}`);
    }

    // Avatar Upload
    function initializeAvatarUpload() {
        const uploadBtn = document.querySelector('.upload-btn');
        const avatarInput = document.getElementById('avatarInput');
        const currentAvatar = document.querySelector('.current-avatar img');

        if (uploadBtn && avatarInput) {
            uploadBtn.addEventListener('click', () => {
                avatarInput.click();
            });

            avatarInput.addEventListener('change', function() {
                const file = this.files[0];
                if (file) {
                    if (validateImage(file)) {
                        const reader = new FileReader();
                        reader.onload = function(e) {
                            currentAvatar.src = e.target.result;
                        };
                        reader.readAsDataURL(file);
                    }
                }
            });
        }
    }

    function validateImage(file) {
        // Check file type
        if (!file.type.startsWith('image/')) {
            showError('Please upload an image file');
            return false;
        }

        // Check file size (1MB)
        if (file.size > 1024 * 1024) {
            showError('Image size should be less than 1MB');
            return false;
        }

        return true;
    }

    // Languages Management
    function initializeLanguages() {
        const addLanguageBtn = document.querySelector('.add-language');
        const languagesList = document.querySelector('.languages-list');

        if (addLanguageBtn && languagesList) {
            addLanguageBtn.addEventListener('click', () => {
                addLanguageRow();
            });

            // Initialize remove buttons for existing languages
            document.querySelectorAll('.remove-language').forEach(btn => {
                btn.addEventListener('click', () => {
                    btn.closest('.language-item').remove();
                });
            });
        }
    }

    function addLanguageRow() {
        const languageItem = document.createElement('div');
        languageItem.className = 'language-item';

        // Get language options HTML from existing select
        const languageOptions = document.querySelector('select[name="language[]"]').innerHTML;

        languageItem.innerHTML = `
            <select name="language[]" required>
                ${languageOptions}
            </select>
            <select name="languageLevel[]" required>
                <option value="basic">Basic</option>
                <option value="conversational">Conversational</option>
                <option value="fluent">Fluent</option>
                <option value="native">Native/Bilingual</option>
            </select>
            <button type="button" class="remove-language">
                <i class="fas fa-times"></i>
            </button>
        `;

        languageItem.querySelector('.remove-language').addEventListener('click', () => {
            languageItem.remove();
        });

        document.querySelector('.languages-list').appendChild(languageItem);
    }

    // Skills Management
    function initializeSkills() {
        const skillInput = document.getElementById('skillInput');
        const skillsList = document.querySelector('.skills-list');
        const skills = new Set();
        const MAX_SKILLS = 15;

        if (skillInput && skillsList) {
            // Initialize existing skills
            document.querySelectorAll('.skill-tag').forEach(tag => {
                skills.add(tag.textContent.trim());
            });

            skillInput.addEventListener('keydown', (e) => {
                if (e.key === 'Enter' || e.key === ',') {
                    e.preventDefault();
                    const skill = skillInput.value.trim().toLowerCase();

                    if (skill && skills.size < MAX_SKILLS && !skills.has(skill)) {
                        addSkill(skill);
                        skillInput.value = '';
                    }
                }
            });

            // Initialize remove buttons
            document.querySelectorAll('.remove-skill').forEach(btn => {
                btn.addEventListener('click', () => {
                    const skill = btn.closest('.skill-tag').textContent.trim();
                    removeSkill(skill);
                });
            });
        }

        function addSkill(skill) {
            skills.add(skill);

            const skillTag = document.createElement('span');
            skillTag.className = 'skill-tag';
            skillTag.innerHTML = `
                ${skill}
                <button type="button" class="remove-skill">
                    <i class="fas fa-times"></i>
                </button>
            `;

            skillTag.querySelector('.remove-skill').addEventListener('click', () => {
                removeSkill(skill);
            });

            skillsList.appendChild(skillTag);
        }

        function removeSkill(skill) {
            skills.delete(skill);
            const skillTag = Array.from(skillsList.children)
                .find(tag => tag.textContent.trim() === skill);
            if (skillTag) {
                skillTag.remove();
            }
        }
    }

    // Form Validation and Submission
    function initializeFormValidation() {
        const forms = document.querySelectorAll('.edit-form');

        forms.forEach(form => {
            form.addEventListener('submit', async (e) => {
                e.preventDefault();

                if (validateForm(form)) {
                    await submitForm(form);
                }
            });
        });
    }

    function validateForm(form) {
        const requiredFields = form.querySelectorAll('[required]');
        let isValid = true;

        requiredFields.forEach(field => {
            if (!field.value.trim()) {
                showFieldError(field, 'This field is required');
                isValid = false;
            } else {
                removeFieldError(field);
            }
        });

        // Specific validations based on form type
        if (form.id === 'personalForm') {
            isValid = validatePersonalForm(form) && isValid;
        } else if (form.id === 'professionalForm') {
            isValid = validateProfessionalForm(form) && isValid;
        }

        return isValid;
    }

    function validatePersonalForm(form) {
        let isValid = true;
        const displayName = form.querySelector('#displayName');
        const description = form.querySelector('#description');

        // Display name validation
        if (displayName.value.length < 3) {
            showFieldError(displayName, 'Display name must be at least 3 characters');
            isValid = false;
        }

        // Description validation
        if (description.value.length < 50) {
            showFieldError(description, 'Description must be at least 50 characters');
            isValid = false;
        }

        return isValid;
    }

    function validateProfessionalForm(form) {
        let isValid = true;
        const title = form.querySelector('#title');

        if (title.value.length < 5) {
            showFieldError(title, 'Professional title must be at least 5 characters');
            isValid = false;
        }

        return isValid;
    }

    function showFieldError(field, message) {
        removeFieldError(field);
        const errorDiv = document.createElement('div');
        errorDiv.className = 'field-error';
        errorDiv.textContent = message;
        field.parentNode.appendChild(errorDiv);
        field.classList.add('error');
    }

    function removeFieldError(field) {
        const error = field.parentNode.querySelector('.field-error');
        if (error) {
            error.remove();
        }
        field.classList.remove('error');
    }

    async function submitForm(form) {
        const formId = form.id;
        const formData = new FormData(form);
        let endpoint;

        switch(formId) {
            case 'personalForm':
                endpoint = '/api/profile/personal';
                break;
            case 'professionalForm':
                endpoint = '/api/profile/professional';
                break;
            case 'skillsForm':
                endpoint = '/api/profile/skills';
                break;
            default:
                endpoint = '/api/profile/update';
        }

        try {
            showLoading();

            const response = await fetch(endpoint, {
                method: 'POST',
                body: formData
            });

            if (!response.ok) throw new Error('Failed to update profile');

            showSuccess('Profile updated successfully');

            // If it's avatar update, update the avatar in header
            if (formData.has('avatar')) {
                const data = await response.json();
                updateAvatarDisplay(data.avatarUrl);
            }

        } catch (error) {
            console.error('Error updating profile:', error);
            showError('Failed to update profile. Please try again.');
        } finally {
            hideLoading();
        }
    }

    // Character Counter Management
    function initializeCharacterCounters() {
        const elements = document.querySelectorAll('[maxlength]');
        elements.forEach(element => {
            const counter = element.parentNode.querySelector('.char-count');
            if (counter) {
                updateCharCount(element, counter);
                element.addEventListener('input', () => {
                    updateCharCount(element, counter);
                });
            }
        });
    }

    function updateCharCount(element, counter) {
        const current = element.value.length;
        const max = element.getAttribute('maxlength');
        counter.textContent = `${current}/${max}`;

        if (current >= max - 10) {
            counter.classList.add('warning');
        } else {
            counter.classList.remove('warning');
        }
    }

    // Loading State Management
    function showLoading() {
        const overlay = document.createElement('div');
        overlay.className = 'loading-overlay';
        overlay.innerHTML = `
            <div class="loading-spinner"></div>
            <span>Saving changes...</span>
        `;
        document.body.appendChild(overlay);
    }

    function hideLoading() {
        const overlay = document.querySelector('.loading-overlay');
        if (overlay) {
            overlay.remove();
        }
    }

    // Toast Notifications
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

    // Avatar Management
    function updateAvatarDisplay(newUrl) {
        const avatarImages = document.querySelectorAll('.current-avatar img');
        avatarImages.forEach(img => {
            img.src = newUrl;
        });

        // Also update header avatar if exists
        const headerAvatar = document.querySelector('.header-avatar img');
        if (headerAvatar) {
            headerAvatar.src = newUrl;
        }
    }

    // Handle Page Navigation via URL Hash
    function handleHashChange() {
        const hash = window.location.hash.slice(1) || 'personal';
        const navItem = document.querySelector(`.nav-item[href="#${hash}"]`);
        if (navItem) {
            navItem.click();
        }
    }

    // Initialize hash handling
    window.addEventListener('hashchange', handleHashChange);
    handleHashChange(); // Handle initial hash

    // Add CSS styles for loading and notifications
    const style = document.createElement('style');
    style.textContent = `
        .loading-overlay {
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: rgba(255, 255, 255, 0.8);
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            z-index: 1000;
        }

        .loading-spinner {
            width: 40px;
            height: 40px;
            border: 3px solid #f3f3f3;
            border-top: 3px solid #1dbf73;
            border-radius: 50%;
            animation: spin 1s linear infinite;
            margin-bottom: 16px;
        }

        @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }

        .field-error {
            color: #ff4d4d;
            font-size: 12px;
            margin-top: 4px;
        }

        input.error,
        textarea.error,
        select.error {
            border-color: #ff4d4d;
        }

        .toast {
            position: fixed;
            bottom: 20px;
            right: 20px;
            padding: 12px 24px;
            border-radius: 4px;
            color: white;
            font-weight: 500;
            z-index: 1000;
            animation: slideIn 0.3s ease-out;
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

        @keyframes slideIn {
            from {
                transform: translateY(100%);
                opacity: 0;
            }
            to {
                transform: translateY(0);
                opacity: 1;
            }
        }

        .char-count.warning {
            color: #ff4d4d;
        }
    `;
    document.head.appendChild(style);
});
