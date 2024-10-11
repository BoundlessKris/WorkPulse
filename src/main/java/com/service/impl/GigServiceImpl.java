package com.service.impl;

import com.dao.interfaces.*;
import com.model.Gig;
import com.service.interfaces.GigService;
import java.util.List;

public class GigServiceImpl implements GigService {
    private GigDao gigDao;
    private ReviewDao reviewDao;
    private OrderDao orderDao;

    public GigServiceImpl(GigDao gigDao, ReviewDao reviewDao, OrderDao orderDao) {
        this.gigDao = gigDao;
        this.reviewDao = reviewDao;
        this.orderDao = orderDao;
    }

    @Override
    public Gig createGig(Gig gig) throws Exception {
        validateGig(gig);
        return gigDao.create(gig);
    }

    @Override
    public Gig getGigById(int id) throws Exception {
        Gig gig = gigDao.findById(id);
        if (gig == null) {
            throw new Exception("Gig not found with id: " + id);
        }
        return gig;
    }

    @Override
    public List<Gig> getAllGigs() throws Exception {
        return gigDao.findAll();
    }

    @Override
    public List<Gig> getGigsBySellerId(int sellerId) throws Exception {
        return gigDao.findBySellerId(sellerId);
    }

    @Override
    public Gig updateGig(Gig gig) throws Exception {
        validateGig(gig);
        Gig existingGig = getGigById(gig.getGigId());
        if (existingGig == null) {
            throw new Exception("Gig not found for update with id: " + gig.getGigId());
        }
        return gigDao.update(gig);
    }

    @Override
    public void deleteGig(int id) throws Exception {
        Gig gig = getGigById(id);
        if (gig == null) {
            throw new Exception("Gig not found for deletion with id: " + id);
        }
        gigDao.delete(id);
    }

    @Override
    public List<Gig> searchGigsByKeyword(String keyword) throws Exception {
        if (keyword == null || keyword.trim().isEmpty()) {
            throw new IllegalArgumentException("Search keyword cannot be empty");
        }
        return gigDao.searchByKeywords(keyword);
    }

    @Override
    public List<Gig> getGigsByCategory(int categoryId) throws Exception {
        if (categoryId <= 0) {
            throw new IllegalArgumentException("Invalid category ID");
        }
        return gigDao.findByCategory(categoryId);
    }

    @Override
    public double getAverageRatingForGig(int gigId) throws Exception {
        return reviewDao.calculateAverageRatingForGig(gigId);
    }

    @Override
    public int getOrderCountForGig(int gigId) throws Exception {
        return orderDao.countByGigId(gigId);
    }

    @Override
    public List<Gig> getFeaturedGigs(int limit) throws Exception {
        // Implementation depends on how you define "featured".
        // This is just an example.
        return gigDao.findTopRated(limit);
    }

    @Override
    public List<Gig> getRecentGigs(int limit) throws Exception {
        return gigDao.findMostRecent(limit);
    }

    @Override
    public List<Gig> getTopRatedGigs(int limit) throws Exception {
        return gigDao.findTopRated(limit);
    }

    @Override
    public boolean isGigOwnedBySeller(int gigId, int sellerId) throws Exception {
        Gig gig = getGigById(gigId);
        return gig != null && gig.getSellerId() == sellerId;
    }

    private void validateGig(Gig gig) throws IllegalArgumentException {
        if (gig == null) {
            throw new IllegalArgumentException("Gig cannot be null");
        }
        if (gig.getTitle() == null || gig.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Gig title cannot be empty");
        }
        if (gig.getDescription() == null || gig.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("Gig description cannot be empty");
        }
        if (gig.getDeliveryTime() <= 0) {
            throw new IllegalArgumentException("Delivery time must be greater than zero");
        }
    }
}
