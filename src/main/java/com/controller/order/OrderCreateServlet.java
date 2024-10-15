package com.controller.order;

import com.model.Order;
import com.model.User;
import com.service.interfaces.OrderService;
import com.service.impl.OrderServiceImpl;
import com.dao.impl.OrderDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/order/create")
public class OrderCreateServlet extends HttpServlet {
    private OrderService orderService;

    @Override
    public void init() throws ServletException {
        orderService = new OrderServiceImpl(new OrderDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        int gigId = Integer.parseInt(request.getParameter("gigId"));
        request.setAttribute("gigId", gigId);
        request.getRequestDispatcher("/WEB-INF/jsp/order/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        User buyer = (User) session.getAttribute("user");
        int gigId = Integer.parseInt(request.getParameter("gigId"));
        int sellerId = Integer.parseInt(request.getParameter("sellerId"));
        int priceId = Integer.parseInt(request.getParameter("priceId"));

        Order order = new Order();
        order.setGigId(gigId);
        order.setBuyerId(buyer.getUserId());
        order.setSellerId(sellerId);
        order.setPriceId(priceId);
        order.setStatus("pending");
        order.setCreatedAt(LocalDateTime.now());

        try {
            Order createdOrder = orderService.createOrder(order);
            response.sendRedirect(request.getContextPath() + "/order/details?id=" + createdOrder.getOrderId());
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/order/create.jsp").forward(request, response);
        }
    }
}
