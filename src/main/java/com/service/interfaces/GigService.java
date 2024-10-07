package com.service.interfaces;

import com.model.Gig;
import java.util.List;

public interface GigService {
    Gig createGig(Gig gig) throws Exception;
    Gig getGigById(int id) throws Exception;
    List<Gig> getAllGigs() throws Exception;
    List<Gig> getGigsBySellerId(int sellerId) throws Exception;
    Gig updateGig(Gig gig) throws Exception;
    void deleteGig(int id) throws Exception;
    List<Gig> searchGigsByKeyword(String keyword) throws Exception;
    List<Gig> getGigsByCategory(int categoryId) throws Exception;
    double getAverageRatingForGig(int gigId) throws Exception;
    int getOrderCountForGig(int gigId) throws Exception;
}
