package com.dao.impl;

import com.dao.interfaces.BuyerRequestDao;
import com.model.BuyerRequest;
import com.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public class BuyerRequestDaoImpl implements BuyerRequestDao {

    @Override
    public BuyerRequest create(BuyerRequest request) throws Exception {
        String sql = "INSERT INTO buyer_requests (buyer_id, title, description, budget, created_at, expires_at) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, request.getBuyerId());
            ps.setString(2, request.getTitle());
            ps.setString(3, request.getDescription());
            ps.setBigDecimal(4, request.getBudget());
            ps.setTimestamp(5, Timestamp.valueOf(request.getCreatedAt()));
            ps.setTimestamp(6, Timestamp.valueOf(request.getExpiresAt()));

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating buyer request failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    request.setRequestId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating buyer request failed, no ID obtained.");
                }
            }
        }
        return request;
    }

    @Override
    public BuyerRequest findById(int id) throws Exception {
        String sql = "SELECT * FROM buyer_requests WHERE request_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractBuyerRequestFromResultSet(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<BuyerRequest> findByBuyerId(int buyerId) throws Exception {
        List<BuyerRequest> requests = new ArrayList<>();
        String sql = "SELECT * FROM buyer_requests WHERE buyer_id = ? ORDER BY created_at DESC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, buyerId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    requests.add(extractBuyerRequestFromResultSet(rs));
                }
            }
        }
        return requests;
    }

    @Override
    public List<BuyerRequest> findActive() throws Exception {
        List<BuyerRequest> requests = new ArrayList<>();
        String sql = "SELECT * FROM buyer_requests WHERE expires_at > NOW() ORDER BY created_at DESC";
        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                requests.add(extractBuyerRequestFromResultSet(rs));
            }
        }
        return requests;
    }

    @Override
    public BuyerRequest update(BuyerRequest request) throws Exception {
        String sql = "UPDATE buyer_requests SET buyer_id = ?, title = ?, description = ?, budget = ?, expires_at = ? WHERE request_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, request.getBuyerId());
            ps.setString(2, request.getTitle());
            ps.setString(3, request.getDescription());
            ps.setBigDecimal(4, request.getBudget());
            ps.setTimestamp(5, Timestamp.valueOf(request.getExpiresAt()));
            ps.setInt(6, request.getRequestId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating buyer request failed, no rows affected.");
            }
        }
        return request;
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM buyer_requests WHERE request_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<BuyerRequest> findByCategory(int categoryId) throws Exception {
        List<BuyerRequest> requests = new ArrayList<>();
        String sql = "SELECT br.* FROM buyer_requests br JOIN buyer_request_categories brc ON br.request_id = brc.request_id WHERE brc.category_id = ? AND br.expires_at > NOW() ORDER BY br.created_at DESC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, categoryId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    requests.add(extractBuyerRequestFromResultSet(rs));
                }
            }
        }
        return requests;
    }

    @Override
    public List<BuyerRequest> searchByKeywords(String keywords) throws Exception {
        List<BuyerRequest> requests = new ArrayList<>();
        String sql = "SELECT * FROM buyer_requests WHERE MATCH(title, description) AGAINST(? IN NATURAL LANGUAGE MODE) AND expires_at > NOW() ORDER BY created_at DESC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, keywords);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    requests.add(extractBuyerRequestFromResultSet(rs));
                }
            }
        }
        return requests;
    }

    @Override
    public int countOffersForRequest(int requestId) throws Exception {
        String sql = "SELECT COUNT(*) FROM buyer_request_offers WHERE request_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, requestId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return 0;
    }

    @Override
    public List<BuyerRequest> findExpiringSoon(int withinHours) throws Exception {
        List<BuyerRequest> requests = new ArrayList<>();
        String sql = "SELECT * FROM buyer_requests WHERE expires_at BETWEEN NOW() AND DATE_ADD(NOW(), INTERVAL ? HOUR) ORDER BY expires_at ASC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, withinHours);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    requests.add(extractBuyerRequestFromResultSet(rs));
                }
            }
        }
        return requests;
    }

    @Override
    public int markExpiredRequests(LocalDateTime currentTime) throws Exception {
        String sql = "UPDATE buyer_requests SET status = 'EXPIRED' WHERE expires_at <= ? AND status = 'ACTIVE'";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setTimestamp(1, Timestamp.valueOf(currentTime));
            return ps.executeUpdate();
        }
    }

    private BuyerRequest extractBuyerRequestFromResultSet(ResultSet rs) throws SQLException {
        BuyerRequest request = new BuyerRequest();
        request.setRequestId(rs.getInt("request_id"));
        request.setBuyerId(rs.getInt("buyer_id"));
        request.setTitle(rs.getString("title"));
        request.setDescription(rs.getString("description"));
        request.setBudget(rs.getBigDecimal("budget"));
        request.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        request.setExpiresAt(rs.getTimestamp("expires_at").toLocalDateTime());
        return request;
    }
}