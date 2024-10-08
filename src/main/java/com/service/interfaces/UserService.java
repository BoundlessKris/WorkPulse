package com.service.interfaces;

import com.model.User;

import java.util.List;

public interface UserService {
    User registerUser(User user) throws Exception;

    User login(String username, String password) throws Exception;

    User getUserById(int id) throws Exception;

    User getUserByUsername(String username) throws Exception;

    User getUserByEmail(String email) throws Exception;

    List<User> getAllUsers() throws Exception;

    List<User> getUsersByType(String userType) throws Exception;

    List<User> getUsersBySellerLevel(String sellerLevel) throws Exception;

    User updateUser(User user) throws Exception;

    void deleteUser(int id) throws Exception;

    boolean isUsernameAvailable(String username) throws Exception;

    boolean isEmailAvailable(String email) throws Exception;

    void changePassword(int userId, String oldPassword, String newPassword) throws Exception;

    void resetPassword(String email) throws Exception;

    void updateSellerLevel(int userId, String newLevel) throws Exception;

    int getTotalUsersCount() throws Exception;

    List<User> searchUsers(String keyword) throws Exception;
}
