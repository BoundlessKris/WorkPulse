package com.controller.tag;

import com.model.Tag;
import com.service.interfaces.TagService;
import com.service.impl.TagServiceImpl;
import com.dao.impl.TagDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tag/search")
public class TagSearchServlet extends HttpServlet {
    private TagService tagService;

    @Override
    public void init() throws ServletException {
        tagService = new TagServiceImpl(new TagDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        try {
            List<Tag> tags = tagService.searchTagsByPartialName(keyword);
            request.setAttribute("tags", tags);
            request.setAttribute("keyword", keyword);
            request.getRequestDispatcher("/WEB-INF/jsp/tag/searchResults.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
