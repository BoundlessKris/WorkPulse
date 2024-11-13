document.addEventListener('DOMContentLoaded', function() {
    // Forms
    const resetForm = document.getElementById('resetForm');
    const newPasswordForm = document.getElementById('newPasswordForm');

    // Buttons
    const resendButton = document.getElementById('resendButton');
    const togglePasswordBtns = document.querySelectorAll('.toggle-password');

    // Initialize event listeners
    initializeEventListeners();

    function initializeEventListeners() {
        // Reset Form Submit
        resetForm?.addEventListener('submit', handleResetSubmit);

        // New Password Form Submit
        newPasswordForm?.addEventListener('submit', handleNewPasswordSubmit);

        // Resend Button
        resendButton?.addEventListener('click', handleResend);

        // Password Toggle Buttons
        togglePasswordBtns.forEach(btn => {
            btn.addEventListener('click', handlePasswordToggle);
        });

        // Password Strength Meter
        const newPasswordInput = document.getElementById('newPassword');
        newPasswordInput?.addEventListener('input', checkPasswordStrength);
    }

    function handleResetSubmit(e) {
        e.preventDefault();
        const email = document.getElementById('email').value;

        if (!validateEmail(email)) {
            showError('emailError', 'Please enter a valid email address');
            return;
        }

        // Here you would typically make an API call to your backend
        // For demo, we'll just show the confirmation screen
        document.getElementById('sentEmailAddress').textContent = email;
        goToStep(2);
    }

    function handleNewPasswordSubmit(e) {
        e.preventDefault();
        const newPassword = document.getElementById('newPassword').value;
        const confirmPassword = document.getElementById('confirmPassword').value;

        if (!validatePassword(newPassword)) {
            showError('passwordError', 'Password must be at least 8 characters long');
            return;
        }

        if (newPassword !== confirmPassword) {
            showError('passwordError', 'Passwords do not match');
            return;
        }

        // Here you would typically make an API call to your backend
        // For demo, we'll just show the success screen
        goToStep(4);
    }

    function handleResend() {
        if (resendButton.disabled) return;

        resendButton.disabled = true;
        startCountdown();

        // Here you would typically make an API call to resend the email
        // For demo, we'll just show a message
        alert('Reset link has been resent to your email');
    }

    function handlePasswordToggle(e) {
        const button = e.currentTarget;
        const input = button.parentElement.querySelector('input');
        const icon = button.querySelector('i');

        if (input.type === 'password') {
            input.type = 'text';
            icon.classList.remove('fa-eye');
            icon.classList.add('fa-eye-slash');
        } else {
            input.type = 'password';
            icon.classList.remove('fa-eye-slash');
            icon.classList.add('fa-eye');
        }
    }

    function checkPasswordStrength(e) {
        const password = e.target.value;
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

    function startCountdown() {
        const countdownElement = document.getElementById('countdown');
        const countdownWrapper = document.querySelector('.countdown');
        let timeLeft = 60;

        countdownWrapper.classList.remove('hidden');

        const interval = setInterval(() => {
            timeLeft--;
            countdownElement.textContent = timeLeft;

            if (timeLeft <= 0) {
                clearInterval(interval);
                resendButton.disabled = false;
                countdownWrapper.classList.add('hidden');
            }
        }, 1000);
    }

    function goToStep(step) {
        // Hide all steps
        document.querySelectorAll('.auth-box').forEach(box => {
            box.classList.add('hidden');
        });

        // Show requested step
        document.getElementById(`step${step}`).classList.remove('hidden');
    }

    function validateEmail(email) {
        return /^[^\s@]+@}[^\s@]+\.[^\s@]+$/.test(email);
    }});
