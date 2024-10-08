package com.dao.interfaces;

import com.model.Notification;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationDao {
    /**
     * Creates a new notification in the database.
     * Purpose: To store a new notification for a user.
     * Use cases:
     * - System generating a notification for a new order
     * - Alerting a user about a new message
     *
     * @param notification The Notification object containing the notification details
     * @return The created Notification object with the generated ID
     * @throws Exception If there's an error during the database operation
     */
    Notification create(Notification notification) throws Exception;

    /**
     * Retrieves a notification by its ID.
     * Purpose: To fetch details of a specific notification.
     * Use cases:
     * - Displaying a particular notification
     * - Fetching notification details for processing
     *
     * @param id The unique identifier of the notification
     * @return The Notification object if found, null otherwise
     * @throws Exception If there's an error during the database operation
     */
    Notification findById(int id) throws Exception;

    /**
     * Retrieves all notifications for a specific user.
     * Purpose: To get all notifications associated with a particular user.
     * Use cases:
     * - Displaying notifications in a user's dashboard
     * - Fetching user's notification history
     *
     * @param userId The ID of the user
     * @return A List of Notification objects for the specified user
     * @throws Exception If there's an error during the database operation
     */
    List<Notification> findByUserId(int userId) throws Exception;

    /**
     * Updates an existing notification's information.
     * Purpose: To modify the content or status of a notification.
     * Use cases:
     * - Marking a notification as read
     * - Updating notification content
     *
     * @param notification The Notification object with updated information
     * @return The updated Notification object
     * @throws Exception If there's an error during the database operation
     */
    Notification update(Notification notification) throws Exception;

    /**
     * Deletes a notification from the database.
     * Purpose: To remove a notification from the system.
     * Use cases:
     * - User deleting a notification
     * - System cleaning up old notifications
     *
     * @param id The unique identifier of the notification to be deleted
     * @throws Exception If there's an error during the database operation
     */
    void delete(int id) throws Exception;

    /**
     * Marks a notification as read.
     * Purpose: To update the read status of a notification.
     * Use cases:
     * - User viewing a notification
     * - Marking all notifications as read
     *
     * @param notificationId The ID of the notification to mark as read
     * @throws Exception If there's an error during the database operation
     */
    void markAsRead(int notificationId) throws Exception;

    /**
     * Counts the number of unread notifications for a user.
     * Purpose: To determine how many new notifications a user has.
     * Use cases:
     * - Displaying unread notification count in the UI
     * - Determining if a user needs to be alerted about new notifications
     *
     * @param userId The ID of the user
     * @return The number of unread notifications for the specified user
     * @throws Exception If there's an error during the database operation
     */
    int countUnreadNotifications(int userId) throws Exception;

    /**
     * Retrieves recent notifications for a user.
     * Purpose: To get the latest notifications a user has received.
     * Use cases:
     * - Displaying recent notifications in a user's dashboard
     * - Implementing a notification center feature
     *
     * @param userId The ID of the user
     * @param limit  The maximum number of recent notifications to retrieve
     * @return A List of the most recent Notification objects for the specified user
     * @throws Exception If there's an error during the database operation
     */
    List<Notification> findRecentNotifications(int userId, int limit) throws Exception;

    /**
     * Retrieves notifications by type for a user.
     * Purpose: To get notifications of a specific type for a user.
     * Use cases:
     * - Filtering notifications by category (e.g., order updates, messages)
     * - Implementing notification preferences
     *
     * @param userId The ID of the user
     * @param type   The type of notifications to retrieve
     * @return A List of Notification objects of the specified type for the user
     * @throws Exception If there's an error during the database operation
     */
    List<Notification> findByType(int userId, String type) throws Exception;

    /**
     * Deletes old notifications for a user.
     * Purpose: To clean up old or irrelevant notifications.
     * Use cases:
     * - Periodic cleanup of notification history
     * - Implementing a "clear all" feature for notifications
     *
     * @param userId     The ID of the user
     * @param beforeDate Delete notifications created before this date
     * @throws Exception If there's an error during the database operation
     */
    void deleteOldNotifications(int userId, LocalDateTime beforeDate) throws Exception;

    /**
     * Marks all notifications as read for a user.
     * Purpose: To update the read status of all notifications for a user.
     * Use cases:
     * - Implementing a "mark all as read" feature
     * - Clearing notification indicators
     *
     * @param userId The ID of the user
     * @throws Exception If there's an error during the database operation
     */
    void markAllAsRead(int userId) throws Exception;
}