package com.controller.gig;

import com.model.Gig;
import com.service.interfaces.GigService;
import com.service.impl.GigServiceImpl;
import com.dao.impl.GigDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/gig/list")
public class GigListServlet extends HttpServlet {
    private GigService gigService;

    @Override
    public void init() throws ServletException {
        gigService = new GigServiceImpl(new GigDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Gig> gigs = gigService.getAllGigs();
            request.setAttribute("gigs", gigs);
            request.getRequestDispatcher("/WEB-INF/jsp/gig/list.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
