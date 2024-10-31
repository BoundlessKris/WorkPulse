package com.controller.buyerrequest;

import com.model.BuyerRequest;
import com.model.User;
import com.service.impl.BuyerRequestServiceImpl;
import com.service.interfaces.BuyerRequestService;
import com.dao.impl.BuyerRequestDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@WebServlet("/buyerrequest/create")
public class BuyerRequestCreateServlet extends HttpServlet {
    private BuyerRequestService buyerRequestService;

    @Override
    public void init() throws ServletException {
        buyerRequestService = new BuyerRequestServiceImpl(new BuyerRequestDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/jsp/buyerrequest/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        User buyer = (User) session.getAttribute("user");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        BigDecimal budget = new BigDecimal(request.getParameter("budget"));
        LocalDateTime expiresAt = LocalDateTime.parse(request.getParameter("expiresAt"));

        BuyerRequest buyerRequest = new BuyerRequest();
        buyerRequest.setBuyerId(buyer.getUserId());
        buyerRequest.setTitle(title);
        buyerRequest.setDescription(description);
        buyerRequest.setBudget(budget);
        buyerRequest.setCreatedAt(LocalDateTime.now());
        buyerRequest.setExpiresAt(expiresAt);

        try {
            BuyerRequest createdRequest = buyerRequestService.createBuyerRequest(buyerRequest);
            response.sendRedirect(request.getContextPath() + "/buyerrequest/details?id=" + createdRequest.getRequestId());
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/buyerrequest/create.jsp").forward(request, response);
        }
    }
}
