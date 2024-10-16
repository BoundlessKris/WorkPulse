package com.controller.tag;

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

@WebServlet("/tag/delete")
public class TagDeleteServlet extends HttpServlet {
    private TagService tagService;

    @Override
    public void init() throws ServletException {
        tagService = new TagServiceImpl(new TagDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        int tagId = Integer.parseInt(request.getParameter("tagId"));
        try {
            tagService.deleteTag(tagId);
            response.sendRedirect(request.getContextPath() + "/tag/list");
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/tag/list");
        }
    }
}
