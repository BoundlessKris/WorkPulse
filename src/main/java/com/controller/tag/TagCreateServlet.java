package com.controller.tag;

import com.model.Tag;
import com.model.User;
import com.service.interfaces.TagService;
import com.service.impl.TagServiceImpl;
import com.dao.impl.TagDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/tag/create")
public class TagCreateServlet extends HttpServlet {
    private TagService tagService;

    @Override
    public void init() throws ServletException {
        tagService = new TagServiceImpl(new TagDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/jsp/tag/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        String name = request.getParameter("name");

        Tag tag = new Tag();
        tag.setName(name);

        try {
            Tag createdTag = tagService.createTag(tag);
            response.sendRedirect(request.getContextPath() + "/tag/list");
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/tag/create.jsp").forward(request, response);
        }
    }
}
