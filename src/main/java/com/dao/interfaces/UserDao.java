package com.dao.interfaces;

import com.model.User;

import java.util.List;

public interface UserDao {
    /**
     * Creates a new user in the database.
     * Purpose: To insert a new user record into the database.
     * Use cases:
     * - User registration process
     * - Admin creating a new user account
     *
     * @param user The User object containing the user's information
     * @return The created User object with the generated ID
     * @throws Exception If there's an error during the database operation
     */
    User create(User user) throws Exception;

    /**
     * Retrieves a user by their ID.
     * Purpose: To fetch a specific user's details using their unique identifier.
     * Use cases:
     * - Displaying user profile information
     * - Verifying user existence before performing operations
     *
     * @param id The unique identifier of the user
     * @return The User object if found, null otherwise
     * @throws Exception If there's an error during the database operation
     */
    User findById(int id) throws Exception;

    /**
     * Retrieves all users from the database.
     * Purpose: To get a list of all users in the system.
     * Use cases:
     * - Displaying a list of users in an admin panel
     * - Generating site-wide statistics
     *
     * @return A List of all User objects in the database
     * @throws Exception If there's an error during the database operation
     */
    List<User> findAll() throws Exception;

    /**
     * Updates an existing user's information.
     * Purpose: To modify the details of a user already in the database.
     * Use cases:
     * - User editing their own profile
     * - Admin modifying a user's details
     *
     * @param user The User object with updated information
     * @return The updated User object
     * @throws Exception If there's an error during the database operation
     */
    User update(User user) throws Exception;

    /**
     * Deletes a user from the database.
     * Purpose: To remove a user's record from the system.
     * Use cases:
     * - User requesting account deletion
     * - Admin removing a problematic user
     *
     * @param id The unique identifier of the user to be deleted
     * @throws Exception If there's an error during the database operation
     */
    void delete(int id) throws Exception;

    /**
     * Finds a user by their username.
     * Purpose: To retrieve a user's information using their username.
     * Use cases:
     * - User login process
     * - Checking username availability during registration
     *
     * @param username The username to search for
     * @return The User object if found, null otherwise
     * @throws Exception If there's an error during the database operation
     */
    User findByUsername(String username) throws Exception;

    /**
     * Finds a user by their email address.
     * Purpose: To retrieve a user's information using their email.
     * Use cases:
     * - Password reset functionality
     * - Email verification process
     *
     * @param email The email address to search for
     * @return The User object if found, null otherwise
     * @throws Exception If there's an error during the database operation
     */
    User findByEmail(String email) throws Exception;

    /**
     * Retrieves all users with a specific seller level.
     * Purpose: To get a list of users based on their seller status.
     * Use cases:
     * - Displaying top-rated sellers
     * - Filtering sellers by their experience level
     *
     * @param sellerLevel The seller level to filter by
     * @return A List of User objects with the specified seller level
     * @throws Exception If there's an error during the database operation
     */
    List<User> findBySellerlevel(String sellerLevel) throws Exception;

    /**
     * Checks if a username is available (not already taken).
     * Purpose: To verify the uniqueness of a username.
     * Use cases:
     * - Real-time username availability check during registration
     * - Suggesting alternative usernames if the chosen one is taken
     *
     * @param username The username to check
     * @return true if the username is available, false otherwise
     * @throws Exception If there's an error during the database operation
     */
    boolean isUsernameAvailable(String username) throws Exception;

    /**
     * Checks if an email address is available (not already registered).
     * Purpose: To verify the uniqueness of an email address.
     * Use cases:
     * - Ensuring email uniqueness during user registration
     * - Preventing creation of duplicate accounts
     *
     * @param email The email address to check
     * @return true if the email is available, false otherwise
     * @throws Exception If there's an error during the database operation
     */
    boolean isEmailAvailable(String email) throws Exception;


    /**
     * Retrieves all users of a specific user type.
     * Purpose: To fetch users based on their role in the system.
     * Use cases:
     * - Filtering users by their role (buyer, seller, admin)
     * - Generating role-specific reports or statistics
     * - Implementing role-based features or notifications
     *
     * @param userType The type of user to retrieve (e.g., "buyer", "seller", "admin")
     * @return A List of User objects matching the specified user type
     * @throws Exception If there's an error during the database operation
     */
    List<User> findByUserType(String userType) throws Exception;

    /**
     * Counts the total number of users in the system.
     * Purpose: To get the overall count of users for statistical purposes.
     * Use cases:
     * - Displaying total user count on admin dashboards
     * - Tracking user growth over time
     * - Implementing pagination for user lists
     *
     * @return The total number of users in the database
     * @throws Exception If there's an error during the database operation
     */
    int getTotalCount() throws Exception;

    /**
     * Searches for users based on a keyword.
     * Purpose: To find users whose details match a given search term.
     * Use cases:
     * - Implementing a search functionality in user management interfaces
     * - Finding users by partial username, email, or other profile information
     * - Auto-suggesting users in various parts of the application
     *
     * @param keyword The search term to match against user details
     * @return A List of User objects that match the search criteria
     * @throws Exception If there's an error during the database operation
     */
    List<User> searchByKeyword(String keyword) throws Exception;
}
