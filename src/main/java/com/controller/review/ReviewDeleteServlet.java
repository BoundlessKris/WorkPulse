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

@WebServlet("/review/delete")
public class ReviewDeleteServlet extends HttpServlet {
    private ReviewService reviewService;

    @Override
    public void init() throws ServletException {
        reviewService = new ReviewServiceImpl(new ReviewDaoImpl());
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

        try {
            Review review = reviewService.getReviewById(reviewId);
            if (review.getReviewerId() != user.getUserId() && !"admin".equals(user.getUserType())) {
                throw new IllegalStateException("You are not authorized to delete this review");
            }
            reviewService.deleteReview(reviewId);
            response.sendRedirect(request.getContextPath() + "/order/details?id=" + review.getOrderId());
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/order/list");
        }
    }
}
