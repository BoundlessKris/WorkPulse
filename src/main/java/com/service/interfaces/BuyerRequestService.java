package com.service.interfaces;

import com.model.BuyerRequest;
import java.time.LocalDateTime;
import java.util.List;

public interface BuyerRequestService {
    BuyerRequest createBuyerRequest(BuyerRequest request) throws Exception;
    BuyerRequest getBuyerRequestById(int id) throws Exception;
    List<BuyerRequest> getBuyerRequestsByBuyerId(int buyerId) throws Exception;
    List<BuyerRequest> getActiveBuyerRequests() throws Exception;
    BuyerRequest updateBuyerRequest(BuyerRequest request) throws Exception;
    void deleteBuyerRequest(int id) throws Exception;
    List<BuyerRequest> getBuyerRequestsByCategory(int categoryId) throws Exception;
    List<BuyerRequest> searchBuyerRequestsByKeywords(String keywords) throws Exception;
    int countOffersForRequest(int requestId) throws Exception;
    List<BuyerRequest> getBuyerRequestsExpiringSoon(int withinHours) throws Exception;
    int markExpiredBuyerRequests(LocalDateTime currentTime) throws Exception;
    List<BuyerRequest> getRecentBuyerRequests(int limit) throws Exception;
}
