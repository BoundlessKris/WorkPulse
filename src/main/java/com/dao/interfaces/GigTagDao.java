package com.dao.interfaces;

import com.model.Gig;
import com.model.Tag;

import java.util.List;

public interface GigTagDao {
    /**
     * Associates a tag with a gig.
     * Purpose: To create a relationship between a gig and a tag.
     * Use cases:
     * - Seller adding tags to their gig during creation or editing
     * - Admin tagging gigs for better categorization
     *
     * @param gigId The ID of the gig
     * @param tagId The ID of the tag
     * @throws Exception If there's an error during the database operation
     */
    void addTagToGig(int gigId, int tagId) throws Exception;

    /**
     * Removes the association between a tag and a gig.
     * Purpose: To delete the relationship between a gig and a tag.
     * Use cases:
     * - Seller removing a tag from their gig
     * - Admin adjusting gig tags
     *
     * @param gigId The ID of the gig
     * @param tagId The ID of the tag
     * @throws Exception If there's an error during the database operation
     */
    void removeTagFromGig(int gigId, int tagId) throws Exception;

    /**
     * Retrieves all tags associated with a specific gig.
     * Purpose: To get all tags that are linked to a particular gig.
     * Use cases:
     * - Displaying tags on a gig's detail page
     * - Populating tag fields when editing a gig
     *
     * @param gigId The ID of the gig
     * @return A List of Tag objects associated with the specified gig
     * @throws Exception If there's an error during the database operation
     */
    List<Tag> findTagsByGigId(int gigId) throws Exception;

    /**
     * Retrieves all gigs associated with a specific tag.
     * Purpose: To get all gigs that are tagged with a particular tag.
     * Use cases:
     * - Displaying gigs when a user clicks on a tag
     * - Generating a list of gigs for a tag-based search
     *
     * @param tagId The ID of the tag
     * @return A List of Gig objects associated with the specified tag
     * @throws Exception If there's an error during the database operation
     */
    List<Gig> findGigsByTagId(int tagId) throws Exception;

    /**
     * Checks if a gig is associated with a specific tag.
     * Purpose: To determine if a particular tag is applied to a gig.
     * Use cases:
     * - Validating tag selections during gig editing
     * - Filtering gigs based on tag presence
     *
     * @param gigId The ID of the gig
     * @param tagId The ID of the tag
     * @return true if the gig is associated with the tag, false otherwise
     * @throws Exception If there's an error during the database operation
     */
    boolean isGigAssociatedWithTag(int gigId, int tagId) throws Exception;

    /**
     * Counts the number of tags associated with a gig.
     * Purpose: To determine how many tags are applied to a specific gig.
     * Use cases:
     * - Enforcing a maximum number of tags per gig
     * - Displaying tag count on gig listings
     *
     * @param gigId The ID of the gig
     * @return The number of tags associated with the specified gig
     * @throws Exception If there's an error during the database operation
     */
    int countTagsForGig(int gigId) throws Exception;

    /**
     * Retrieves gigs that share common tags with a specific gig.
     * Purpose: To find gigs that have similar tags to a given gig.
     * Use cases:
     * - Recommending similar gigs to users
     * - Implementing a "related gigs" feature
     *
     * @param gigId The ID of the gig to find similar gigs for
     * @param limit The maximum number of similar gigs to return
     * @return A List of Gig objects that share tags with the specified gig
     * @throws Exception If there's an error during the database operation
     */
    List<Gig> findSimilarGigs(int gigId, int limit) throws Exception;

    /**
     * Updates all tags for a gig.
     * Purpose: To replace the entire set of tags for a gig.
     * Use cases:
     * - Bulk updating of gig tags during editing
     * - Syncing gig tags with an external system
     *
     * @param gigId  The ID of the gig
     * @param tagIds A List of tag IDs to associate with the gig
     * @throws Exception If there's an error during the database operation
     */
    void updateGigTags(int gigId, List<Integer> tagIds) throws Exception;

    /**
     * Finds the most used tags across all gigs.
     * Purpose: To identify the most popular tags in the system.
     * Use cases:
     * - Displaying trending tags on the homepage
     * - Suggesting popular tags during gig creation
     *
     * @param limit The maximum number of top tags to retrieve
     * @return A List of Tag objects sorted by usage frequency
     * @throws Exception If there's an error during the database operation
     */
    List<Tag> findMostUsedTags(int limit) throws Exception;
}
