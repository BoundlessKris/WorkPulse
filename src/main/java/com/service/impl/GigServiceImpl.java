//package com.service.impl;
//
//import com.dao.interfaces.GigDao;
//import com.dao.interfaces.OrderDao;
//import com.dao.interfaces.ReviewDao;
//import com.model.Gig;
//import com.model.Review;
//import com.service.interfaces.GigService;
//
//import java.util.List;
//
//public class GigServiceImpl implements GigService {
//    private GigDao gigDao;
//    private ReviewDao reviewDao;
//    private OrderDao orderDao;
//
//    public GigServiceImpl(GigDao gigDao, ReviewDao reviewDao, OrderDao orderDao) {
//        this.gigDao = gigDao;
//        this.reviewDao = reviewDao;
//        this.orderDao = orderDao;
//    }
//
//    @Override
//    public Gig createGig(Gig gig) throws Exception {
//        validateGig(gig);
//        return gigDao.create(gig);
//    }
//
//    @Override
//    public Gig getGigById(int id) throws Exception {
//        Gig gig = gigDao.findById(id);
//        if (gig == null) {
//            throw new Exception("Gig not found with id: " + id);
//        }
//        return gig;
//    }
//
//    @Override
//    public List<Gig> getAllGigs() throws Exception {
//        return gigDao.findAll();
//    }
//
//    @Override
//    public List<Gig> getGigsBySellerId(int sellerId) throws Exception {
//        return gigDao.findBySellerId(sellerId);
//    }
//
//    @Override
//    public Gig updateGig(Gig gig) throws Exception {
//        validateGig(gig);
//        Gig existingGig = getGigById(gig.getGigId());
//        if (existingGig == null) {
//            throw new Exception("Gig not found for update with id: " + gig.getGigId());
//        }
//        return gigDao.update(gig);
//    }
//
//    @Override
//    public void deleteGig(int id) throws Exception {
//        Gig gig = getGigById(id);
//        if (gig == null) {
//            throw new Exception("Gig not found for deletion with id: " + id);
//        }
//        gigDao.delete(id);
//    }
//
//    @Override
//    public List<Gig> searchGigsByKeyword(String keyword) throws Exception {
//        if (keyword == null || keyword.trim().isEmpty()) {
//            throw new IllegalArgumentException("Search keyword cannot be empty");
//        }
//        return gigDao.searchByKeywords(keyword);
//    }
//
//    @Override
//    public List<Gig> getGigsByCategory(int categoryId) throws Exception {
//        if (categoryId <= 0) {
//            throw new IllegalArgumentException("Invalid category ID");
//        }
//        return gigDao.findByCategory(categoryId);
//    }
//
//    @Override
//    public double getAverageRatingForGig(int gigId) throws Exception {
//        List<Review> reviews = reviewDao.findByGigId(gigId);
//        if (reviews.isEmpty()) {
//            return 0.0;
//        }
//        double totalRating = reviews.stream().mapToInt(Review::getRating).sum();
//        return totalRating / reviews.size();
//    }
//
//    @Override
//    public int getOrderCountForGig(int gigId) throws Exception {
//        return orderDao.countByGigId(gigId);
//    }
//
//    private void validateGig(Gig gig) throws IllegalArgumentException {
//        if (gig == null) {
//            throw new IllegalArgumentException("Gig cannot be null");
//        }
//        if (gig.getTitle() == null || gig.getTitle().trim().isEmpty()) {
//            throw new IllegalArgumentException("Gig title cannot be empty");
//        }
//        if (gig.getDescription() == null || gig.getDescription().trim().isEmpty()) {
//            throw new IllegalArgumentException("Gig description cannot be empty");
//        }
//        if (gig.getPrice() <= 0) {
//            throw new IllegalArgumentException("Gig price must be greater than zero");
//        }
//        // will add more validation if requies
//    }
//}
