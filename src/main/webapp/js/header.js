document.addEventListener('DOMContentLoaded', function() {
    // Header scroll effect
    window.addEventListener('scroll', function() {
        const header = document.querySelector('.header-top');
        if (window.scrollY > 50) {
            header.classList.add('header-scrolled');
        } else {
            header.classList.remove('header-scrolled');
        }
    });

    // Update message count
    function updateMessageCount() {
        fetch('/api/messages/unread-count')
            .then(response => response.json())
            .then(data => {
                const badge = document.getElementById('messageCount');
                if (data.count > 0) {
                    badge.style.display = 'block';
                    badge.textContent = data.count > 9 ? '9+' : data.count;
                } else {
                    badge.style.display = 'none';
                }
            });
    }

    // If user is logged in, start message count polling
    if (document.querySelector('.profile-pic')) {
        updateMessageCount();
        setInterval(updateMessageCount, 30000); // Update every 30 seconds
    }
});
