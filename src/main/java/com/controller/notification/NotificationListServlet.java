package com.controller.notification;

import com.model.Notification;
import com.model.User;
import com.service.interfaces.NotificationService;
import com.dao.impl.NotificationDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/notification/list")
public class NotificationListServlet extends HttpServlet {
    private NotificationService notificationService;

    @Override
    public void init() throws ServletException {
        notificationService = new NotificationServiceImpl(new NotificationDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        User currentUser = (User) session.getAttribute("user");

        try {
            List<Notification> notifications = notificationService.getNotificationsByUserId(currentUser.getUserId());
            request.setAttribute("notifications", notifications);
            request.getRequestDispatcher("/WEB-INF/jsp/notification/list.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
