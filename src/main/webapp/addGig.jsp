<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Gig</title>
    <link rel="stylesheet" href="css/addGig.css">
</head>

<body>
<div class="add">
    <div class="container">
        <h1>Add New Gig</h1>
        <div class="sections">
            <div class="left">
                <label for="title">Gig Title</label>
                <input type="text" id="title" placeholder="e.g. I will design your website" required>

                <label for="cat">Category</label>
                <select id="cat" required>
                    <option value="">Select a Category</option>
                    <option value="1">Design</option>
                    <option value="2">Web Development</option>
                    <option value="3">Animation</option>
                    <option value="4">Music</option>
                </select>

                <!-- Cover Image Upload -->
                <label for="coverImage">Cover Image</label>
                <div class="upload-box" id="coverImageBox">
                    <img src="https://via.placeholder.com/80" alt="Upload Icon" class="upload-icon">
                    <p>Drag & drop a Photo or <span>Browse</span></p>
                    <input type="file" id="coverImage" accept="image/*" hidden>
                </div>

                <!-- Multiple Images Upload -->
                <label for="gigImages">Upload Images</label>
                <div class="upload-box" id="gigImagesBox">
                    <img src="https://via.placeholder.com/80" alt="Upload Icon" class="upload-icon">
                    <p>Drag & drop Photos or <span>Browse</span></p>
                    <input type="file" id="gigImages" accept="image/*" multiple hidden>
                </div>

                <label for="description">Description</label>
                <textarea id="description" cols="30" rows="6" placeholder="Introduce your service"
                          required></textarea>

                <label for="deliveryTime">Delivery Time (Days)</label>
                <input type="number" id="deliveryTime" min="1" required>

                <button id="createGig">Create Gig</button>
            </div>

            <div class="right">
                <h3>Pricing Tiers</h3>
                <div class="tier">
                    <label>Tier Name</label>
                    <select class="tierName">
                        <option value="basic">Basic</option>
                        <option value="standard">Standard</option>
                        <option value="premium">Premium</option>
                    </select>

                    <label>Price</label>
                    <input type="number" class="price" placeholder="Enter price" required>

                    <label>Description</label>
                    <textarea class="tierDescription" cols="30" rows="4"
                              placeholder="Brief description of this tier" required></textarea>
                </div>

                <label>Add Additional Features</label>
                <form class="add-feature-form">
                    <input type="text" id="featureInput" placeholder="e.g. Custom logo design">
                    <button type="submit">+ Add</button>
                </form>

                <div class="addedFeatures"></div>
            </div>
        </div>
    </div>
</div>

<script>
    const featureForm = document.querySelector('.add-feature-form');
    const featureInput = document.getElementById('featureInput');
    const addedFeatures = document.querySelector('.addedFeatures');
    const createGigButton = document.getElementById('createGig');

    // Add feature functionality
    featureForm.addEventListener('submit', function (e) {
        e.preventDefault();
        const feature = featureInput.value.trim();
        if (feature) {
            const div = document.createElement('div');
            div.className = 'feature-item';
            div.innerHTML = `${feature} <button class="remove-feature">Remove</button>`;
            addedFeatures.appendChild(div);
            featureInput.value = '';
        }
    });

    // Remove feature functionality
    addedFeatures.addEventListener('click', function (e) {
        if (e.target.classList.contains('remove-feature')) {
            e.target.parentElement.remove();
        }
    });

    const coverImageBox = document.getElementById('coverImageBox');
    const coverImageInput = document.getElementById('coverImage');
    const gigImagesBox = document.getElementById('gigImagesBox');
    const gigImagesInput = document.getElementById('gigImages');

    // Helper function to preview image inside the upload box
    function previewImage(file, container) {
        const reader = new FileReader();
        reader.onload = function (e) {
            container.innerHTML = ''; // Clear previous content
            const img = document.createElement('img');
            img.src = e.target.result;
            img.className = 'preview-image'; // Add CSS class for styling
            container.appendChild(img);
        };
        reader.readAsDataURL(file);
    }

    // Cover image file upload handler
    coverImageInput.addEventListener('change', (e) => {
        const file = e.target.files[0];
        if (file) {
            previewImage(file, coverImageBox);
        }
    });

    // Multiple images upload handler
    gigImagesInput.addEventListener('change', (e) => {
        gigImagesBox.innerHTML = ''; // Clear previous previews
        Array.from(e.target.files).forEach(file => {
            const div = document.createElement('div');
            div.style.marginBottom = '10px';
            div.style.overflow = 'hidden'; // Ensure images stay within their containers
            div.style.height = '80px'; // Set height for better layout
            previewImage(file, div);
            gigImagesBox.appendChild(div);
        });
    });

    // Open file dialogs on box click
    coverImageBox.addEventListener('click', () => coverImageInput.click());
    gigImagesBox.addEventListener('click', () => gigImagesInput.click());

    // Prevent default behavior for dragover and drop
    ['dragover', 'drop'].forEach(eventName => {
        coverImageBox.addEventListener(eventName, (e) => e.preventDefault());
        gigImagesBox.addEventListener(eventName, (e) => e.preventDefault());
    });

    // Create gig button validation and redirect
    createGigButton.addEventListener('click', function () {
        const title = document.getElementById('title').value.trim();
        const category = document.getElementById('cat').value;
        const description = document.getElementById('description').value.trim();
        const deliveryTime = document.getElementById('deliveryTime').value.trim();
        const coverImage = coverImageInput.files[0];

        if (!title || !category || !description || !deliveryTime || !coverImage) {
            alert("Please fill out all fields before creating the gig.");
            return;
        }
        window.location.href = 'myGigs.html';
    });
</script>
</body>

</html>
