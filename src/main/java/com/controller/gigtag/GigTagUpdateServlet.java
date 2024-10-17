package com.controller.gigtag;

import com.model.User;
import com.service.interfaces.GigTagService;
import com.service.impl.GigTagServiceImpl;
import com.dao.impl.GigTagDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/gigtag/update")
public class GigTagUpdateServlet extends HttpServlet {
    private GigTagService gigTagService;

    @Override
    public void init() throws ServletException {
        gigTagService = new GigTagServiceImpl(new GigTagDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        int gigId = Integer.parseInt(request.getParameter("gigId"));
        String[] tagIdsArray = request.getParameterValues("tagIds");
        List<Integer> tagIds = tagIdsArray == null ? List.of() :
                Arrays.stream(tagIdsArray).map(Integer::parseInt).collect(Collectors.toList());

        try {
            gigTagService.updateGigTags(gigId, tagIds);
            response.sendRedirect(request.getContextPath() + "/gig/details?id=" + gigId);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/gig/details?id=" + gigId);
        }
    }
}