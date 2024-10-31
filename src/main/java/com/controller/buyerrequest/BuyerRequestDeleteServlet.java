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

@WebServlet("/buyerrequest/delete")
public class BuyerRequestDeleteServlet extends HttpServlet {
    private BuyerRequestService buyerRequestService;

    @Override
    public void init() throws ServletException {
        buyerRequestService = new BuyerRequestServiceImpl(new BuyerRequestDaoImpl());
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

        try {
            BuyerRequest buyerRequest = buyerRequestService.getBuyerRequestById(requestId);
            if (buyerRequest.getBuyerId() != user.getUserId()) {
                throw new IllegalStateException("You are not authorized to delete this request");
            }

            buyerRequestService.deleteBuyerRequest(requestId);
            response.sendRedirect(request.getContextPath() + "/buyerrequest/list");
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/buyerrequest/list");
        }
    }
}
