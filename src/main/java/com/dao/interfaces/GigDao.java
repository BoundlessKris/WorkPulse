package com.dao.interfaces;

import com.model.Gig;

import java.util.List;

public interface GigDao {
    /**
     * Creates a new gig in the database.
     * Purpose: To insert a new gig listing into the system.
     * Use cases:
     * - Seller creating a new service offering
     * - Admin adding a gig on behalf of a seller
     * @param gig The Gig object containing all the gig details
     * @return The created Gig object with the generated ID
     * @throws Exception If there's an error during the database operation
     */
    Gig create(Gig gig) throws Exception;

    /**
     * Retrieves a gig by its ID.
     * Purpose: To fetch a specific gig's details using its unique identifier.
     * Use cases:
     * - Displaying gig details page
     * - Editing an existing gig
     * @param id The unique identifier of the gig
     * @return The Gig object if found, null otherwise
     * @throws Exception If there's an error during the database operation
     */
    Gig findById(int id) throws Exception;

    /**
     * Retrieves all gigs from the database.
     * Purpose: To get a list of all available gigs in the system.
     * Use cases:
     * - Displaying a list of all gigs on the homepage
     * - Admin viewing all gigs in the system
     * @return A List of all Gig objects in the database
     * @throws Exception If there's an error during the database operation
     */
    List<Gig> findAll() throws Exception;

    /**
     * Updates an existing gig's information.
     * Purpose: To modify the details of a gig already in the database.
     * Use cases:
     * - Seller editing their gig listing
     * - Admin updating gig details
     * @param gig The Gig object with updated information
     * @return The updated Gig object
     * @throws Exception If there's an error during the database operation
     */
    Gig update(Gig gig) throws Exception;

    /**
     * Deletes a gig from the database.
     * Purpose: To remove a gig listing from the system.
     * Use cases:
     * - Seller removing their gig
     * - Admin deleting a non-compliant gig
     * @param id The unique identifier of the gig to be deleted
     * @throws Exception If there's an error during the database operation
     */
    void delete(int id) throws Exception;

    /**
     * Finds all gigs by a specific seller.
     * Purpose: To retrieve all gigs associated with a particular seller.
     * Use cases:
     * - Displaying a seller's profile with all their gigs
     * - Seller viewing all their active listings
     * @param sellerId The unique identifier of the seller
     * @return A List of Gig objects belonging to the specified seller
     * @throws Exception If there's an error during the database operation
     */
    List<Gig> findBySellerId(int sellerId) throws Exception;

    /**
     * Finds gigs by category.
     * Purpose: To retrieve all gigs within a specific category.
     * Use cases:
     * - Displaying gigs when a user browses a particular category
     * - Filtering gigs by category in search results
     * @param categoryId The unique identifier of the category
     * @return A List of Gig objects in the specified category
     * @throws Exception If there's an error during the database operation
     */
    List<Gig> findByCategory(int categoryId) throws Exception;

    /**
     * Searches for gigs based on keywords.
     * Purpose: To find gigs that match given search terms.
     * Use cases:
     * - User searching for gigs using the search bar
     * - Implementing search functionality in the application
     * @param keywords The search terms entered by the user
     * @return A List of Gig objects that match the search criteria
     * @throws Exception If there's an error during the database operation
     */
    List<Gig> searchByKeywords(String keywords) throws Exception;

    /**
     * Retrieves the most popular gigs.
     * Purpose: To get a list of gigs sorted by popularity (e.g., number of orders).
     * Use cases:
     * - Displaying trending or popular gigs on the homepage
     * - Showing recommended gigs to users
     * @param limit The number of top gigs to retrieve
     * @return A List of the most popular Gig objects
     * @throws Exception If there's an error during the database operation
     */
    List<Gig> findMostPopular(int limit) throws Exception;

    /**
     * Finds gigs within a specific price range.
     * Purpose: To retrieve gigs based on their pricing.
     * Use cases:
     * - Filtering gigs by price in search results
     * - Displaying gigs that fit a user's budget
     * @param minPrice The minimum price of the gig
     * @param maxPrice The maximum price of the gig
     * @return A List of Gig objects within the specified price range
     * @throws Exception If there's an error during the database operation
     */
    List<Gig> findByPriceRange(double minPrice, double maxPrice) throws Exception;

    List<Gig> findTopRated(int limit) throws Exception;

    List<Gig> findMostRecent(int limit) throws Exception;
}
