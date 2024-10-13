package com.service.impl;

import com.dao.interfaces.OrderDao;
import com.model.Order;
import com.service.interfaces.OrderService;
import java.time.LocalDateTime;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order createOrder(Order order) throws Exception {
        validateOrder(order);
        return orderDao.create(order);
    }

    @Override
    public Order getOrderById(int id) throws Exception {
        Order order = orderDao.findById(id);
        if (order == null) {
            throw new Exception("Order not found with id: " + id);
        }
        return order;
    }

    @Override
    public List<Order> getOrdersByBuyerId(int buyerId) throws Exception {
        return orderDao.findByBuyerId(buyerId);
    }

    @Override
    public List<Order> getOrdersBySellerId(int sellerId) throws Exception {
        return orderDao.findBySellerId(sellerId);
    }

    @Override
    public Order updateOrder(Order order) throws Exception {
        validateOrder(order);
        Order existingOrder = getOrderById(order.getOrderId());
        if (existingOrder == null) {
            throw new Exception("Order not found for update with id: " + order.getOrderId());
        }
        return orderDao.update(order);
    }

    @Override
    public void deleteOrder(int id) throws Exception {
        Order order = getOrderById(id);
        if (order == null) {
            throw new Exception("Order not found for deletion with id: " + id);
        }
        orderDao.delete(id);
    }

    @Override
    public List<Order> getOrdersByStatus(String status) throws Exception {
        return orderDao.findByStatus(status);
    }

    @Override
    public List<Order> getOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate) throws Exception {
        return orderDao.findByDateRange(startDate, endDate);
    }

    @Override
    public int countOrdersForGig(int gigId) throws Exception {
        return orderDao.countOrdersForGig(gigId);
    }

    @Override
    public double calculateSellerEarnings(int sellerId, LocalDateTime startDate, LocalDateTime endDate) throws Exception {
        return orderDao.calculateSellerEarnings(sellerId, startDate, endDate);
    }

    @Override
    public void updateOrderStatus(int orderId, String newStatus) throws Exception {
        Order order = getOrderById(orderId);
        order.setStatus(newStatus);
        if ("completed".equalsIgnoreCase(newStatus)) {
            order.setCompletedAt(LocalDateTime.now());
        }
        orderDao.update(order);
    }

    @Override
    public List<Order> getRecentOrders(int limit) throws Exception {
        return orderDao.findRecentOrders(limit);
    }

    @Override
    public double getAverageOrderValueForSeller(int sellerId) throws Exception {
        List<Order> sellerOrders = getOrdersBySellerId(sellerId);
        if (sellerOrders.isEmpty()) {
            return 0.0;
        }
        double totalValue = sellerOrders.stream()
                .mapToDouble(Order::getTotalAmount)
                .sum();
        return totalValue / sellerOrders.size();
    }

    @Override
    public int getCompletedOrdersCount(int userId) throws Exception {
        List<Order> completedOrders = orderDao.findBySellerIdAndStatus(userId, "completed");
        return completedOrders.size();
    }

    private void validateOrder(Order order) throws IllegalArgumentException {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        if (order.getBuyerId() <= 0) {
            throw new IllegalArgumentException("Invalid buyer ID");
        }
        if (order.getSellerId() <= 0) {
            throw new IllegalArgumentException("Invalid seller ID");
        }
        if (order.getGigId() <= 0) {
            throw new IllegalArgumentException("Invalid gig ID");
        }
        if (order.getStatus() == null || order.getStatus().trim().isEmpty()) {
            throw new IllegalArgumentException("Order status cannot be empty");
        }
    }
}