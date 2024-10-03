package com.dao.impl;

import com.dao.interfaces.UserDao;
import com.model.User;
import com.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public User create(User user) throws Exception {
        String sql = "INSERT INTO users (username, email, password_hash, user_type, seller_level, created_at) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPasswordHash());
            ps.setString(4, user.getUserType());
            ps.setString(5, user.getSellerLevel());
            ps.setTimestamp(6, Timestamp.valueOf(user.getCreatedAt()));

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setUserId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }
        return user;
    }

    @Override
    public User findById(int id) throws Exception {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractUserFromResultSet(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() throws Exception {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                users.add(extractUserFromResultSet(rs));
            }
        }
        return users;
    }

    @Override
    public User update(User user) throws Exception {
        String sql = "UPDATE users SET username = ?, email = ?, password_hash = ?, user_type = ?, seller_level = ? WHERE user_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPasswordHash());
            ps.setString(4, user.getUserType());
            ps.setString(5, user.getSellerLevel());
            ps.setInt(6, user.getUserId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating user failed, no rows affected.");
            }
        }
        return user;
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM users WHERE user_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public User findByUsername(String username) throws Exception {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractUserFromResultSet(rs);
                }
            }
        }
        return null;
    }

    @Override
    public User findByEmail(String email) throws Exception {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractUserFromResultSet(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<User> findBySellerlevel(String sellerLevel) throws Exception {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE seller_level = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, sellerLevel);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    users.add(extractUserFromResultSet(rs));
                }
            }
        }
        return users;
    }

    @Override
    public boolean isUsernameAvailable(String username) throws Exception {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) == 0;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isEmailAvailable(String email) throws Exception {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) == 0;
                }
            }
        }
        return false;
    }

    @Override
    public List<User> findByUserType(String userType) throws Exception {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE user_type = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, userType);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    users.add(extractUserFromResultSet(rs));
                }
            }
        }
        return users;
    }

    @Override
    public int getTotalCount() throws Exception {
        String sql = "SELECT COUNT(*) FROM users";
        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }

    @Override
    public List<User> searchByKeyword(String keyword) throws Exception {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE username LIKE ? OR email LIKE ? OR description LIKE ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            String searchPattern = "%" + keyword + "%";
            ps.setString(1, searchPattern);
            ps.setString(2, searchPattern);
            ps.setString(3, searchPattern);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    users.add(extractUserFromResultSet(rs));
                }
            }
        }
        return users;
    }

    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setPasswordHash(rs.getString("password_hash"));
        user.setUserType(rs.getString("user_type"));
        user.setSellerLevel(rs.getString("seller_level"));
        user.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        return user;
    }
}
