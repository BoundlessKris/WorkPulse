package com.dao.impl;

import com.dao.interfaces.MessageDao;
import com.model.Message;
import com.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements MessageDao {

    @Override
    public Message create(Message message) throws Exception {
        String sql = "INSERT INTO messages (sender_id, receiver_id, content, sent_at, is_read) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, message.getSenderId());
            ps.setInt(2, message.getReceiverId());
            ps.setString(3, message.getContent());
            ps.setTimestamp(4, Timestamp.valueOf(message.getSentAt()));
            ps.setBoolean(5, message.isRead());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating message failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    message.setMessageId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating message failed, no ID obtained.");
                }
            }
        }
        return message;
    }

    @Override
    public Message findById(int id) throws Exception {
        String sql = "SELECT * FROM messages WHERE message_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractMessageFromResultSet(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Message> findBySenderId(int senderId) throws Exception {
        List<Message> messages = new ArrayList<>();
        String sql = "SELECT * FROM messages WHERE sender_id = ? ORDER BY sent_at DESC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, senderId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    messages.add(extractMessageFromResultSet(rs));
                }
            }
        }
        return messages;
    }

    @Override
    public List<Message> findByReceiverId(int receiverId) throws Exception {
        List<Message> messages = new ArrayList<>();
        String sql = "SELECT * FROM messages WHERE receiver_id = ? ORDER BY sent_at DESC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, receiverId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    messages.add(extractMessageFromResultSet(rs));
                }
            }
        }
        return messages;
    }

    @Override
    public List<Message> findConversation(int user1Id, int user2Id) throws Exception {
        List<Message> messages = new ArrayList<>();
        String sql = "SELECT * FROM messages WHERE (sender_id = ? AND receiver_id = ?) OR (sender_id = ? AND receiver_id = ?) ORDER BY sent_at ASC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, user1Id);
            ps.setInt(2, user2Id);
            ps.setInt(3, user2Id);
            ps.setInt(4, user1Id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    messages.add(extractMessageFromResultSet(rs));
                }
            }
        }
        return messages;
    }

    @Override
    public Message update(Message message) throws Exception {
        String sql = "UPDATE messages SET sender_id = ?, receiver_id = ?, content = ?, sent_at = ?, is_read = ? WHERE message_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, message.getSenderId());
            ps.setInt(2, message.getReceiverId());
            ps.setString(3, message.getContent());
            ps.setTimestamp(4, Timestamp.valueOf(message.getSentAt()));
            ps.setBoolean(5, message.isRead());
            ps.setInt(6, message.getMessageId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating message failed, no rows affected.");
            }
        }
        return message;
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM messages WHERE message_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public void markAsRead(int messageId) throws Exception {
        String sql = "UPDATE messages SET is_read = true WHERE message_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, messageId);
            ps.executeUpdate();
        }
    }

    @Override
    public int countUnreadMessages(int userId) throws Exception {
        String sql = "SELECT COUNT(*) FROM messages WHERE receiver_id = ? AND is_read = false";
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
    public List<Message> findRecentMessages(int userId, int limit) throws Exception {
        List<Message> messages = new ArrayList<>();
        String sql = "SELECT * FROM messages WHERE sender_id = ? OR receiver_id = ? ORDER BY sent_at DESC LIMIT ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, userId);
            ps.setInt(3, limit);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    messages.add(extractMessageFromResultSet(rs));
                }
            }
        }
        return messages;
    }

    @Override
    public List<Message> searchMessages(int userId, String keywords) throws Exception {
        List<Message> messages = new ArrayList<>();
        String sql = "SELECT * FROM messages WHERE (sender_id = ? OR receiver_id = ?) AND content LIKE ? ORDER BY sent_at DESC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, userId);
            ps.setString(3, "%" + keywords + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    messages.add(extractMessageFromResultSet(rs));
                }
            }
        }
        return messages;
    }

    private Message extractMessageFromResultSet(ResultSet rs) throws SQLException {
        Message message = new Message();
        message.setMessageId(rs.getInt("message_id"));
        message.setSenderId(rs.getInt("sender_id"));
        message.setReceiverId(rs.getInt("receiver_id"));
        message.setContent(rs.getString("content"));
        message.setSentAt(rs.getTimestamp("sent_at").toLocalDateTime());
        message.setRead(rs.getBoolean("is_read"));
        return message;
    }
}