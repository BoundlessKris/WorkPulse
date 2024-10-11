package com.controller.gig;

import com.dao.impl.OrderDaoImpl;
import com.dao.impl.ReviewDaoImpl;
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

@WebServlet("/gig/search")
public class GigSearchServlet extends HttpServlet {
    private GigService gigService;

    @Override
    public void init() throws ServletException {
        GigDaoImpl gigDao = new GigDaoImpl();
        ReviewDaoImpl reviewDao = new ReviewDaoImpl();
        OrderDaoImpl orderDao = new OrderDaoImpl();
        gigService = new GigServiceImpl(gigDao, reviewDao, orderDao);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        try {
            List<Gig> gigs = gigService.searchGigsByKeyword(keyword);
            request.setAttribute("gigs", gigs);
            request.setAttribute("keyword", keyword);
            request.getRequestDispatcher("/WEB-INF/jsp/gig/searchResults.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
