package com.dao.interfaces;

import com.model.Message;

import java.util.List;

public interface MessageDao {
    /**
     * Creates a new message in the database.
     * Purpose: To store a new message sent between users.
     * Use cases:
     * - User sending a message to another user
     * - System generating an automatic message
     *
     * @param message The Message object containing the message details
     * @return The created Message object with the generated ID
     * @throws Exception If there's an error during the database operation
     */
    Message create(Message message) throws Exception;

    /**
     * Retrieves a message by its ID.
     * Purpose: To fetch details of a specific message.
     * Use cases:
     * - Displaying a particular message
     * - Fetching message details for moderation
     *
     * @param id The unique identifier of the message
     * @return The Message object if found, null otherwise
     * @throws Exception If there's an error during the database operation
     */
    Message findById(int id) throws Exception;

    /**
     * Retrieves all messages sent by a specific user.
     * Purpose: To get all messages a user has sent.
     * Use cases:
     * - Displaying sent messages in a user's inbox
     * - Auditing user communication
     *
     * @param senderId The ID of the sender
     * @return A List of Message objects sent by the specified user
     * @throws Exception If there's an error during the database operation
     */
    List<Message> findBySenderId(int senderId) throws Exception;

    /**
     * Retrieves all messages received by a specific user.
     * Purpose: To get all messages a user has received.
     * Use cases:
     * - Displaying received messages in a user's inbox
     * - Checking for new messages
     *
     * @param receiverId The ID of the receiver
     * @return A List of Message objects received by the specified user
     * @throws Exception If there's an error during the database operation
     */
    List<Message> findByReceiverId(int receiverId) throws Exception;

    /**
     * Retrieves the conversation between two users.
     * Purpose: To get the message history between two specific users.
     * Use cases:
     * - Displaying a chat thread between a buyer and a seller
     * - Loading previous messages when opening a conversation
     *
     * @param user1Id The ID of the first user
     * @param user2Id The ID of the second user
     * @return A List of Message objects exchanged between the two users, sorted by timestamp
     * @throws Exception If there's an error during the database operation
     */
    List<Message> findConversation(int user1Id, int user2Id) throws Exception;

    /**
     * Updates an existing message's information.
     * Purpose: To modify the content or status of a message.
     * Use cases:
     * - Marking a message as read
     * - Editing a message (if allowed)
     *
     * @param message The Message object with updated information
     * @return The updated Message object
     * @throws Exception If there's an error during the database operation
     */
    Message update(Message message) throws Exception;

    /**
     * Deletes a message from the database.
     * Purpose: To remove a message from the system.
     * Use cases:
     * - User deleting a message from their inbox
     * - Admin removing inappropriate messages
     *
     * @param id The unique identifier of the message to be deleted
     * @throws Exception If there's an error during the database operation
     */
    void delete(int id) throws Exception;

    /**
     * Marks a message as read.
     * Purpose: To update the read status of a message.
     * Use cases:
     * - Marking messages as read when opened by the receiver
     * - Updating message status in real-time chat
     *
     * @param messageId The ID of the message to mark as read
     * @throws Exception If there's an error during the database operation
     */
    void markAsRead(int messageId) throws Exception;

    /**
     * Counts the number of unread messages for a user.
     * Purpose: To determine how many new messages a user has.
     * Use cases:
     * - Displaying unread message count in the UI
     * - Sending notifications about new messages
     *
     * @param userId The ID of the user
     * @return The number of unread messages for the specified user
     * @throws Exception If there's an error during the database operation
     */
    int countUnreadMessages(int userId) throws Exception;

    /**
     * Retrieves recent messages for a user.
     * Purpose: To get the latest messages a user has received.
     * Use cases:
     * - Displaying recent messages in a user's dashboard
     * - Implementing a "recent conversations" feature
     *
     * @param userId The ID of the user
     * @param limit  The maximum number of recent messages to retrieve
     * @return A List of the most recent Message objects for the specified user
     * @throws Exception If there's an error during the database operation
     */
    List<Message> findRecentMessages(int userId, int limit) throws Exception;

    /**
     * Searches for messages containing specific keywords.
     * Purpose: To find messages based on their content.
     * Use cases:
     * - Implementing a search function in the messaging system
     * - Finding specific information in message history
     *
     * @param userId   The ID of the user performing the search
     * @param keywords The search terms to look for in messages
     * @return A List of Message objects that contain the specified keywords
     * @throws Exception If there's an error during the database operation
     */
    List<Message> searchMessages(int userId, String keywords) throws Exception;
}