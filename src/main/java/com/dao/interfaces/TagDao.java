package com.dao.interfaces;

import com.model.Tag;
import java.util.List;

public interface TagDao {
    /**
     * Creates a new tag in the database.
     * Purpose: To add a new tag for classifying gigs.
     * Use cases:
     * - Seller adding a new tag when creating or editing a gig
     * - Admin creating predefined tags for the system
     * @param tag The Tag object containing the tag details
     * @return The created Tag object with the generated ID
     * @throws Exception If there's an error during the database operation
     */
    Tag create(Tag tag) throws Exception;

    /**
     * Retrieves a tag by its ID.
     * Purpose: To fetch details of a specific tag.
     * Use cases:
     * - Displaying tag information on gig pages
     * - Retrieving tag details for editing purposes
     * @param id The unique identifier of the tag
     * @return The Tag object if found, null otherwise
     * @throws Exception If there's an error during the database operation
     */
    Tag findById(int id) throws Exception;

    /**
     * Retrieves all tags from the database.
     * Purpose: To get a list of all available tags in the system.
     * Use cases:
     * - Populating tag selection interfaces
     * - Displaying a cloud or list of all available tags
     * @return A List of all Tag objects in the database
     * @throws Exception If there's an error during the database operation
     */
    List<Tag> findAll() throws Exception;

    /**
     * Updates an existing tag's information.
     * Purpose: To modify the details of a tag already in the database.
     * Use cases:
     * - Admin editing tag name or description
     * - Correcting misspelled tags
     * @param tag The Tag object with updated information
     * @return The updated Tag object
     * @throws Exception If there's an error during the database operation
     */
    Tag update(Tag tag) throws Exception;

    /**
     * Deletes a tag from the database.
     * Purpose: To remove a tag from the system.
     * Use cases:
     * - Admin removing inappropriate or obsolete tags
     * - Cleaning up unused tags
     * @param id The unique identifier of the tag to be deleted
     * @throws Exception If there's an error during the database operation
     */
    void delete(int id) throws Exception;

    /**
     * Finds a tag by its name.
     * Purpose: To retrieve a tag using its name rather than ID.
     * Use cases:
     * - Checking if a tag already exists when a user enters a new tag
     * - Finding tags for autocomplete functionality
     * @param name The name of the tag to search for
     * @return The Tag object if found, null otherwise
     * @throws Exception If there's an error during the database operation
     */
    Tag findByName(String name) throws Exception;

    /**
     * Retrieves all tags associated with a specific gig.
     * Purpose: To get all tags that are linked to a particular gig.
     * Use cases:
     * - Displaying tags on a gig's detail page
     * - Allowing users to click on tags to find similar gigs
     * @param gigId The ID of the gig
     * @return A List of Tag objects associated with the specified gig
     * @throws Exception If there's an error during the database operation
     */
    List<Tag> findByGigId(int gigId) throws Exception;

    /**
     * Finds the most popular tags.
     * Purpose: To retrieve tags that are most frequently used across gigs.
     * Use cases:
     * - Displaying trending or popular tags on the homepage
     * - Suggesting popular tags when sellers are creating gigs
     * @param limit The number of top tags to retrieve
     * @return A List of the most frequently used Tag objects
     * @throws Exception If there's an error during the database operation
     */
    List<Tag> findMostPopular(int limit) throws Exception;

    /**
     * Searches for tags based on a partial name.
     * Purpose: To find tags that match a given search term.
     * Use cases:
     * - Implementing tag search or autocomplete functionality
     * - Helping users find relevant tags when creating or editing gigs
     * @param partialName The partial name or search term for the tag
     * @return A List of Tag objects that match the search criteria
     * @throws Exception If there's an error during the database operation
     */
    List<Tag> searchByPartialName(String partialName) throws Exception;

    /**
     * Counts the number of gigs associated with a specific tag.
     * Purpose: To determine how many gigs are using a given tag.
     * Use cases:
     * - Displaying the popularity of tags
     * - Identifying rarely used tags for potential cleanup
     * @param tagId The ID of the tag
     * @return The number of gigs associated with the specified tag
     * @throws Exception If there's an error during the database operation
     */
    int countGigsWithTag(int tagId) throws Exception;
}
