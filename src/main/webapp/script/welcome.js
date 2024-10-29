document.addEventListener("DOMContentLoaded", () => {
    const username = "John Doe"; // Simulate database username retrieval
    document.getElementById("username").innerText = username;

    // Populate gigs data (simulate fetching from the database)
    const gigs = [
        { title: "Logo Design", price: "$50", seller: "Seller1", imageUrl: "https://via.placeholder.com/250" },
        { title: "Web Development", price: "$200", seller: "Seller2", imageUrl: "https://via.placeholder.com/250" },
        { title: "SEO Services", price: "$100", seller: "Seller3", imageUrl: "https://via.placeholder.com/250" },
        // Add more gig data as needed
    ];

    const gigsGrid = document.getElementById("gigsGrid");
    gigs.forEach(gig => {
        const gigCard = document.createElement("div");
        gigCard.className = "gig-card";
        gigCard.innerHTML = `
            <img src="${gig.imageUrl}" alt="${gig.title}" class="gig-image">
            <div class="gig-info">
                <div class="seller-info">
                    <img src="https://via.placeholder.com/32" alt="Seller" class="seller-avatar">
                    <span class="seller-level">Level 2 Seller</span>
                </div>
                <h3 class="gig-title">${gig.title}</h3>
                <span class="gig-price">${gig.price}</span>
            </div>
        `;
        gigsGrid.appendChild(gigCard);
    });

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

// Function to handle navigation of gigs
function navigateGigs(direction) {
    // Implement functionality to fetch or display gigs based on navigation
    console.log(direction);
}
