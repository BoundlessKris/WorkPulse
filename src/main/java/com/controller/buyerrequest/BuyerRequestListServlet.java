package com.controller.buyerrequest;

import com.model.BuyerRequest;
import com.service.impl.BuyerRequestServiceImpl;
import com.service.interfaces.BuyerRequestService;
import com.dao.impl.BuyerRequestDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/buyerrequest/list")
public class BuyerRequestListServlet extends HttpServlet {
    private BuyerRequestService buyerRequestService;

    @Override
    public void init() throws ServletException {
        buyerRequestService = new BuyerRequestServiceImpl(new BuyerRequestDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<BuyerRequest> activeRequests = buyerRequestService.getActiveBuyerRequests();
            request.setAttribute("buyerRequests", activeRequests);
            request.getRequestDispatcher("/WEB-INF/jsp/buyerrequest/list.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
