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

@WebServlet("/gigprice/create")
public class GigPriceCreateServlet extends HttpServlet {
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

        int gigId = Integer.parseInt(request.getParameter("gigId"));
        request.setAttribute("gigId", gigId);
        request.getRequestDispatcher("/WEB-INF/jsp/gigprice/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        int gigId = Integer.parseInt(request.getParameter("gigId"));
        String tierName = request.getParameter("tierName");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");

        GigPrice gigPrice = new GigPrice();
        gigPrice.setGigId(gigId);
        gigPrice.setTierName(tierName);
        gigPrice.setPrice(price);
        gigPrice.setDescription(description);

        try {
            GigPrice createdGigPrice = gigPriceService.createGigPrice(gigPrice);
            response.sendRedirect(request.getContextPath() + "/gig/details?id=" + gigId);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/gigprice/create.jsp").forward(request, response);
        }
    }
}
