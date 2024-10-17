package com.controller.review;

import com.model.Review;
import com.model.User;
import com.service.impl.ReviewServiceImpl;
import com.service.interfaces.ReviewService;
import com.dao.impl.ReviewDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/review/update")
public class ReviewUpdateServlet extends HttpServlet {
    private ReviewService reviewService;

    @Override
    public void init() throws ServletException {
        reviewService = new ReviewServiceImpl(new ReviewDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        int reviewId = Integer.parseInt(request.getParameter("id"));
        try {
            Review review = reviewService.getReviewById(reviewId);
            request.setAttribute("review", review);
            request.getRequestDispatcher("/WEB-INF/jsp/review/update.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Review not found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        User user = (User) session.getAttribute("user");
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        int rating = Integer.parseInt(request.getParameter("rating"));
        String comment = request.getParameter("comment");

        try {
            Review review = reviewService.getReviewById(reviewId);
            if (review.getReviewerId() != user.getUserId()) {
                throw new IllegalStateException("You are not authorized to update this review");
            }
            review.setRating(rating);
            review.setComment(comment);

            Review updatedReview = reviewService.updateReview(review);
            response.sendRedirect(request.getContextPath() + "/order/details?id=" + updatedReview.getOrderId());
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/review/update.jsp").forward(request, response);
        }
    }
}
