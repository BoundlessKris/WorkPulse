package com.dao.impl;

import com.dao.interfaces.OrderDao;
import com.model.Order;
import com.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class OrderDaoImpl implements OrderDao {

    @Override
    public Order create(Order order) throws Exception {
        String sql = "INSERT INTO orders (gig_id, buyer_id, seller_id, price_id, status, created_at, total_amount) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, order.getGigId());
            ps.setInt(2, order.getBuyerId());
            ps.setInt(3, order.getSellerId());
            ps.setInt(4, order.getPriceId());
            ps.setString(5, order.getStatus());
            ps.setTimestamp(6, Timestamp.valueOf(order.getCreatedAt()));
            ps.setDouble(7, order.getTotalAmount());


            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating order failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    order.setOrderId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating order failed, no ID obtained.");
                }
            }
        }
        return order;
    }

    @Override
    public Order findById(int id) throws Exception {
        String sql = "SELECT * FROM orders WHERE order_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractOrderFromResultSet(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Order> findByBuyerId(int buyerId) throws Exception {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT o.*, gp.price as total_amount FROM orders o " +
                "JOIN gig_prices gp ON o.price_id = gp.price_id " +
                "WHERE o.buyer_id = ? ORDER BY o.created_at DESC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, buyerId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    orders.add(extractOrderFromResultSet(rs));
                }
            }
        }
        return orders;
    }

    @Override
    public List<Order> findBySellerId(int sellerId) throws Exception {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE seller_id = ? ORDER BY created_at DESC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, sellerId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    orders.add(extractOrderFromResultSet(rs));
                }
            }
        }
        return orders;
    }

    @Override
    public Order update(Order order) throws Exception {
        String sql = "UPDATE orders SET gig_id = ?, buyer_id = ?, seller_id = ?, price_id = ?, status = ?, completed_at = ? WHERE order_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, order.getGigId());
            ps.setInt(2, order.getBuyerId());
            ps.setInt(3, order.getSellerId());
            ps.setInt(4, order.getPriceId());
            ps.setString(5, order.getStatus());
            ps.setTimestamp(6, order.getCompletedAt() != null ? Timestamp.valueOf(order.getCompletedAt()) : null);
            ps.setInt(7, order.getOrderId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating order failed, no rows affected.");
            }
        }
        return order;
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM orders WHERE order_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Order> findByStatus(String status) throws Exception {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE status = ? ORDER BY created_at DESC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    orders.add(extractOrderFromResultSet(rs));
                }
            }
        }
        return orders;
    }

    @Override
    public List<Order> findByDateRange(LocalDateTime startDate, LocalDateTime endDate) throws Exception {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE created_at BETWEEN ? AND ? ORDER BY created_at DESC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setTimestamp(1, Timestamp.valueOf(startDate));
            ps.setTimestamp(2, Timestamp.valueOf(endDate));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    orders.add(extractOrderFromResultSet(rs));
                }
            }
        }
        return orders;
    }

    @Override
    public int countOrdersForGig(int gigId) throws Exception {
        String sql = "SELECT COUNT(*) FROM orders WHERE gig_id = ?";
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
    public double calculateSellerEarnings(int sellerId, LocalDateTime startDate, LocalDateTime endDate) throws Exception {
        String sql = "SELECT SUM(gp.price) FROM orders o JOIN gig_prices gp ON o.price_id = gp.price_id " +
                "WHERE o.seller_id = ? AND o.status = 'completed' AND o.completed_at BETWEEN ? AND ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, sellerId);
            ps.setTimestamp(2, Timestamp.valueOf(startDate));
            ps.setTimestamp(3, Timestamp.valueOf(endDate));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble(1);
                }
            }
        }
        return 0.0;
    }

    private Order extractOrderFromResultSet(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setOrderId(rs.getInt("order_id"));
        order.setGigId(rs.getInt("gig_id"));
        order.setBuyerId(rs.getInt("buyer_id"));
        order.setSellerId(rs.getInt("seller_id"));
        order.setPriceId(rs.getInt("price_id"));
        order.setStatus(rs.getString("status"));
        order.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        Timestamp completedAt = rs.getTimestamp("completed_at");
        if (completedAt != null) {
            order.setCompletedAt(completedAt.toLocalDateTime());
        }
        order.setTotalAmount(rs.getDouble("total_amount"));
        return order;
    }
    @Override
    public int countByGigId(int gigId) throws Exception {
        String sql = "SELECT COUNT(*) FROM orders WHERE gig_id = ?";
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
    public List<Order> findRecentOrders(int limit) throws Exception {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders ORDER BY created_at DESC LIMIT ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, limit);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    orders.add(extractOrderFromResultSet(rs));
                }
            }
        }
        return orders;
    }

    @Override
    public List<Order> findBySellerIdAndStatus(int sellerId, String status) throws Exception {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE seller_id = ? AND status = ? ORDER BY created_at DESC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, sellerId);
            ps.setString(2, status);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    orders.add(extractOrderFromResultSet(rs));
                }
            }
        }
        return orders;
    }
}
