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
import java.util.List;

@WebServlet("/message/list")
public class MessageListServlet extends HttpServlet {
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

        User currentUser = (User) session.getAttribute("user");
        String type = request.getParameter("type");

        try {
            List<Message> messages;
            if ("sent".equals(type)) {
                messages = messageService.getMessagesBySenderId(currentUser.getUserId());
            } else if ("received".equals(type)) {
                messages = messageService.getMessagesByReceiverId(currentUser.getUserId());
            } else {
                throw new IllegalArgumentException("Invalid message type");
            }
            request.setAttribute("messages", messages);
            request.setAttribute("type", type);
            request.getRequestDispatcher("/WEB-INF/jsp/message/list.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
