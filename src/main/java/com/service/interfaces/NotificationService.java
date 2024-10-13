package com.service.interfaces;

import com.model.Notification;
import java.time.LocalDateTime;
import java.util.List;

public interface NotificationService {
    Notification createNotification(Notification notification) throws Exception;
    Notification getNotificationById(int id) throws Exception;
    List<Notification> getNotificationsByUserId(int userId) throws Exception;
    Notification updateNotification(Notification notification) throws Exception;
    void deleteNotification(int id) throws Exception;
    void markNotificationAsRead(int notificationId) throws Exception;
    int countUnreadNotifications(int userId) throws Exception;
    List<Notification> getRecentNotifications(int userId, int limit) throws Exception;
    List<Notification> getNotificationsByType(int userId, String type) throws Exception;
    void deleteOldNotifications(int userId, LocalDateTime beforeDate) throws Exception;
    void markAllNotificationsAsRead(int userId) throws Exception;
    void sendSystemNotification(int userId, String content) throws Exception;
}
