package com.service.impl;

import com.dao.interfaces.NotificationDao;
import com.model.Notification;
import com.service.interfaces.NotificationService;
import java.time.LocalDateTime;
import java.util.List;

public class NotificationServiceImpl implements NotificationService {
    private NotificationDao notificationDao;

    public NotificationServiceImpl(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    @Override
    public Notification createNotification(Notification notification) throws Exception {
        validateNotification(notification);
        return notificationDao.create(notification);
    }

    @Override
    public Notification getNotificationById(int id) throws Exception {
        Notification notification = notificationDao.findById(id);
        if (notification == null) {
            throw new Exception("Notification not found with id: " + id);
        }
        return notification;
    }

    @Override
    public List<Notification> getNotificationsByUserId(int userId) throws Exception {
        return notificationDao.findByUserId(userId);
    }

    @Override
    public Notification updateNotification(Notification notification) throws Exception {
        validateNotification(notification);
        Notification existingNotification = getNotificationById(notification.getNotificationId());
        if (existingNotification == null) {
            throw new Exception("Notification not found for update with id: " + notification.getNotificationId());
        }
        return notificationDao.update(notification);
    }

    @Override
    public void deleteNotification(int id) throws Exception {
        Notification notification = getNotificationById(id);
        if (notification == null) {
            throw new Exception("Notification not found for deletion with id: " + id);
        }
        notificationDao.delete(id);
    }

    @Override
    public void markNotificationAsRead(int notificationId) throws Exception {
        notificationDao.markAsRead(notificationId);
    }

    @Override
    public int countUnreadNotifications(int userId) throws Exception {
        return notificationDao.countUnreadNotifications(userId);
    }

    @Override
    public List<Notification> getRecentNotifications(int userId, int limit) throws Exception {
        return notificationDao.findRecentNotifications(userId, limit);
    }

    @Override
    public List<Notification> getNotificationsByType(int userId, String type) throws Exception {
        return notificationDao.findByType(userId, type);
    }

    @Override
    public void deleteOldNotifications(int userId, LocalDateTime beforeDate) throws Exception {
        notificationDao.deleteOldNotifications(userId, beforeDate);
    }

    @Override
    public void markAllNotificationsAsRead(int userId) throws Exception {
        notificationDao.markAllAsRead(userId);
    }

    @Override
    public void sendSystemNotification(int userId, String content) throws Exception {
        Notification notification = new Notification();
        notification.setUserId(userId);
        notification.setType("SYSTEM");
        notification.setContent(content);
        notification.setCreatedAt(LocalDateTime.now());
        notification.setRead(false);
        createNotification(notification);
    }

    private void validateNotification(Notification notification) throws IllegalArgumentException {
        if (notification == null) {
            throw new IllegalArgumentException("Notification cannot be null");
        }
        if (notification.getUserId() <= 0) {
            throw new IllegalArgumentException("Invalid user ID");
        }
        if (notification.getType() == null || notification.getType().trim().isEmpty()) {
            throw new IllegalArgumentException("Notification type cannot be empty");
        }
        if (notification.getContent() == null || notification.getContent().trim().isEmpty()) {
            throw new IllegalArgumentException("Notification content cannot be empty");
        }
    }
}
