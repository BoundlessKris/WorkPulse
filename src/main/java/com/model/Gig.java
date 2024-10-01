package com.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Gig {

    private int gigId;
    private int sellerId;
    private String title;
    private String description;
    private int deliveryTime;
    private LocalDateTime createdAt;

    public Gig() {
    }

    public Gig(int gigId, int sellerId, String description, String title, int deliveryTime, LocalDateTime createdAt) {
        this.gigId = gigId;
        this.sellerId = sellerId;
        this.description = description;
        this.title = title;
        this.deliveryTime = deliveryTime;
        this.createdAt = createdAt;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getGigId() {
        return gigId;
    }

    public void setGigId(int gigId) {
        this.gigId = gigId;
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

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Gig{" +
                "gigId=" + gigId +
                ", sellerId=" + sellerId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deliveryTime=" + deliveryTime +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gig gig = (Gig) o;
        return gigId == gig.gigId && sellerId == gig.sellerId && deliveryTime == gig.deliveryTime && Objects.equals(title, gig.title) && Objects.equals(description, gig.description) && Objects.equals(createdAt, gig.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gigId, sellerId, title, description, deliveryTime, createdAt);
    }
}
