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

@WebServlet("/message/search")
public class MessageSearchServlet extends HttpServlet {
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
        String keyword = request.getParameter("keyword");

        try {
            List<Message> messages = messageService.searchMessages(currentUser.getUserId(), keyword);
            request.setAttribute("messages", messages);
            request.setAttribute("keyword", keyword);
            request.getRequestDispatcher("/WEB-INF/jsp/message/searchResults.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
