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

@WebServlet("/notification/delete")
public class NotificationDeleteServlet extends HttpServlet {
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
        int notificationId = Integer.parseInt(request.getParameter("notificationId"));

        try {
            notificationService.deleteNotification(notificationId);
            response.sendRedirect(request.getContextPath() + "/notification/list");
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/notification/list");
        }
    }
}
