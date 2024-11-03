document.addEventListener("DOMContentLoaded", () => {
    // Profile Dropdown Functionality
    const profileDropdown = document.getElementById("profileDropdown");
    const dropdownMenu = document.getElementById("dropdownMenu");

    profileDropdown.addEventListener("click", () => {
        dropdownMenu.style.display = dropdownMenu.style.display === "block" ? "none" : "block";
    });

    window.addEventListener("click", (event) => {
        if (!profileDropdown.contains(event.target) && !dropdownMenu.contains(event.target)) {
            dropdownMenu.style.display = "none";
        }
    });
});

const packages = {
    basic: {
        price: 49,
        delivery: 3,
        features: [
            "1 page design",
            "Responsive design",
            "Source files",
            "2 revisions"
        ]
    },
    standard: {
        price: 99,
        delivery: 5,
        features: [
            "3 page designs",
            "Responsive design",
            "Source files",
            "5 revisions",
            "Interactive prototypes"
        ]
    },
    premium: {
        price: 199,
        delivery: 7,
        features: [
            "5 page designs",
            "Responsive design",
            "Source files",
            "Unlimited revisions",
            "Interactive prototypes",
            "Priority support",
            "Design system"
        ]
    }
};

function switchPackage(packageType) {
    // Update active tab
    document.querySelectorAll('.pricing-tab').forEach(tab => {
        tab.classList.remove('active');
    });
    event.target.classList.add('active');

    // Update package content
    const package = packages[packageType];
    const content = document.querySelector('.pricing-content');

    content.innerHTML = `
                <div class="price">$${package.price}</div>
                <div class="delivery-time">
                    <svg width="16" height="16" viewBox="0 0 16 16" fill="#62646a">
                        <path d="M8 0C3.6 0 0 3.6 0 8s3.6 8 8 8 8-3.6 8-8-3.6-8-8-8zm0 14c-3.3 0-6-2.7-6-6s2.7-6 6-6 6 2.7 6 6-2.7 6-6 6z"/>
                        <path d="M9 4H7v5h5V7H9V4z"/>
                    </svg>
                    ${package.delivery} days delivery
                </div>
                <ul class="features">
                    ${package.features.map(feature => `<li>${feature}</li>`).join('')}
                </ul>
                <button class="order-button">Continue ($${package.price})</button>
            `;
}