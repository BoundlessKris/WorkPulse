package com.dao.impl;

import com.dao.interfaces.GigTagDao;
import com.model.Gig;
import com.model.Tag;
import com.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GigTagDaoImpl implements GigTagDao {

    @Override
    public void addTagToGig(int gigId, int tagId) throws Exception {
        String sql = "INSERT INTO gig_tags (gig_id, tag_id) VALUES (?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, gigId);
            ps.setInt(2, tagId);
            ps.executeUpdate();
        }
    }

    @Override
    public void removeTagFromGig(int gigId, int tagId) throws Exception {
        String sql = "DELETE FROM gig_tags WHERE gig_id = ? AND tag_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, gigId);
            ps.setInt(2, tagId);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Tag> findTagsByGigId(int gigId) throws Exception {
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
    public List<Gig> findGigsByTagId(int tagId) throws Exception {
        List<Gig> gigs = new ArrayList<>();
        String sql = "SELECT g.* FROM gigs g JOIN gig_tags gt ON g.gig_id = gt.gig_id WHERE gt.tag_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, tagId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    gigs.add(extractGigFromResultSet(rs));
                }
            }
        }
        return gigs;
    }

    @Override
    public boolean isGigAssociatedWithTag(int gigId, int tagId) throws Exception {
        String sql = "SELECT COUNT(*) FROM gig_tags WHERE gig_id = ? AND tag_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, gigId);
            ps.setInt(2, tagId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    @Override
    public int countTagsForGig(int gigId) throws Exception {
        String sql = "SELECT COUNT(*) FROM gig_tags WHERE gig_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, gigId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return 0;
    }

    @Override
    public List<Gig> findSimilarGigs(int gigId, int limit) throws Exception {
        List<Gig> similarGigs = new ArrayList<>();
        String sql = "SELECT g.*, COUNT(gt2.tag_id) as shared_tags " +
                "FROM gigs g " +
                "JOIN gig_tags gt2 ON g.gig_id = gt2.gig_id " +
                "JOIN gig_tags gt1 ON gt1.tag_id = gt2.tag_id " +
                "WHERE gt1.gig_id = ? AND g.gig_id != ? " +
                "GROUP BY g.gig_id " +
                "ORDER BY shared_tags DESC " +
                "LIMIT ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, gigId);
            ps.setInt(2, gigId);
            ps.setInt(3, limit);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    similarGigs.add(extractGigFromResultSet(rs));
                }
            }
        }
        return similarGigs;
    }

    @Override
    public void updateGigTags(int gigId, List<Integer> tagIds) throws Exception {
        String deleteSql = "DELETE FROM gig_tags WHERE gig_id = ?";
        String insertSql = "INSERT INTO gig_tags (gig_id, tag_id) VALUES (?, ?)";

        try (Connection con = DatabaseConnection.getConnection()) {
            con.setAutoCommit(false);
            try {
                // Delete existing tags
                try (PreparedStatement deletePs = con.prepareStatement(deleteSql)) {
                    deletePs.setInt(1, gigId);
                    deletePs.executeUpdate();
                }

                // Insert new tags
                try (PreparedStatement insertPs = con.prepareStatement(insertSql)) {
                    for (Integer tagId : tagIds) {
                        insertPs.setInt(1, gigId);
                        insertPs.setInt(2, tagId);
                        insertPs.addBatch();
                    }
                    insertPs.executeBatch();
                }

                con.commit();
            } catch (SQLException e) {
                con.rollback();
                throw e;
            } finally {
                con.setAutoCommit(true);
            }
        }
    }

    @Override
    public List<Tag> findMostUsedTags(int limit) throws Exception {
        List<Tag> tags = new ArrayList<>();
        String sql = "SELECT t.*, COUNT(gt.gig_id) as usage_count " +
                "FROM tags t " +
                "JOIN gig_tags gt ON t.tag_id = gt.tag_id " +
                "GROUP BY t.tag_id " +
                "ORDER BY usage_count DESC " +
                "LIMIT ?";
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

    private Tag extractTagFromResultSet(ResultSet rs) throws SQLException {
        Tag tag = new Tag();
        tag.setTagId(rs.getInt("tag_id"));
        tag.setName(rs.getString("name"));
        return tag;
    }

    private Gig extractGigFromResultSet(ResultSet rs) throws SQLException {
        Gig gig = new Gig();
        gig.setGigId(rs.getInt("gig_id"));
        gig.setTitle(rs.getString("title"));
        // Set other Gig properties as needed
        return gig;
    }
}