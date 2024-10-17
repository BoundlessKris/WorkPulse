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
import java.time.LocalDateTime;

@WebServlet("/review/create")
public class ReviewCreateServlet extends HttpServlet {
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

        int orderId = Integer.parseInt(request.getParameter("orderId"));
        request.setAttribute("orderId", orderId);
        request.getRequestDispatcher("/WEB-INF/jsp/review/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        User reviewer = (User) session.getAttribute("user");
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        int rating = Integer.parseInt(request.getParameter("rating"));
        String comment = request.getParameter("comment");

        Review review = new Review();
        review.setOrderId(orderId);
        review.setReviewerId(reviewer.getUserId());
        review.setRating(rating);
        review.setComment(comment);
        review.setCreatedAt(LocalDateTime.now());

        try {
            Review createdReview = reviewService.createReview(review);
            response.sendRedirect(request.getContextPath() + "/order/details?id=" + orderId);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/review/create.jsp").forward(request, response);
        }
    }
}
