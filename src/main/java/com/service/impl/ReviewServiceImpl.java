package com.service.impl;

import com.dao.interfaces.ReviewDao;
import com.model.Review;
import com.service.interfaces.ReviewService;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewServiceImpl implements ReviewService {
    private ReviewDao reviewDao;

    public ReviewServiceImpl(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Override
    public Review createReview(Review review) throws Exception {
        validateReview(review);
        return reviewDao.create(review);
    }

    @Override
    public Review getReviewById(int id) throws Exception {
        Review review = reviewDao.findById(id);
        if (review == null) {
            throw new Exception("Review not found with id: " + id);
        }
        return review;
    }

    @Override
    public List<Review> getReviewsByOrderId(int orderId) throws Exception {
        return reviewDao.findByOrderId(orderId);
    }

    @Override
    public List<Review> getReviewsByReviewerId(int reviewerId) throws Exception {
        return reviewDao.findByReviewerId(reviewerId);
    }

    @Override
    public List<Review> getReviewsByGigId(int gigId) throws Exception {
        return reviewDao.findByGigId(gigId);
    }

    @Override
    public Review updateReview(Review review) throws Exception {
        validateReview(review);
        Review existingReview = getReviewById(review.getReviewId());
        if (existingReview == null) {
            throw new Exception("Review not found for update with id: " + review.getReviewId());
        }
        return reviewDao.update(review);
    }

    @Override
    public void deleteReview(int id) throws Exception {
        Review review = getReviewById(id);
        if (review == null) {
            throw new Exception("Review not found for deletion with id: " + id);
        }
        reviewDao.delete(id);
    }

    @Override
    public double calculateAverageRatingForGig(int gigId) throws Exception {
        return reviewDao.calculateAverageRatingForGig(gigId);
    }

    @Override
    public int countReviewsForGig(int gigId) throws Exception {
        return reviewDao.countReviewsForGig(gigId);
    }

    @Override
    public List<Review> getMostRecentReviewsForGig(int gigId, int limit) throws Exception {
        return reviewDao.findMostRecentReviewsForGig(gigId, limit);
    }

    @Override
    public double calculateAverageRatingForSeller(int sellerId) throws Exception {
        // This might require a more complex query involving joins with the Order table
        throw new UnsupportedOperationException("This operation is not yet implemented");
    }

    @Override
    public List<Review> getTopRatedReviews(int limit) throws Exception {
        return reviewDao.findTopRatedReviews(limit);
    }

    @Override
    public boolean hasUserReviewedGig(int userId, int gigId) throws Exception {
        return reviewDao.hasUserReviewedGig(userId, gigId);
    }

    private void validateReview(Review review) throws IllegalArgumentException {
        if (review == null) {
            throw new IllegalArgumentException("Review cannot be null");
        }
        if (review.getOrderId() <= 0) {
            throw new IllegalArgumentException("Invalid order ID");
        }
        if (review.getReviewerId() <= 0) {
            throw new IllegalArgumentException("Invalid reviewer ID");
        }
        if (review.getRating() < 1 || review.getRating() > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
    }

    @Override
    public List<Review> searchReviewsByRatingAndKeyword(int rating, String keyword) throws Exception {
        List<Review> allReviews = reviewDao.findAll();
        return allReviews.stream()
                .filter(review -> review.getRating() == rating &&
                        (review.getComment().toLowerCase().contains(keyword.toLowerCase()) ||
                                String.valueOf(review.getOrderId()).contains(keyword)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Review> searchReviewsByKeyword(String keyword) throws Exception {
        List<Review> allReviews = reviewDao.findAll();
        return allReviews.stream()
                .filter(review -> review.getComment().toLowerCase().contains(keyword.toLowerCase()) ||
                        String.valueOf(review.getOrderId()).contains(keyword))
                .collect(Collectors.toList());
    }
}
