package com.controller.message;

import com.model.Message;
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
import java.time.LocalDateTime;

@WebServlet("/message/send")
public class MessageSendServlet extends HttpServlet {
    private MessageService messageService;

    @Override
    public void init() throws ServletException {
        messageService = new MessageServiceImpl(new MessageDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        int receiverId = Integer.parseInt(request.getParameter("receiverId"));
        request.setAttribute("receiverId", receiverId);
        request.getRequestDispatcher("/WEB-INF/jsp/message/send.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        User sender = (User) session.getAttribute("user");
        int receiverId = Integer.parseInt(request.getParameter("receiverId"));
        String content = request.getParameter("content");

        Message message = new Message();
        message.setSenderId(sender.getUserId());
        message.setReceiverId(receiverId);
        message.setContent(content);
        message.setSentAt(LocalDateTime.now());
        message.setRead(false);

        try {
            Message sentMessage = messageService.sendMessage(message);
            response.sendRedirect(request.getContextPath() + "/message/conversation?userId=" + receiverId);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/message/send.jsp").forward(request, response);
        }
    }
}
