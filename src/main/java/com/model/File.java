package com.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class File {
    private int fileId;
    private Integer userId;  // Can be null if the file is not associated with a user
    private Integer gigId;   // Can be null if the file is not associated with a gig
    private String fileType;
    private String filePath;
    private LocalDateTime uploadedAt;

    public File() {
    }

    public File(int fileId, Integer userId, Integer gigId, String fileType, String filePath, LocalDateTime uploadedAt) {
        this.fileId = fileId;
        this.userId = userId;
        this.gigId = gigId;
        this.fileType = fileType;
        this.filePath = filePath;
        this.uploadedAt = uploadedAt;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGigId() {
        return gigId;
    }

    public void setGigId(Integer gigId) {
        this.gigId = gigId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileId=" + fileId +
                ", userId=" + userId +
                ", gigId=" + gigId +
                ", fileType='" + fileType + '\'' +
                ", filePath='" + filePath + '\'' +
                ", uploadedAt=" + uploadedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return fileId == file.fileId && Objects.equals(userId, file.userId) && Objects.equals(gigId, file.gigId) && Objects.equals(fileType, file.fileType) && Objects.equals(filePath, file.filePath) && Objects.equals(uploadedAt, file.uploadedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileId, userId, gigId, fileType, filePath, uploadedAt);
    }
}
