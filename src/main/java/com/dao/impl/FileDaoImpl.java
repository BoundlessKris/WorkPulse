package com.dao.impl;

import com.dao.interfaces.FileDao;
import com.model.File;
import com.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class FileDaoImpl implements FileDao {

    @Override
    public File create(File file) throws Exception {
        String sql = "INSERT INTO files (user_id, gig_id, file_type, file_path, uploaded_at) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setObject(1, file.getUserId());  // Can be null
            ps.setObject(2, file.getGigId());   // Can be null
            ps.setString(3, file.getFileType());
            ps.setString(4, file.getFilePath());
            ps.setTimestamp(5, Timestamp.valueOf(file.getUploadedAt()));

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating file failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    file.setFileId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating file failed, no ID obtained.");
                }
            }
        }
        return file;
    }

    @Override
    public File findById(int id) throws Exception {
        String sql = "SELECT * FROM files WHERE file_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractFileFromResultSet(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<File> findByUserId(int userId) throws Exception {
        List<File> files = new ArrayList<>();
        String sql = "SELECT * FROM files WHERE user_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    files.add(extractFileFromResultSet(rs));
                }
            }
        }
        return files;
    }

    @Override
    public List<File> findByGigId(int gigId) throws Exception {
        List<File> files = new ArrayList<>();
        String sql = "SELECT * FROM files WHERE gig_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, gigId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    files.add(extractFileFromResultSet(rs));
                }
            }
        }
        return files;
    }

    @Override
    public File update(File file) throws Exception {
        String sql = "UPDATE files SET user_id = ?, gig_id = ?, file_type = ?, file_path = ? WHERE file_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, file.getUserId());  // Can be null
            ps.setObject(2, file.getGigId());   // Can be null
            ps.setString(3, file.getFileType());
            ps.setString(4, file.getFilePath());
            ps.setInt(5, file.getFileId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating file failed, no rows affected.");
            }
        }
        return file;
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM files WHERE file_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<File> findByFileType(String fileType) throws Exception {
        List<File> files = new ArrayList<>();
        String sql = "SELECT * FROM files WHERE file_type = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, fileType);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    files.add(extractFileFromResultSet(rs));
                }
            }
        }
        return files;
    }

    @Override
    public int countFilesByUser(int userId) throws Exception {
        String sql = "SELECT COUNT(*) FROM files WHERE user_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return 0;
    }

    @Override
    public List<File> findByUploadDateRange(LocalDateTime startDate, LocalDateTime endDate) throws Exception {
        List<File> files = new ArrayList<>();
        String sql = "SELECT * FROM files WHERE uploaded_at BETWEEN ? AND ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setTimestamp(1, Timestamp.valueOf(startDate));
            ps.setTimestamp(2, Timestamp.valueOf(endDate));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    files.add(extractFileFromResultSet(rs));
                }
            }
        }
        return files;
    }

    @Override
    public List<File> searchFiles(String searchTerm) throws Exception {
        List<File> files = new ArrayList<>();
        String sql = "SELECT * FROM files WHERE file_path LIKE ? OR file_type LIKE ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            String searchPattern = "%" + searchTerm + "%";
            ps.setString(1, searchPattern);
            ps.setString(2, searchPattern);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    files.add(extractFileFromResultSet(rs));
                }
            }
        }
        return files;
    }

    private File extractFileFromResultSet(ResultSet rs) throws SQLException {
        File file = new File();
        file.setFileId(rs.getInt("file_id"));
        file.setUserId(rs.getObject("user_id", Integer.class));  // Can be null
        file.setGigId(rs.getObject("gig_id", Integer.class));    // Can be null
        file.setFileType(rs.getString("file_type"));
        file.setFilePath(rs.getString("file_path"));
        file.setUploadedAt(rs.getTimestamp("uploaded_at").toLocalDateTime());
        return file;
    }
}
