package com.dao.impl;

import com.dao.interfaces.NotificationDao;
import com.model.Notification;
import com.util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NotificationDaoImpl implements NotificationDao {

    @Override
    public Notification create(Notification notification) throws Exception {
        String sql = "INSERT INTO notifications (user_id, type, content, created_at, is_read) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, notification.getUserId());
            ps.setString(2, notification.getType());
            ps.setString(3, notification.getContent());
            ps.setTimestamp(4, Timestamp.valueOf(notification.getCreatedAt()));
            ps.setBoolean(5, notification.isRead());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating notification failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    notification.setNotificationId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating notification failed, no ID obtained.");
                }
            }
        }
        return notification;
    }

    @Override
    public Notification findById(int id) throws Exception {
        String sql = "SELECT * FROM notifications WHERE notification_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractNotificationFromResultSet(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Notification> findByUserId(int userId) throws Exception {
        List<Notification> notifications = new ArrayList<>();
        String sql = "SELECT * FROM notifications WHERE user_id = ? ORDER BY created_at DESC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    notifications.add(extractNotificationFromResultSet(rs));
                }
            }
        }
        return notifications;
    }

    @Override
    public Notification update(Notification notification) throws Exception {
        String sql = "UPDATE notifications SET user_id = ?, type = ?, content = ?, is_read = ? WHERE notification_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, notification.getUserId());
            ps.setString(2, notification.getType());
            ps.setString(3, notification.getContent());
            ps.setBoolean(4, notification.isRead());
            ps.setInt(5, notification.getNotificationId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating notification failed, no rows affected.");
            }
        }
        return notification;
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM notifications WHERE notification_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public void markAsRead(int notificationId) throws Exception {
        String sql = "UPDATE notifications SET is_read = true WHERE notification_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, notificationId);
            ps.executeUpdate();
        }
    }

    @Override
    public int countUnreadNotifications(int userId) throws Exception {
        String sql = "SELECT COUNT(*) FROM notifications WHERE user_id = ? AND is_read = false";
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
    public List<Notification> findRecentNotifications(int userId, int limit) throws Exception {
        List<Notification> notifications = new ArrayList<>();
        String sql = "SELECT * FROM notifications WHERE user_id = ? ORDER BY created_at DESC LIMIT ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, limit);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    notifications.add(extractNotificationFromResultSet(rs));
                }
            }
        }
        return notifications;
    }

    @Override
    public List<Notification> findByType(int userId, String type) throws Exception {
        List<Notification> notifications = new ArrayList<>();
        String sql = "SELECT * FROM notifications WHERE user_id = ? AND type = ? ORDER BY created_at DESC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setString(2, type);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    notifications.add(extractNotificationFromResultSet(rs));
                }
            }
        }
        return notifications;
    }

    @Override
    public void deleteOldNotifications(int userId, LocalDateTime beforeDate) throws Exception {
        String sql = "DELETE FROM notifications WHERE user_id = ? AND created_at < ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setTimestamp(2, Timestamp.valueOf(beforeDate));
            ps.executeUpdate();
        }
    }

    @Override
    public void markAllAsRead(int userId) throws Exception {
        String sql = "UPDATE notifications SET is_read = true WHERE user_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.executeUpdate();
        }
    }

    private Notification extractNotificationFromResultSet(ResultSet rs) throws SQLException {
        Notification notification = new Notification();
        notification.setNotificationId(rs.getInt("notification_id"));
        notification.setUserId(rs.getInt("user_id"));
        notification.setType(rs.getString("type"));
        notification.setContent(rs.getString("content"));
        notification.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        notification.setRead(rs.getBoolean("is_read"));
        return notification;
    }
}