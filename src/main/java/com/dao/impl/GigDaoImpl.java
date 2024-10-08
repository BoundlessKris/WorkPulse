package com.dao.impl;

import com.dao.interfaces.GigDao;
import com.model.Gig;
import com.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GigDaoImpl implements GigDao {

    @Override
    public Gig create(Gig gig) throws Exception {
        String sql = "INSERT INTO gigs (seller_id, title, description, delivery_time, created_at) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, gig.getSellerId());
            ps.setString(2, gig.getTitle());
            ps.setString(3, gig.getDescription());
            ps.setInt(4, gig.getDeliveryTime());
            ps.setTimestamp(5, Timestamp.valueOf(gig.getCreatedAt()));

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating gig failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    gig.setGigId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating gig failed, no ID obtained.");
                }
            }
        }
        return gig;
    }

    @Override
    public Gig findById(int id) throws Exception {
        String sql = "SELECT * FROM gigs WHERE gig_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractGigFromResultSet(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Gig> findAll() throws Exception {
        List<Gig> gigs = new ArrayList<>();
        String sql = "SELECT * FROM gigs";
        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                gigs.add(extractGigFromResultSet(rs));
            }
        }
        return gigs;
    }

    @Override
    public Gig update(Gig gig) throws Exception {
        String sql = "UPDATE gigs SET seller_id = ?, title = ?, description = ?, delivery_time = ? WHERE gig_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, gig.getSellerId());
            ps.setString(2, gig.getTitle());
            ps.setString(3, gig.getDescription());
            ps.setInt(4, gig.getDeliveryTime());
            ps.setInt(5, gig.getGigId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating gig failed, no rows affected.");
            }
        }
        return gig;
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM gigs WHERE gig_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Gig> findBySellerId(int sellerId) throws Exception {
        List<Gig> gigs = new ArrayList<>();
        String sql = "SELECT * FROM gigs WHERE seller_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, sellerId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    gigs.add(extractGigFromResultSet(rs));
                }
            }
        }
        return gigs;
    }

    @Override
    public List<Gig> findByCategory(int categoryId) throws Exception {
        List<Gig> gigs = new ArrayList<>();
        String sql = "SELECT g.* FROM gigs g JOIN gig_categories gc ON g.gig_id = gc.gig_id WHERE gc.category_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, categoryId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    gigs.add(extractGigFromResultSet(rs));
                }
            }
        }
        return gigs;
    }

    @Override
    public List<Gig> searchByKeywords(String keywords) throws Exception {
        List<Gig> gigs = new ArrayList<>();
        String sql = "SELECT * FROM gigs WHERE MATCH(title, description) AGAINST(? IN NATURAL LANGUAGE MODE)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, keywords);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    gigs.add(extractGigFromResultSet(rs));
                }
            }
        }
        return gigs;
    }

    @Override
    public List<Gig> findMostPopular(int limit) throws Exception {
        List<Gig> gigs = new ArrayList<>();
        String sql = "SELECT g.*, COUNT(o.order_id) as order_count " +
                "FROM gigs g LEFT JOIN orders o ON g.gig_id = o.gig_id " +
                "GROUP BY g.gig_id ORDER BY order_count DESC LIMIT ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, limit);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    gigs.add(extractGigFromResultSet(rs));
                }
            }
        }
        return gigs;
    }

    @Override
    public List<Gig> findByPriceRange(double minPrice, double maxPrice) throws Exception {
        List<Gig> gigs = new ArrayList<>();
        String sql = "SELECT g.* FROM gigs g " +
                "JOIN gig_prices gp ON g.gig_id = gp.gig_id " +
                "WHERE gp.price BETWEEN ? AND ? " +
                "GROUP BY g.gig_id";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, minPrice);
            ps.setDouble(2, maxPrice);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    gigs.add(extractGigFromResultSet(rs));
                }
            }
        }
        return gigs;
    }

    private Gig extractGigFromResultSet(ResultSet rs) throws SQLException {
        Gig gig = new Gig();
        gig.setGigId(rs.getInt("gig_id"));
        gig.setSellerId(rs.getInt("seller_id"));
        gig.setTitle(rs.getString("title"));
        gig.setDescription(rs.getString("description"));
        gig.setDeliveryTime(rs.getInt("delivery_time"));
        gig.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        return gig;
    }
}