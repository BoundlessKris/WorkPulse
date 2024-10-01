package com.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class BuyerRequest {

    private int requestId;
    private int buyerId;
    private String title;
    private String description;
    private BigDecimal budget;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;

    public BuyerRequest(int requestId, int buyerId, String title, String description, BigDecimal budget, LocalDateTime createdAt, LocalDateTime expiresAt) {
        this.requestId = requestId;
        this.buyerId = buyerId;
        this.title = title;
        this.description = description;
        this.budget = budget;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Override
    public String toString() {
        return "BuyerRequest{" +
                "requestId=" + requestId +
                ", buyerId=" + buyerId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", budget=" + budget +
                ", createdAt=" + createdAt +
                ", expiresAt=" + expiresAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyerRequest that = (BuyerRequest) o;
        return requestId == that.requestId && buyerId == that.buyerId && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(budget, that.budget) && Objects.equals(createdAt, that.createdAt) && Objects.equals(expiresAt, that.expiresAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, buyerId, title, description, budget, createdAt, expiresAt);
    }
}
