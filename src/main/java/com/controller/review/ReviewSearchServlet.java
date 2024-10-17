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

@WebServlet("/review/search")
public class ReviewSearchServlet extends HttpServlet {
    private ReviewService reviewService;

    @Override
    public void init() throws ServletException {
        reviewService = new ReviewServiceImpl(new ReviewDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        int rating = Integer.parseInt(request.getParameter("rating"));

        try {
            List<Review> reviews;
            if (rating > 0) {
                reviews = reviewService.searchReviewsByRatingAndKeyword(rating, keyword);
            } else {
                reviews = reviewService.searchReviewsByKeyword(keyword);
            }
            request.setAttribute("reviews", reviews);
            request.setAttribute("keyword", keyword);
            request.setAttribute("rating", rating);
            request.getRequestDispatcher("/WEB-INF/jsp/review/searchResults.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
