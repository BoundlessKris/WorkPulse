package com.dao.interfaces;

import com.model.BuyerRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface BuyerRequestDao {
    /**
     * Creates a new buyer request in the database.
     * Purpose: To store a new request from a buyer for a custom service.
     * Use cases:
     * - Buyer posting a new request for a service
     * - System creating a request based on user input
     *
     * @param request The BuyerRequest object containing the request details
     * @return The created BuyerRequest object with the generated ID
     * @throws Exception If there's an error during the database operation
     */
    BuyerRequest create(BuyerRequest request) throws Exception;

    /**
     * Retrieves a buyer request by its ID.
     * Purpose: To fetch details of a specific buyer request.
     * Use cases:
     * - Displaying a particular request's details
     * - Fetching request information for editing or responding
     *
     * @param id The unique identifier of the buyer request
     * @return The BuyerRequest object if found, null otherwise
     * @throws Exception If there's an error during the database operation
     */
    BuyerRequest findById(int id) throws Exception;

    /**
     * Retrieves all buyer requests created by a specific buyer.
     * Purpose: To get all requests associated with a particular buyer.
     * Use cases:
     * - Displaying a buyer's request history
     * - Allowing buyers to manage their active requests
     *
     * @param buyerId The ID of the buyer
     * @return A List of BuyerRequest objects created by the specified buyer
     * @throws Exception If there's an error during the database operation
     */
    List<BuyerRequest> findByBuyerId(int buyerId) throws Exception;

    /**
     * Updates an existing buyer request's information.
     * Purpose: To modify the details of a buyer request.
     * Use cases:
     * - Buyer editing their request
     * - Updating request status (e.g., open, closed, assigned)
     *
     * @param request The BuyerRequest object with updated information
     * @return The updated BuyerRequest object
     * @throws Exception If there's an error during the database operation
     */
    BuyerRequest update(BuyerRequest request) throws Exception;

    /**
     * Deletes a buyer request from the database.
     * Purpose: To remove a buyer request from the system.
     * Use cases:
     * - Buyer cancelling their request
     * - Admin removing inappropriate requests
     *
     * @param id The unique identifier of the buyer request to be deleted
     * @throws Exception If there's an error during the database operation
     */
    void delete(int id) throws Exception;

    /**
     * Retrieves all active buyer requests.
     * Purpose: To get a list of all currently open and valid requests.
     * Use cases:
     * - Displaying available requests to sellers
     * - Generating reports on active requests
     *
     * @return A List of active BuyerRequest objects
     * @throws Exception If there's an error during the database operation
     */
    List<BuyerRequest> findActive() throws Exception;

    /**
     * Finds buyer requests by category.
     * Purpose: To retrieve requests within a specific service category.
     * Use cases:
     * - Filtering requests by category for sellers
     * - Analyzing popular request categories
     *
     * @param categoryId The ID of the category
     * @return A List of BuyerRequest objects in the specified category
     * @throws Exception If there's an error during the database operation
     */
    List<BuyerRequest> findByCategory(int categoryId) throws Exception;

    /**
     * Searches for buyer requests based on keywords.
     * Purpose: To find requests that match given search terms.
     * Use cases:
     * - Implementing a search function for buyer requests
     * - Helping sellers find relevant requests
     *
     * @param keywords The search terms to look for in requests
     * @return A List of BuyerRequest objects that match the search criteria
     * @throws Exception If there's an error during the database operation
     */
    List<BuyerRequest> searchByKeywords(String keywords) throws Exception;

    /**
     * Counts the number of offers made for a buyer request.
     * Purpose: To determine how many sellers have responded to a request.
     * Use cases:
     * - Displaying offer count on request listings
     * - Helping buyers gauge interest in their requests
     *
     * @param requestId The ID of the buyer request
     * @return The number of offers made for the specified request
     * @throws Exception If there's an error during the database operation
     */
    int countOffersForRequest(int requestId) throws Exception;

    /**
     * Retrieves buyer requests that are expiring soon.
     * Purpose: To get a list of requests nearing their expiration date.
     * Use cases:
     * - Notifying buyers about soon-to-expire requests
     * - Highlighting urgent requests to sellers
     *
     * @param withinHours Retrieve requests expiring within this many hours
     * @return A List of BuyerRequest objects expiring soon
     * @throws Exception If there's an error during the database operation
     */
    List<BuyerRequest> findExpiringSoon(int withinHours) throws Exception;

    /**
     * Updates the status of expired buyer requests.
     * Purpose: To mark requests as expired once they pass their deadline.
     * Use cases:
     * - Automatic cleanup of expired requests
     * - Maintaining accuracy of available requests
     *
     * @param currentTime The current time to compare against expiration times
     * @return The number of requests marked as expired
     * @throws Exception If there's an error during the database operation
     */
    int markExpiredRequests(LocalDateTime currentTime) throws Exception;
}