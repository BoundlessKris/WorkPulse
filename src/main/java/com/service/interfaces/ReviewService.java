package com.service.interfaces;

import com.model.Review;
import java.util.List;

public interface ReviewService {
    Review createReview(Review review) throws Exception;
    Review getReviewById(int id) throws Exception;
    List<Review> getReviewsByOrderId(int orderId) throws Exception;
    List<Review> getReviewsByReviewerId(int reviewerId) throws Exception;
    List<Review> getReviewsByGigId(int gigId) throws Exception;
    Review updateReview(Review review) throws Exception;
    void deleteReview(int id) throws Exception;
    double calculateAverageRatingForGig(int gigId) throws Exception;
    int countReviewsForGig(int gigId) throws Exception;
    List<Review> getMostRecentReviewsForGig(int gigId, int limit) throws Exception;
    double calculateAverageRatingForSeller(int sellerId) throws Exception;
    List<Review> getTopRatedReviews(int limit) throws Exception;
    boolean hasUserReviewedGig(int userId, int gigId) throws Exception;

    List<Review> searchReviewsByRatingAndKeyword(int rating, String keyword) throws Exception;
    List<Review> searchReviewsByKeyword(String keyword) throws Exception;
}
