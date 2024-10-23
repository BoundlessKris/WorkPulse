package com.service.impl;

import com.dao.interfaces.FileDao;
import com.model.File;
import com.service.interfaces.FileService;
import java.time.LocalDateTime;
import java.util.List;

public class FileServiceImpl implements FileService {
    private FileDao fileDao;

    public FileServiceImpl(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    @Override
    public File uploadFile(File file) throws Exception {
        validateFile(file);
        return fileDao.create(file);
    }

    @Override
    public File getFileById(int id) throws Exception {
        File file = fileDao.findById(id);
        if (file == null) {
            throw new Exception("File not found with id: " + id);
        }
        return file;
    }

    @Override
    public List<File> getFilesByUserId(int userId) throws Exception {
        return fileDao.findByUserId(userId);
    }

    @Override
    public List<File> getFilesByGigId(int gigId) throws Exception {
        return fileDao.findByGigId(gigId);
    }

    @Override
    public File updateFile(File file) throws Exception {
        validateFile(file);
        File existingFile = getFileById(file.getFileId());
        if (existingFile == null) {
            throw new Exception("File not found for update with id: " + file.getFileId());
        }
        return fileDao.update(file);
    }

    @Override
    public void deleteFile(int id) throws Exception {
        File file = getFileById(id);
        if (file == null) {
            throw new Exception("File not found for deletion with id: " + id);
        }
        fileDao.delete(id);
    }

    @Override
    public List<File> getFilesByFileType(String fileType) throws Exception {
        return fileDao.findByFileType(fileType);
    }

    @Override
    public int countFilesByUser(int userId) throws Exception {
        return fileDao.countFilesByUser(userId);
    }

    @Override
    public List<File> getFilesByUploadDateRange(LocalDateTime startDate, LocalDateTime endDate) throws Exception {
        return fileDao.findByUploadDateRange(startDate, endDate);
    }

    @Override
    public List<File> searchFiles(String searchTerm) throws Exception {
        return fileDao.searchFiles(searchTerm);
    }

    @Override
    public long getTotalFilesSizeByUser(int userId) throws Exception {
        // This might require additional implementation in the DAO
        throw new UnsupportedOperationException("This operation is not yet implemented");
    }

    @Override
    public boolean isFileBelongsToUser(int fileId, int userId) throws Exception {
        File file = getFileById(fileId);
        return file != null && file.getUserId() != null && file.getUserId() == userId;
    }

    @Override
    public void moveFile(int fileId, String newPath) throws Exception {
        File file = getFileById(fileId);
        if (file == null) {
            throw new Exception("File not found with id: " + fileId);
        }
        file.setFilePath(newPath);
        fileDao.update(file);
    }

    private void validateFile(File file) throws IllegalArgumentException {
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        if (file.getFileType() == null || file.getFileType().trim().isEmpty()) {
            throw new IllegalArgumentException("File type cannot be empty");
        }
        if (file.getFilePath() == null || file.getFilePath().trim().isEmpty()) {
            throw new IllegalArgumentException("File path cannot be empty");
        }
        if (file.getUploadedAt() == null) {
            throw new IllegalArgumentException("Upload date cannot be null");
        }
    }
}
