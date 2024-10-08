package com.dao.interfaces;

import com.model.Review;

import java.util.List;

public interface ReviewDao {
    /**
     * Creates a new review in the database.
     * Purpose: To add a new review for a completed order.
     * Use cases:
     * - Buyer submitting a review after receiving a service
     * - Seller providing feedback on a buyer (if applicable)
     *
     * @param review The Review object containing the review details
     * @return The created Review object with the generated ID
     * @throws Exception If there's an error during the database operation
     */
    Review create(Review review) throws Exception;

    /**
     * Retrieves a review by its ID.
     * Purpose: To fetch details of a specific review.
     * Use cases:
     * - Displaying a particular review
     * - Fetching review details for editing or moderation
     *
     * @param id The unique identifier of the review
     * @return The Review object if found, null otherwise
     * @throws Exception If there's an error during the database operation
     */
    Review findById(int id) throws Exception;

    /**
     * Retrieves all reviews for a specific order.
     * Purpose: To get all reviews associated with a particular order.
     * Use cases:
     * - Displaying reviews on an order's detail page
     * - Collecting feedback for a specific transaction
     *
     * @param orderId The ID of the order
     * @return A List of Review objects associated with the specified order
     * @throws Exception If there's an error during the database operation
     */
    List<Review> findByOrderId(int orderId) throws Exception;

    /**
     * Retrieves all reviews given by a specific reviewer.
     * Purpose: To get all reviews submitted by a particular user.
     * Use cases:
     * - Displaying a user's review history
     * - Analyzing a user's reviewing patterns
     *
     * @param reviewerId The ID of the reviewer (user who wrote the reviews)
     * @return A List of Review objects written by the specified reviewer
     * @throws Exception If there's an error during the database operation
     */
    List<Review> findByReviewerId(int reviewerId) throws Exception;

    /**
     * Retrieves all reviews for a specific gig.
     * Purpose: To get all reviews associated with a particular gig.
     * Use cases:
     * - Displaying reviews on a gig's detail page
     * - Calculating average rating for a gig
     *
     * @param gigId The ID of the gig
     * @return A List of Review objects associated with the specified gig
     * @throws Exception If there's an error during the database operation
     */
    List<Review> findByGigId(int gigId) throws Exception;

    /**
     * Updates an existing review's information.
     * Purpose: To modify the content or rating of a review.
     * Use cases:
     * - User editing their review
     * - Admin moderating and updating a review
     *
     * @param review The Review object with updated information
     * @return The updated Review object
     * @throws Exception If there's an error during the database operation
     */
    Review update(Review review) throws Exception;

    /**
     * Deletes a review from the database.
     * Purpose: To remove a review from the system.
     * Use cases:
     * - User deleting their own review
     * - Admin removing an inappropriate review
     *
     * @param id The unique identifier of the review to be deleted
     * @throws Exception If there's an error during the database operation
     */
    void delete(int id) throws Exception;

    /**
     * Calculates the average rating for a specific gig.
     * Purpose: To determine the overall rating of a gig based on its reviews.
     * Use cases:
     * - Displaying average rating on gig listings
     * - Sorting gigs by their average rating
     *
     * @param gigId The ID of the gig
     * @return The average rating of the gig
     * @throws Exception If there's an error during the database operation
     */
    double calculateAverageRatingForGig(int gigId) throws Exception;

    /**
     * Counts the number of reviews for a specific gig.
     * Purpose: To determine how many reviews a gig has received.
     * Use cases:
     * - Displaying review count on gig listings
     * - Filtering gigs by number of reviews
     *
     * @param gigId The ID of the gig
     * @return The number of reviews for the specified gig
     * @throws Exception If there's an error during the database operation
     */
    int countReviewsForGig(int gigId) throws Exception;

    /**
     * Retrieves the most recent reviews for a gig.
     * Purpose: To get the latest feedback for a particular gig.
     * Use cases:
     * - Displaying recent reviews on a gig's page
     * - Showing latest feedback in search results
     *
     * @param gigId The ID of the gig
     * @param limit The maximum number of recent reviews to retrieve
     * @return A List of the most recent Review objects for the specified gig
     * @throws Exception If there's an error during the database operation
     */
    List<Review> findMostRecentReviewsForGig(int gigId, int limit) throws Exception;
}