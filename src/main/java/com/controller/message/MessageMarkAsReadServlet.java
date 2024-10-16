package com.controller.message;

import com.model.User;
import com.service.interfaces.MessageService;
import com.service.impl.MessageServiceImpl;
import com.dao.impl.MessageDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/message/markAsRead")
public class MessageMarkAsReadServlet extends HttpServlet {
    private MessageService messageService;

    @Override
    public void init() throws ServletException {
        messageService = new MessageServiceImpl(new MessageDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        User currentUser = (User) session.getAttribute("user");
        int messageId = Integer.parseInt(request.getParameter("messageId"));

        try {
            messageService.markMessageAsRead(messageId);
            response.sendRedirect(request.getHeader("referer"));
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            response.sendRedirect(request.getHeader("referer"));
        }
    }
}
