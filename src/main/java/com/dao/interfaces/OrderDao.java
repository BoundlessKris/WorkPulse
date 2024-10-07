package com.dao.interfaces;

import com.model.Order;
import java.util.List;
import java.time.LocalDateTime;

public interface OrderDao {
    /**
     * Creates a new order in the database.
     * Purpose: To record a new order placed by a buyer.
     * Use cases:
     * - Buyer purchasing a gig
     * - System creating an order after successful payment
     * @param order The Order object containing the order details
     * @return The created Order object with the generated ID
     * @throws Exception If there's an error during the database operation
     */
    Order create(Order order) throws Exception;

    /**
     * Retrieves an order by its ID.
     * Purpose: To fetch details of a specific order.
     * Use cases:
     * - Displaying order details to buyer or seller
     * - Processing order status updates
     * @param id The unique identifier of the order
     * @return The Order object if found, null otherwise
     * @throws Exception If there's an error during the database operation
     */
    Order findById(int id) throws Exception;

    /**
     * Retrieves all orders for a specific buyer.
     * Purpose: To get a list of all orders placed by a particular buyer.
     * Use cases:
     * - Displaying order history to a buyer
     * - Generating buyer purchase reports
     * @param buyerId The ID of the buyer
     * @return A List of Order objects associated with the specified buyer
     * @throws Exception If there's an error during the database operation
     */
    List<Order> findByBuyerId(int buyerId) throws Exception;

    /**
     * Retrieves all orders for a specific seller.
     * Purpose: To get a list of all orders received by a particular seller.
     * Use cases:
     * - Displaying incoming orders to a seller
     * - Generating seller earnings reports
     * @param sellerId The ID of the seller
     * @return A List of Order objects associated with the specified seller
     * @throws Exception If there's an error during the database operation
     */
    List<Order> findBySellerId(int sellerId) throws Exception;

    /**
     * Updates an existing order's information.
     * Purpose: To modify the details or status of an order.
     * Use cases:
     * - Updating order status (e.g., from 'in progress' to 'completed')
     * - Adding delivery details to an order
     * @param order The Order object with updated information
     * @return The updated Order object
     * @throws Exception If there's an error during the database operation
     */
    Order update(Order order) throws Exception;

    void delete(int id) throws Exception;

    /**
     * Retrieves orders by their status.
     * Purpose: To get a list of orders with a specific status.
     * Use cases:
     * - Displaying all pending orders to a seller
     * - Generating reports on completed orders
     * @param status The status of the orders to retrieve
     * @return A List of Order objects with the specified status
     * @throws Exception If there's an error during the database operation
     */
    List<Order> findByStatus(String status) throws Exception;

    /**
     * Retrieves orders created within a specific date range.
     * Purpose: To get orders based on their creation date.
     * Use cases:
     * - Generating periodic sales reports
     * - Analyzing order trends over time
     * @param startDate The start date of the range
     * @param endDate The end date of the range
     * @return A List of Order objects created within the specified date range
     * @throws Exception If there's an error during the database operation
     */
    List<Order> findByDateRange(LocalDateTime startDate, LocalDateTime endDate) throws Exception;

    /**
     * Counts the number of orders for a specific gig.
     * Purpose: To determine how many times a gig has been ordered.
     * Use cases:
     * - Displaying order count on gig listings
     * - Calculating gig popularity
     * @param gigId The ID of the gig
     * @return The number of orders for the specified gig
     * @throws Exception If there's an error during the database operation
     */
    int countOrdersForGig(int gigId) throws Exception;

    /**
     * Calculates the total earnings for a seller within a date range.
     * Purpose: To sum up the earnings from all completed orders for a seller.
     * Use cases:
     * - Generating seller earnings reports
     * - Calculating seller payouts
     * @param sellerId The ID of the seller
     * @param startDate The start date of the range
     * @param endDate The end date of the range
     * @return The total earnings for the seller within the specified date range
     * @throws Exception If there's an error during the database operation
     */
    double calculateSellerEarnings(int sellerId, LocalDateTime startDate, LocalDateTime endDate) throws Exception;
}
