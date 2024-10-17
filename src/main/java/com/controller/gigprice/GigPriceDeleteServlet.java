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

@WebServlet("/gigprice/delete")
public class GigPriceDeleteServlet extends HttpServlet {
    private GigPriceService gigPriceService;

    @Override
    public void init() throws ServletException {
        gigPriceService = new GigPriceServiceImpl(new GigPriceDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        int priceId = Integer.parseInt(request.getParameter("priceId"));
        try {
            GigPrice gigPrice = gigPriceService.getGigPriceById(priceId);
            gigPriceService.deleteGigPrice(priceId);
            response.sendRedirect(request.getContextPath() + "/gig/details?id=" + gigPrice.getGigId());
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/gig/list");
        }
    }
}
