package com.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {
    private int orderId;
    private int gigId;
    private int buyerId;
    private int sellerId;
    private int priceId;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

    public Order() {
    }

    public Order(int orderId, int gigId, int buyerId, int sellerId, int priceId, String status, LocalDateTime createdAt, LocalDateTime completedAt) {
        this.orderId = orderId;
        this.gigId = gigId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.priceId = priceId;
        this.status = status;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getGigId() {
        return gigId;
    }

    public void setGigId(int gigId) {
        this.gigId = gigId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", gigId=" + gigId +
                ", buyerId=" + buyerId +
                ", sellerId=" + sellerId +
                ", priceId=" + priceId +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", completedAt=" + completedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && gigId == order.gigId && buyerId == order.buyerId && sellerId == order.sellerId && priceId == order.priceId && Objects.equals(status, order.status) && Objects.equals(createdAt, order.createdAt) && Objects.equals(completedAt, order.completedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, gigId, buyerId, sellerId, priceId, status, createdAt, completedAt);
    }
}
