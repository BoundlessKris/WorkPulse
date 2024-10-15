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

@WebServlet("/order/update")
public class OrderUpdateServlet extends HttpServlet {
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

        int orderId = Integer.parseInt(request.getParameter("id"));
        try {
            Order order = orderService.getOrderById(orderId);
            request.setAttribute("order", order);
            request.getRequestDispatcher("/WEB-INF/jsp/order/update.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Order not found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        int orderId = Integer.parseInt(request.getParameter("orderId"));
        String status = request.getParameter("status");

        try {
            Order order = orderService.getOrderById(orderId);
            order.setStatus(status);

            Order updatedOrder = orderService.updateOrder(order);
            response.sendRedirect(request.getContextPath() + "/order/details?id=" + updatedOrder.getOrderId());
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/order/update.jsp").forward(request, response);
        }
    }
}
