package com.controller.notification;

import com.model.User;
import com.service.impl.NotificationServiceImpl;
import com.service.interfaces.NotificationService;
import com.dao.impl.NotificationDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/notification/cleanup")
public class NotificationCleanupServlet extends HttpServlet {
    private NotificationService notificationService;

    @Override
    public void init() throws ServletException {
        notificationService = new NotificationServiceImpl(new NotificationDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        User currentUser = (User) session.getAttribute("user");
        LocalDateTime beforeDate = LocalDateTime.now().minusDays(30); // Delete notifications older than 30 days

        try {
            notificationService.deleteOldNotifications(currentUser.getUserId(), beforeDate);
            response.sendRedirect(request.getContextPath() + "/notification/list");
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/notification/list");
        }
    }
}
