document.addEventListener('DOMContentLoaded', function() {
    let currentStep = 1;
    let selectedAccountType = '';

    // DOM Elements
    const form = document.getElementById('registrationForm');
    const accountTypeCards = document.querySelectorAll('.account-type-card');
    const progressSteps = document.querySelectorAll('.progress-step');
    const typeButtons = document.querySelectorAll('.select-type-btn');
    const backButtons = document.querySelectorAll('.back-btn');
    const passwordInput = document.getElementById('password');
    const togglePasswordBtn = document.querySelector('.toggle-password');
    const verificationInputs = document.querySelectorAll('.code-digit');
    const resendButton = document.getElementById('resendCode');
    const countdownElement = document.getElementById('countdown');

    // Initialize event listeners
    initializeEventListeners();

    function initializeEventListeners() {
        // Account type selection
        typeButtons.forEach(button => {
            button.addEventListener('click', function () {
                selectedAccountType = this.dataset.type;
                document.getElementById('selectedType').textContent =
                    selectedAccountType.charAt(0).toUpperCase() + selectedAccountType.slice(1);
                goToStep(2);
            });
        });

        // Account type card selection
        accountTypeCards.forEach(card => {
            card.addEventListener('click', function () {
                accountTypeCards.forEach(c => c.classList.remove('selected'));
                this.classList.add('selected');
                selectedAccountType = this.dataset.type;
            });
        });

        // Back buttons
        backButtons.forEach(button => {
            button.addEventListener('click', function () {
                goToStep(parseInt(this.dataset.step));
            });
        });

        // Password toggle
        togglePasswordBtn.addEventListener('click', function () {
            const type = passwordInput.getAttribute('type');
            passwordInput.setAttribute('type', type === 'password' ? 'text' : 'password');
            this.querySelector('i').classList.toggle('fa-eye');
            this.querySelector('i').classList.toggle('fa-eye-slash');
        });

        // Password strength
        passwordInput.addEventListener('input', checkPasswordStrength);

        // Form submission
        form.addEventListener('submit', handleFormSubmit);

        // Verification code inputs
        verificationInputs.forEach((input, index) => {
            input.addEventListener('input', (e) => handleVerificationInput(e, index));
            input.addEventListener('keydown', (e) => handleVerificationKeydown(e, index));
        });

        // Resend code button
        resendButton.addEventListener('click', handleResendCode);
    }

    function goToStep(step) {
        // Hide all steps
        document.querySelectorAll('.registration-step').forEach(s => {
            s.classList.add('hidden');
        });

        // Show current step
        document.getElementById(`step${step}`).classList.remove('hidden');

        // Update progress indicators
        progressSteps.forEach(s => {
            const stepNum = parseInt(s.dataset.step);
            if (stepNum <= step) {
                s.classList.add('active');
            } else {
                s.classList.remove('active');
            }
        });

        currentStep = step;
    }

    function checkPasswordStrength() {
        const password = passwordInput.value;
        const strengthMeter = document.querySelector('.strength-meter');
        const strengthLabel = document.getElementById('strengthLabel');

        // Define strength criteria
        const hasLower = /[a-z]/.test(password);
        const hasUpper = /[A-Z]/.test(password);
        const hasNumber = /[0-9]/.test(password);
        const hasSpecial = /[!@#$%^&*]/.test(password);
        const isLongEnough = password.length >= 8;

        let strength = 0;
        if (hasLower) strength++;
        if (hasUpper) strength++;
        if (hasNumber) strength++;
        if (hasSpecial) strength++;
        if (isLongEnough) strength++;

        // Update UI
        strengthMeter.classList.remove('weak', 'medium', 'strong');
        if (strength <= 2) {
            strengthMeter.classList.add('weak');
            strengthLabel.textContent = 'Poor';
        } else if (strength <= 4) {
            strengthMeter.classList.add('medium');
            strengthLabel.textContent = 'Medium';
        } else {
            strengthMeter.classList.add('strong');
            strengthLabel.textContent = 'Strong';
        }
    }

    function handleFormSubmit(e) {
        e.preventDefault();

        // Basic form validation
        const requiredFields = form.querySelectorAll('[required]');
        let isValid = true;

        requiredFields.forEach(field => {
            if (!field.value) {
                isValid = false;
                field.classList.add('error');
            } else {
                field.classList.remove('error');
            }
        });

        if (!isValid) {
            return;
        }

        // If valid, proceed to verification step
        const formData = new FormData(form);
        formData.append('accountType', selectedAccountType);

        // Here you would typically send the data to your server
        // For demo, we'll just proceed to verification step
        goToStep(3);
    }

    function handleVerificationInput(e, index) {
        const input = e.target;
        const value = input.value;

        // Allow only numbers
        if (!/^\d*$/.test(value)) {
            input.value = '';
            return;
        }

        if (value && index < verificationInputs.length - 1) {
            verificationInputs[index + 1].focus();
        }

        checkVerificationComplete();
    }

    function handleVerificationKeydown(e, index) {
        if (e.key === 'Backspace' && !e.target.value && index > 0) {
            verificationInputs[index - 1].focus();
        }
    }

    function checkVerificationComplete() {
        const verifyButton = document.getElementById('verifyButton');
        const code = Array.from(verificationInputs)
            .map(input => input.value)
            .join('');

        verifyButton.disabled = code.length !== 6;
    }});
