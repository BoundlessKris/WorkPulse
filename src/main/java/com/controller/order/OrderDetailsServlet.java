package com.controller.order;

import com.model.Order;
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

@WebServlet("/order/details")
public class OrderDetailsServlet extends HttpServlet {
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
            request.getRequestDispatcher("/WEB-INF/jsp/order/details.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Order not found");
        }
    }
}
