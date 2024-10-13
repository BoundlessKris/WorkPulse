package com.service.interfaces;

import com.model.GigPrice;
import java.util.List;

public interface GigPriceService {
    GigPrice createGigPrice(GigPrice gigPrice) throws Exception;
    GigPrice getGigPriceById(int id) throws Exception;
    List<GigPrice> getGigPricesByGigId(int gigId) throws Exception;
    GigPrice updateGigPrice(GigPrice gigPrice) throws Exception;
    void deleteGigPrice(int id) throws Exception;
    GigPrice getBasePriceForGig(int gigId) throws Exception;
    List<GigPrice> getPricesInRange(double minPrice, double maxPrice) throws Exception;
    boolean hasMultipleTiers(int gigId) throws Exception;
    GigPrice getHighestTierForGig(int gigId) throws Exception;
}
