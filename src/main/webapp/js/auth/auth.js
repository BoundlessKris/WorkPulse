document.addEventListener('DOMContentLoaded', function() {
    // Password visibility toggle
    const togglePassword = document.querySelector('.toggle-password');
    if (togglePassword) {
        togglePassword.addEventListener('click', function() {
            const passwordInput = document.querySelector('#password');
            const icon = this.querySelector('i');

            if (passwordInput.type === 'password') {
                passwordInput.type = 'text';
                icon.classList.remove('fa-eye');
                icon.classList.add('fa-eye-slash');
            } else {
                passwordInput.type = 'password';
                icon.classList.remove('fa-eye-slash');
                icon.classList.add('fa-eye');
            }
        });
    }

    // Form validation
    const loginForm = document.getElementById('loginForm');
    if (loginForm) {
        loginForm.addEventListener('submit', function(e) {
            e.preventDefault();

            const username = document.getElementById('username').value.trim();
            const password = document.getElementById('password').value.trim();

            if (!username || !password) {
                showError('Please fill in all fields');
                return;
            }

            // Submit form if validation passes
            this.submit();
        });
    }

    // Social login handlers
    const googleBtn = document.querySelector('.google-btn');
    if (googleBtn) {
        googleBtn.addEventListener('click', function() {
            // Implement Google OAuth login
            window.location.href = '/auth/google';
        });
    }

    const facebookBtn = document.querySelector('.facebook-btn');
    if (facebookBtn) {
        facebookBtn.addEventListener('click', function() {
            // Implement Facebook OAuth login
            window.location.href = '/auth/facebook';
        });
    }

    // Error message handling
    function showError(message) {
        const errorDiv = document.createElement('div');
        errorDiv.className = 'alert alert-error';
        errorDiv.innerHTML = `
            <i class="fas fa-exclamation-circle"></i>
            ${message}
        `;

        const form = document.querySelector('.auth-form');
        form.insertBefore(errorDiv, form.firstChild);

        // Remove error after 5 seconds
        setTimeout(() => {
            errorDiv.remove();
        }, 5000);
    }

    // Auto-hide alerts after 5 seconds
    const alerts = document.querySelectorAll('.alert');
    alerts.forEach(alert => {
        setTimeout(() => {
            alert.style.opacity = '0';
            setTimeout(() => alert.remove(), 300);
        }, 5000);
    });
});
