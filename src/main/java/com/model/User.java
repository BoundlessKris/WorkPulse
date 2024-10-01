package com.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {

    private int userId;
    private String username;
    private String email;
    private String passwordHash;
    private String userType;
    private String sellerLevel;
    private LocalDateTime createdAt;
    private String profilePicture;
    private String description;

    public User() {
    }

    public User(int userId, String username, String email, String passwordHash, String userType, String sellerLevel, LocalDateTime createdAt, String profilePicture, String description) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.userType = userType;
        this.sellerLevel = sellerLevel;
        this.createdAt = createdAt;
        this.profilePicture = profilePicture;
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getSellerLevel() {
        return sellerLevel;
    }

    public void setSellerLevel(String sellerLevel) {
        this.sellerLevel = sellerLevel;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", userType='" + userType + '\'' +
                ", sellerLevel='" + sellerLevel + '\'' +
                ", createdAt=" + createdAt +
                ", profilePicture='" + profilePicture + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(passwordHash, user.passwordHash) && Objects.equals(userType, user.userType) && Objects.equals(sellerLevel, user.sellerLevel) && Objects.equals(createdAt, user.createdAt) && Objects.equals(profilePicture, user.profilePicture) && Objects.equals(description, user.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, email, passwordHash, userType, sellerLevel, createdAt, profilePicture, description);
    }
}
