package com.controller.gigtag;

import com.model.Tag;
import com.service.interfaces.GigTagService;
import com.service.impl.GigTagServiceImpl;
import com.dao.impl.GigTagDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/gigtag/list")
public class GigTagListServlet extends HttpServlet {
    private GigTagService gigTagService;

    @Override
    public void init() throws ServletException {
        gigTagService = new GigTagServiceImpl(new GigTagDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int gigId = Integer.parseInt(request.getParameter("gigId"));

        try {
            List<Tag> tags = gigTagService.getTagsByGigId(gigId);
            request.setAttribute("tags", tags);
            request.setAttribute("gigId", gigId);
            request.getRequestDispatcher("/WEB-INF/jsp/gigtag/list.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
