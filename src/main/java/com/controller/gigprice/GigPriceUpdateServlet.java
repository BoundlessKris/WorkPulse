package com.controller.gigprice;

import com.model.GigPrice;
import com.model.User;
import com.service.interfaces.GigPriceService;
import com.service.impl.GigPriceServiceImpl;
import com.dao.impl.GigPriceDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/gigprice/update")
public class GigPriceUpdateServlet extends HttpServlet {
    private GigPriceService gigPriceService;

    @Override
    public void init() throws ServletException {
        gigPriceService = new GigPriceServiceImpl(new GigPriceDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        int priceId = Integer.parseInt(request.getParameter("id"));
        try {
            GigPrice gigPrice = gigPriceService.getGigPriceById(priceId);
            request.setAttribute("gigPrice", gigPrice);
            request.getRequestDispatcher("/WEB-INF/jsp/gigprice/update.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Gig price not found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        int priceId = Integer.parseInt(request.getParameter("priceId"));
        String tierName = request.getParameter("tierName");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");

        try {
            GigPrice gigPrice = gigPriceService.getGigPriceById(priceId);
            gigPrice.setTierName(tierName);
            gigPrice.setPrice(price);
            gigPrice.setDescription(description);

            GigPrice updatedGigPrice = gigPriceService.updateGigPrice(gigPrice);
            response.sendRedirect(request.getContextPath() + "/gig/details?id=" + updatedGigPrice.getGigId());
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/gigprice/update.jsp").forward(request, response);
        }
    }
}
