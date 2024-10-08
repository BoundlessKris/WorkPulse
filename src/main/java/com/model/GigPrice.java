package com.model;

import java.util.Objects;

public class GigPrice {

    private int priceId;
    private int gigId;
    private String tierName;
    private double price;
    private String description;

    public GigPrice() {
    }

    public GigPrice(int priceId, int gigId, String tierName, double price, String description) {
        this.priceId = priceId;
        this.gigId = gigId;
        this.tierName = tierName;
        this.price = price;
        this.description = description;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public int getGigId() {
        return gigId;
    }

    public void setGigId(int gigId) {
        this.gigId = gigId;
    }

    public String getTierName() {
        return tierName;
    }

    public void setTierName(String tierName) {
        this.tierName = tierName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "GigPrice{" +
                "priceId=" + priceId +
                ", gigId=" + gigId +
                ", tierName='" + tierName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GigPrice gigPrice = (GigPrice) o;
        return priceId == gigPrice.priceId && gigId == gigPrice.gigId && Objects.equals(tierName, gigPrice.tierName) && Objects.equals(price, gigPrice.price) && Objects.equals(description, gigPrice.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceId, gigId, tierName, price, description);
    }
}
