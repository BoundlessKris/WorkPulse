package com.dao.interfaces;

import com.model.GigCategory;
import java.util.List;

public interface GigCategoryDao {
    /**
     * Creates a new gig category in the database.
     * Purpose: To add a new category for classifying gigs.
     * Use cases:
     * - Admin creating a new category for gigs
     * - Expanding the service offerings into new areas
     * @param category The GigCategory object containing the category details
     * @return The created GigCategory object with the generated ID
     * @throws Exception If there's an error during the database operation
     */
    GigCategory create(GigCategory category) throws Exception;

    /**
     * Retrieves a gig category by its ID.
     * Purpose: To fetch details of a specific category.
     * Use cases:
     * - Displaying category information on the website
     * - Retrieving category details for gig creation or editing
     * @param id The unique identifier of the gig category
     * @return The GigCategory object if found, null otherwise
     * @throws Exception If there's an error during the database operation
     */
    GigCategory findById(int id) throws Exception;

    /**
     * Retrieves all gig categories from the database.
     * Purpose: To get a list of all available categories in the system.
     * Use cases:
     * - Populating category dropdown menus
     * - Displaying a directory of all service categories
     * @return A List of all GigCategory objects in the database
     * @throws Exception If there's an error during the database operation
     */
    List<GigCategory> findAll() throws Exception;

    /**
     * Updates an existing gig category's information.
     * Purpose: To modify the details of a category already in the database.
     * Use cases:
     * - Admin editing category name or description
     * - Updating category hierarchy
     * @param category The GigCategory object with updated information
     * @return The updated GigCategory object
     * @throws Exception If there's an error during the database operation
     */
    GigCategory update(GigCategory category) throws Exception;

    /**
     * Deletes a gig category from the database.
     * Purpose: To remove a category from the system.
     * Use cases:
     * - Admin removing an obsolete or unused category
     * - Consolidating categories
     * @param id The unique identifier of the category to be deleted
     * @throws Exception If there's an error during the database operation
     */
    void delete(int id) throws Exception;

    /**
     * Finds all subcategories of a given parent category.
     * Purpose: To retrieve all direct child categories of a specific category.
     * Use cases:
     * - Displaying subcategories when a user browses a main category
     * - Building a hierarchical category navigation structure
     * @param parentId The ID of the parent category
     * @return A List of GigCategory objects that are direct subcategories of the specified parent
     * @throws Exception If there's an error during the database operation
     */
    List<GigCategory> findSubcategories(int parentId) throws Exception;

    /**
     * Retrieves all top-level categories (categories without a parent).
     * Purpose: To get a list of main categories that are not subcategories of any other category.
     * Use cases:
     * - Displaying main category options in the primary navigation
     * - Showing top-level categories on the homepage
     * @return A List of GigCategory objects that are top-level categories
     * @throws Exception If there's an error during the database operation
     */
    List<GigCategory> findTopLevelCategories() throws Exception;

    /**
     * Finds the parent category of a given category.
     * Purpose: To retrieve the immediate parent of a specific category.
     * Use cases:
     * - Building breadcrumb navigation
     * - Displaying the category hierarchy
     * @param categoryId The ID of the category whose parent is to be found
     * @return The GigCategory object representing the parent category, or null if it's a top-level category
     * @throws Exception If there's an error during the database operation
     */
    GigCategory findParentCategory(int categoryId) throws Exception;

    /**
     * Counts the number of gigs in a specific category.
     * Purpose: To determine how many gigs are classified under a given category.
     * Use cases:
     * - Displaying the number of available gigs in each category
     * - Identifying popular or underutilized categories
     * @param categoryId The ID of the category
     * @return The number of gigs in the specified category
     * @throws Exception If there's an error during the database operation
     */
    int countGigsInCategory(int categoryId) throws Exception;

    /**
     * Checks if a category has any gigs.
     * Purpose: To determine if a category is currently in use.
     * Use cases:
     * - Preventing deletion of categories that contain gigs
     * - Identifying empty categories for potential cleanup
     * @param categoryId The ID of the category
     * @return true if the category contains gigs, false otherwise
     * @throws Exception If there's an error during the database operation
     */
    boolean hasGigs(int categoryId) throws Exception;
}
