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

@WebServlet("/buyerrequest/update")
public class BuyerRequestUpdateServlet extends HttpServlet {
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

        int requestId = Integer.parseInt(request.getParameter("id"));
        try {
            BuyerRequest buyerRequest = buyerRequestService.getBuyerRequestById(requestId);
            request.setAttribute("buyerRequest", buyerRequest);
            request.getRequestDispatcher("/WEB-INF/jsp/buyerrequest/update.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Buyer request not found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        User user = (User) session.getAttribute("user");
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        BigDecimal budget = new BigDecimal(request.getParameter("budget"));
        LocalDateTime expiresAt = LocalDateTime.parse(request.getParameter("expiresAt"));

        try {
            BuyerRequest buyerRequest = buyerRequestService.getBuyerRequestById(requestId);
            if (buyerRequest.getBuyerId() != user.getUserId()) {
                throw new IllegalStateException("You are not authorized to update this request");
            }

            buyerRequest.setTitle(title);
            buyerRequest.setDescription(description);
            buyerRequest.setBudget(budget);
            buyerRequest.setExpiresAt(expiresAt);

            BuyerRequest updatedRequest = buyerRequestService.updateBuyerRequest(buyerRequest);
            response.sendRedirect(request.getContextPath() + "/buyerrequest/details?id=" + updatedRequest.getRequestId());
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/buyerrequest/update.jsp").forward(request, response);
        }
    }
}
