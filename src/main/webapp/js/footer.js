// Language selector functionality
function changeLanguage(lang) {
    // Set language cookie
    document.cookie = `preferredLanguage=${lang}; path=/; max-age=31536000`;

    // Reload page with new language parameter
    const currentUrl = new URL(window.location.href);
    currentUrl.searchParams.set('lang', lang);
    window.location.href = currentUrl.toString();
}

// Add current year to copyright
document.addEventListener('DOMContentLoaded', function() {
    const currentYear = new Date().getFullYear();
    const copyrightElement = document.querySelector('.copyright');
    if (copyrightElement) {
        copyrightElement.innerHTML = copyrightElement.innerHTML.replace('${currentYear}', currentYear);
    }
});
