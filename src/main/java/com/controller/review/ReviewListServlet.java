package com.controller.review;

import com.model.Review;
import com.service.impl.ReviewServiceImpl;
import com.service.interfaces.ReviewService;
import com.dao.impl.ReviewDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/review/list")
public class ReviewListServlet extends HttpServlet {
    private ReviewService reviewService;

    @Override
    public void init() throws ServletException {
        reviewService = new ReviewServiceImpl(new ReviewDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            List<Review> reviews;
            if ("gig".equals(type)) {
                reviews = reviewService.getReviewsByGigId(id);
            } else if ("reviewer".equals(type)) {
                reviews = reviewService.getReviewsByReviewerId(id);
            } else {
                throw new IllegalArgumentException("Invalid list type");
            }
            request.setAttribute("reviews", reviews);
            request.getRequestDispatcher("/WEB-INF/jsp/review/list.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
