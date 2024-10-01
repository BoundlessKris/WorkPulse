package com.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Review {
    private int reviewId;
    private int orderId;
    private int reviewerId;
    private int rating;
    private String comment;
    private LocalDateTime createdAt;

    public Review() {
    }

    public Review(int reviewId, int orderId, int reviewerId, int rating, String comment, LocalDateTime createdAt) {
        this.reviewId = reviewId;
        this.orderId = orderId;
        this.reviewerId = reviewerId;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = createdAt;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(int reviewerId) {
        this.reviewerId = reviewerId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", orderId=" + orderId +
                ", reviewerId=" + reviewerId +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return reviewId == review.reviewId && orderId == review.orderId && reviewerId == review.reviewerId && rating == review.rating && Objects.equals(comment, review.comment) && Objects.equals(createdAt, review.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, orderId, reviewerId, rating, comment, createdAt);
    }
}
