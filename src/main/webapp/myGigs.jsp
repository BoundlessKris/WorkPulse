<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Gigs</title>
    <link rel="stylesheet" href="css/myGigs.css">
</head>

<body>
<div class="my-gigs">
    <div class="container">
        <div class="header">
            <h1>My Gigs</h1>
            <button id="createNewGig">+ Create New Gig</button>
        </div>

        <table>
            <thead>
            <tr>
                <th>Cover Image</th>
                <th>Gig Title</th>
                <th>Category</th>
                <th>Description</th>
                <th>Delivery Time (Days)</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody id="gigsTableBody">
            <!-- Gigs will be populated here -->
            </tbody>
        </table>

        <div id="noGigsMessage" class="no-gigs">No gigs available.</div>
    </div>
</div>

<script>
    const gigs = [
        {
            coverImage: 'cover1.jpg', // Replace with actual image path from database
            title: "Website Design",
            category: "Design",
            description: "I will design your website.",
            deliveryTime: 3,
            price: 100,
        },
        {
            coverImage: 'cover2.jpg',
            title: "SEO Optimization",
            category: "Web Development",
            description: "I will optimize your website for search engines.",
            deliveryTime: 5,
            price: 150,
        }
    ];

    const gigsTableBody = document.getElementById('gigsTableBody');
    const noGigsMessage = document.getElementById('noGigsMessage');

    function displayGigs() {
        if (gigs.length === 0) {
            noGigsMessage.style.display = 'block';
        } else {
            noGigsMessage.style.display = 'none';
            gigs.forEach((gig, index) => {
                const row = document.createElement('tr');
                row.innerHTML = `
                        <td><img src="${gig.coverImage}" alt="Cover Image" class="cover-img"></td>
                        <td>${gig.title}</td>
                        <td>${gig.category}</td>
                        <td>${gig.description}</td>
                        <td>${gig.deliveryTime}</td>
                        <td>₹${gig.price}</td>
                        <td><button class="delete-gig" data-index="${index}">Delete</button></td>
                    `;
                gigsTableBody.appendChild(row);
            });
        }
    }

    gigsTableBody.addEventListener('click', function (e) {
        if (e.target.classList.contains('delete-gig')) {
            const index = e.target.dataset.index;
            gigs.splice(index, 1);
            gigsTableBody.innerHTML = '';
            displayGigs();
        }
    });

    document.getElementById('createNewGig').addEventListener('click', () => {
        window.location.href = 'addGig.html';
    });

    displayGigs();
</script>
</body>

</html>

