package com.service.interfaces;

import com.model.File;
import java.time.LocalDateTime;
import java.util.List;

public interface FileService {
    File uploadFile(File file) throws Exception;
    File getFileById(int id) throws Exception;
    List<File> getFilesByUserId(int userId) throws Exception;
    List<File> getFilesByGigId(int gigId) throws Exception;
    File updateFile(File file) throws Exception;
    void deleteFile(int id) throws Exception;
    List<File> getFilesByFileType(String fileType) throws Exception;
    int countFilesByUser(int userId) throws Exception;
    List<File> getFilesByUploadDateRange(LocalDateTime startDate, LocalDateTime endDate) throws Exception;
    List<File> searchFiles(String searchTerm) throws Exception;
    long getTotalFilesSizeByUser(int userId) throws Exception;
    boolean isFileBelongsToUser(int fileId, int userId) throws Exception;
    void moveFile(int fileId, String newPath) throws Exception;
}
