package com.dao.impl;

import com.dao.interfaces.ReviewDao;
import com.model.Review;
import com.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDaoImpl implements ReviewDao {

    @Override
    public Review create(Review review) throws Exception {
        String sql = "INSERT INTO reviews (order_id, reviewer_id, rating, comment, created_at) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, review.getOrderId());
            ps.setInt(2, review.getReviewerId());
            ps.setInt(3, review.getRating());
            ps.setString(4, review.getComment());
            ps.setTimestamp(5, Timestamp.valueOf(review.getCreatedAt()));

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating review failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    review.setReviewId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating review failed, no ID obtained.");
                }
            }
        }
        return review;
    }

    @Override
    public Review findById(int id) throws Exception {
        String sql = "SELECT * FROM reviews WHERE review_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractReviewFromResultSet(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Review> findByOrderId(int orderId) throws Exception {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews WHERE order_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    reviews.add(extractReviewFromResultSet(rs));
                }
            }
        }
        return reviews;
    }

    @Override
    public List<Review> findByReviewerId(int reviewerId) throws Exception {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews WHERE reviewer_id = ? ORDER BY created_at DESC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, reviewerId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    reviews.add(extractReviewFromResultSet(rs));
                }
            }
        }
        return reviews;
    }

    @Override
    public List<Review> findByGigId(int gigId) throws Exception {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT r.* FROM reviews r JOIN orders o ON r.order_id = o.order_id WHERE o.gig_id = ? ORDER BY r.created_at DESC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, gigId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    reviews.add(extractReviewFromResultSet(rs));
                }
            }
        }
        return reviews;
    }

    @Override
    public Review update(Review review) throws Exception {
        String sql = "UPDATE reviews SET order_id = ?, reviewer_id = ?, rating = ?, comment = ? WHERE review_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, review.getOrderId());
            ps.setInt(2, review.getReviewerId());
            ps.setInt(3, review.getRating());
            ps.setString(4, review.getComment());
            ps.setInt(5, review.getReviewId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating review failed, no rows affected.");
            }
        }
        return review;
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM reviews WHERE review_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public double calculateAverageRatingForGig(int gigId) throws Exception {
        String sql = "SELECT AVG(r.rating) FROM reviews r JOIN orders o ON r.order_id = o.order_id WHERE o.gig_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, gigId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble(1);
                }
            }
        }
        return 0.0;
    }

    @Override
    public int countReviewsForGig(int gigId) throws Exception {
        String sql = "SELECT COUNT(*) FROM reviews r JOIN orders o ON r.order_id = o.order_id WHERE o.gig_id = ?";
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
    public List<Review> findMostRecentReviewsForGig(int gigId, int limit) throws Exception {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT r.* FROM reviews r JOIN orders o ON r.order_id = o.order_id " +
                "WHERE o.gig_id = ? ORDER BY r.created_at DESC LIMIT ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, gigId);
            ps.setInt(2, limit);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    reviews.add(extractReviewFromResultSet(rs));
                }
            }
        }
        return reviews;
    }

    private Review extractReviewFromResultSet(ResultSet rs) throws SQLException {
        Review review = new Review();
        review.setReviewId(rs.getInt("review_id"));
        review.setOrderId(rs.getInt("order_id"));
        review.setReviewerId(rs.getInt("reviewer_id"));
        review.setRating(rs.getInt("rating"));
        review.setComment(rs.getString("comment"));
        review.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        return review;
    }
}