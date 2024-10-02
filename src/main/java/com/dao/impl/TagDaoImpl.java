package com.dao.impl;

import com.dao.interfaces.TagDao;
import com.model.Tag;
import com.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TagDaoImpl implements TagDao {

    @Override
    public Tag create(Tag tag) throws Exception {
        String sql = "INSERT INTO tags (name) VALUES (?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, tag.getName());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating tag failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    tag.setTagId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating tag failed, no ID obtained.");
                }
            }
        }
        return tag;
    }

    @Override
    public Tag findById(int id) throws Exception {
        String sql = "SELECT * FROM tags WHERE tag_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractTagFromResultSet(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Tag> findAll() throws Exception {
        List<Tag> tags = new ArrayList<>();
        String sql = "SELECT * FROM tags";
        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                tags.add(extractTagFromResultSet(rs));
            }
        }
        return tags;
    }

    @Override
    public Tag update(Tag tag) throws Exception {
        String sql = "UPDATE tags SET name = ? WHERE tag_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, tag.getName());
            ps.setInt(2, tag.getTagId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating tag failed, no rows affected.");
            }
        }
        return tag;
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM tags WHERE tag_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public Tag findByName(String name) throws Exception {
        String sql = "SELECT * FROM tags WHERE name = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractTagFromResultSet(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Tag> findByGigId(int gigId) throws Exception {
        List<Tag> tags = new ArrayList<>();
        String sql = "SELECT t.* FROM tags t JOIN gig_tags gt ON t.tag_id = gt.tag_id WHERE gt.gig_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, gigId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    tags.add(extractTagFromResultSet(rs));
                }
            }
        }
        return tags;
    }

    @Override
    public List<Tag> findMostPopular(int limit) throws Exception {
        List<Tag> tags = new ArrayList<>();
        String sql = "SELECT t.*, COUNT(gt.gig_id) as usage_count " +
                "FROM tags t LEFT JOIN gig_tags gt ON t.tag_id = gt.tag_id " +
                "GROUP BY t.tag_id ORDER BY usage_count DESC LIMIT ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, limit);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    tags.add(extractTagFromResultSet(rs));
                }
            }
        }
        return tags;
    }

    @Override
    public List<Tag> searchByPartialName(String partialName) throws Exception {
        List<Tag> tags = new ArrayList<>();
        String sql = "SELECT * FROM tags WHERE name LIKE ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + partialName + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    tags.add(extractTagFromResultSet(rs));
                }
            }
        }
        return tags;
    }

    @Override
    public int countGigsWithTag(int tagId) throws Exception {
        String sql = "SELECT COUNT(DISTINCT gig_id) FROM gig_tags WHERE tag_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, tagId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return 0;
    }

    private Tag extractTagFromResultSet(ResultSet rs) throws SQLException {
        Tag tag = new Tag();
        tag.setTagId(rs.getInt("tag_id"));
        tag.setName(rs.getString("name"));
        return tag;
    }
}