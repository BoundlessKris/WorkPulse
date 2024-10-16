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

@WebServlet("/tag/update")
public class TagUpdateServlet extends HttpServlet {
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

        int tagId = Integer.parseInt(request.getParameter("id"));
        try {
            Tag tag = tagService.getTagById(tagId);
            request.setAttribute("tag", tag);
            request.getRequestDispatcher("/WEB-INF/jsp/tag/update.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Tag not found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        int tagId = Integer.parseInt(request.getParameter("tagId"));
        String name = request.getParameter("name");

        try {
            Tag tag = tagService.getTagById(tagId);
            tag.setName(name);

            Tag updatedTag = tagService.updateTag(tag);
            response.sendRedirect(request.getContextPath() + "/tag/list");
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/tag/update.jsp").forward(request, response);
        }
    }
}
