package com.dao.interfaces;

import com.model.GigPrice;

import java.math.BigDecimal;
import java.util.List;

public interface GigPriceDao {
    /**
     * Creates a new gig price entry in the database.
     * Purpose: To add a new pricing tier for a specific gig.
     * Use cases:
     * - Seller adding a new pricing option to their gig
     * - System creating default pricing tiers for a new gig
     * @param gigPrice The GigPrice object containing the price details
     * @return The created GigPrice object with the generated ID
     * @throws Exception If there's an error during the database operation
     */
    GigPrice create(GigPrice gigPrice) throws Exception;

    /**
     * Retrieves a gig price by its ID.
     * Purpose: To fetch details of a specific pricing tier.
     * Use cases:
     * - Displaying price details on a gig page
     * - Retrieving price information when processing an order
     * @param id The unique identifier of the gig price
     * @return The GigPrice object if found, null otherwise
     * @throws Exception If there's an error during the database operation
     */
    GigPrice findById(int id) throws Exception;

    /**
     * Retrieves all price tiers for a specific gig.
     * Purpose: To get all pricing options available for a particular gig.
     * Use cases:
     * - Displaying all pricing tiers on a gig's page
     * - Allowing a buyer to choose between different pricing options
     * @param gigId The ID of the gig
     * @return A List of GigPrice objects associated with the gig
     * @throws Exception If there's an error during the database operation
     */
    List<GigPrice> findByGigId(int gigId) throws Exception;

    /**
     * Updates an existing gig price entry.
     * Purpose: To modify the details of an existing pricing tier.
     * Use cases:
     * - Seller updating the price or description of a tier
     * - Admin adjusting pricing details
     * @param gigPrice The GigPrice object with updated information
     * @return The updated GigPrice object
     * @throws Exception If there's an error during the database operation
     */
    GigPrice update(GigPrice gigPrice) throws Exception;

    /**
     * Deletes a gig price entry from the database.
     * Purpose: To remove a pricing tier from a gig.
     * Use cases:
     * - Seller removing a pricing option from their gig
     * - Admin deleting an inappropriate pricing tier
     * @param id The unique identifier of the gig price to be deleted
     * @throws Exception If there's an error during the database operation
     */
    void delete(int id) throws Exception;

    /**
     * Finds the base (lowest) price for a gig.
     * Purpose: To retrieve the minimum price offered for a gig.
     * Use cases:
     * - Displaying the starting price in gig listings
     * - Sorting gigs by their base price
     * @param gigId The ID of the gig
     * @return The lowest GigPrice object for the specified gig
     * @throws Exception If there's an error during the database operation
     */
    GigPrice findBasePrice(int gigId) throws Exception;

    /**
     * Retrieves all gig prices within a specific price range.
     * Purpose: To find gigs that fall within a certain budget.
     * Use cases:
     * - Filtering gigs based on user's budget
     * - Generating reports on gigs within certain price brackets
     * @param minPrice The minimum price
     * @param maxPrice The maximum price
     * @return A List of GigPrice objects within the specified price range
     * @throws Exception If there's an error during the database operation
     */
    List<GigPrice> findByPriceRange(double minPrice, double maxPrice) throws Exception;

    /**
     * Checks if a gig has multiple pricing tiers.
     * Purpose: To determine if a gig offers different pricing options.
     * Use cases:
     * - Displaying a "multiple options" badge on gig listings
     * - Filtering gigs that offer package deals
     * @param gigId The ID of the gig
     * @return true if the gig has more than one pricing tier, false otherwise
     * @throws Exception If there's an error during the database operation
     */
    boolean hasMultipleTiers(int gigId) throws Exception;

    /**
     * Retrieves the most expensive pricing tier for a gig.
     * Purpose: To find the highest-priced option for a gig.
     * Use cases:
     * - Displaying price range on gig listings (e.g., "$5 - $100")
     * - Analyzing highest-value offerings across the platform
     * @param gigId The ID of the gig
     * @return The GigPrice object with the highest price for the specified gig
     * @throws Exception If there's an error during the database operation
     */
    GigPrice findHighestTier(int gigId) throws Exception;
}
