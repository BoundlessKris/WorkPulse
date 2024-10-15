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
import java.util.List;

@WebServlet("/order/list")
public class OrderListServlet extends HttpServlet {
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

        User user = (User) session.getAttribute("user");
        try {
            List<Order> orders;
            if ("buyer".equals(user.getUserType())) {
                orders = orderService.getOrdersByBuyerId(user.getUserId());
            } else if ("seller".equals(user.getUserType())) {
                orders = orderService.getOrdersBySellerId(user.getUserId());
            } else {
                throw new IllegalStateException("Invalid user type");
            }
            request.setAttribute("orders", orders);
            request.getRequestDispatcher("/WEB-INF/jsp/order/list.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
