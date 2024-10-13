package com.service.impl;

import com.dao.interfaces.BuyerRequestDao;
import com.model.BuyerRequest;
import com.service.interfaces.BuyerRequestService;
import java.time.LocalDateTime;
import java.util.List;

public class BuyerRequestServiceImpl implements BuyerRequestService {
    private BuyerRequestDao buyerRequestDao;

    public BuyerRequestServiceImpl(BuyerRequestDao buyerRequestDao) {
        this.buyerRequestDao = buyerRequestDao;
    }

    @Override
    public BuyerRequest createBuyerRequest(BuyerRequest request) throws Exception {
        validateBuyerRequest(request);
        return buyerRequestDao.create(request);
    }

    @Override
    public BuyerRequest getBuyerRequestById(int id) throws Exception {
        BuyerRequest request = buyerRequestDao.findById(id);
        if (request == null) {
            throw new Exception("BuyerRequest not found with id: " + id);
        }
        return request;
    }

    @Override
    public List<BuyerRequest> getBuyerRequestsByBuyerId(int buyerId) throws Exception {
        return buyerRequestDao.findByBuyerId(buyerId);
    }

    @Override
    public List<BuyerRequest> getActiveBuyerRequests() throws Exception {
        return buyerRequestDao.findActive();
    }

    @Override
    public BuyerRequest updateBuyerRequest(BuyerRequest request) throws Exception {
        validateBuyerRequest(request);
        BuyerRequest existingRequest = getBuyerRequestById(request.getRequestId());
        if (existingRequest == null) {
            throw new Exception("BuyerRequest not found for update with id: " + request.getRequestId());
        }
        return buyerRequestDao.update(request);
    }

    @Override
    public void deleteBuyerRequest(int id) throws Exception {
        BuyerRequest request = getBuyerRequestById(id);
        if (request == null) {
            throw new Exception("BuyerRequest not found for deletion with id: " + id);
        }
        buyerRequestDao.delete(id);
    }

    @Override
    public List<BuyerRequest> getBuyerRequestsByCategory(int categoryId) throws Exception {
        return buyerRequestDao.findByCategory(categoryId);
    }

    @Override
    public List<BuyerRequest> searchBuyerRequestsByKeywords(String keywords) throws Exception {
        return buyerRequestDao.searchByKeywords(keywords);
    }

    @Override
    public int countOffersForRequest(int requestId) throws Exception {
        return buyerRequestDao.countOffersForRequest(requestId);
    }

    @Override
    public List<BuyerRequest> getBuyerRequestsExpiringSoon(int withinHours) throws Exception {
        return buyerRequestDao.findExpiringSoon(withinHours);
    }

    @Override
    public int markExpiredBuyerRequests(LocalDateTime currentTime) throws Exception {
        return buyerRequestDao.markExpiredRequests(currentTime);
    }

    @Override
    public List<BuyerRequest> getRecentBuyerRequests(int limit) throws Exception {
        // Assuming we want to get the most recent active requests
        List<BuyerRequest> activeRequests = buyerRequestDao.findActive();
        return activeRequests.subList(0, Math.min(limit, activeRequests.size()));
    }

    private void validateBuyerRequest(BuyerRequest request) throws IllegalArgumentException {
        if (request == null) {
            throw new IllegalArgumentException("BuyerRequest cannot be null");
        }
        if (request.getBuyerId() <= 0) {
            throw new IllegalArgumentException("Invalid buyer ID");
        }
        if (request.getTitle() == null || request.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("BuyerRequest title cannot be empty");
        }
        if (request.getDescription() == null || request.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("BuyerRequest description cannot be empty");
        }
        if (request.getBudget() != null && request.getBudget().doubleValue() < 0) {
            throw new IllegalArgumentException("BuyerRequest budget cannot be negative");
        }
        if (request.getExpiresAt() == null || request.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("BuyerRequest expiration date must be in the future");
        }
    }
}
