package com.service.interfaces;

import com.model.Order;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    Order createOrder(Order order) throws Exception;
    Order getOrderById(int id) throws Exception;
    List<Order> getOrdersByBuyerId(int buyerId) throws Exception;
    List<Order> getOrdersBySellerId(int sellerId) throws Exception;
    Order updateOrder(Order order) throws Exception;
    void deleteOrder(int id) throws Exception;
    List<Order> getOrdersByStatus(String status) throws Exception;
    List<Order> getOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate) throws Exception;
    int countOrdersForGig(int gigId) throws Exception;
    double calculateSellerEarnings(int sellerId, LocalDateTime startDate, LocalDateTime endDate) throws Exception;
    void updateOrderStatus(int orderId, String newStatus) throws Exception;
    List<Order> getRecentOrders(int limit) throws Exception;
    double getAverageOrderValueForSeller(int sellerId) throws Exception;
    int getCompletedOrdersCount(int userId) throws Exception;
}
