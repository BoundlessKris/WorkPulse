package com.service.impl;

import com.dao.interfaces.UserDao;
import com.model.User;
import com.service.interfaces.UserService;
import java.util.List;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User registerUser(User user) throws Exception {
        if (isUsernameAvailable(user.getUsername()) && isEmailAvailable(user.getEmail())) {
            user.setPasswordHash(hashPassword(user.getPasswordHash()));
            return userDao.create(user);
        }
        throw new Exception("Username or email already taken");
    }

    @Override
    public User login(String username, String password) throws Exception {
        User user = userDao.findByUsername(username);
        if (user != null && verifyPassword(password, user.getPasswordHash())) {
            return user;
        }
        throw new Exception("Invalid username or password");
    }

    @Override
    public User getUserById(int id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public User getUserByUsername(String username) throws Exception {
        return userDao.findByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) throws Exception {
        return userDao.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        return userDao.findAll();
    }

    @Override
    public List<User> getUsersByType(String userType) throws Exception {
        return userDao.findByUserType(userType);
    }

    @Override
    public List<User> getUsersBySellerLevel(String sellerLevel) throws Exception {
        return userDao.findBySellerlevel(sellerLevel);
    }

    @Override
    public User updateUser(User user) throws Exception {
        return userDao.update(user);
    }

    @Override
    public void deleteUser(int id) throws Exception {
        userDao.delete(id);
    }

    @Override
    public boolean isUsernameAvailable(String username) throws Exception {
        return userDao.isUsernameAvailable(username);
    }

    @Override
    public boolean isEmailAvailable(String email) throws Exception {
        return userDao.isEmailAvailable(email);
    }

    @Override
    public void changePassword(int userId, String oldPassword, String newPassword) throws Exception {
        User user = getUserById(userId);
        if (user != null && verifyPassword(oldPassword, user.getPasswordHash())) {
            user.setPasswordHash(hashPassword(newPassword));
            userDao.update(user);
        } else {
            throw new Exception("Invalid old password");
        }
    }

    @Override
    public void resetPassword(String email) throws Exception {
        User user = getUserByEmail(email);
        if (user != null) {
            String newPassword = generateRandomPassword();
            user.setPasswordHash(hashPassword(newPassword));
            userDao.update(user);
            // TODO: Send email with new password
        } else {
            throw new Exception("User not found");
        }
    }

    @Override
    public void updateSellerLevel(int userId, String newLevel) throws Exception {
        User user = getUserById(userId);
        if (user != null) {
            user.setSellerLevel(newLevel);
            userDao.update(user);
        } else {
            throw new Exception("User not found");
        }
    }

    @Override
    public int getTotalUsersCount() throws Exception {
        return userDao.getTotalCount();
    }

    @Override
    public List<User> searchUsers(String keyword) throws Exception {
        return userDao.searchByKeyword(keyword);
    }

    private String hashPassword(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedPassword = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    private boolean verifyPassword(String inputPassword, String storedHash) throws Exception {
        String hashedInput = hashPassword(inputPassword);
        return hashedInput.equals(storedHash);
    }

    private String generateRandomPassword() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[10];
        random.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }
}
