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
    private double totalAmount;

    public Order() {
    }

    public Order(int orderId, int gigId, int buyerId, int sellerId, LocalDateTime createdAt, int priceId, String status, LocalDateTime completedAt, double totalAmount) {
        this.orderId = orderId;
        this.gigId = gigId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.createdAt = createdAt;
        this.priceId = priceId;
        this.status = status;
        this.completedAt = completedAt;
        this.totalAmount = totalAmount;
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
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
                ", totalAmount=" + totalAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && gigId == order.gigId && buyerId == order.buyerId && sellerId == order.sellerId && priceId == order.priceId && Double.compare(totalAmount, order.totalAmount) == 0 && Objects.equals(status, order.status) && Objects.equals(createdAt, order.createdAt) && Objects.equals(completedAt, order.completedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, gigId, buyerId, sellerId, priceId, status, createdAt, completedAt, totalAmount);
    }
}
