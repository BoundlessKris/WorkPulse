package com.service.impl;

import com.dao.interfaces.GigPriceDao;
import com.model.GigPrice;
import com.service.interfaces.GigPriceService;
import java.util.List;

public class GigPriceServiceImpl implements GigPriceService {
    private GigPriceDao gigPriceDao;

    public GigPriceServiceImpl(GigPriceDao gigPriceDao) {
        this.gigPriceDao = gigPriceDao;
    }

    @Override
    public GigPrice createGigPrice(GigPrice gigPrice) throws Exception {
        validateGigPrice(gigPrice);
        return gigPriceDao.create(gigPrice);
    }

    @Override
    public GigPrice getGigPriceById(int id) throws Exception {
        GigPrice gigPrice = gigPriceDao.findById(id);
        if (gigPrice == null) {
            throw new Exception("GigPrice not found with id: " + id);
        }
        return gigPrice;
    }

    @Override
    public List<GigPrice> getGigPricesByGigId(int gigId) throws Exception {
        return gigPriceDao.findByGigId(gigId);
    }

    @Override
    public GigPrice updateGigPrice(GigPrice gigPrice) throws Exception {
        validateGigPrice(gigPrice);
        GigPrice existingGigPrice = getGigPriceById(gigPrice.getPriceId());
        if (existingGigPrice == null) {
            throw new Exception("GigPrice not found for update with id: " + gigPrice.getPriceId());
        }
        return gigPriceDao.update(gigPrice);
    }

    @Override
    public void deleteGigPrice(int id) throws Exception {
        GigPrice gigPrice = getGigPriceById(id);
        if (gigPrice == null) {
            throw new Exception("GigPrice not found for deletion with id: " + id);
        }
        gigPriceDao.delete(id);
    }

    @Override
    public GigPrice getBasePriceForGig(int gigId) throws Exception {
        return gigPriceDao.findBasePrice(gigId);
    }

    @Override
    public List<GigPrice> getPricesInRange(double minPrice, double maxPrice) throws Exception {
        if (minPrice < 0 || maxPrice < minPrice) {
            throw new IllegalArgumentException("Invalid price range");
        }
        return gigPriceDao.findByPriceRange(minPrice, maxPrice);
    }

    @Override
    public boolean hasMultipleTiers(int gigId) throws Exception {
        return gigPriceDao.hasMultipleTiers(gigId);
    }

    @Override
    public GigPrice getHighestTierForGig(int gigId) throws Exception {
        return gigPriceDao.findHighestTier(gigId);
    }

    private void validateGigPrice(GigPrice gigPrice) throws IllegalArgumentException {
        if (gigPrice == null) {
            throw new IllegalArgumentException("GigPrice cannot be null");
        }
        if (gigPrice.getGigId() <= 0) {
            throw new IllegalArgumentException("Invalid Gig ID");
        }
        if (gigPrice.getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        if (gigPrice.getTierName() == null || gigPrice.getTierName().trim().isEmpty()) {
            throw new IllegalArgumentException("Tier name cannot be empty");
        }
    }
}