package com.dao.interfaces;

import com.model.File;
import java.util.List;

public interface FileDao {
    /**
     * Creates a new file entry in the database.
     * Purpose: To store metadata about an uploaded file.
     * Use cases:
     * - Uploading a profile picture
     * - Adding images or documents to a gig
     * - Attaching files to messages or orders
     * @param file The File object containing the file metadata
     * @return The created File object with the generated ID
     * @throws Exception If there's an error during the database operation
     */
    File create(File file) throws Exception;

    /**
     * Retrieves a file entry by its ID.
     * Purpose: To fetch metadata of a specific file.
     * Use cases:
     * - Displaying file information
     * - Retrieving file path for download
     * @param id The unique identifier of the file
     * @return The File object if found, null otherwise
     * @throws Exception If there's an error during the database operation
     */
    File findById(int id) throws Exception;

    /**
     * Retrieves all files associated with a specific user.
     * Purpose: To get all files uploaded by or associated with a particular user.
     * Use cases:
     * - Displaying a user's uploaded files
     * - Managing user's file storage
     * @param userId The ID of the user
     * @return A List of File objects associated with the specified user
     * @throws Exception If there's an error during the database operation
     */
    List<File> findByUserId(int userId) throws Exception;

    /**
     * Retrieves all files associated with a specific gig.
     * Purpose: To get all files related to a particular gig.
     * Use cases:
     * - Displaying images or documents attached to a gig
     * - Managing gig-related files
     * @param gigId The ID of the gig
     * @return A List of File objects associated with the specified gig
     * @throws Exception If there's an error during the database operation
     */
    List<File> findByGigId(int gigId) throws Exception;

    /**
     * Updates an existing file's metadata.
     * Purpose: To modify the information about a file.
     * Use cases:
     * - Updating file description
     * - Changing file associations (e.g., moving a file from one gig to another)
     * @param file The File object with updated information
     * @return The updated File object
     * @throws Exception If there's an error during the database operation
     */
    File update(File file) throws Exception;

    /**
     * Deletes a file entry from the database.
     * Purpose: To remove a file's metadata from the system.
     * Use cases:
     * - User deleting an uploaded file
     * - Removing files associated with deleted gigs or users
     * @param id The unique identifier of the file to be deleted
     * @throws Exception If there's an error during the database operation
     */
    void delete(int id) throws Exception;

    /**
     * Retrieves files by their type.
     * Purpose: To get files of a specific type (e.g., image, document).
     * Use cases:
     * - Filtering files by type in a file manager
     * - Retrieving all images for a gallery
     * @param fileType The type of files to retrieve
     * @return A List of File objects of the specified type
     * @throws Exception If there's an error during the database operation
     */
    List<File> findByFileType(String fileType) throws Exception;

    /**
     * Counts the number of files associated with a user.
     * Purpose: To determine how many files a user has uploaded.
     * Use cases:
     * - Enforcing storage limits
     * - Displaying file count in user profiles
     * @param userId The ID of the user
     * @return The number of files associated with the specified user
     * @throws Exception If there's an error during the database operation
     */
    int countFilesByUser(int userId) throws Exception;

    /**
     * Retrieves files uploaded within a specific date range.
     * Purpose: To get files based on their upload date.
     * Use cases:
     * - Generating reports on recent uploads
     * - Filtering files by upload date
     * @param startDate The start date of the range
     * @param endDate The end date of the range
     * @return A List of File objects uploaded within the specified date range
     * @throws Exception If there's an error during the database operation
     */
    List<File> findByUploadDateRange(java.time.LocalDateTime startDate, java.time.LocalDateTime endDate) throws Exception;

    /**
     * Searches for files based on filename or description.
     * Purpose: To find files that match given search terms.
     * Use cases:
     * - Implementing a search function in a file manager
     * - Finding specific files by name or description
     * @param searchTerm The search term to look for in filenames or descriptions
     * @return A List of File objects that match the search criteria
     * @throws Exception If there's an error during the database operation
     */
    List<File> searchFiles(String searchTerm) throws Exception;
}